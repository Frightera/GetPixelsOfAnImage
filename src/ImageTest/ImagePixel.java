package ImageTest;

import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.imageio.ImageIO;

@SuppressWarnings("serial") // Warning..
public class ImagePixel extends Component {

  public static void main(String[] args) {
	  new ImagePixel();
  }
  /*
  int i = 0;
  int j = 0;
  */
  /*
  public void Pixellerin_RGB_Alpha_Degerleri(int pixel) {
    int alpha = (pixel >> 24) & 0xff;
    int red = (pixel >> 16) & 0xff;
    int green = (pixel >> 8) & 0xff;
    int blue = (pixel) & 0xff;
    System.out.println("Alpha/Red/Green/Blue: " + alpha + ", " + red + ", " + green + ", " + blue);
    //int benim_rengim = (alpha * 65536) + (red * 24) + (green * 8) + blue;
   // System.out.println("Benim rengimin degeri // Koordinatlar (x,y) = " +benim_rengim +i +j);    
  }
  */	
  
  private boolean inLimit(int x, int y, int w, int h)
  {
	  if (x < 0 || y < 0 || x >= w || y >= h)
		  return false;
	  
	  return true;
  }
  
  private void ekle(Set<String> m, int a, int b)
  {
	  if (a == b)
		  return;
	  
	  String s1 = a + "\t" + b;
	  String s2 = b + "\t" + a;
	  if (!m.contains(s1) && !m.contains(s2))
	  {
		  m.add(s1);
	  }
  }
 
  
  private void Resmi_Gezme(BufferedImage image) {
	
	Set<String> m = new HashSet<String>(); 
	  
    int w = image.getWidth();
    int h = image.getHeight();
    int[][] benim_rengim = new int[w][h];
    System.out.println("width, height: " + w + ", " + h);
   
    for (int i = 0; i < w; i++) {
      for (int j = 0; j < h; j++) {
        System.out.println("Koordinatlar (x,y): " + j + ", " + i);
        int pixel = image.getRGB(i, j) & 0xFFFFFF;
        //Pixellerin_RGB_Alpha_Degerleri(pixel);
        int alpha = (pixel >> 24) & 0xff;
        int red = (pixel >> 16) & 0xff;
        int green = (pixel >> 8) & 0xff;
        int blue = (pixel) & 0xff;
        System.out.println("Alpha/Red/Green/Blue: " + alpha + ", " + red + ", " + green + ", " + blue);
        
		benim_rengim[i][j] = pixel;
       // System.out.println("Benim rengimin degeri " +benim_rengim[i][j]);
         System.out.println("Benim rengimin degeri = " + Integer.toHexString(benim_rengim[i][j]));
        
        System.out.println("");
        	}
       	}
    	
    	for(int k = 0; k < w; k++) {
    		for(int n = 0; n < h; n++) {
    			int a = benim_rengim[k][n];
    			int b = 0;
    			
    			// Test 1: k, n+1
    			int kk = k;
    			int nn = n + 1;
    			if (inLimit(kk, nn, h, w))
    			{
    				b = benim_rengim[nn][kk];
    				ekle(m, a, b);
    			}
    			
    			// Test 2: k+1, n
    			kk = k+1;
    			nn = n;
    			if (inLimit(kk, nn, h, w))
    			{
    				b = benim_rengim[nn][kk];
    				ekle(m, a, b);
    			}
   			
    			
    			// Test 3: k-1, n
    			kk = k-1;
    			nn = n;
    			if (inLimit(kk, nn, h, w))
    			{
    				b = benim_rengim[nn][kk];
    				ekle(m, a, b);
    			}
    			
    			// Test 4: k, n-1
    			kk = k;
    			nn = n-1;
    			if (inLimit(kk, nn, h, w))
    			{
    				b = benim_rengim[nn][kk];
    				ekle(m, a, b);
    			}
    		}
    	}
    	
    	{
    		for (String a : m)
    		System.out.println(a);
    		
    		try {
                
                File newTextFile = new File("put-file-location");

                FileWriter fw = new FileWriter(newTextFile);
                
                for (String a : m)
                {
                	fw.write(a + "\r\n");	
                }
                
                
                fw.close();

            } catch (IOException iox) {
                
                iox.printStackTrace();
            }
    		
    	}
    	}
    	/*
    	for(int k = 0; k < h; k++) {
    		for(int n = 0; n < w; n++) {
    			if(benim_rengim[k][n] != benim_rengim[k][n+1]) {
    				System.out.printf("(%d,%d) --- (%d,%d)",k, n, k, n+1);
    				System.out.printf("\n");
    			}
    		}
    	}
    	*/
  	
  
  public ImagePixel() {
    try {
      
      BufferedImage image = 
      ImageIO.read(this.getClass().getResource("put-location-here"));
      
      Resmi_Gezme(image);
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

 /*
 public BufferedImage loadImage(String deneme1){

    BufferedImage buff = null;
    try {
        buff = ImageIO.read(getClass().getResourceAsStream(deneme1));
    } 
    catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        return null;
    }
    return buff;

  } 
  */
}


