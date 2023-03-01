
import controlador.SnakeGameController;
import java.awt.Color;
import javax.swing.JFrame;
import modelo.SnakeGameModel;
import vista.SnakeGameView;

public class launcher {
    public static void main(String[] args) {
        int boardWidth = 20;
        int boardHeight = 20;
        int blockSize = 20;
        int screenWidth = boardWidth * blockSize;
        int screenHeight = boardHeight * blockSize;
        
        Color snakeColor = Color.GREEN;
        Color appleColor = Color.RED;
        Color backgroundColor = Color.BLACK;
        
        SnakeGameModel model = new SnakeGameModel(boardWidth, boardHeight);
        SnakeGameView view = new SnakeGameView(blockSize, screenWidth, screenHeight, snakeColor, appleColor, backgroundColor);
        SnakeGameController controller = new SnakeGameController(model, view);
        
        JFrame frame = new JFrame("Snake Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(view);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    
    }
}