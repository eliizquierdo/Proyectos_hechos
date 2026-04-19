package grafica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

import logica.AccountsDAO;
import persistencia.GestionCuentas;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
/**
 * Clase para el diálogo de registro de nuevas cuentas vinculadas a personas existentes.
 */
public class DlgPersonRegister extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JPasswordField pssPassAccount;
    private JPanel panel;
    private JLabel lblEmail;
    private JLabel lblPassAccount;
    private JButton btnOK;
    private JButton btnBack;
    private JTextField txtEmail;
    private JLabel lblRequest;

    /**
     * Constructor por defecto para la clase DlgPersonRegister.
     * Inicializa la apariencia y los manejadores de eventos.
     */
    public DlgPersonRegister() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        eventStarter();
        eventHandler();
    }

    /**
     * Configura los manejadores de eventos para varios componentes en el diálogo.
     */
    private void eventHandler() {
        pssPassAccount.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // Presionaron Enter, ejecuta la acción del botón "Aceptar"
                    btnOK.doClick(); // Simula un clic en el botón
                }
            }
        });

        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                DlgNewClient newClient = new DlgNewClient();
                newClient.setVisible(true);
            }
        });

        btnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String mail = txtEmail.getText();
                String pass = new String(pssPassAccount.getPassword());

                if (AccountsDAO.verifyAccount(mail, pass) != 0) {
                    int id_Persons = AccountsDAO.verifyAccount(mail, pass);
                    dispose();
                    DlgNewAccount newAccount = new DlgNewAccount(id_Persons);
                    newAccount.setVisible(true);
                } else {
                    dispose();
                    DlgNewClient newCliente = new DlgNewClient();
                    newCliente.setVisible(true);
                }
            }
        });
    }

    /**
     * Configura la apariencia inicial y el diseño del diálogo.
     */
    private void eventStarter() {
        setResizable(false);
        setTitle("NETXILF - Vincular");
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\img\\Nlogo.jpg"));
        setBounds(100, 100, 350, 252);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(new Color(0, 0, 0));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        panel = new JPanel();
        panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 0, 0), new Color(255, 0, 0)));
        panel.setBackground(new Color(0, 0, 0));
        panel.setBounds(10, 10, 314, 194);
        contentPanel.add(panel);
        panel.setLayout(null);

        txtEmail = new JTextField();
        txtEmail.setBounds(46, 61, 222, 28);
        panel.add(txtEmail);
        txtEmail.setColumns(10);

        lblEmail = new JLabel("Correo");
        lblEmail.setBounds(136, 36, 48, 14);
        panel.add(lblEmail);
        lblEmail.setForeground(new Color(255, 255, 255));
        lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));

        pssPassAccount = new JPasswordField();
        pssPassAccount.setBounds(46, 121, 222, 28);
        panel.add(pssPassAccount);

        lblPassAccount = new JLabel("Contraseña");
        lblPassAccount.setBounds(118, 100, 80, 14);
        panel.add(lblPassAccount);
        lblPassAccount.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblPassAccount.setForeground(new Color(255, 255, 255));

        btnOK = new JButton("Aceptar");
        btnOK.setBounds(46, 160, 103, 23);
        panel.add(btnOK);
        btnOK.setActionCommand("OK");

        btnBack = new JButton("No soy cliente");
        btnBack.setBounds(165, 160, 103, 23);
        panel.add(btnBack);
        btnBack.setActionCommand("Cancel");

        lblRequest = new JLabel("Proporciona una cuenta ya registrada.");
        lblRequest.setHorizontalAlignment(SwingConstants.CENTER);
        lblRequest.setForeground(Color.WHITE);
        lblRequest.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblRequest.setBounds(10, 11, 294, 23);
        panel.add(lblRequest);
    }
}