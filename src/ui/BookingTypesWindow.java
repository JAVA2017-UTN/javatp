package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import controllers.CtrlBookingTypes;
import entity.BookableTypes;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class BookingTypesWindow {
	
	private CtrlBookingTypes ctrl = new CtrlBookingTypes();

	private JFrame frmCargarTiposElementos;
	private JTextField textFieldId;
	private JTextField textFieldTipoElemento;
	private JTextField textFieldMaxReservas;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookingTypesWindow window = new BookingTypesWindow();
					window.frmCargarTiposElementos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BookingTypesWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCargarTiposElementos = new JFrame();
		frmCargarTiposElementos.setTitle("Cargar tipos elementos");
		frmCargarTiposElementos.setBounds(100, 100, 447, 273);
		frmCargarTiposElementos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCargarTiposElementos.getContentPane().setLayout(null);
		
		JLabel lblId = new JLabel("Id ");
		lblId.setBounds(161, 44, 35, 14);
		frmCargarTiposElementos.getContentPane().add(lblId);
		
		JLabel lblTipoElemento = new JLabel("Tipo de elemento");
		lblTipoElemento.setHorizontalAlignment(SwingConstants.LEFT);
		lblTipoElemento.setBounds(83, 82, 113, 14);
		frmCargarTiposElementos.getContentPane().add(lblTipoElemento);
		
		textFieldId = new JTextField();
		textFieldId.setEditable(false);
		textFieldId.setBounds(221, 41, 65, 20);
		frmCargarTiposElementos.getContentPane().add(textFieldId);
		textFieldId.setColumns(10);
		
		textFieldTipoElemento = new JTextField();
		textFieldTipoElemento.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldTipoElemento.setBounds(221, 76, 86, 20);
		frmCargarTiposElementos.getContentPane().add(textFieldTipoElemento);
		textFieldTipoElemento.setColumns(10);
		
		JLabel lblMaxReservas = new JLabel("M\u00E1ximo reservas pendientes");
		lblMaxReservas.setHorizontalAlignment(SwingConstants.LEFT);
		lblMaxReservas.setBounds(44, 110, 167, 14);
		frmCargarTiposElementos.getContentPane().add(lblMaxReservas);
		
		textFieldMaxReservas = new JTextField();
		textFieldMaxReservas.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldMaxReservas.setBounds(221, 107, 86, 20);
		frmCargarTiposElementos.getContentPane().add(textFieldMaxReservas);
		textFieldMaxReservas.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				aceptarClick();
			}
		});
		btnAceptar.setBounds(83, 168, 89, 23);
		frmCargarTiposElementos.getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(218, 168, 89, 23);
		frmCargarTiposElementos.getContentPane().add(btnCancelar);
	}
	
	protected void aceptarClick() {
		BookableTypes bt = this.mapearDeForm();
		try{
			ctrl.add(bt);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		this.textFieldId.setText(String.valueOf(bt.getId()));
	}
			
	
	private BookableTypes mapearDeForm(){
		BookableTypes bt= new BookableTypes();
		if(!this.textFieldId.getText().isEmpty()){
			bt.setId(Integer.parseInt(this.textFieldId.getText()));
		}
		bt.setNombre(this.textFieldTipoElemento.getText());
		bt.setCantReservasPendientes(Integer.parseInt(this.textFieldMaxReservas.getText()));
		
		return bt;
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
