import java.io.IOException;

import clases.Actividad;
import clases.Negocio;
import clases.Organizacion;
import clases.Persona;


public class Main {
	
	public static void main(String[] args) throws IOException {
		System.out.println("Cargando...");		
		FilesController filesController = new FilesController();
		filesController.createFiles();
		
		try{
			Persona persona = new Persona("Cesar","12345","pkgears@gmail.com");
			Negocio negocio = new Negocio("título","descripción","nombre_organización","nombre_persona","fecha_cierre","estado",100);
			Organizacion organizacion = new Organizacion("Empresa1","Direccion","1235");
			Actividad actividad = new Actividad("descripción","tipo","fecha","hora","duración","nombre_persona",
					"nombre_organización","nombre_negocio");
			filesController.saveFile(persona);
			filesController.saveFile(negocio);
			filesController.saveFile(organizacion);
			filesController.saveFile(actividad);
			//filesController.getAllObjects(filesController.getPersonasJson(), obj.getClass());
			filesController.getAllPersonas();
			filesController.getAllNegocios();
			filesController.getAllActividades();
			filesController.getAllOrganizaciones();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
