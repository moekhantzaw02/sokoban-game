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

public class Movement{
  

    public final int space=30;
    public int x;
    public int y;
    public Image thingsImage;
   
    public Image getImage() {
        return thingsImage;
    }

    public void setImage(Image thingsImage) {
        this.thingsImage = thingsImage;
    }
    public Movement(int x,int y)
    {
        this.x=x;
        this.y=y;
        
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public boolean LeftMove(Movement actor)
    {
    if(this.getX()-space==actor.getX() && (this.getY()==actor.getY()))
    {
        return true;
    }
    else{
    return false;
}
    }
    public boolean RighMove(Movement actor)
    {
    if(this.getX()+space==actor.getX() && (this.getY()==actor.getY()))
    {
        return true;
    }
    else{
    return false;
    }
    }
    public boolean TopMove(Movement actor)
   {
    if(this.getY()-space==actor.getY() && (this.getX()==actor.getX()))
    {
        return true;
    }
    else{
    return false;
    }
    }
    public boolean BottomMove(Movement actor)
    {
    if(this.getY()+space==actor.getY() && (this.getX()==actor.getX()))
    {
        return true;
    }
    else{
    return false;
    }
    }

}


