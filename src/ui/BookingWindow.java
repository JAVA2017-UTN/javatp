package ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import controllers.CtrlABMPeople;
import controllers.CtrlBooking;
import controllers.CtrlBookingTypes;
import controllers.CtrlBookableItems;

import javax.swing.JComboBox;
import javax.swing.JLabel;

public class BookingWindow extends JInternalFrame {

	private JFrame frame;
	private JComboBox<String> tipoEleCmbBox;
	private JComboBox<String> elemCmbBox;
	private CtrlBooking ctrlBook = new CtrlBooking();
	private CtrlABMPeople ctrlPer = new CtrlABMPeople();
	private CtrlBookingTypes ctrlType = new CtrlBookingTypes();
	private CtrlBookableItems ctrlItems = new CtrlBookableItems();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookingWindow window = new BookingWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public BookingWindow() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tipoEleCmbBox = new JComboBox();
		tipoEleCmbBox.setBounds(187, 47, 123, 27);
		tipoEleCmbBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					llenarElem((String) tipoEleCmbBox.getSelectedItem());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(tipoEleCmbBox);
		
		JLabel lblTipoElemento = new JLabel("Tipo Elemento");
		lblTipoElemento.setBounds(10, 53, 123, 14);
		frame.getContentPane().add(lblTipoElemento);
		
		elemCmbBox = new JComboBox();
		elemCmbBox.setBounds(187, 120, 128, 27);
		frame.getContentPane().add(elemCmbBox);
		
		JLabel lblElemento = new JLabel("Elemento");
		lblElemento.setBounds(10, 126, 73, 14);
		frame.getContentPane().add(lblElemento);
		
		this.llenarTypes();
	}
	
	private void llenarTypes() throws Exception {
		ArrayList<String> types = new ArrayList<String>();
		types = ctrlType.getAllNames();
		for(int i = 0; i<types.size(); i++) {
			tipoEleCmbBox.addItem(types.get(i));
		}
	}
	
	private void llenarElem(String type) throws Exception {
		elemCmbBox.removeAllItems();
		Integer id_tipo = null;
		ArrayList<String> items = new ArrayList<String>();
		id_tipo = ctrlType.getTypeId(type);
		items = ctrlItems.getAllNames(id_tipo);
		for(int i = 0; i<items.size(); i++) {
			elemCmbBox.addItem(items.get(i));
		}
	}
}
