package ui;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import controllers.CtrlBooking;
import entity.Booking;
import entity.Session;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookingCancelWindow {

	private CtrlBooking ctrlBook = new CtrlBooking();
	private ArrayList<Booking> bookings;
	private JInternalFrame frmReservas;
	private JTable tblReservas;
	private JTextField txtId;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookingCancelWindow window = new BookingCancelWindow();
					window.frmReservas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BookingCancelWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmReservas = new JInternalFrame();
		frmReservas.setTitle("Cancelar Reserva");
		frmReservas.setBounds(100, 100, 786, 359);
		frmReservas.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		frmReservas.getContentPane().setLayout(null);
		
		JLabel lblListaDeReservas = new JLabel("Usuario "+ Session.usuario + ", su lista de reservas es la siguiente:");
		lblListaDeReservas.setBounds(10, 22, 447, 20);
		frmReservas.getContentPane().add(lblListaDeReservas);
		
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(556, 255, 29, 14);
		frmReservas.getContentPane().add(lblId);
		
		txtId = new JTextField();
		txtId.setBounds(595, 252, 74, 20);
		frmReservas.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnEliminarClick();
			}
		});
		btnEliminar.setIcon(new ImageIcon("D:\\Users\\mauri\\eclipse\\Librerias JAVA\\png\\003-error.png"));
		btnEliminar.setBounds(556, 286, 105, 23);
		frmReservas.getContentPane().add(btnEliminar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmReservas.dispose();
			}
		});
		btnCancelar.setBounds(671, 286, 89, 23);
		frmReservas.getContentPane().add(btnCancelar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 60, 750, 181);
		frmReservas.getContentPane().add(scrollPane);
		
		tblReservas = new JTable();
		scrollPane.setViewportView(tblReservas);
		
		loadTable();
	}
	
	private void btnEliminarClick() {
		if(this.txtId.getText() != null) {
		try {
			ctrlBook.deleteById(Integer.parseInt(this.txtId.getText()));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loadTable();
		this.txtId.setText(null);
		}
	}
	
	private void loadTable() {
		try{

			this.bookings = ctrlBook.getReservasByPerson(Session.getDni());

		} catch (Exception e){

			JOptionPane.showMessageDialog(this.frmReservas,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}

		initDataBindings();
	}
	
	private void initDataBindings() {
		
		JTableBinding<Booking, java.util.List<Booking>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, bookings, tblReservas);
		BeanProperty<Booking, String> personaBeanProperty = BeanProperty.create("id");
		jTableBinding.addColumnBinding(personaBeanProperty).setColumnName("Id").setEditable(false);
		BeanProperty<Booking, String> personaBeanProperty_1 = BeanProperty.create("detalle");
		jTableBinding.addColumnBinding(personaBeanProperty_1).setColumnName("Detalle").setEditable(false);
		BeanProperty<Booking, String> personaBeanProperty_2 = BeanProperty.create("fecha");
		jTableBinding.addColumnBinding(personaBeanProperty_2).setColumnName("Fecha").setEditable(false);
		BeanProperty<Booking, String> personaBeanProperty_3 = BeanProperty.create("hora");
		jTableBinding.addColumnBinding(personaBeanProperty_3).setColumnName("Hora").setEditable(false);
		BeanProperty<Booking, String> personaBeanProperty_5 = BeanProperty.create("id_tipoElemento");
		jTableBinding.addColumnBinding(personaBeanProperty_5).setColumnName("ID Tipo Elemento").setEditable(false);
		BeanProperty<Booking, String> personaBeanProperty_4 = BeanProperty.create("id_elemento");
		jTableBinding.addColumnBinding(personaBeanProperty_4).setColumnName("ID Elemento").setEditable(false);
		BeanProperty<Booking, String> personaBeanProperty_6 = BeanProperty.create("id_persona");
		jTableBinding.addColumnBinding(personaBeanProperty_6).setColumnName("ID Persona").setEditable(false);
		
		jTableBinding.setEditable(false);

		jTableBinding.bind();
	}
	
	public void setVisible(boolean v) {
		this.frmReservas.setVisible(v);
	}
	
	public void setDesktopPane(JDesktopPane p) {
		p.add(this.frmReservas);
	}
}
