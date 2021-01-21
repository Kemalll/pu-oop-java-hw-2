package Swamp;

import Frogs.Defender;
import Frogs.Leader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Battelfield extends JFrame implements MouseListener {

    private Object[][] pieceCollection;                            ///Tук са обектите от defender and leader.
    private Object selectedPiece;                                  ///Следи дали елементат е избран
    public static final int TILE_SIDE_COUNT = 5;

    public Battelfield() {

        this.pieceCollection = new Object[TILE_SIDE_COUNT][TILE_SIDE_COUNT];

        //Green
        this.pieceCollection[0][0] = (new Defender(0, 0, Color.green));
        this.pieceCollection[0][1] = (new Defender(0, 1, Color.green));
        this.pieceCollection[0][2] = (new Defender(0, 2, Color.green));
        this.pieceCollection[0][3] = (new Defender(0, 3, Color.green));
        this.pieceCollection[0][4] = (new Leader  (0, 4, Color.green));

        //Yellow
        this.pieceCollection[4][1] = (new Defender(4, 1, Color.yellow));
        this.pieceCollection[4][2] = (new Defender(4, 2, Color.yellow));
        this.pieceCollection[4][3] = (new Defender(4, 3, Color.yellow));
        this.pieceCollection[4][4] = (new Defender(4, 4, Color.yellow));
        this.pieceCollection[4][0] = (new Leader  (4, 0, Color.yellow));


        this.setSize(500, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.addMouseListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        int row = this.getBoardDimention(e.getY());               //Намира се координатите посредством
        int col = this.getBoardDimention(e.getX());               // клик на мишката

        if (this.selectedPiece != null){
            if(this.selectedPiece instanceof Leader){              //Проверява от кой вид е избрания елемент
                Leader leader=(Leader)this.selectedPiece;
                leader.move(row,col); }
            if(this.selectedPiece instanceof Defender){
                Defender d=(Defender)this.selectedPiece;
                d.move(row, col);}

            this.selectedPiece = null;
            this.repaint();
        }
        if (this.hasBoardPiece(row, col)) {
            this.selectedPiece = this.getBoardPiece(row, col);
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void paint(Graphics g) {
        for (int row = 0; row < 5; row++) {                         //Създава полето
            for (int col = 0; col < 5; col++) {

                //SpecialTl st = new SpecialTl(2, 2);
                //st.render(g);

                this.renderGameTile(g, row, col);
                this.renderGamePiece(g, row, col);

            }
        }
    }

    private Color getTileColor(int row, int col) {
        if ((col == 0 && row == 0 || col == 4 && row == 0) ||
                (col == 1 && row == 4 || col == 3 && row == 4))  //If Else проверява кое поле как да се оцвети
        {
            return Color.ORANGE;     //Промяна на цвета на полето(ПНЦНП)
        } else if ((col == 1 && row == 1 || col == 0 && row == 1) ||
                (col == 3 && row == 1 || col == 4 && row == 1) ||
                (col == 1 && row == 3 || col == 0 && row == 3) ||
                (col == 3 && row == 3 || col == 4 && row == 3)) {
            return Color.GRAY;   //(ПНЦНП)
        } else if ((col == 1 && row == 0 || col == 3 && row == 0) ||
                (col == 0 && row == 4 || col == 4 && row == 4)) {
            return Color.BLACK;   //(ПНЦНП)
        } else {
            return Color.WHITE;   //(ПНЦНП)
        }
    }

    private void renderGameTile(Graphics g, int row, int col) {             //Рендира квадратите на полето

        Color tileColor = this.getTileColor(row, col);
        GameTile tile = new GameTile(row, col, tileColor);
        tile.render(g);
    }

    private Object getBoardPiece(int row, int col) {
        return this.pieceCollection[row][col];
    }

    private boolean hasBoardPiece(int row, int col) {                //Проверява дали фигората съществува
        return this.getBoardPiece(row, col) != null;
    }

    private void renderGamePiece(Graphics g, int row, int col) {
        if (this.hasBoardPiece(row, col)) {

            if (this.getBoardPiece(row, col) instanceof Leader) {              //Проверява от кой вид е елемента
                Leader l = (Leader) this.getBoardPiece(row, col);              //и какво да рендира
                l.render(g);
            }
            if (this.getBoardPiece(row, col) instanceof Defender) {
                Defender d = (Defender) this.getBoardPiece(row, col);
                d.render(g);
            }
        }
        }
        private int getBoardDimention ( int coordinates){
        return coordinates / GameTile.TILE_SIZE;
    }
}





