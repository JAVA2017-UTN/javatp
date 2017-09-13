package ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import controllers.CtrlBookableItems;
import controllers.CtrlBookingTypes;
import entity.BookableItems;
import entity.BookableTypes;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class BookingItemWindow extends JInternalFrame {
	
	private CtrlBookableItems ctrl = new CtrlBookableItems();
	private CtrlBookingTypes ctrlbt = new CtrlBookingTypes();
	
	private JTable elemTbl;
	private JTextField txtId;
	private JTextField txtNombre;
	private JComboBox<String> tipoEleCmbBox;
	private CtrlBookingTypes ctrlType = new CtrlBookingTypes();
	private CtrlBookableItems ctrlItems = new CtrlBookableItems();
	private ArrayList<BookableItems> items;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookingItemWindow frame = new BookingItemWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BookingItemWindow() {
		setClosable(true);
		setTitle("Elementos");
		setBounds(100, 100, 644, 339);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(287, 10, 330, 230);
		getContentPane().add(scrollPane);
		
		elemTbl = new JTable();
		scrollPane.setViewportView(elemTbl);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(10, 11, 46, 14);
		getContentPane().add(lblId);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 55, 46, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblTipoElemento = new JLabel("Tipo Elemento");
		lblTipoElemento.setBounds(10, 101, 88, 14);
		getContentPane().add(lblTipoElemento);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(66, 8, 86, 20);
		getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(66, 52, 86, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		tipoEleCmbBox = new JComboBox<String>();
		tipoEleCmbBox.setBounds(95, 97, 116, 23);
		
		try {
			this.llenarTypes();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		getContentPane().add(tipoEleCmbBox);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLimpiarClick();
			}
		});
		btnLimpiar.setIcon(new ImageIcon(BookingItemWindow.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
		btnLimpiar.setBounds(122, 149, 110, 23);
		getContentPane().add(btnLimpiar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBuscarClick();
			}
		});
		btnBuscar.setBounds(287, 251, 89, 23);
		getContentPane().add(btnBuscar);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnAgregarClick();
			}
		});
		btnAgregar.setBounds(9, 149, 89, 23);
		getContentPane().add(btnAgregar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnModificarClick();
			}
		});
		btnModificar.setBounds(10, 183, 89, 23);
		getContentPane().add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEliminarClick();
			}
		});
		btnEliminar.setBounds(10, 217, 89, 23);
		getContentPane().add(btnEliminar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(460, 251, 89, 23);
		getContentPane().add(btnCancelar);
		
		loadTable();

	}
	
	private void loadTable() {
		try{

			this.items = ctrlItems.getAll();

		} catch (Exception e){

			JOptionPane.showMessageDialog(this,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}

		initDataBindings();
	}
	
	private void initDataBindings() {
		
		JTableBinding<BookableItems, java.util.List<BookableItems>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, items, elemTbl);
		BeanProperty<BookableItems, String> personaBeanProperty = BeanProperty.create("id");
		jTableBinding.addColumnBinding(personaBeanProperty).setColumnName("Id").setEditable(false);
		BeanProperty<BookableItems, String> personaBeanProperty_1 = BeanProperty.create("nombre");
		jTableBinding.addColumnBinding(personaBeanProperty_1).setColumnName("Nombre").setEditable(false);
		BeanProperty<BookableItems, String> personaBeanProperty_2 = BeanProperty.create("id_tipoElemento");
		jTableBinding.addColumnBinding(personaBeanProperty_2).setColumnName("ID Tipo Elemento").setEditable(false);
		jTableBinding.setEditable(false);

		jTableBinding.bind();
	}
	
	private void btnLimpiarClick() {
		this.cleanForm();	
	}
	
	private void btnBuscarClick(){
		try {
			this.mapearAForm(ctrl.getRow(elemTbl.getSelectedRow()));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
		
	private void btnAgregarClick() {
		BookableItems bi = this.mapearDeForm();
		try{
			ctrlItems.add(bi);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		this.txtId.setText(String.valueOf(bi.getId()));
		loadTable();
	}
	
	private void btnModificarClick() {
		try{
			ctrlItems.update(this.mapearDeForm());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		loadTable();
	}
	
	private void btnEliminarClick() {
		try{
			ctrlItems.delete(this.mapearDeForm());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		loadTable();
	}
	
	private void cleanForm() {
		this.txtId.setText(null);
		this.txtNombre.setText(null);
		this.tipoEleCmbBox.setSelectedItem(null);
		
	}
	
	private void llenarTypes() throws Exception {
		ArrayList<String> types = new ArrayList<String>();
		types = ctrlType.getAllNames();
		for(int i = 0; i<types.size(); i++) {
			this.tipoEleCmbBox.addItem(types.get(i));
		}
	}
	
	private BookableItems mapearDeForm(){
		BookableItems bi= new BookableItems();
		if(!this.txtId.getText().isEmpty()){
			bi.setId(Integer.parseInt(this.txtId.getText()));
		}
		bi.setNombre(this.txtNombre.getText());
		bi.setId_tipoElemento(this.getId_tipoEle(String.valueOf(this.tipoEleCmbBox.getSelectedItem())));
		
		return bi;
	}
	
	private void mapearAForm(BookableItems bi) throws Exception{
		BookableTypes bt = new BookableTypes();
		this.txtId.setText(String.valueOf(bi.getId()));
		this.txtNombre.setText(bi.getNombre());
		bt = ctrlbt.getById(bi.getId_tipoElemento());
		this.tipoEleCmbBox.setSelectedItem(bt.getNombre());
	}
	
	private int getId_tipoEle(String type) {
		Integer id = null;
		try {
			id = ctrlType.getTypeId(type);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}
}
