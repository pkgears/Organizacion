package controllers;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import clases.Organizacion;
import clases.Persona;
import clases.Negocio;
import clases.Actividad;

public class FilesController {
	// atributos para archivos
	private String path = "archivos/";
	private File personasJson = new File(path+"personas.json");
    private File negociosJson =  new File(path+"negocios.json"); 
    private File organizacionesJson = new File(path+"organizaciones.json"); 
    private File actividadesJson = new File(path+"actividades.json");
    private ArrayList<File> fileList = new ArrayList<>();
   
    // Atributos para leer archvios
	private FileReader fr;
    private BufferedReader br;
    private Gson gson;
	private FileWriter fw;
	
	// Arreglos para clases
	private ArrayList<Persona> arrayPersonas;
	private ArrayList<Organizacion> arrayOrganizaciones;
	private ArrayList<Actividad> arrayActividades;
	private ArrayList<Negocio> arrayNegocios;
	
	private static final Type PERSONA_TYPE = new TypeToken<ArrayList<Persona>>() {}.getType();
	private static final Type ORGANIZACION_TYPE = new TypeToken<ArrayList<Organizacion>>() {}.getType();
	private static final Type NEGOCIO_TYPE = new TypeToken<ArrayList<Negocio>>() {}.getType();
	private static final Type ACTIVIDAD_TYPE = new TypeToken<ArrayList<Actividad>>() {}.getType();
	
	public FilesController(){
		fileList.add(personasJson);
	    fileList.add(negociosJson);
	    fileList.add(organizacionesJson);
	    fileList.add(actividadesJson);
	}
	
	public void printListFiles(){
		fileList.forEach((file)-> {
	    	System.out.println(file.getName());			
	    });    
	}
	
	
	public void createFiles() throws IOException{
	    fileList.forEach((file)-> {
	    	if(!file.exists()){
				try{
					file.createNewFile();
					FileWriter fw = new FileWriter(file);
					fw.write("[]");
					fw.flush();
					fw.close();
					System.out.println("Archivo "+file.getName() + " creado");
				}catch(Exception e){
					e.printStackTrace();
				}
	    	}else{
	    		System.out.println("Se encontró archivo "+file.getName());
	    	}
	    });    
	}
	
	public void saveFile(Persona element) throws FileNotFoundException{
		try{
			File file = this.getPersonasJson();
			Type type = PERSONA_TYPE;
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			ArrayList<Persona> array = new ArrayList<Persona>();
			
			GsonBuilder gsonbuilder = new GsonBuilder();
			gson = gsonbuilder.create();
			
			array = gson.fromJson(br,type);
			array.add(element);
			
			fw = new FileWriter(file);
			gson.toJson(array, fw);
			fw.flush();
			fw.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	
	public void saveFile(Organizacion element) throws FileNotFoundException{
		try{
			File file = this.getOrganizacionesJson();
			Type type = ORGANIZACION_TYPE;
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			ArrayList<Organizacion> array = new ArrayList<Organizacion>();
			
			GsonBuilder gsonbuilder = new GsonBuilder();
			gson = gsonbuilder.create();
			
			array = gson.fromJson(br,type);
			array.add(element);
			
			fw = new FileWriter(file);
			gson.toJson(array, fw);
			fw.flush();
			fw.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	
	public void saveFile(Actividad element) throws FileNotFoundException{
		try{
			File file = this.getActividadesJson();
			Type type = ACTIVIDAD_TYPE;
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			ArrayList<Actividad> array = new ArrayList<Actividad>();
			
			GsonBuilder gsonbuilder = new GsonBuilder();
			gson = gsonbuilder.create();
			
			array = gson.fromJson(br,type);
			array.add(element);
			
			fw = new FileWriter(file);
			gson.toJson(array, fw);
			fw.flush();
			fw.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	
	public void saveFile(Negocio element) throws FileNotFoundException{
		try{
			File file = this.getNegociosJson();
			Type type = NEGOCIO_TYPE;
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			ArrayList<Negocio> array = new ArrayList<Negocio>();
			
			GsonBuilder gsonbuilder = new GsonBuilder();
			gson = gsonbuilder.create();
			
			array = gson.fromJson(br,type);
			array.add(element);
			fw = new FileWriter(file);
			gson.toJson(array, fw);
			fw.flush();
			fw.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	
	public void savePersonasArrayOnFile(ArrayList<Persona> array, DefaultTableModel model){
		gson = new Gson();
		array.clear();
		for (int count_row = 0; count_row < model.getRowCount(); count_row++){
			Persona persona = new Persona();
			for( int count_column = 0; count_column< model.getColumnCount(); count_column++ ){
				if(count_column == 0){
					persona.setNombre(model.getValueAt(count_row, count_column).toString());
				}
				else if(count_column == 1){
					persona.setTelefono(model.getValueAt(count_row, count_column).toString());
				}else if(count_column == 2){
					persona.setCorreo(model.getValueAt(count_row, count_column).toString());
				}
			}
			array.add(persona);
		}
		try{
			String json = gson.toJson(array).toString();
			System.out.println(json);
			FileWriter fw = new FileWriter(this.getPersonasJson());
			gson.toJson(array, fw);
			fw.flush();

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void saveOrganizacionesArrayOnFile(ArrayList<Organizacion> array, DefaultTableModel model){
		gson = new Gson();
		array.clear();
		for (int count_row = 0; count_row < model.getRowCount(); count_row++){
			Organizacion organizacion = new Organizacion();
			for( int count_column = 0; count_column< model.getColumnCount(); count_column++ ){
				if(count_column == 0){
					organizacion.setNombre(model.getValueAt(count_row, count_column).toString());
				}
				else if(count_column == 1){
					organizacion.setTelefono(model.getValueAt(count_row, count_column).toString());
				}else if(count_column == 2){
					organizacion.setDireccion(model.getValueAt(count_row, count_column).toString());
				}
			}
			array.add(organizacion);
		}
		try{
			String json = gson.toJson(array).toString();
			System.out.println(json);
			FileWriter fw = new FileWriter(this.getOrganizacionesJson());
			gson.toJson(array, fw);
			fw.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void saveNegociosArrayOnFile(ArrayList<Negocio> array, DefaultTableModel model){
		gson = new Gson();
		array.clear();
		for (int count_row = 0; count_row < model.getRowCount(); count_row++){
			Negocio negocio = new Negocio();
			for( int count_column = 0; count_column< model.getColumnCount(); count_column++ ){
				if(count_column == 0){
					negocio.setTítulo(model.getValueAt(count_row, count_column).toString());
				}
				else if(count_column == 1){
					negocio.setDescripción(model.getValueAt(count_row, count_column).toString());
				}else if(count_column == 2){
					negocio.setFechaCierre(model.getValueAt(count_row, count_column).toString());
				}else if(count_column == 3){
					negocio.setNombreOrganización(model.getValueAt(count_row, count_column).toString());
				}else if(count_column == 4){
					negocio.setNombrePersona(model.getValueAt(count_row, count_column).toString());
				}else if(count_column == 5){
					negocio.setValor( Float.parseFloat( model.getValueAt(count_row, count_column).toString() ) );
				}else if(count_column == 6){
					negocio.setEstado(model.getValueAt(count_row, count_column).toString());
				}
			}
			array.add(negocio);
		}
		try{
			String json = gson.toJson(array).toString();
			System.out.println(json);
			FileWriter fw = new FileWriter(this.getNegociosJson());
			gson.toJson(array, fw);
			fw.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void saveActividadesArrayOnFile(ArrayList<Actividad> array, DefaultTableModel model){
		gson = new Gson();
		array.clear();
		for (int count_row = 0; count_row < model.getRowCount(); count_row++){
			Actividad actividad = new Actividad();
			for( int count_column = 0; count_column< model.getColumnCount(); count_column++ ){
				if(count_column == 0){
					actividad.setTipo(model.getValueAt(count_row, count_column).toString());
				}
				else if(count_column == 1){
					actividad.setDescripción(model.getValueAt(count_row, count_column).toString());
				}else if(count_column == 2){
					actividad.setFecha(model.getValueAt(count_row, count_column).toString());
				}else if(count_column == 3){
					actividad.setHora(model.getValueAt(count_row, count_column).toString());
				}else if(count_column == 4){
					actividad.setDuracion(model.getValueAt(count_row, count_column).toString());
				}else if(count_column == 5){
					actividad.setNombreOrganizacion( model.getValueAt(count_row, count_column).toString() );
				}else if(count_column == 6){
					actividad.setNombrePersona(model.getValueAt(count_row, count_column).toString());
				}else if(count_column == 7 ){
					actividad.setNombreNegocio(model.getValueAt(count_row, count_column).toString());
				}
			}
			array.add(actividad);
		}
		try{
			String json = gson.toJson(array).toString();
			System.out.println(json);
			FileWriter fw = new FileWriter(this.getActividadesJson());
			gson.toJson(array, fw);
			fw.flush();
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	
	public ArrayList<Persona> getAllPersonas() throws FileNotFoundException{
		gson = new Gson();
		arrayPersonas = new ArrayList<Persona>();
		try{
			fr = new FileReader(this.getPersonasJson());
			br = new BufferedReader(fr);
			arrayPersonas = gson.fromJson(br, PERSONA_TYPE);
		}catch(Exception e){
			e.printStackTrace();
		}
		return arrayPersonas;
	}
	
	public ArrayList<Organizacion> getAllOrganizaciones(){
		gson = new Gson();
		arrayOrganizaciones = new ArrayList<Organizacion>();
		try{
			fr = new FileReader(this.getOrganizacionesJson());
			br = new BufferedReader(fr);
			arrayOrganizaciones = gson.fromJson(br, ORGANIZACION_TYPE);
		}catch(Exception e){
			e.printStackTrace();
		}
		return arrayOrganizaciones;
	}
	
	public ArrayList<Actividad> getAllActividades(){
		gson = new Gson();
		arrayActividades = new ArrayList<Actividad>();
		try{
			fr = new FileReader(this.getActividadesJson());
			br = new BufferedReader(fr);
			arrayActividades = gson.fromJson(br, ACTIVIDAD_TYPE);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return arrayActividades;
	}
	
	public ArrayList<Negocio> getAllNegocios(){
		gson = new Gson();
		arrayNegocios = new ArrayList<Negocio>();
		try{
			fr = new FileReader(this.getNegociosJson());
			br = new BufferedReader(fr);
			arrayNegocios = gson.fromJson(br, NEGOCIO_TYPE);
		}catch(Exception e){
			e.printStackTrace();
		}
		return arrayNegocios;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public File getPersonasJson() {
		return personasJson;
	}

	public void setPersonasJson(File personasJson) {
		this.personasJson = personasJson;
	}

	public File getNegociosJson() {
		return negociosJson;
	}

	public void setNegociosJson(File negociosJson) {
		this.negociosJson = negociosJson;
	}

	public File getOrganizacionesJson() {
		return organizacionesJson;
	}

	public void setOrganizacionesJson(File organizacionesJson) {
		this.organizacionesJson = organizacionesJson;
	}

	public File getActividadesJson() {
		return actividadesJson;
	}

	public void setActividadesJson(File actividadesJson) {
		this.actividadesJson = actividadesJson;
	}

	public ArrayList<File> getFileList() {
		return fileList;
	}

	public void setFileList(ArrayList<File> fileList) {
		this.fileList = fileList;
	}
	
}
