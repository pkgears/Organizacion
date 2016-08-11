package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnPersonas = new JButton("Personas");
		btnPersonas.setBounds(50, 50, 150, 25);
		
		JButton btnOrganizaciones = new JButton("Organizaciones");
		btnOrganizaciones.setBounds(238, 50, 150, 25);
		
		JButton btnNegocios = new JButton("Negocios");
		btnNegocios.setBounds(50, 124, 150, 25);
		
		JButton btnActividades = new JButton("Actividades");
		btnActividades.setBounds(238, 124, 150, 25);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(359, 210, 66, 25);
		contentPane.setLayout(null);
		contentPane.add(btnPersonas);
		contentPane.add(btnOrganizaciones);
		contentPane.add(btnNegocios);
		contentPane.add(btnActividades);
		contentPane.add(btnSalir);
	}

}
