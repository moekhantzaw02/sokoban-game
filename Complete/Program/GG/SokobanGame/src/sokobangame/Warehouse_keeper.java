package sokobangame;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

public class Warehouse_keeper extends Movement{
    public Warehouse_keeper(int x,int y)
    {
        super(x,y);
        //URL url=this.getClass().getResource("actor.png");
        ImageIcon ico=new ImageIcon("actor.png");
        Image img=ico.getImage();
        this.setImage(img);
        
    }  
    public void Move(int x, int y) {
        int MoveX=this.getX()+x;
        int MoveY=this.getY()+y;
        this.setX(MoveX);
        this.setY(MoveY);
    }
    
}