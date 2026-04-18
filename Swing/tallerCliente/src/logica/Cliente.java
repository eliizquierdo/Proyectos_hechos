package logica;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import comunicacion.*;
import presentacion.VentanaEditorBD;
import javax.swing.JOptionPane;

public class Cliente {
	
	private static Cliente instancia;
	
	private Socket socket;
	private ObjectOutputStream salida;
	private ObjectInputStream entrada;
	
	private String servidorIP;
	private int puerto;
	private String useBD;
	private boolean error;
	
	private Solicitud solicitud;
	private Respuesta respuesta;
	
	
	public static Cliente getInstance() {
		if(instancia==null) {
			instancia = new Cliente();
		}
		return instancia;
	}
	
	private Cliente(){
		servidorIP="localhost";
		puerto=1234;
		useBD="inet";
		error=false;
	}
	
	public void realizarConsulta(String consulta) {
		//Crea la solicitud
		error=false;
		solicitud = new Solicitud(consulta.toLowerCase(), useBD.toLowerCase());
		conectar();
	}
	
	private void conectar() {
		mandarSolicitud();
		if(!error) {
			leerRespuesta();
			cerrarConexion();
		}
	}
	
	private void mandarSolicitud() {
		try{
			//Conectar al servidor
			this.socket = new Socket(servidorIP, puerto);
			//Crear streams de entrada y salida para el servidor
	        this.salida = new ObjectOutputStream(socket.getOutputStream());
	        this.entrada = new ObjectInputStream(socket.getInputStream());
	        //Envia la solicitud al servidor
	        salida.writeObject(solicitud);
		}catch(IOException e) {
	        JOptionPane.showMessageDialog(null, "No puede mandarse solicitud al servidor "+servidorIP+" en el puerto "+puerto, "Error", JOptionPane.INFORMATION_MESSAGE);
			error=true;
	        e.printStackTrace();
		}
	}
	
	private void leerRespuesta() {
        try {
			respuesta = (Respuesta) entrada.readObject();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
        if(respuesta.getSatisfactoria()) {
        	String[] palabras = solicitud.getConsulta().split(" ");
        	if(palabras[0].equals("use")) {
        		useBD=palabras[1];
        	}
        }
        
        
        VentanaEditorBD.getInstance().actualizarCampoRespuesta(solicitud.getConsulta(),respuesta.getResultado());   
        if(respuesta.isHayTabla()) {
        	VentanaEditorBD.getInstance().actualizarCampoTabla(respuesta.getTabla());
        }
	}
	
	private void cerrarConexion() {
        try {
			socket.close();
			salida.close();
	        entrada.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setPuerto(int puerto) {
		this.puerto = puerto;
	}
}
