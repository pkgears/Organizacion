package views;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import clases.Persona;
import controllers.FilesController;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PersonasView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private FilesController controller = new FilesController();
	private JTextField nombreField;
	private JTextField telefonoField;
	private JTextField correoField;

	/**
	 * Launch the application.
	 */
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PersonasView frame = new PersonasView();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * @throws FileNotFoundException 
	 */
	public PersonasView() throws FileNotFoundException {
		setTitle("Personas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("<-");
		btnBack.setBounds(12, 303, 49, 25);
		contentPane.add(btnBack);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 12, 513, 279);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Todas", null, panel, null);
		
		
		JTable table = new JTable();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		loadPersonas(model);
		table.setModel(model);
		table.setFillsViewportHeight(true);
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		
		panel.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Nueva", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblAgregarPersona = new JLabel("Agregar Persona");
		lblAgregarPersona.setBounds(196, 12, 120, 15);
		panel_1.add(lblAgregarPersona);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(50, 60, 70, 15);
		panel_1.add(lblNombre);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(50, 107, 70, 15);
		panel_1.add(lblTelefono);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(50, 154, 70, 15);
		panel_1.add(lblCorreo);
		
		nombreField = new JTextField();
		nombreField.setBounds(138, 58, 325, 19);
		panel_1.add(nombreField);
		nombreField.setColumns(10);
		
		telefonoField = new JTextField();
		telefonoField.setBounds(138, 105, 325, 19);
		panel_1.add(telefonoField);
		telefonoField.setColumns(10);
		
		correoField = new JTextField();
		correoField.setText("");
		correoField.setBounds(138, 152, 325, 19);
		panel_1.add(correoField);
		correoField.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(363, 215, 117, 25);
		panel_1.add(btnAgregar);
		
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Persona newPersona = new Persona
						(nombreField.getText(), telefonoField.getText(), correoField.getText() );
				nombreField.setText("");
				telefonoField.setText("");
				correoField.setText("");
				try {
					controller.saveFile(newPersona);
					model.addRow(new Object[]{newPersona.getNombre(),newPersona.getTelefono(), newPersona.getCorreo() });
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				Main window = new Main();
				window.setVisible(true);
				PersonasView.this.dispose();;
			}
		});
	}
	
	public void loadPersonas(DefaultTableModel model) throws FileNotFoundException{
		ArrayList<Persona> personas = controller.getAllPersonas();
		model.addColumn("Nombre");
		model.addColumn("Telefono");
		model.addColumn("Correo");
		personas.forEach(element ->{
			model.addRow(new Object[]{element.getNombre(),element.getTelefono(), element.getCorreo() });
		});
 	}
}
