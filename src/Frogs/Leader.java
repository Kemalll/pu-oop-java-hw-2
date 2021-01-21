package Frogs;

import Swamp.Battelfield;
import Swamp.GameTile;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.awt.*;

public class Leader {

    private int row,col;
    private Color color;

    public Leader(int row, int col,Color color) {
        this.row = row;
        this.col = col;
        this.color=color;
    }
    public void render(Graphics g){
        int  x= this.col * GameTile.TILE_SIZE;
        int  y= this.row * GameTile.TILE_SIZE;

        g.setColor(this.color);
        g.fillRect(x+25,y+25,55,55);
    }
//    public boolean isMoveValid(int moveRow, int moveCol) {
//        int rowCoeficient =;
//        int colCoeficient =;
//
//       return  rowCoeficient==5&&
//               colCoeficient==5;
//    }
    public void move(int row, int col) {
       // if (isMoveValid(row,col))
        this.row=row;
        this.col=col;
    }
}

