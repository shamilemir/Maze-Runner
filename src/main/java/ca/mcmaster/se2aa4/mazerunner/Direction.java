package ca.mcmaster.se2aa4.mazerunner;

//not the most memory efficient way
//but this prof hates switch cases
public enum Direction {
    NORTH(null, null, 0, -1), //you need to SUBTRACT to go up in array
    EAST(null, null, 1, 0), 
    SOUTH(null, null, 0, 1), 
    WEST(null, null, -1, 0);

    private Direction rightDirection;
    private Direction leftDirection;
    private int xMove;
    private int yMove;

    Direction (Direction rightDirection, Direction leftDirection, int xMove, int yMove) {
        this.xMove = xMove;
        this.yMove = yMove;
    }

    static {
        NORTH.rightDirection = EAST;
        NORTH.leftDirection = WEST;

        EAST.rightDirection = SOUTH;
        EAST.leftDirection = NORTH;

        SOUTH.rightDirection = WEST;
        SOUTH.leftDirection = EAST;

        WEST.rightDirection = NORTH;
        WEST.leftDirection = SOUTH;
    }

    public Direction getRightDirection() {
        return rightDirection;
    }
    public Direction getLeftDirection() {
        return leftDirection;
    }
    public int getXMove() {
        return xMove;
    }
    public int getYMove() {
        return yMove;
    }

}