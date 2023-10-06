import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class GridField {

    public static final int PADDING = 10;

    public static final int cellSize = 20;

    public static final int width = 400;

    public static final int height = 600;

    public static final int numberOfCol = width/cellSize;

    public static final int numberOfRow = height /cellSize;

    private final Rectangle rectangle;
    public static Cursor cursor;
    public Tile[][] gridRectangles;

    public GridField(){
        rectangle = new Rectangle(PADDING, PADDING, width, height);
        rectangle.draw();
        createGrid();
        cursor = new Cursor(this);
    }
    public void createGrid() {

        gridRectangles = new Tile[numberOfRow][numberOfCol];

        for (int i = 0; i < gridRectangles.length; i++) {
            for (int j = 0; j < gridRectangles[i].length; j++){
                gridRectangles[i][j] = new Tile( PADDING + j * cellSize, PADDING + i * cellSize, cellSize, cellSize);
                gridRectangles[i][j].draw();
            }
        }
    }

}

