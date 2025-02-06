package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InputSolver implements MazeSolver {

    private Navigator navigator;
    private String inputPath;
    private int exitXCoord;
    private int exitYCoord;

    public InputSolver(Navigator navigator, String inputPath, int exitXCoord, int exitYCoord) {
        this.navigator = navigator;
        this.inputPath = inputPath;
        this.exitXCoord = exitXCoord;
        this.exitYCoord = exitYCoord;
    }

    public String solve() {
        
        char current;
        for (int i = 0; i < inputPath.length(); i++) {
            current = inputPath.charAt(i);
            //did i mention he hates switch cases
            if (current == 'F') {
                navigator.moveForward();
            }
            else if (current == 'R') {
                navigator.turnRight();
            }
            else if (current == 'L') {
                navigator.turnLeft();
            }
            else {
                //do nothing if space
            }

            if (navigator.insideWall()) {
                return "NOT correct";
            }
        }

        if (finishedMaze()) {
            return "correct";
        }
        else {
            return "NOT correct";
        }

    }

    public boolean finishedMaze() {
        //exitY IS relevant as opposed to righthandsolver
        if ((navigator.getXCoord() == exitXCoord) && (navigator.getYCoord() == exitYCoord)) {
            return true;
        }
        return false;
    }

}