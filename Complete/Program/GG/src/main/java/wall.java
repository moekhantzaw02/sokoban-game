
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author home
 */
public class wall  extends movement{
    public wall(int x,int y)
    {
        super(x,y);
        URL url=this.getClass().getResource("isDXGKTTA3.jpg");
        ImageIcon ico=new ImageIcon(url);
        Image img=ico.getImage();
        this.setImage(img);
    }
}
