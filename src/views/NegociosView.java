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

import clases.Negocio;
import clases.Organizacion;
import clases.Persona;
import controllers.FilesController;
import javax.swing.JComboBox;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class NegociosView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private FilesController controller = new FilesController();
	
	private ArrayList<Negocio> negocios;
	private ArrayList<Persona> personas;
	private ArrayList<Organizacion> organizaciones;
	private JTextField textTitulo;
	private JTextField textFecha;
	private JTextField textValor;
	private JTextField textStatus;

	/**
	 * Create the frame.
	 * @throws FileNotFoundException 
	 */
	public NegociosView() throws FileNotFoundException {
		setTitle("Negocios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 402);
		
		personas = controller.getAllPersonas();
		organizaciones = controller.getAllOrganizaciones();
		
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
		loadNegocios(model);
		table.setModel(model);
		table.setFillsViewportHeight(true);
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		
		panel.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Nueva", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblAgregarPersona = new JLabel("Agregar Negocio");
		lblAgregarPersona.setBounds(196, 12, 120, 15);
		panel_1.add(lblAgregarPersona);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(473, 192, 117, 25);
		panel_1.add(btnAgregar);
		
		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setBounds(12, 43, 70, 15);
		panel_1.add(lblTitulo);
		
		textTitulo = new JTextField();
		textTitulo.setBounds(90, 41, 155, 19);
		panel_1.add(textTitulo);
		textTitulo.setColumns(10);
		
		JLabel lblDescripcin = new JLabel("Descripción");
		lblDescripcin.setBounds(12, 86, 93, 15);
		panel_1.add(lblDescripcin);
		
		JTextArea textDescripcion = new JTextArea();
		textDescripcion.setLineWrap(true);
		textDescripcion.setBounds(12, 113, 233, 46);
		panel_1.add(textDescripcion);
		
		JLabel lblFechaDeCierre = new JLabel("Fecha de cierre");
		lblFechaDeCierre.setBounds(12, 192, 120, 15);
		panel_1.add(lblFechaDeCierre);
		
		textFecha = new JTextField();
		textFecha.setText("");
		textFecha.setBounds(134, 192, 111, 19);
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
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(431, 43, 70, 15);
		panel_1.add(lblValor);
		
		textValor = new JTextField();
		textValor.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				try{
					Float.parseFloat( textValor.getText() );
					labelError.setText("");
					btnAgregar.setEnabled(true);
				}catch(Exception e){
					System.out.println("Verifica que el campo valor sea numérico");
					labelError.setText("Verifica que el campo valor sea numérico");
					btnAgregar.setEnabled(false);
				}
			}
		});
		
		textValor.setBounds(441, 67, 114, 19);
		panel_1.add(textValor);
		textValor.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(431, 113, 70, 15);
		panel_1.add(lblEstado);
		
		textStatus = new JTextField();
		textStatus.setBounds(441, 138, 114, 19);
		panel_1.add(textStatus);
		textStatus.setColumns(10);
		
		
		
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
				Negocio newNegocio = new Negocio();
				newNegocio.setTítulo(textTitulo.getText());
				newNegocio.setDescripción(textDescripcion.getText());
				newNegocio.setFechaCierre(textFecha.getText());
				newNegocio.setNombreOrganización(comboEmpresa.getSelectedItem().toString() );
				newNegocio.setNombrePersona(comboPersona.getSelectedItem().toString() );
				newNegocio.setEstado(textStatus.getText());
				newNegocio.setValor( Float.parseFloat( textValor.getText() ) );
				try {
					controller.saveFile(newNegocio);
					model.addRow(new Object[]{
						newNegocio.getTítulo(),
						newNegocio.getDescripción(),
						newNegocio.getFechaCierre(),
						newNegocio.getNombreOrganización(),
						newNegocio.getNombrePersona(),
						newNegocio.getValor(),
						newNegocio.getEstado()
					});
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
					controller.saveNegociosArrayOnFile(negocios, model);
					labelError.setText("");
				}catch(Exception e){
					labelError.setText("Para eliminar seleccione un registro");
				}
				
			}
		});
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controller.saveNegociosArrayOnFile(negocios, model);
			}
		});
		
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				Main window = new Main();
				window.setVisible(true);
				NegociosView.this.dispose();;
			}
		});
	}

	public void loadNegocios(DefaultTableModel model) throws FileNotFoundException{
		negocios = controller.getAllNegocios();
		model.addColumn("Titulo");
		model.addColumn("Descripción");
		model.addColumn("Fecha de cierre");
		model.addColumn("Nombre empresa");
		model.addColumn("Nombre persona");
		model.addColumn("Valor");
		model.addColumn("Estado");
		negocios = controller.getAllNegocios();
		negocios.forEach(element ->{
			model.addRow(new Object[]{
				element.getTítulo(),
				element.getDescripción(),
				element.getFechaCierre(),
				element.getNombreOrganización(),
				element.getNombrePersona(),
				element.getValor(),
				element.getEstado()
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
}
