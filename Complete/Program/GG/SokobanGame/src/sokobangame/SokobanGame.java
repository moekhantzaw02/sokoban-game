
package sokobangame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;

public class SokobanGame extends JFrame
{
JLabel lblUN, lblMoveCount,lblCurrentLevel;
JLabel lblWarehouse_keeperImg, lblCratesImg,lblDiamondImg,lblWallImg;
JLabel lblInstruction1, lblInstructions2, lblInstructions3;
JLabel lblUpArrow,lblDownArrow,lblLeftArrow,lblRightArrow;
JLabel lblGameBoarsImage;
JPanel pnlGameBoard;
    Wall objWall;
    Crates objCrates;
    Diamond objDiamond;


    private int movecount = 0;
    private final int OFFSET = 180;
    private final int SPACE = 30;
    private final int LeftMove = 1;
    private final int RighMove = 2;
    private final int TopMove = 3;
    private final int BottomMove = 4;
    private ArrayList alWalls = new ArrayList();
    private ArrayList alBaggs = new ArrayList();
    private ArrayList alAreas = new ArrayList();
    private int width = 0;
    private int height = 0;
    private Warehouse_keeper dlite_soko;
    private boolean completestaus =false;
    String LevelComplete = "";
    map m = new map();

    public SokobanGame ()
    {
        this.setTitle("Sokoban Game");
        this.setSize(600,500);
        this.setLayout(null);
        lblUN = new JLabel("Moe Khant Zaw");
        lblMoveCount= new JLabel();
        lblCurrentLevel=new JLabel();
        lblUN.setBounds(40,30, 130, 50);
        this.add(lblUN);
        lblMoveCount.setBounds(20, 60, 100, 30);
        this.add(lblMoveCount);
        lblCurrentLevel.setBounds(20, 100, 100, 30);
        this.add(lblCurrentLevel);
        pnlGameBoard = new JPanel();
        pnlGameBoard.setBounds(130, 20, 350, 430);
        this.add(pnlGameBoard);

        lblGameBoarsImage = new JLabel();
        lblGameBoarsImage.setBounds(10,10,350,450);
        lblInstruction1 = new JLabel("Use the Arrow Key");
        lblInstruction1.setBounds(10,180,130,30);
        this.add(lblInstruction1);
        lblUpArrow= new JLabel(new ImageIcon("up.png"));
        lblUpArrow.setBounds(30,210,30,30);
        this.add(lblUpArrow);
        lblLeftArrow= new JLabel(new ImageIcon("left.png"));
        lblLeftArrow.setBounds(10,230,30,30);
        this.add(lblLeftArrow);
        lblRightArrow= new JLabel(new ImageIcon("right.png"));
        lblRightArrow.setBounds(50,230,30,30);
        this.add(lblRightArrow);
        lblDownArrow= new JLabel(new ImageIcon("down.png"));
        lblDownArrow.setBounds(30,250,30,30);
        
        this.add(lblDownArrow);
        lblInstructions2= new JLabel("Restart Level");
        lblInstructions2.setBounds(10,280,100,30);
        this.add(lblInstructions2);
         lblInstructions3= new JLabel("Press R");
        lblInstructions3.setBounds(10,300,100,30);
        this.add(lblInstructions3);

        Crates c = new Crates(40,40);
        lblCratesImg = new JLabel(new ImageIcon(c.getImage()));
        lblCratesImg.setSize(40,40);
        
        Wall w= new Wall(40,40);
        lblWallImg= new JLabel(new ImageIcon(w.getImage()));
        lblWallImg.setSize(40,40);

        Diamond a= new Diamond(30,30);
        lblDiamondImg= new JLabel(new ImageIcon(a.getImage()));
        lblDiamondImg.setSize(40,40);

        Warehouse_keeper wk= new Warehouse_keeper(30,30);
        lblWarehouse_keeperImg=new JLabel(new ImageIcon(wk.getImage()));
        lblWarehouse_keeperImg.setSize(40,40);

        LevelComplete= m.level_1;
        lblCurrentLevel.setText("Level_1");
        startGameBoard(LevelComplete);
        repaint();
        pnlGameBoard.add(lblGameBoarsImage);
        pnlGameBoard.addKeyListener(new MovementKeyAdapter());
        pnlGameBoard.setFocusable(true);
        this.setVisible(true);
    }

    public final void startGameBoard(String level)
    {
        int x= OFFSET;
        int y=130;
        for (int i=0; i< level.length();i++)
        {
        char item = level.charAt(i);
        if(item =='\n'){
        y += SPACE;
        if(this.width< x)
        {
           this.width=x;
        }
        x=OFFSET;
        }else if (item =='#'){
        objWall = new Wall(x,y);
        alWalls.add(objWall);
        x += SPACE;
        }else if (item =='.'){
        objDiamond = new Diamond(x,y);
        alAreas.add(objDiamond);
        x += SPACE;
        }else if(item =='$'){
            objCrates= new Crates(x,y);
            alBaggs.add(objCrates);
        x += SPACE;
        }else if(item =='@'){
            dlite_soko= new Warehouse_keeper(x,y);
            x+=SPACE;
        }else if (item ==' '){
            x+=SPACE;
        }
        height=y;
        }
    }

public void buildLevel_Map(Graphics g)
  {
      Graphics2D g2d=(Graphics2D) g;
      ImageIcon iia = new ImageIcon();
      Image img = iia.getImage();
      g2d.drawImage(img, 0, 0,null);
      g2d.fillRect(0, 0, lblGameBoarsImage.getWidth(), lblGameBoarsImage.getHeight());

      ArrayList alLevelMap = new ArrayList();
      alLevelMap.addAll(alWalls);
      alLevelMap.addAll(alAreas);
      alLevelMap.addAll(alBaggs);
      alLevelMap.add(dlite_soko);

      for (int i = 0; i < alLevelMap.size(); i++)
      {

          Movement item =(Movement) alLevelMap.get(i);

          if ((item instanceof Warehouse_keeper)|| (item instanceof Crates ))
          {
              g2d.drawImage(item.getImage(), item.getX()+2,item.getY() +2,lblGameBoarsImage);

          }
          else
          {
              g2d.drawImage(item.getImage(), item.getX(),item.getY(),lblGameBoarsImage);
          }

          if(completestaus)
          {
              g2d.setColor(new Color(0,0,0));
              g2d.drawString("Completed", 25, 20);
              if(LevelComplete.equals("level_1"))
              {
                  LevelComplete ="level_2";
                  startGameBoard(LevelComplete);
              }
              else if(LevelComplete.equals("level_2"))
              {
                  LevelComplete ="level_3";
                  startGameBoard(LevelComplete);
              }
              else if(LevelComplete.equals("level_3"))
              {
                  LevelComplete ="level_4";
                  startGameBoard(LevelComplete);
              }
              else if(LevelComplete.equals("level_4"))
              {
                  LevelComplete ="level_5";
                  startGameBoard(LevelComplete);
              }
          }
      }
  }

   

     @Override
    public void paint(Graphics g){
        Graphics2D g2d=(Graphics2D) g;
        super.paint(g2d);
       lblGameBoarsImage.paint(g);
       buildLevel_Map(g2d);
    }

    class MovementKeyAdapter extends KeyAdapter{

        @Override
        public void keyPressed(KeyEvent e)
        {
                if(completestaus)
                {
                return;

                }
        int key= e.getKeyCode();
        
        if(key ==KeyEvent.VK_LEFT)
        {
        if(checkWallCollision(dlite_soko,LeftMove))
        {
            JOptionPane.showMessageDialog(null,"Left Wall");
            repaint();
        }
        if(checkBagCollision(LeftMove)){
        JOptionPane.showMessageDialog(null,"Left Wall");
         repaint();
        }
        movecount+=1;
        dlite_soko.Move(-SPACE,0);
        }

        else if(key ==KeyEvent.VK_RIGHT)
        {
        if(checkWallCollision(dlite_soko,RighMove))
        {
            JOptionPane.showMessageDialog(null,"Right Wall");
            repaint();
        }
        if(checkBagCollision(RighMove)){
        JOptionPane.showMessageDialog(null,"Right Wall");
         repaint();
        }
        movecount+=1;
        dlite_soko.Move(SPACE,0);
        }



        else   if(key ==KeyEvent.VK_UP )      {
        if(checkWallCollision(dlite_soko,TopMove))
        {
            JOptionPane.showMessageDialog(null,"Top Wall");
            repaint();
        }
        if(checkBagCollision(TopMove)){
        JOptionPane.showMessageDialog(null,"Top Wall");
         repaint();
        }
        movecount+=1;
        dlite_soko.Move(0,-SPACE);
        }



        if(key ==KeyEvent.VK_DOWN)
        {
        if(checkWallCollision(dlite_soko,BottomMove))
        {
            JOptionPane.showMessageDialog(null,"Bottom Wall");
            repaint();
        }
        if(checkBagCollision(BottomMove)){
        JOptionPane.showMessageDialog(null,"Bottom Wall");
         repaint();
        }
        movecount+=1;
        dlite_soko.Move(0,SPACE);
        }
        else if(key ==KeyEvent.VK_R)
        {
            nextlevel();
        }
        lblMoveCount.setText(String .valueOf(movecount));
        repaint();
    }
    }


    public int nextlevel()
    {
        alAreas.clear();
        alBaggs.clear();
        alWalls.clear();
        startGameBoard(LevelComplete);
        movecount=0;
        if(completestaus)
        {
            completestaus= false;
        }
        return movecount;
    }

   

     private boolean checkWallCollision(Movement warehousekeeper, int type)
    {
        if(type==LeftMove)
        {
            for(int i=0;i<alWalls.size();i++)
            {
                Wall walls = (Wall) alWalls.get(i);
                if(warehousekeeper.LeftMove(walls))
                {
                    return true;
                }
            }
            return false;
        }
        else if(type==RighMove)
        {
            for(int i=0;i<alWalls.size();i++)
            {
                Wall walls = (Wall) alWalls.get(i);
                if(warehousekeeper.RighMove(walls))
                {
                    return true;
                }
            }
            return false;
        }
        else if(type==TopMove)
        {
            for(int i=0;i<alWalls.size();i++)
            {
                Wall walls = (Wall) alWalls.get(i);
                if(warehousekeeper.TopMove(walls))
                {
                    return true;
                }
            }
            return false;
        }
        else if(type==BottomMove)
        {
            for(int i=0;i<alWalls.size();i++)
            {
                Wall walls = (Wall) alWalls.get(i);
                if(warehousekeeper.BottomMove(walls))
                {
                    return true;
                }
            }
            return false;
        }
        return false;
     }
      public void LevelComplete(){

        int num = alBaggs.size();
        int compl = 0;


        for (int i = 0; i < num; i++) {
            Crates bag = (Crates) alBaggs.get(i);
            for (int j = 0; j < num; j++) {
                Diamond area = (Diamond) alAreas.get(j);
                if (bag.getX() == area.getX()
                        && bag.getY() == area.getY()) {
                    compl += 1;
                }
            }
        }


        if (compl == num) {

            completestaus = false;
            if (LevelComplete.equals(m.level_1)) {

                LevelComplete = m.level_2;
                lblCurrentLevel.setText("Level 2");
                startGameBoard(LevelComplete);
            } else if (LevelComplete.equals(m.level_2)) {
                LevelComplete = m.level_3;
                lblCurrentLevel.setText("Level 3");
                startGameBoard(LevelComplete);
            } else if (LevelComplete.equals(m.level_3)) {
                LevelComplete = m.level_4;
                lblCurrentLevel.setText("Level 4");
                startGameBoard(LevelComplete);
            } else {
                LevelComplete = m.level_5;
                lblCurrentLevel.setText("Level 5");
                startGameBoard(LevelComplete);
            }
            JOptionPane.showMessageDialog(null, "Level Complete");
            nextlevel();
            repaint();
        }
    }

     private boolean checkBagCollision(int collision_type) {

    switch (collision_type) {
        case LeftMove:
            for (int i = 0; i < alBaggs.size(); i++) {

                Crates bag = (Crates) alBaggs.get(i);
                if (dlite_soko.LeftMove(bag)) {

                    for (int j = 0; j < alBaggs.size(); j++) {
                        Crates item = (Crates) alBaggs.get(j);
                        if (!bag.equals(item)) {
                            if (bag.LeftMove(item)) {
                                return true;
                            }
                        }
                        if (checkWallCollision(bag,
                                LeftMove)) {
                            return true;
                        }
                    }
                    bag.Move(-SPACE, 0);
                    LevelComplete();
                }
            }
            return false;
        case RighMove:
            for (int i = 0; i < alBaggs.size(); i++) {

                Crates bag = (Crates) alBaggs.get(i);
                if (dlite_soko.RighMove(bag)) {
                    for (int j = 0; j < alBaggs.size(); j++) {

                        Crates item = (Crates) alBaggs.get(j);
                        if (!bag.equals(item)) {
                            if (bag.RighMove(item)) {
                                return true;
                            }
                        }
                        if (checkWallCollision(bag,
                                RighMove)) {
                            return true;
                        }
                    }
                    bag.Move(SPACE, 0);
                    LevelComplete();
                }
            }
            return false;
        case TopMove:
            for (int i = 0; i < alBaggs.size(); i++) {

                Crates bag = (Crates) alBaggs.get(i);
                if (dlite_soko.TopMove(bag)) {
                    for (int j = 0; j < alBaggs.size(); j++) {

                        Crates item = (Crates) alBaggs.get(j);
                        if (!bag.equals(item)) {
                            if (bag.TopMove(item)) {
                                return true;
                            }
                        }
                        if (checkWallCollision(bag,
                                TopMove)) {
                            return true;
                        }
                    }
                    bag.Move(0, -SPACE);
                    LevelComplete();
                }
            }

            return false;
        case BottomMove:
            for (int i = 0; i < alBaggs.size(); i++) {

                Crates bag = (Crates) alBaggs.get(i);
                if (dlite_soko.BottomMove(bag)) {
                    for (int j = 0; j < alBaggs.size(); j++) {

                        Crates item = (Crates) alBaggs.get(j);
                        if (!bag.equals(item)) {
                            if (bag.BottomMove(item)) {
                                return true;
                            }
                        }
                        if (checkWallCollision(bag, BottomMove)) {
                            return true;
                        }
                    }
                    bag.Move(0, SPACE);
                    LevelComplete();
                }
            }
            break;
        default:
            break;
    }

        return false;
    }




  
    public static void main(String[] args)
    {
        SokobanGame m = new SokobanGame();
        
    }


 }