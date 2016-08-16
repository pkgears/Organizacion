package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.FilesController;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static FilesController controller = new FilesController();
	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		controller.createFiles();
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
		setTitle("Inicio");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnPersonas = new JButton("Personas");
		btnPersonas.setBounds(50, 50, 150, 25);
		btnPersonas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				PersonasView window = null;
				try {
					window = new PersonasView();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				window.setVisible(true);
				Main.this.dispose();;
			}
		});
		

		JButton btnOrganizaciones = new JButton("Organizaciones");
		btnOrganizaciones.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				OrganizacionesView windowOrganizaciones = null;
				try{
					windowOrganizaciones = new OrganizacionesView();
				}catch( Exception e){
					e.printStackTrace();
				}
				windowOrganizaciones.setVisible(true);
				Main.this.dispose();
				
			}
		});
		btnOrganizaciones.setBounds(238, 50, 150, 25);
		
		JButton btnNegocios = new JButton("Negocios");
		btnNegocios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NegociosView window = null;
				try {
					window = new NegociosView();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				window.setVisible(true);
				Main.this.dispose();
			}
		});
		btnNegocios.setBounds(50, 124, 150, 25);
		
		JButton btnActividades = new JButton("Actividades");
		btnActividades.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ActividadesView window = new ActividadesView();
				window.setVisible(true);
				Main.this.dispose();
			}
		});
		btnActividades.setBounds(238, 124, 150, 25);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(359, 210, 66, 25);
		contentPane.setLayout(null);
		contentPane.add(btnPersonas);
		contentPane.add(btnOrganizaciones);
		contentPane.add(btnNegocios);
		contentPane.add(btnActividades);
		contentPane.add(btnSalir);
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				System.exit(0);
			}
		});
	}

}
