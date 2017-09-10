package ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import controllers.CtrlABMPeople;
import controllers.CtrlBooking;
import controllers.CtrlBookingTypes;
import entity.Booking;
import entity.People;
import controllers.CtrlBookableItems;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;
import com.toedter.components.JSpinField;
import com.github.lgooddatepicker.components.TimePicker;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.TextArea;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class BookingWindow extends JInternalFrame {

	private JFrame frmRealizarReserva;
	private JComboBox<String> tipoEleCmbBox;
	private JComboBox<String> elemCmbBox;
	private CtrlBooking ctrlBook = new CtrlBooking();
	private CtrlABMPeople ctrlPer = new CtrlABMPeople();
	private CtrlBookingTypes ctrlType = new CtrlBookingTypes();
	private CtrlBookableItems ctrlItems = new CtrlBookableItems();
	private JLabel lblHora;
	private JCalendar calendar;
	private JLabel lblDetalle;
	private JTextArea txtDetalle;
	private JScrollPane scrollPane;
	private TimePicker timePicker;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookingWindow window = new BookingWindow();
					window.frmRealizarReserva.setVisible(true);
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
	public BookingWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize(){
		frmRealizarReserva = new JFrame();
		frmRealizarReserva.setBounds(100, 100, 511, 388);
		frmRealizarReserva.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRealizarReserva.getContentPane().setLayout(null);
		
		tipoEleCmbBox = new JComboBox();
		tipoEleCmbBox.setBounds(123, 47, 123, 27);
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
		frmRealizarReserva.getContentPane().add(tipoEleCmbBox);
		
		JLabel lblTipoElemento = new JLabel("Tipo Elemento");
		lblTipoElemento.setBounds(10, 53, 123, 14);
		frmRealizarReserva.getContentPane().add(lblTipoElemento);
		
		elemCmbBox = new JComboBox<String>();
		elemCmbBox.setBounds(123, 90, 123, 27);
		frmRealizarReserva.getContentPane().add(elemCmbBox);
		
		JLabel lblElemento = new JLabel("Elemento");
		lblElemento.setBounds(10, 96, 73, 14);
		frmRealizarReserva.getContentPane().add(lblElemento);
		
		calendar = new JCalendar();
		calendar.setBounds(280, 47, 205, 153);
		frmRealizarReserva.getContentPane().add(calendar);
		
		lblHora = new JLabel("Hora");
		lblHora.setBounds(10, 137, 46, 14);
		frmRealizarReserva.getContentPane().add(lblHora);
		
		timePicker = new TimePicker();
		timePicker.setBounds(123, 133, 76, 23);
		frmRealizarReserva.getContentPane().add(timePicker);
		
		JButton btnReservar = new JButton("Reservar");
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reservarClick();
			}
		});
		btnReservar.setIcon(new ImageIcon("D:\\Users\\mauri\\eclipse\\Librerias JAVA\\png\\004-exito.png"));
		btnReservar.setBounds(229, 315, 123, 23);
		frmRealizarReserva.getContentPane().add(btnReservar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon("D:\\Users\\mauri\\eclipse\\Librerias JAVA\\png\\003-error.png"));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmRealizarReserva.dispose();
			}
		});
		btnCancelar.setBounds(362, 315, 123, 23);
		frmRealizarReserva.getContentPane().add(btnCancelar);
		
		lblDetalle = new JLabel("Detalle");
		lblDetalle.setBounds(10, 186, 46, 14);
		frmRealizarReserva.getContentPane().add(lblDetalle);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 211, 475, 85);
		frmRealizarReserva.getContentPane().add(scrollPane);
		
		txtDetalle = new JTextArea();
		txtDetalle.setColumns(20);
		scrollPane.setViewportView(txtDetalle);
	
		
		try {
			this.llenarTypes();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	private void reservarClick() {
		Booking b = this.mapearDeForm();
		try {
			ctrlBook.add(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Reserva realizada satisfactoriamente.");
		frmRealizarReserva.dispose();
	}
	
	private Booking mapearDeForm(){
		JYearChooser year = this.calendar.getYearChooser();
		JMonthChooser month = this.calendar.getMonthChooser();
		JDayChooser day = this.calendar.getDayChooser();
		String date = year.getYear() + "-" + month.getMonth() + "-" + day.getDay();
		Booking b = new Booking();
		b.setDetalle(this.txtDetalle.getText());
		b.setFecha(Date.valueOf(date));
		b.setHora(Time.valueOf(this.timePicker.getTime()));
		b.setId_tipoElemento(this.getId_tipoele((String) tipoEleCmbBox.getSelectedItem()));
		b.setId_elemento(this.getId_ele((String) elemCmbBox.getSelectedItem()));
		/*b.setId_persona(String.valueOf(this.contrasenia.getPassword())); */
		return b;
	}
	
	private void llenarTypes() throws Exception {
		ArrayList<String> types = new ArrayList<String>();
		types = ctrlType.getAllNames();
		for(int i = 0; i<types.size(); i++) {
			tipoEleCmbBox.addItem(types.get(i));
		}
	}
	
	private int getId_tipoele(String type) {
		Integer id = null;
		try {
			id = ctrlType.getTypeId(type);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	
	private int getId_ele(String elem) {
		Integer id = null;
		try {
			id = ctrlItems.getItemId(elem);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
		
	
	
	private void llenarElem(String type) throws Exception {
		elemCmbBox.removeAllItems();
		Integer id_tipo = null;
		ArrayList<String> items = new ArrayList<String>();
		id_tipo = this.getId_tipoele(type);
		items = ctrlItems.getAllNames(id_tipo);
		for(int i = 0; i<items.size(); i++) {
			elemCmbBox.addItem(items.get(i));
		}
	}
	
	public void getId_Persona() {
		
	}
}
