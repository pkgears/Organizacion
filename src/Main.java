import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	
	private static ArrayList<File> fileList;

	public static void main(String[] args) throws IOException {
		System.out.println("Cargando...");		
		FilesController filesController = new FilesController();
		fileList = filesController.createFiles();
		
	}

	
}
