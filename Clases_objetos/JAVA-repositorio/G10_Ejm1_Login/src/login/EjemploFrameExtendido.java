package login;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * @date 08/07/2018
 * @author Fredy Kcrez
 */
public class EjemploFrameExtendido extends JFrame {
    final int ANCHO = 300;
    final int ALTO = 300;
    private JLabel lUsuario;
    private JTextField tUsuario;
    private JLabel lPassword;
    private JTextField tPassword;
    private JButton bAceptar;
    private JButton bCancelar;

    public EjemploFrameExtendido(String titulo) {
        super(titulo);
        initComponent();
    }
    
    private void initComponent() {
        lUsuario = new JLabel("Nombre de usuario:");
        tUsuario = new JTextField("Ingrese aquí el usuario");
        lPassword = new JLabel("Password:");
        tPassword = new JTextField("Ingrese aquí el password");
        bAceptar = new JButton("Aceptar");
        bCancelar = new JButton("Cancelar");
        setSize(ANCHO, ALTO);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        bAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tUsuario.getText().toUpperCase().equals("ALUMNO") && 
                        tPassword.getText().toUpperCase().equals("PRN315")) {
                    JOptionPane.showMessageDialog(null, "Bienvenido al sistema");
                } else{
                    JOptionPane.showMessageDialog(null, "Ud. no tiene las "
                            + "credenciales para entrar");
                }
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        //Agrupamiento horizontal
        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGroup(layout.createParallelGroup().addComponent(lUsuario).addComponent(lPassword).addComponent(bAceptar));
        hGroup.addGroup(layout.createParallelGroup().addComponent(tUsuario).addComponent(tPassword).addComponent(bCancelar));
        layout.setHorizontalGroup(hGroup);

        //Agrupamiento vertical
        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(lPassword).addComponent(tPassword));
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(lUsuario).addComponent(tUsuario));
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(bAceptar).addComponent(bCancelar));
        layout.setVerticalGroup(vGroup);
    }
}