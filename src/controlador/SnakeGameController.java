
package controlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.SnakeGameModel;
import vista.SnakeGameView;

public class SnakeGameController implements ActionListener {
    private SnakeGameModel model;
    private SnakeGameView view;
    private Timer timer;
    
    public SnakeGameController(SnakeGameModel model, SnakeGameView view) {
        this.model = model;
        this.view = view;
        this.view.setModel(this.model);

        timer = new Timer(100, this);
        timer.start();
        }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(model.isGameOver());
        if (!model.isGameOver()) {
            model.moveSnake();
            view.update();
        } else {
            timer.stop();
            int choice = JOptionPane.showConfirmDialog(view, "Game Over! Play again?", "Game Over",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (choice == JOptionPane.YES_OPTION) {
                    model.resetGame();
                    timer.start();
                } else {
                    System.exit(0);
                }
        }
    }
}
   
