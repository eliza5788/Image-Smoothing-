
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;


//Inheritance: 
    
public abstract class Smoothing extends Citire {
 
	
    private long timeS;
    private BufferedImage imageS;
    
    
    //Constructorul Smoothing mosteneste metoda de citire din clasa Citire:
    
    public Smoothing ()
    {
    	this.imageS = super.getImage();
    }
    
    //Procesarea imaginii de prelucrat:
    
    public void smooth() {

        timeS = System.currentTimeMillis(); //variabila folosita pentru a prelua timpul curent
        
        //Generarea kernelului:
        
        Kernel kernel = new Kernel(3, 3, new float[] { 1f / 9f, 1f / 9f, 1f / 9f, 1f / 9f, 1f / 9f, 1f / 9f, 1f / 9f, 1f / 9f, 1f / 9f });
        
        //Generarea matricei de convolutie prin instantierea clasei ConvolveOp:
        
        BufferedImageOp op = new ConvolveOp(kernel);
        
        //Prelucrarea imaginii prin realizarea convolutiei dintre matricea de convolutie si BufferedImage:
        
        this.imageS = op.filter(super.getImage(), null);   
        
        //Calculul timpului de procesare:
        
        timeS = System.currentTimeMillis() - timeS;  
    }
    
    //Imaginea editata este returnata:
    
	public BufferedImage getImageS() {
    	return this.imageS;
    }
	
	//Timpul de procesare:
	
	@Override
    public long smoothImageTimp(){
        System.out.println("Timpul de prelucrare al imaginii este: " + timeS / 1000.0f + "s");
        return timeS;
    }
	
	public long scriereTimp(){
        return 0;
    }
    
	  
}