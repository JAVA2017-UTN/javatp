package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;

import entity.Session;

import javax.swing.JDesktopPane;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu {

	private JFrame frame;
	private JDesktopPane desktopPane;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 995, 705);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(23, 32, 125, 40);
		frame.getContentPane().add(toolBar);
		
		JButton btnPersonas = new JButton("Personas");
		btnPersonas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPersonasClick();
			}
		});
		btnPersonas.setIcon(new ImageIcon(MainMenu.class.getResource("/com/sun/java/swing/plaf/windows/icons/JavaCup32.png")));
		toolBar.add(btnPersonas);
		
		JToolBar toolBar_1 = new JToolBar();
		toolBar_1.setBounds(158, 32, 160, 40);
		frame.getContentPane().add(toolBar_1);
		
		JButton btnReservas = new JButton("Nueva Reserva");
		toolBar_1.add(btnReservas);
		btnReservas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnReservasClick();
			}
		});
		btnReservas.setIcon(new ImageIcon(MainMenu.class.getResource("/com/sun/java/swing/plaf/windows/icons/JavaCup32.png")));
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.menu);
		desktopPane.setBounds(10, 104, 959, 530);
		frame.getContentPane().add(desktopPane);
		
		JToolBar toolBar_2 = new JToolBar();
		toolBar_2.setBounds(328, 32, 170, 40);
		frame.getContentPane().add(toolBar_2);
		
		JButton btnCancelarReserva = new JButton("Cancelar Reserva");
		btnCancelarReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnCancelarReservaClick();
			}
		});
		btnCancelarReserva.setIcon(new ImageIcon(MainMenu.class.getResource("/com/sun/java/swing/plaf/windows/icons/JavaCup32.png")));
		toolBar_2.add(btnCancelarReserva);
		
		JToolBar toolBar_3 = new JToolBar();
		toolBar_3.setBounds(508, 32, 160, 40);
		frame.getContentPane().add(toolBar_3);
		
		JButton btnElementos = new JButton("Elementos");
		btnElementos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnElementosClick();
			}
		});
		btnElementos.setIcon(new ImageIcon(MainMenu.class.getResource("/com/sun/java/swing/plaf/windows/icons/JavaCup32.png")));
		toolBar_3.add(btnElementos);
		
		JToolBar toolBar_4 = new JToolBar();
		toolBar_4.setBounds(678, 32, 180, 40);
		frame.getContentPane().add(toolBar_4);
		
		JButton btnTiposDeElementos = new JButton("Tipos de Elementos");
		btnTiposDeElementos.setIcon(new ImageIcon(MainMenu.class.getResource("/com/sun/java/swing/plaf/windows/icons/JavaCup32.png")));
		toolBar_4.add(btnTiposDeElementos);
		
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		JMenuItem mntmCerrarSesin = new JMenuItem("Cerrar Sesi\u00F3n");
		mntmCerrarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login lg = new Login();
				lg.setVisible(true);
				frame.setVisible(false);
			}
		});
		mntmCerrarSesin.setIcon(new ImageIcon(MainMenu.class.getResource("/com/sun/java/swing/plaf/windows/icons/Warn.gif")));
		mnMenu.add(mntmCerrarSesin);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		mntmExit.setIcon(new ImageIcon(MainMenu.class.getResource("/javax/swing/plaf/metal/icons/Error.gif")));
		mnMenu.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.setIcon(new ImageIcon(MainMenu.class.getResource("/com/sun/java/swing/plaf/windows/icons/Question.gif")));
		mnHelp.add(mntmAbout);
	}
	
	protected void btnPersonasClick() {
		ABMCPeopleDesktop pd= new ABMCPeopleDesktop();
		desktopPane.add(pd);
		pd.setVisible(true);
	}
	
	protected void btnReservasClick() {
		BookingWindow bw = new BookingWindow();
		bw.setDesktopPane(desktopPane);
		bw.setVisible(true);
	}
	
	protected void btnCancelarReservaClick() {
		BookingCancelWindow bw = new BookingCancelWindow();
		bw.setDesktopPane(desktopPane);
		bw.setVisible(true);
	}
	
	protected void btnElementosClick() {
		BookingItemWindow pd= new BookingItemWindow();
		desktopPane.add(pd);
		pd.setVisible(true);
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
		frame.setTitle("Bienvenido: " + Session.getApellido() + ", " + Session.getNombre());		
	}
}
