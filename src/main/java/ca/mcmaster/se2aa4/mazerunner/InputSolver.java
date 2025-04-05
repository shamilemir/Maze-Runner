package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.Commands.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InputSolver implements MazeSolver {

    private Navigator navigator;
    private String inputPath;
    private PathFactorizer pathFactorizer;
    private int exitXCoord;
    private int exitYCoord;

    private TurnLeftCommand turnLeftCommand = new TurnLeftCommand();
    private TurnRightCommand turnRightCommand = new TurnRightCommand();
    private MoveForwardCommand moveForwardCommand = new MoveForwardCommand();

    public InputSolver(Navigator navigator, String inputPath, PathFactorizer pathFactorizer, int exitXCoord, int exitYCoord) {
        this.navigator = navigator;
        this.inputPath = inputPath;
        this.pathFactorizer = pathFactorizer;
        this.exitXCoord = exitXCoord;
        this.exitYCoord = exitYCoord;
    }

    public String solve() {
        
        char current;
        if (isFactorized()) {
            inputPath = pathFactorizer.unfactorize(inputPath);
        }
        for (int i = 0; i < inputPath.length(); i++) {
            current = inputPath.charAt(i);
            //did i mention he hates switch cases
            if (current == 'F') {
                navigator.setCommand(moveForwardCommand);
            }
            else if (current == 'R') {
                navigator.setCommand(turnRightCommand);
            }
            else if (current == 'L') {
                navigator.setCommand(turnLeftCommand);
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

    private boolean isFactorized() {
        for (int i = 0; i < inputPath.length(); i++) {
            if (Character.isDigit(inputPath.charAt(i))) {
                return true;
            }
        }
        return false;
    }

}