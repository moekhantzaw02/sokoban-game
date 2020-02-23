/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author home
 */
import java.awt.Image;
public class movement {
    public final int space=40;
    public int x;
    public int y;
    public Image thingsImage;
   
    public Image getImage() {
        return thingsImage;
    }

    public void setImage(Image thingsImage) {
        this.thingsImage = thingsImage;
    }
    public movement(int x,int y)
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
    
    public boolean left(movement actor)
    {
    if(this.getX()-space==actor.getX() &&(getY()-space==actor.getY()))
    {
        return true;
    }
    else{
    return false;
}
    }
    public boolean right(movement actor)
    {
    if(this.getX()-space==actor.getX() &&(getY()-space==actor.getY()))
    {
        return true;
    }
    else{
    return false;
    }
    }
    public boolean Top(movement actor)
   {
    if(this.getX()-space==actor.getX() &&(getY()-space==actor.getY()))
    {
        return true;
    }
    else{
    return false;
    }
    }
    public boolean bottm(movement actor)
    {
    if(this.getX()-space==actor.getX() &&(getY()-space==actor.getY()))
    {
        return true;
    }
    else{
    return false;
    }
    }
}
