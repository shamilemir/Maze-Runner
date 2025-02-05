package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Navigator {

    private StringBuilder path;

    public Navigator(StringBuilder path) {
        this.path = path;
    }

    //not the most memory efficient way
    //but this prof hates switch cases
    enum Directions {
        NORTH(EAST, WEST), 
        EAST(SOUTH, NORTH), 
        SOUTH(WEST, EAST), 
        WEST(NORTH, SOUTH);

        private Directions turnRightDirection;
        private Directions turnLeftDirection;

        Directions (Directions turnRightDirection, Directions turnLeftDirection) {
            this.turnRightDirection = turnRightDirection;
            this.turnLeftDirection = turnLeftDirection;
        }

        public Directions turnRight(){
            return this.turnRightDirection;
        }
        public Directions turnLeft(){
            return this.turnLeftDirection;
        }
    }



    public void addToPath(String movement) {
        path.append(movement);
    }

    public String getPath() {
        return path.toString();
    }

}