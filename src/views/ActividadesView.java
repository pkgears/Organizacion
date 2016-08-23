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
import javax.swing.JComboBox;
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

import clases.*;

import controllers.FilesController;
import javax.swing.SwingConstants;

public class ActividadesView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ArrayList<Persona> personas;
	private ArrayList<Organizacion> organizaciones;
	private ArrayList<Negocio> negocios;
	private ArrayList<Actividad> actividades;
	private FilesController controller = new FilesController();
	private JTextField textTipo;
	private JTextField textFecha;
	private JTextField textHora;
	private JTextField textDuracion;

	
	/**
	 * Create the frame.
	 * @throws FileNotFoundException 
	 */
	public ActividadesView() throws FileNotFoundException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 402);
		
		controller = new FilesController();
		
		personas = controller.getAllPersonas();
		organizaciones = controller.getAllOrganizaciones();
		negocios = controller.getAllNegocios();
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel labelError = new JLabel("");
		labelError.setBounds(183, 12, 330, 15);
		contentPane.add(labelError);
		
		JButton btnBack = new JButton("<-");
		btnBack.setBounds(22, 280, 49, 25);
		contentPane.add(btnBack);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 12, 607, 256);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.RED);
		tabbedPane.addTab("Todas", null, panel, null);
		
		
		JTable table = new JTable();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		loadActividades(model);
		
		table.setModel(model);
		table.setFillsViewportHeight(true);
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		
		panel.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Nueva", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblAgregarActividad = new JLabel("Agregar Actividad");
		lblAgregarActividad.setBounds(196, 12, 149, 15);
		panel_1.add(lblAgregarActividad);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(473, 192, 117, 25);
		panel_1.add(btnAgregar);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(12, 43, 70, 15);
		panel_1.add(lblTipo);
		
		textTipo = new JTextField();
		textTipo.setBounds(61, 41, 184, 19);
		panel_1.add(textTipo);
		textTipo.setColumns(10);
		
		JLabel lblDescripcin = new JLabel("Descripción");
		lblDescripcin.setBounds(12, 86, 93, 15);
		panel_1.add(lblDescripcin);
		
		JTextArea textDescripcion = new JTextArea();
		textDescripcion.setLineWrap(true);
		textDescripcion.setBounds(12, 113, 233, 46);
		panel_1.add(textDescripcion);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(12, 171, 54, 15);
		panel_1.add(lblFecha);
		
		textFecha = new JTextField();
		textFecha.setText("");
		textFecha.setBounds(12, 195, 111, 19);
		panel_1.add(textFecha);
		textFecha.setColumns(10);
		
		JLabel lblEmpresa = new JLabel("Empresa");
		lblEmpresa.setBounds(260, 43, 70, 15);
		panel_1.add(lblEmpresa);
		
		JLabel lblPersona = new JLabel("Persona");
		lblPersona.setBounds(263, 113, 70, 15);
		panel_1.add(lblPersona);
		
		JComboBox<String> comboEmpresa = new JComboBox<String>();
		comboEmpresa.setBounds(260, 64, 155, 24);
		panel_1.add(comboEmpresa);
		fillComboEmpresa(organizaciones, comboEmpresa);
		
		JComboBox<String> comboPersona = new JComboBox<String>();
		comboPersona.setBounds(260, 135, 155, 24);
		panel_1.add(comboPersona);
		fillComboPersona(personas, comboPersona);
		
		JComboBox<String> comboNegocios = new JComboBox<String>();
		comboNegocios.setBounds(441, 64, 138, 24);
		panel_1.add(comboNegocios);
		fillComboNegocios(negocios, comboNegocios);
		
		JLabel lblNegocio = new JLabel("Negocio");
		lblNegocio.setHorizontalAlignment(SwingConstants.LEFT);
		lblNegocio.setBounds(431, 43, 70, 15);
		panel_1.add(lblNegocio);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(141, 171, 70, 15);
		panel_1.add(lblHora);
		
		textHora = new JTextField();
		textHora.setBounds(135, 195, 114, 19);
		panel_1.add(textHora);
		textHora.setColumns(10);
		
		JLabel lblDuracion = new JLabel("Duracion");
		lblDuracion.setBounds(270, 171, 70, 15);
		panel_1.add(lblDuracion);
		
		textDuracion = new JTextField();
		textDuracion.setBounds(266, 195, 114, 19);
		panel_1.add(textDuracion);
		textDuracion.setColumns(10);
		
		
		JTextArea txtInstrucciones = new JTextArea();
		txtInstrucciones.setFont(new Font("Dialog", Font.PLAIN, 11));
		txtInstrucciones.setLineWrap(true);
		txtInstrucciones.setEditable(false);
		txtInstrucciones.setWrapStyleWord(true);
		txtInstrucciones.setText("Para modificar dar doble click sobre la celda que desea modifcar, hacer los cambios, presionar enter y luego click sobre el boton \"Guardar Cambios\"");
		txtInstrucciones.setBounds(160, 286, 459, 45);
		contentPane.add(txtInstrucciones);
		
		
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Actividad newActividad = new Actividad(
						textDescripcion.getText(),
						textTipo.getText(),
						textFecha.getText(),
						textHora.getText(),
						textDuracion.getText(),
						comboPersona.getSelectedItem().toString(),
						comboEmpresa.getSelectedItem().toString(),
						comboNegocios.getSelectedItem().toString()
						);
				try{
					controller.saveFile(newActividad);
					model.addRow(new Object[]{
						newActividad.getTipo(),
						newActividad.getDescripcion(),
						newActividad.getFecha(),
						newActividad.getHora(),
						newActividad.getDuracion(),
						newActividad.getNombreOrganizacion(),
						newActividad.getNombrePersona(),
						newActividad.getNombreNegocio()
					});
				}catch(Exception e){
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
					controller.saveActividadesArrayOnFile(actividades, model);
					labelError.setText("");
				}catch(Exception e){
					labelError.setText("Para eliminar seleccione un registro");
				}
				
			}
		});
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controller.saveActividadesArrayOnFile(actividades, model);
			}
		});
		
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				Main window = new Main();
				window.setVisible(true);
				ActividadesView.this.dispose();;
			}
		});
	}
	
	public void loadActividades(DefaultTableModel model){
		actividades = controller.getAllActividades();
		model.addColumn("Tipo");
		model.addColumn("Descripcion");
		model.addColumn("Fecha");
		model.addColumn("Hora");
		model.addColumn("Hora");
		model.addColumn("Organizacion");
		model.addColumn("Persona");
		model.addColumn("Negocio");
		actividades.forEach(element ->{
			model.addRow(new Object[]{
				element.getTipo(),
				element.getDescripcion(),
				element.getFecha(),
				element.getHora(),
				element.getDuracion(),
				element.getNombreOrganizacion(),
				element.getNombrePersona(),
				element.getNombreNegocio()
			});
		});
	}

	public void fillComboPersona(ArrayList<Persona> array, JComboBox<String> combo ){
		array.forEach(element ->{
			combo.addItem( element.getNombre() );
		});
	}
	
	public void fillComboEmpresa(ArrayList<Organizacion> array, JComboBox<String> combo ){
		array.forEach(element ->{
			combo.addItem( element.getNombre() );
		});
	}
	
	public void fillComboNegocios(ArrayList<Negocio> array , JComboBox<String> combo ){
		array.forEach(element ->{
			combo.addItem( element.getTítulo() );
		});
	}
}	
	