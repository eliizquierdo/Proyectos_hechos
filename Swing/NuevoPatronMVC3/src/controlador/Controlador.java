package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Modelo;
import vista.VistaInterfaz;

/**
 * @date 09/08/2018
 * @author Fredy Kcrez
 */
public class Controlador implements ActionListener {
    private VistaInterfaz view;
    private Modelo model;
    
    public Controlador(VistaInterfaz view, Modelo model) {
        this.view = view;
        this.model = model;
        this.view.btnMultiplar.addActionListener(this);
    }
    
    public void iniciar() {
        view.setTitle("MVC multiplicar");
        view.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.setNumero1(Float.parseFloat(view.txtNumeroUno.getText()));
        model.setNumero2(Float.parseFloat(view.txtNumeroDos.getText()));
        view.txtResultado.setText(String.valueOf(model.multiplicar()));
    }
}