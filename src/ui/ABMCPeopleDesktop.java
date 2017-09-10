package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.CtrlABMPeople;
import entity.People;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ABMCPeopleDesktop extends JInternalFrame {

	private CtrlABMPeople ctrl=new CtrlABMPeople();
	
	private JPanel contentPane;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JCheckBox chkHabilitado;
	private JButton btnAgregar;
	private JButton btnBorrar;
	private JButton btnModificar;
	private JTextField txtId;
	private JTextField txtUsuario;
	private JLabel lblContra;
	private JPasswordField contrasenia;
	private JButton btnLimpiar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMCPeopleDesktop frame = new ABMCPeopleDesktop();
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
	public ABMCPeopleDesktop() {
		setTitle("Personas");
		setClosable(true);
		setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 300, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblDni = new JLabel("DNI");
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		
		JLabel lblApellido = new JLabel("Apellido");
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		
		chkHabilitado = new JCheckBox("Habilitado");
		chkHabilitado.setSelected(true);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buscarClick();
			}
		});
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				agregarClick();
			}
		});
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				borrarClick();
			}
		});
		
		btnModificar = new JButton("Modificar");
		btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modificarClick();
			}
		});
		
		JLabel lblId = new JLabel("ID");
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setColumns(10);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		
		lblContra = new JLabel("Contrase\u00F1a");
		
		contrasenia = new JPasswordField();
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cleanForm();
			}
		});
		btnLimpiar.setIcon(new ImageIcon(ABMCPeopleDesktop.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblApellido, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblUsuario)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtUsuario))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblId)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblDni)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNombre)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(txtApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.addGap(18)
							.addComponent(btnBuscar))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(chkHabilitado)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnLimpiar))
							.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblContra)
										.addGap(18)
										.addComponent(contrasenia))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(btnAgregar)
										.addGap(18)
										.addComponent(btnBorrar)))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnModificar))))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDni)
						.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblApellido)
						.addComponent(txtApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsuario)
						.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblContra)
						.addComponent(contrasenia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(chkHabilitado)
						.addComponent(btnLimpiar))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAgregar)
						.addComponent(btnBorrar)
						.addComponent(btnModificar))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void buscarClick() {
		try {
			this.mapearAForm(ctrl.getByDni(this.mapearDeForm()));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	
	protected void agregarClick() {
		People p = this.mapearDeForm();
		try{
			if(p.getDni().length() != 0 ) {
				ctrl.add(p);
				JOptionPane.showMessageDialog(null, "Persona agregada correctamente");
				cleanForm();
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		this.txtId.setText(String.valueOf(p.getId()));	
	}
	
	protected void borrarClick(){
		try{
			ctrl.delete(this.mapearDeForm());
			this.cleanForm();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	
	protected void modificarClick(){
		try{
			ctrl.update(this.mapearDeForm());
			this.cleanForm();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	
	private void cleanForm() {
		this.txtDni.setText(null);
		this.txtNombre.setText(null);
		this.txtApellido.setText(null);
		this.txtUsuario.setText(null);
		this.txtId.setText(null);
		this.contrasenia.setText(null);
	}
	
	private void mapearAForm(People p){
		this.txtDni.setText(p.getDni());
		this.txtNombre.setText(p.getNombre());
		this.txtApellido.setText(p.getApellido());
		this.txtUsuario.setText(p.getUsuario());
		this.chkHabilitado.setSelected(p.isHabilitado());
		this.txtId.setText(String.valueOf(p.getId()));
		this.contrasenia.setText(p.getContrasenia());
	}
	
	private People mapearDeForm(){
		People p=new People();
		if(!this.txtId.getText().isEmpty()) {
			p.setId(Integer.parseInt(this.txtId.getText()));
		}
		p.setDni(this.txtDni.getText());
		p.setNombre(this.txtNombre.getText());
		p.setApellido(this.txtApellido.getText());
		p.setEstado(this.chkHabilitado.isSelected());
		p.setUsuario(this.txtUsuario.getText());
		p.setContrasenia(String.valueOf(this.contrasenia.getPassword()));
		return p;
	}
	
}