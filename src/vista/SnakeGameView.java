/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import modelo.SnakeGameModel;

public class SnakeGameView extends JPanel implements KeyListener {
    private SnakeGameModel model;
    private int blockSize;
    private int screenWidth;
    private int screenHeight;
    private Color snakeColor;
    private Color appleColor;
    private Color backgroundColor;

    public SnakeGameView(int blockSize, int screenWidth, int screenHeight,
        Color snakeColor, Color appleColor, Color backgroundColor) {
        this.blockSize = blockSize;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.snakeColor = snakeColor;
        this.appleColor = appleColor;
        this.backgroundColor = backgroundColor;
        
        setPreferredSize(new Dimension(screenWidth, screenHeight));
        setBackground(backgroundColor);
        setFocusable(true);
        addKeyListener(this);
    }
    
    public void setModel(SnakeGameModel model) {
        this.model = model;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(appleColor);
        g.fillOval(model.getApple().x * blockSize, model.getApple().y * blockSize, blockSize, blockSize);
        g.setColor(snakeColor);
        for (Point bodyPart : model.getSnakeBody()) {
            g.fillRect(bodyPart.x * blockSize, bodyPart.y * blockSize, blockSize, blockSize);
        }
    }
        
    public void update() {
        repaint();
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        System.out.println(keyCode);
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
            model.setSnakeDirection(SnakeGameModel.Direction.LEFT);
                System.out.println("left");
        break;
            case KeyEvent.VK_RIGHT:
            model.setSnakeDirection(SnakeGameModel.Direction.RIGHT);
                  System.out.println("r");

        break;
            case KeyEvent.VK_UP:
            model.setSnakeDirection(SnakeGameModel.Direction.UP);
        break;
            case KeyEvent.VK_DOWN:
            model.setSnakeDirection(SnakeGameModel.Direction.DOWN);
        break;
        }
        update();
    }
    
    @Override
        public void keyTyped(KeyEvent e) {
    }
        
    @Override
        public void keyReleased(KeyEvent e) {
    }
        
}
