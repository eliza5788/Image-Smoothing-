import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;


public class MainClass {
	
	 static void display(String... values){  
		 for(String s:values){  
			   System.out.println(s);  
		 }  
		 } 

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		//Citirea pathului pentru imaginea de prelucrat:
		
		display("Introduceti calea fisierului .bmp pe care doriti sa il prelucrati","Fisier(BMP):");
		Scanner scanner = new Scanner(System.in);
		String image= scanner.nextLine();
		
		//Citirea pathului pentru imaginea obtinuta dupa prelucrare:
		
		display("Introduceti calea fisierului .bmp final prelucrat","Fisier(BMP):");
		String file= scanner.nextLine();
		
		//Citirea, procesarea si scrierea imaginii:
		
		Scriere write = new Scriere(image);
		write.writeImageToFile(file);
		scanner.close();
		
		//Afisarea pe consola a timpilor:
		
		write.citireTimp();
		write.smoothImageTimp();
		write.scriereTimp();
	}

}
