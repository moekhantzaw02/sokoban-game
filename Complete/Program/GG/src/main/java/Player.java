import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

public class Player extends movement{
    public Player(int x,int y)
    {
        super(x,y);
        URL url=this.getClass().getResource("actor.png");
        ImageIcon ico=new ImageIcon(url);
        Image img=ico.getImage();
        this.setImage(img);
        
        
    }
    public void Move(int x,int y)
    {
        int MoveX=this.getX()+x;
        int MoveY=this.getY()+y;
        this.setX(MoveX);
        this.setY(MoveY);
    }
}