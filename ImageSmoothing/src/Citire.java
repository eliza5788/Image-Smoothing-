
import java.awt.image.BufferedImage;

import java.io.File;

import java.io.IOException;
import javax.imageio.ImageIO;

public abstract class Citire implements InterfataDeTimp {

	private BufferedImage image;
	long time;
	
	//Constructorul: 
	
	public BufferedImage getImage() {
		return this.image;
	}
	
	//Se citeste imaginea gasita in pathul precizat, se prelucreaza si se calculeaza timpul:
	
	public void readImageFromFile (String fileName) {

		File file = new File(fileName);
		
		time = System.currentTimeMillis(); //Se preia timpul curent

		//Tratarea exceptiilor:
		
		try {
			this.image = ImageIO.read(file);

		} catch (IOException e) {
			System.out.println("Nu a fost gasit fisierul!!!");    
		}
		
		//Calculul timpului de citire:
		
		time = System.currentTimeMillis() - time; 
	}

	//Scrierea timpului de citire:
	
	@Override
	public long citireTimp() {
		System.out.println("Timpul de citire al imaginii este: " + time / 1000.0f + "s");
		return time;
	}

	//Metodele unimplemented:
	
	@Override
	public abstract long smoothimageTimp();

	@Override
	public abstract long scriereTimp();


}
