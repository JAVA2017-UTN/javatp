package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.Panel;
import java.awt.TextField;
import javax.swing.JTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;

import entity.People;

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
		frame.setBounds(100, 100, 774, 705);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(139, 32, 124, 59);
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
		toolBar_1.setBounds(377, 32, 124, 59);
		frame.getContentPane().add(toolBar_1);
		
		JButton btnReservas = new JButton("Reservas");
		btnReservas.setIcon(new ImageIcon(MainMenu.class.getResource("/com/sun/java/swing/plaf/windows/icons/JavaCup32.png")));
		toolBar_1.add(btnReservas);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.menu);
		desktopPane.setBounds(10, 104, 738, 530);
		frame.getContentPane().add(desktopPane);
		
		
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

	public void setVisible(boolean b, People per) {
		frame.setVisible(b);
		frame.setTitle("Bienvenido " + per.getNombre() + " " + per.getApellido());
		
	}
}
