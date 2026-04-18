package grafica;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;


public class AgregarImagen {
	
	        //ImageIcon icon = new ImageIcon("C:/Users/zaeli/eclipse-workspace/UnidadGUI_a - Hecho/UnidadGUI_a/imagenes/bomba.png");
	       
	public static void main(String[] args) {
	                // Crear el frame
	                JFrame frame = new JFrame("Ejemplo");
	                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                frame.setSize(400, 300);
	                frame.getContentPane().setLayout(null);

	                // Cargar la imagen y redimensionarla para el JLabel
	                ImageIcon iconOriginal = new ImageIcon("C:/Users/zaeli/eclipse-workspace/UnidadGUI_a - Hecho/UnidadGUI_a/imagenes/bomba.png"); // Cambia por la ruta de tu imagen
	                Image imagenOriginal = iconOriginal.getImage(); // Obtener el objeto Image
	                Image imagenRedimensionada = imagenOriginal.getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Redimensionar
	                ImageIcon iconRedimensionado = new ImageIcon(imagenRedimensionada); // Crear el nuevo ImageIcon redimensionado

	                // Crear el JLabel con la imagen redimensionada
	                JLabel labelImagen = new JLabel(iconRedimensionado);
	                labelImagen.setBounds(50, 30, 100, 100);  // Ajustar la posición y tamaño del JLabel

	                // Crear un botón con una imagen
	                JButton botonConImagen = new JButton();
	                ImageIcon iconoBoton = new ImageIcon(imagenOriginal.getScaledInstance(50, 50, Image.SCALE_SMOOTH)); // Redimensionar para el botón
	                botonConImagen.setIcon(iconoBoton);  // Asignar la imagen al botón
	                botonConImagen.setBounds(200, 30, 100, 100); // Ajustar posición y tamaño del botón

	                // Agregar componentes al frame
	                frame.getContentPane().add(labelImagen);  // Agregar la imagen al frame
	                frame.getContentPane().add(botonConImagen);  // Agregar el botón con imagen al frame
	                
	                JLabel lblNewLabel = new JLabel("Etiqueta con una imagen");
	                lblNewLabel.setBounds(42, 151, 131, 14);
	                frame.getContentPane().add(lblNewLabel);
	                
	                JLabel lblNewLabel_1 = new JLabel("Botón con imagen");
	                lblNewLabel_1.setBounds(210, 140, 90, 14);
	                frame.getContentPane().add(lblNewLabel_1);

	                // Hacer visible el frame
	                frame.setVisible(true);
	            }
	        }
