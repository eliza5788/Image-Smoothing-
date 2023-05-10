import java.io.FileNotFoundException;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

//Inheritance:

public class Scriere extends Smoothing {
    
    long timeW;
    private static BufferedImage imageW;
    
    //Constructorul care foloseste metoda de citire mostenita de la Citire:
    
    public Scriere ()
    {
    	Scriere.imageW = super.getImageS();
    }
    
    //Getterul care returneaza imaginea:
    
    public static BufferedImage getImageW() {
    	return Scriere.imageW;
    }
    
    //Getter si setter ptr timeW
    
    public long getTimeW() {
		return timeW;
	}

	public void setTimeW(long timeW) {
		this.timeW = timeW;
	}

	
    //Setterul care preia si modifica imaginea utilizand metodele de citire si procesare mostenite de la Citire si Smoothing:
    
    public Scriere(String fileName)
    {
    	super.readImageFromFile(fileName);
    	super.smooth();
    	Scriere.imageW = super.getImageS();
    }
    
    //Metoda prin care se scrie imaginea prelucrata:
    
    public void writeImageToFile(String fileName) throws FileNotFoundException, IOException {
 
        timeW = System.currentTimeMillis(); //se preia timpul curent
        FileOutputStream stream = new FileOutputStream(fileName); //se scrie imaginea prelucrata
        
        //Tratarea exceptiilor:
        
        try{
            ImageIO.write(Scriere.imageW, "BMP", stream);
        } catch (FileNotFoundException e) {
            System.out.println(fileName + "nu este valid!!!");
	    return;
		} catch (IOException e) {
	            System.out.println("Eroare la scriere!!!");
	            return ;
		}

        timeW = System.currentTimeMillis() - timeW; //Calculul timpului de scriere
    }
    
    //Timpul de scriere:
    
    @Override
    public long scriereTimp(){
        System.out.println("Timpul de scriere al imaginii este: " + timeW / 1000.0f + "s");
       
        return timeW;
    }


   
}
