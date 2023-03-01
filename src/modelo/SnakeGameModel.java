
package modelo;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class SnakeGameModel {
    private int boardWidth;
    private int boardHeight;
    private Point snakeHead;
    private ArrayList<Point> snakeBody;
    private Point apple;
    private boolean isGameOver;
    private Direction snakeDirection;
    private Random random;

    public enum Direction {
        LEFT, RIGHT, UP, DOWN
    }
    
    public SnakeGameModel(int boardWidth, int boardHeight) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        random = new Random();
        resetGame();
    }
    public void resetGame() {
        snakeHead = new Point(boardWidth / 2, boardHeight / 2);
        snakeBody = new ArrayList<Point>();
        snakeBody.add(new Point(snakeHead.x - 1, snakeHead.y));
        snakeBody.add(new Point(snakeHead.x - 2, snakeHead.y));
        snakeDirection = Direction.RIGHT;
        spawnApple();
        isGameOver = false;
    }
   public void moveSnake() {
        // Get the current head of the snake
        Point head = snakeBody.get(snakeBody.size() - 1);

        // Create a new head based on the current direction of the snake
        Point newHead = new Point(head);
        switch (snakeDirection) {
            case UP:
                newHead.y--;
                break;
            case DOWN:
                newHead.y++;
                break;
            case LEFT:
                newHead.x--;
                break;
            case RIGHT:
                newHead.x++;
                break;
        }

        // Check if the new head collides with the snake's body
        for (int i = 0; i < snakeBody.size() - 1; i++) {
            if (newHead.equals(snakeBody.get(i))) {
                isGameOver = true;
                return;
            }
        }

        // Check if the new head collides with the walls
        if (newHead.x < 0  newHead.x >= boardWidth  newHead.y < 0 || newHead.y >= boardHeight) {
            isGameOver = true;
            return;
        }

        // Check if the new head collides with the apple
        if (newHead.equals(apple)) {
            snakeBody.add(apple);
            apple = spawnApple();
        } else {
            // Remove the tail of the snake
            snakeBody.remove(0);
        }

        // Add the new head to the snake's body
        snakeBody.add(newHead);
    }
    
    private void spawnApple() {
        apple = new Point(random.nextInt(boardWidth), random.nextInt(boardHeight));
    }
    
    public Point getSnakeHead() {
        return snakeHead;
    }
    
    public ArrayList<Point> getSnakeBody() {
    return snakeBody;
    }
    
    public Point getApple() {
        return apple;
    }
    
    public boolean isGameOver() {
        return isGameOver;
    }
    
    public Direction getSnakeDirection() {
        return snakeDirection;
    }
    
    public void setSnakeDirection(Direction snakeDirection) {
        if (this.snakeDirection == Direction.LEFT && snakeDirection == Direction.RIGHT ||
            this.snakeDirection == Direction.RIGHT && snakeDirection == Direction.LEFT ||
            this.snakeDirection == Direction.UP && snakeDirection == Direction.DOWN ||
            this.snakeDirection == Direction.DOWN && snakeDirection == Direction.UP) {
            return;
        }
        this.snakeDirection = snakeDirection;
        }
    }