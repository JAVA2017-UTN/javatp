package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controllers.CtrlABMPeople;
import entity.People;
import entity.Session;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {
	
	private CtrlABMPeople ctrl=new CtrlABMPeople();

	private JFrame frmLogin;
	private JTextField txtUsu;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 284, 196);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(44, 52, 46, 14);
		frmLogin.getContentPane().add(lblUsuario);
		
		JLabel lblContrasenia = new JLabel("Contrase\u00F1a");
		lblContrasenia.setBounds(44, 89, 81, 14);
		frmLogin.getContentPane().add(lblContrasenia);
		
		txtUsu = new JTextField();
		txtUsu.setBounds(122, 49, 97, 20);
		frmLogin.getContentPane().add(txtUsu);
		txtUsu.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(122, 86, 97, 20);
		frmLogin.getContentPane().add(passwordField);
		
		JLabel lblBienvenidoAlSistema = new JLabel("Bienvenido al Sistema");
		lblBienvenidoAlSistema.setBounds(72, 11, 132, 14);
		frmLogin.getContentPane().add(lblBienvenidoAlSistema);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarClick();
			}
		});
		btnAceptar.setBounds(44, 123, 89, 23);
		frmLogin.getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmLogin.dispose();
			}
		});
		btnCancelar.setBounds(143, 123, 89, 23);
		frmLogin.getContentPane().add(btnCancelar);
	}

	public void setVisible(boolean b) {
		frmLogin.setVisible(b);
		
	}
	
	protected void buscarClick() {
		try {
			People per = ctrl.validaUsuario(this.mapearDeForm());
			if(per != null) {
				Session.setSession(per.getId(), per.getNombre(), per.getApellido(), per.getDni(), per.getUsuario(), per.getContrasenia(), per.isHabilitado());
				JOptionPane.showMessageDialog(null, "Bienvenido al Sistema: " + Session.getUsuario());
				MainMenu mm = new MainMenu();
				mm.setVisible(true);
				frmLogin.setVisible(false);
			}
			else {
				JOptionPane.showMessageDialog(null, "Error en el inicio de sesión, datos incorrectos");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}
	
	private People mapearDeForm(){
		People p=new People();
		p.setUsuario(this.txtUsu.getText());
		p.setContrasenia(String.valueOf(this.passwordField.getPassword()));
		return p;
	}
}
