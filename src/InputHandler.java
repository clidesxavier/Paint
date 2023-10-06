import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class InputHandler implements KeyboardHandler {


    private static Keyboard keyboard;
    private static  KeyboardEvent[] events;
    private Cursor cursor;
    private Rectangle cursor1;


    public InputHandler(Cursor cursor){
        keyboard = new Keyboard(this);
        events = new KeyboardEvent[8];
        createEvents();
        this.cursor = cursor;
        cursor1 = Cursor.cursor;
    }


    /*
        create events > set keys > set event type > add listeners
    */
    public static void createEvents(){

        for (int i = 0; i < events.length; i++) {
            events[i] = new KeyboardEvent();
        }

        events[0].setKey(KeyboardEvent.KEY_DOWN);
        events[1].setKey(KeyboardEvent.KEY_RIGHT);
        events[2].setKey(KeyboardEvent.KEY_LEFT);
        events[3].setKey(KeyboardEvent.KEY_UP);
        events[4].setKey(KeyboardEvent.KEY_SPACE);
        events[5].setKey(KeyboardEvent.KEY_C);
        events[6].setKey(KeyboardEvent.KEY_P);
        events[7].setKey(KeyboardEvent.KEY_B);


        for (KeyboardEvent event : events) {
            event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboard.addEventListener(event);
        }
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_UP:
                if ((cursor1.getY() - GridField.cellSize) > 0) {
                    cursor1.translate(0, -GridField.cellSize);
                            cursor.translate(0, 5);
                            try {
                                Thread.sleep(15L);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                }
                break;
            case KeyboardEvent.KEY_DOWN:
                if ((cursor1.getY() + GridField.cellSize) < GridField.height) {
                    cursor1.translate(0, GridField.cellSize);
                }
                break;
            case KeyboardEvent.KEY_LEFT:
                if((cursor1.getX() - GridField.cellSize) > 0) {
                    cursor1.translate(-GridField.cellSize, 0);
                }
                break;
            case KeyboardEvent.KEY_RIGHT:
                if((cursor1.getX() + GridField.cellSize) < GridField.width) {
                    cursor1.translate(GridField.cellSize, 0);
                }
                break;
            case KeyboardEvent.KEY_SPACE:
                cursor.paint();
                break;
            case KeyboardEvent.KEY_C:
                cursor.delete();
                break;
            case KeyboardEvent.KEY_P:
                cursor.paintPink();
                break;
            case KeyboardEvent.KEY_B:
                cursor.paintBlue();

        }
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
