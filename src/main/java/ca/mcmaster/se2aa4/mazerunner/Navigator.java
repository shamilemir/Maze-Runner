package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.Commands.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Navigator {
    
    private char[][] mazeArray;
    private Direction direction;
    private int yCoord;
    private int xCoord;

    private int tempX = 0;
    private int tempY = 0;

    private Command command;

    public Navigator(char[][] mazeArray, int yCoord) {
        this.mazeArray = mazeArray;
        this.direction = Direction.EAST; //start from left
        this.yCoord = yCoord;
        this.xCoord = 0;
    }

    public void setCommand(Command command) {
        this.command = command;
        executeCommand();
    }

    public void executeCommand() {
        command.execute(this);
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
    public boolean insideWall() {
        if (mazeArray[yCoord][xCoord] == '#') {
            return true;
        }
        return false;
    }

    public int getXCoord() {
        return xCoord;
    }
    public int getYCoord() {
        return yCoord;
    }
    public Direction getDirection() {
        return direction;
    }
    public void setXCoord(int xCoord) {
        this.xCoord = xCoord;
    }
    public void setYCoord(int yCoord) {
        this.yCoord = yCoord;
    }
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

}