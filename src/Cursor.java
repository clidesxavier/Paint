import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;

import static org.academiadecodigo.simplegraphics.graphics.Color.*;

public class Cursor {

    public GridField gridField;
    public static Rectangle cursor;

    public Cursor(GridField gridField){
        this.gridField = gridField;
        cursor = new Rectangle(GridField.PADDING, GridField.PADDING, GridField.cellSize, GridField.cellSize);
        cursor.setColor(BLUE);
        cursor.fill();
    }


    public void paint() {

        int col = (cursor.getX() - GridField.PADDING)/ GridField.cellSize;
        int row = (cursor.getY() - GridField.PADDING)/ GridField.cellSize;
        gridField.gridRectangles[row][col].fill();
        }

    public void delete() {
        int col = (cursor.getX() - GridField.PADDING)/ GridField.cellSize;
        int row = (cursor.getY() - GridField.PADDING)/ GridField.cellSize;

        gridField.gridRectangles[row][col].draw();
    }

    public void paintPink() {
        int col = (cursor.getX() - GridField.PADDING)/ GridField.cellSize;
        int row = (cursor.getY() - GridField.PADDING)/ GridField.cellSize;
        gridField.gridRectangles[row][col].setColor(PINK);
    }

    public void paintBlue() {
        int col = (cursor.getX() - GridField.PADDING)/ GridField.cellSize;
        int row = (cursor.getY() - GridField.PADDING)/ GridField.cellSize;
        gridField.gridRectangles[row][col].setColor(BLUE);

    }


    public void translate(int i, int i1) {
    }
}







