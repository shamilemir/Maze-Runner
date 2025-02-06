package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Navigator {

    private static final Logger logger = LogManager.getLogger();
    private char[][] mazeArray;
    private Direction direction;
    private int yCoord;
    private int xCoord;

    private int tempX = 0;
    private int tempY = 0;

    public Navigator(char[][] mazeArray) {
        this.mazeArray = mazeArray;
        this.direction = Direction.EAST; //start from left
        this.yCoord = findEntry(mazeArray);
        this.xCoord = 0;
    }


    public int findEntry(char[][] mazeArray) {

        int entryCoord = 0;

        for (int i = 0; i < mazeArray.length; i++) {
            if (mazeArray[i][0] == ' ') {
                return entryCoord;
            }
            entryCoord++;
        }

        logger.info("Faulty maze: no entry point");
        return -1;
        
    }

    public void turnRight() {
        direction = direction.getRightDirection();
    }
    public void turnLeft() {
        direction = direction.getLeftDirection();
    }
    public void moveForward() {
        xCoord += direction.getXMove();
        yCoord += direction.getYMove();
    }

    //temps are global for memory efficiency
    //same reasoning for not creating new direction each time
    public boolean rightSpaceOpen() {
        tempX = xCoord + direction.getRightDirection().getXMove();
        tempY = yCoord + direction.getRightDirection().getYMove();
        if (mazeArray[tempY][tempX] == ' ') {
            return true;
        }
        return false;
    }
    public boolean frontSpaceOpen() {
        tempX = xCoord + direction.getXMove();
        tempY = yCoord + direction.getYMove();
        if (mazeArray[tempY][tempX] == ' ') {
            return true;
        }
        return false;
    }
    public boolean leftSpaceOpen() {
        tempX = xCoord + direction.getLeftDirection().getXMove();
        tempY = yCoord + direction.getLeftDirection().getYMove();
        if (mazeArray[tempY][tempX] == ' ') {
            return true;
        }
        return false;
    }
    public boolean finishedMaze() {
        //exitY not relevant, all other tiles are walls at the end
        if (xCoord == mazeArray[0].length - 1) {
            return true;
        }
        return false;
    }

    public void resetPosition() {
        yCoord = findEntry(mazeArray);
        xCoord = 0;
    }

}