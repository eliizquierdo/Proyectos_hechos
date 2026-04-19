package grafica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

import logica.AccountsDAO;
import logica.PersonsDAO;
import logica.ProfilesDAO;
import logica.Validaciones;
import persistencia.GestionCuentas;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Ventana de diálogo para el inicio de sesión del administrador.
 */
public class DlgValidateProfile extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JPasswordField pssPIN;
    private JPanel panel;
    private JLabel lblPIN;
    private JButton btnLogin;
    private JButton btnBack;

    /**
     * Constructor de la clase DlgLoginAdmin.
     */
    public DlgValidateProfile(String nombre, String [] nombres, String account, String [] id_Profiles) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        eventStarter();
        eventHandler(nombre, nombres, account, id_Profiles);
    }

    /**
     * Configura los manejadores de eventos para los componentes de la interfaz.
     */
    private void eventHandler(String nombre, String [] nombres, String account, String [] id_Profiles) {

        pssPIN.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // Presionar Enter, ejecuta la acción del botón "Ingresar"
                    btnLogin.doClick(); // Simula un clic en el botón
                }
            }
        });

        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DlgProfile profile = new DlgProfile(nombres, account, id_Profiles);
                profile.setVisible(true);
                dispose();
            }
        });
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                String PIN = new String(pssPIN.getPassword());
                String id_Profile = String.valueOf(ProfilesDAO.verifyProfile(nombre, PIN, account));
                if (!id_Profile.equals("0")) {
                    // Cuenta de administrador válida
                    FrmPrincipal principal = new FrmPrincipal(nombre, id_Profile);
                    principal.setVisible(true);
                    dispose();
                } else {
                    // Cuenta de administrador no válida
                    JOptionPane.showMessageDialog(null, "Cuenta inexistente. Verifique los datos!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
        });

    }

    /**
     * Inicializa y configura los componentes de la interfaz.
     */
    private void eventStarter() {
        setResizable(false);
        setTitle("NETXILF - Perfil");
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\img\\Nlogo.jpg"));
        setBounds(100, 100, 278, 171);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(new Color(0, 0, 0));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        panel = new JPanel();
        panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 0, 0), new Color(255, 0, 0)));
        panel.setBackground(new Color(0, 0, 0));
        panel.setBounds(10, 10, 242, 111);
        contentPanel.add(panel);
        panel.setLayout(null);

        pssPIN = new JPasswordField();
        pssPIN.setBounds(10, 36, 222, 28);
        panel.add(pssPIN);

        lblPIN = new JLabel("Ingrese su PIN");
        lblPIN.setBounds(68, 6, 105, 28);
        panel.add(lblPIN);
        lblPIN.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblPIN.setForeground(new Color(255, 255, 255));

        btnLogin = new JButton("Ingresar");
        btnLogin.setBounds(10, 75, 103, 23);
        panel.add(btnLogin);
        btnLogin.setActionCommand("OK");

        btnBack = new JButton("Volver");
        btnBack.setBounds(123, 75, 103, 23);
        panel.add(btnBack);
        btnBack.setActionCommand("Cancel");

    }
}