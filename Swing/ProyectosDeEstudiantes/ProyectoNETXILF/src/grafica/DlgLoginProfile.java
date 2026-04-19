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
public class DlgLoginProfile extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JPasswordField pssPassAdmin;
    private JPanel panel;
    private JLabel lblMail;
    private JLabel lblPassword;
    private JButton btnLogin;
    private JButton btnBack;
    private JTextField txtMail;

    /**
     * Constructor de la clase DlgLoginAdmin.
     */
    public DlgLoginProfile() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        eventStarter();
        eventHandler();
    }

    /**
     * Configura los manejadores de eventos para los componentes de la interfaz.
     */
    private void eventHandler() {

        pssPassAdmin.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // Presionaron Enter, ejecuta la acción del botón "Ingresar"
                    btnLogin.doClick(); // Simula un clic en el botón
                }
            }
        });

        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DlgStart principal = new DlgStart();
                principal.setVisible(true);
                dispose();
            }
        });
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String mail = txtMail.getText();
                String pass = new String(pssPassAdmin.getPassword());
                System.out.println(pass);
                if (PersonsDAO.verifyAccountAdmin(mail, pass) != 0) {
                    // Cuenta de administrador válida
                    DlgHiddenMenu oculto = new DlgHiddenMenu();
                    oculto.setVisible(true);
                    dispose();
                } else {
                    
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
        setTitle("NETXILF - Login");
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\img\\Nlogo.jpg"));
        setBounds(100, 100, 278, 228);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(new Color(0, 0, 0));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        panel = new JPanel();
        panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 0, 0), new Color(255, 0, 0)));
        panel.setBackground(new Color(0, 0, 0));
        panel.setBounds(10, 10, 242, 168);
        contentPanel.add(panel);
        panel.setLayout(null);

        txtMail = new JTextField();
        txtMail.setBounds(10, 36, 222, 28);
        panel.add(txtMail);
        txtMail.setColumns(10);

        lblMail = new JLabel("Correo");
        lblMail.setBounds(100, 11, 48, 14);
        panel.add(lblMail);
        lblMail.setForeground(new Color(255, 255, 255));
        lblMail.setFont(new Font("Tahoma", Font.BOLD, 14));

        pssPassAdmin = new JPasswordField();
        pssPassAdmin.setBounds(10, 96, 222, 28);
        panel.add(pssPassAdmin);

        lblPassword = new JLabel("Contraseña");
        lblPassword.setBounds(82, 75, 80, 14);
        panel.add(lblPassword);
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblPassword.setForeground(new Color(255, 255, 255));

        btnLogin = new JButton("Ingresar");
        btnLogin.setBounds(10, 135, 103, 23);
        panel.add(btnLogin);
        btnLogin.setActionCommand("OK");

        btnBack = new JButton("Volver");
        btnBack.setBounds(129, 135, 103, 23);
        panel.add(btnBack);
        btnBack.setActionCommand("Cancel");

    }
}