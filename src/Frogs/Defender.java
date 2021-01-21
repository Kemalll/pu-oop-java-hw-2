package Frogs;

import Swamp.GameTile;
import java.awt.*;


public class Defender {

    private int col,row;
    private Color color;

    public Defender(int row, int col,Color color) {
        this.row = row;
        this.col = col;
        this.color=color;
    }
    public boolean isMoveValid(int moveRow, int moveCol) {

        int rowCoeficient = Math.abs(moveRow - this.row);                    //Движение на фигорите
        int colCoeficient = moveCol - this.col;
        int SMove=Math.abs(moveRow-moveCol);

        return  rowCoeficient == 1 &&
                colCoeficient == 0;
    }

    public void render(Graphics g) {
        int x = this.col * GameTile.TILE_SIZE;
        int y = this.row * GameTile.TILE_SIZE;

        g.setColor(this.color);
        g.fillOval(x+27, y+27 , 45,45);
        g.setColor(Color.BLUE);
        g.drawOval(x+27, y+27,45,45);
    }

    public void move(int row, int col) {
        if(isMoveValid(row,col)){         //Проверка дали движението е позволено
        this.row=row;
        this.col=col;
        }

    }
}