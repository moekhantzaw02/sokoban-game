
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

public class boxer extends movement{
    public boxer(int x,int y)
    {
           super(x,y);
        URL url=this.getClass().getResource("isDXGKTTA3.jpg");
        ImageIcon ico=new ImageIcon(url);
        Image img=ico.getImage();
        this.setImage(img);
        
        
    }
}
