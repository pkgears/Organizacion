import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FilesController {

	public FilesController(){
		
	}
	
	
	public void createFiles() throws IOException{
		String path = "archivos/";
		ArrayList<File> fileList = new ArrayList<>();
		
	    File personasJson = new File(path+"personas.json");
	    File negociosJson =  new File(path+"negocios.json"); 
	    File organizacionesJson = new File(path+"organizaciones.json"); 
	    File actividadesJson = new File(path+"actividades.json");
	    
	    fileList.add(personasJson);
	    fileList.add(negociosJson);
	    fileList.add(organizacionesJson);
	    fileList.add(actividadesJson);
	    
	    fileList.forEach((file)-> {
	    	if(!file.exists()){
				try{
					file.createNewFile();
					System.out.println("Archivo "+file.getName() + " creado");
				}catch(Exception e){
					e.printStackTrace();
				}
	    	}else{
	    		System.out.println("Se encontró archivo "+file.getName());
	    	}
	    }); 
	    
	}
	
}
