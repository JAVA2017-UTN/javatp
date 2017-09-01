package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class BookingItemsWindows {

	private JFrame frmCargarElementos;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookingItemsWindows window = new BookingItemsWindows();
					window.frmCargarElementos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BookingItemsWindows() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCargarElementos = new JFrame();
		frmCargarElementos.setTitle("Cargar Elementos");
		frmCargarElementos.setBounds(100, 100, 450, 300);
		frmCargarElementos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCargarElementos.getContentPane().setLayout(null);
		
		JLabel lbld = new JLabel("Id");
		lbld.setToolTipText("");
		lbld.setBounds(133, 47, 46, 14);
		frmCargarElementos.getContentPane().add(lbld);
		
		JLabel lblNombreElemento = new JLabel("Nombre elemento");
		lblNombreElemento.setBounds(56, 92, 123, 14);
		frmCargarElementos.getContentPane().add(lblNombreElemento);
		
		JLabel lblNewLabel = new JLabel("Tipo elemento");
		lblNewLabel.setBounds(56, 120, 123, 14);
		frmCargarElementos.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(189, 44, 86, 20);
		frmCargarElementos.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(189, 89, 86, 20);
		frmCargarElementos.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(189, 117, 118, 20);
		frmCargarElementos.getContentPane().add(comboBox);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(49, 182, 89, 23);
		frmCargarElementos.getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(207, 182, 89, 23);
		frmCargarElementos.getContentPane().add(btnCancelar);
	}

}
