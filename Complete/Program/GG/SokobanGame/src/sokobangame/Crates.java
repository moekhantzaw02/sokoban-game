
package sokobangame;

   
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

public class Crates extends Movement{
 

    public Crates(int x,int y)
    {
        super(x,y);
        //URL url=this.getClass().getResource("box.png");
        ImageIcon icon=new ImageIcon("box.png");
        Image img=icon.getImage();
        this.setImage(img);
        
        
    }
     public void Move(int x, int y) {
        int MoveX=this.getX()+x;
        int MoveY=this.getY()+y;
        this.setX(MoveX);
        this.setY(MoveY);
    }
    
}




