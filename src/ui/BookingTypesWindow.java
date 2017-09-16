package ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.SwingConstants;

import controllers.CtrlBookingTypes;
import entity.BookableTypes;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;


public class BookingTypesWindow {
	
	private CtrlBookingTypes ctrl = new CtrlBookingTypes();
	private ArrayList<BookableTypes> booktypes;

	private JInternalFrame frmCargarTiposElementos;
	private JTextField textFieldId;
	private JTextField textFieldTipoElemento;
	private JTextField textFieldMaxReservas;
	private JTable table;

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
		
		frmCargarTiposElementos = new JInternalFrame();
		frmCargarTiposElementos.setTitle("Cargar tipos elementos");
		frmCargarTiposElementos.setBounds(100, 100, 604, 353);
		frmCargarTiposElementos.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		frmCargarTiposElementos.getContentPane().setLayout(null);
		
		
		JLabel lblId = new JLabel("Id ");
		lblId.setBounds(52, 31, 22, 14);
		frmCargarTiposElementos.getContentPane().add(lblId);
		
		JLabel lblTipoElemento = new JLabel("Tipo de elemento");
		lblTipoElemento.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoElemento.setBounds(25, 61, 108, 14);
		frmCargarTiposElementos.getContentPane().add(lblTipoElemento);
		
		textFieldId = new JTextField();
		textFieldId.setEditable(false);
		textFieldId.setBounds(84, 28, 65, 20);
		frmCargarTiposElementos.getContentPane().add(textFieldId);
		textFieldId.setColumns(10);
		
		textFieldTipoElemento = new JTextField();
		textFieldTipoElemento.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldTipoElemento.setBounds(169, 58, 86, 20);
		frmCargarTiposElementos.getContentPane().add(textFieldTipoElemento);
		textFieldTipoElemento.setColumns(10);
		
		JLabel lblMaxReservas = new JLabel("M\u00E1x. Reservas pendientes");
		lblMaxReservas.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaxReservas.setBounds(10, 86, 159, 20);
		frmCargarTiposElementos.getContentPane().add(lblMaxReservas);
		
		textFieldMaxReservas = new JTextField();
		textFieldMaxReservas.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldMaxReservas.setBounds(179, 86, 65, 20);
		frmCargarTiposElementos.getContentPane().add(textFieldMaxReservas);
		textFieldMaxReservas.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				agregarClick();
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmCargarTiposElementos.dispose();
			}
		});
		btnCancelar.setBounds(440, 269, 89, 23);
		frmCargarTiposElementos.getContentPane().add(btnCancelar);
		btnAgregar.setBounds(21, 151, 89, 23);
		frmCargarTiposElementos.getContentPane().add(btnAgregar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modificarClick();
			}
		});
		btnModificar.setBounds(21, 185, 89, 23);
		frmCargarTiposElementos.getContentPane().add(btnModificar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				borrarClick();
			}
		});
		btnBorrar.setBounds(21, 219, 89, 23);
		frmCargarTiposElementos.getContentPane().add(btnBorrar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buscarClick();
			}
		});
		btnBuscar.setBounds(301, 269, 89, 23);
		frmCargarTiposElementos.getContentPane().add(btnBuscar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cleanForm();
			}
		});
		btnLimpiar.setIcon(new ImageIcon(BookingTypesWindow.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
		btnLimpiar.setBounds(138, 117, 99, 23);
		frmCargarTiposElementos.getContentPane().add(btnLimpiar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(291, 24, 281, 227);
		frmCargarTiposElementos.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		try{

			this.booktypes=ctrl.getAll();

		} catch (Exception e){

			JOptionPane.showMessageDialog(this.frmCargarTiposElementos,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}

		initDataBindings();
		
		
		
	}
	
	protected void refreshTable(){
		try{

			this.booktypes=ctrl.getAll();

		} catch (Exception e){

			JOptionPane.showMessageDialog(this.frmCargarTiposElementos,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}

		initDataBindings();
	}
	
	protected void initDataBindings() {
		
		JTableBinding<BookableTypes, java.util.List<BookableTypes>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, booktypes, table);
		BeanProperty<BookableTypes, String> personaBeanProperty = BeanProperty.create("id");
		jTableBinding.addColumnBinding(personaBeanProperty).setColumnName("Id").setEditable(false);
		BeanProperty<BookableTypes, String> personaBeanProperty_1 = BeanProperty.create("nombre");
		jTableBinding.addColumnBinding(personaBeanProperty_1).setColumnName("Nombre").setEditable(false);
		BeanProperty<BookableTypes, String> personaBeanProperty_2 = BeanProperty.create("cantReservasPendientes");
		jTableBinding.addColumnBinding(personaBeanProperty_2).setColumnName("Cant. Reservas Pend.").setEditable(false);
		jTableBinding.setEditable(false);

		jTableBinding.bind();
	}
	
	
	protected void buscarClick(){
		try {
			this.mapearAForm(ctrl.getRow(table.getSelectedRow()));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frmCargarTiposElementos, e.getMessage());
		}
	}
	
	protected void agregarClick(){
		BookableTypes bt = this.mapearDeForm();
		try{
			ctrl.add(bt);
			JOptionPane.showMessageDialog(null, "Tipo de elemento agregado");
			cleanForm();
			this.refreshTable();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frmCargarTiposElementos, e.getMessage());
		}
		this.textFieldId.setText(String.valueOf(bt.getId()));
	}
	
	protected void borrarClick(){
		
		try{
			ctrl.delete(this.mapearDeForm());
			JOptionPane.showMessageDialog(null, "Tipo de elemento eliminado");
			cleanForm();
			this.refreshTable();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this.frmCargarTiposElementos, "Imposible eliminar tipo de elemento. Modificar antes elementos o reservas");
		}
	}	
	
	protected void modificarClick(){
		try{
			ctrl.update(this.mapearDeForm());
			JOptionPane.showMessageDialog(null, "Tipo de elemento actualizado");
			cleanForm();
			this.refreshTable();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this.frmCargarTiposElementos, e.getMessage());
		}

	}
	
	private void cleanForm() {
		this.textFieldId.setText(null);
		this.textFieldTipoElemento.setText(null);
		this.textFieldMaxReservas.setText(null);
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
	
	private void mapearAForm(BookableTypes bt){
		this.textFieldId.setText(String.valueOf(bt.getId()));
		this.textFieldTipoElemento.setText(bt.getNombre());
		this.textFieldMaxReservas.setText(String.valueOf(bt.getCantReservasPendientes()));
	}
	
	public void setVisible(boolean v) {
		this.frmCargarTiposElementos.setVisible(v);
	}
	
	public void setDesktopPane(JDesktopPane p) {
		p.add(this.frmCargarTiposElementos);
	}

	
}
