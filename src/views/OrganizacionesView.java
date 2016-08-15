package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clases.Organizacion;
import controllers.FilesController;

public class OrganizacionesView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private FilesController controller = new FilesController();
	private JTextField nombreField;
	private JTextField direccionField;
	private JTextField telefonoField;
	
	private ArrayList<Organizacion> organizaciones;
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					OrganizacionesView frame = new OrganizacionesView();
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
	public OrganizacionesView() throws FileNotFoundException {
		setTitle("Personas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 373);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("<-");
		btnBack.setBounds(22, 280, 49, 25);
		contentPane.add(btnBack);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 12, 513, 256);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.RED);
		tabbedPane.addTab("Todas", null, panel, null);
		
		
		JTable table = new JTable();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		loadOrganizaciones(model);
		table.setModel(model);
		table.setFillsViewportHeight(true);
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		
		panel.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Nueva", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblAgregarPersona = new JLabel("Agregar Organizacion");
		lblAgregarPersona.setBounds(196, 12, 120, 15);
		panel_1.add(lblAgregarPersona);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(50, 60, 70, 15);
		panel_1.add(lblNombre);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(50, 107, 70, 15);
		panel_1.add(lblTelefono);
		
		JLabel lblCorreo = new JLabel("Direccion");
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
		
		direccionField = new JTextField();
		direccionField.setText("");
		direccionField.setBounds(138, 152, 325, 19);
		panel_1.add(direccionField);
		direccionField.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(355, 192, 117, 25);
		panel_1.add(btnAgregar);
		
		JTextArea txtrParaModificarDar = new JTextArea();
		txtrParaModificarDar.setFont(new Font("Dialog", Font.PLAIN, 11));
		txtrParaModificarDar.setLineWrap(true);
		txtrParaModificarDar.setEditable(false);
		txtrParaModificarDar.setWrapStyleWord(true);
		txtrParaModificarDar.setText("Para modificar dar doble click sobre la celda que desea modifcar, hacer los cambios, presionar enter y luego click sobre el boton \"Guardar Cambios\"");
		txtrParaModificarDar.setBounds(160, 268, 353, 45);
		contentPane.add(txtrParaModificarDar);
		
		JLabel labelError = new JLabel("");
		labelError.setBounds(183, 12, 330, 15);
		contentPane.add(labelError);
		
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Organizacion newOrganizacion = new Organizacion
						(nombreField.getText(), telefonoField.getText(), direccionField.getText() );
				nombreField.setText("");
				telefonoField.setText("");
				direccionField.setText("");
				try {
					controller.saveFile(newOrganizacion);
					model.addRow(new Object[]{newOrganizacion.getNombre(),newOrganizacion.getTelefono(), newOrganizacion.getDireccion() });
				} catch (FileNotFoundException e){
					e.printStackTrace();
				}
			}
		});
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton btnGuardar = new JButton("Guardar cambios");
		menuBar.add(btnGuardar);
		
		JButton btnBorrar= new JButton("Borrar reg. selecionado");
		menuBar.add(btnBorrar);
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					model.removeRow(table.getSelectedRow());
					controller.saveOrganizacionesArrayOnFile(organizaciones, model);
					labelError.setText("");
				}catch(Exception e){
					labelError.setText("Para eliminar seleccione un registro");
				}
				
			}
		});
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controller.saveOrganizacionesArrayOnFile(organizaciones, model);
			}
		});
		
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				Main window = new Main();
				window.setVisible(true);
				OrganizacionesView.this.dispose();;
			}
		});
	}
	
	public void loadOrganizaciones(DefaultTableModel model) throws FileNotFoundException{
		organizaciones = controller.getAllOrganizaciones();
		model.addColumn("Nombre");
		model.addColumn("Telefono");
		model.addColumn("Direccion");
		organizaciones.forEach(element ->{
			model.addRow(new Object[]{element.getNombre(),element.getTelefono(), element.getDireccion() });
		});
 	}

}
