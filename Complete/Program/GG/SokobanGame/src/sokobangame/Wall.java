/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokobangame;

/**
 *
 * @author moekh
 */

    
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
public class Wall extends Movement{
    public Wall(int x,int y)
    {
        super(x,y);
        //URL url=this.getClass().getResource("box.png");
        ImageIcon ico=new ImageIcon("wall.jpeg");
        Image img=ico.getImage();
        this.setImage(img);
    }
}


