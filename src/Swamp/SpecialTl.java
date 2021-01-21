package Swamp;

import java.awt.*;

public class SpecialTl {
    private int col,row,Size;

    public SpecialTl(int col,int row){
        this.col=col;
        this.row=row;
        this.Size=GameTile.TILE_SIZE;

    }
    public void render(Graphics g){

        int tileX = this.col * GameTile.TILE_SIZE;
        int tileY = this.row * GameTile.TILE_SIZE;
        g.setColor(Color.WHITE);
        g.fillRect(tileX,tileY,GameTile.TILE_SIZE,GameTile.TILE_SIZE);
        g.setColor(Color.LIGHT_GRAY);
        g.fillOval(tileX+25,tileY+25,50,50);
        g.setColor(Color.DARK_GRAY);
        g.drawOval(tileX+25,tileY+25,50,50);
        g.setColor(Color.BLACK);
        g.drawRect(tileX,tileY,GameTile.TILE_SIZE,GameTile.TILE_SIZE);

    }
}

