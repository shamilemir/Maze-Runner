package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.Commands.*;
import ca.mcmaster.se2aa4.mazerunner.States.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RightHandSolver implements MazeSolver {

    private Navigator navigator;
    private StringBuilder path;
    private PathFactorizer pathFactorizer;
    private int exitXCoord;
    private State state;

    private TurnLeftCommand turnLeftCommand = new TurnLeftCommand();
    private TurnRightCommand turnRightCommand = new TurnRightCommand();
    private MoveForwardCommand moveForwardCommand = new MoveForwardCommand();

    public RightHandSolver(Navigator navigator, StringBuilder path, PathFactorizer pathFactorizer, int exitXCoord) {
        this.navigator = navigator;
        this.path = path;
        this.pathFactorizer = pathFactorizer;
        this.exitXCoord = exitXCoord;
        this.state = new rightOpenState(this, navigator, path);
    }


    public String solve() {
        while (!finishedMaze()) {
            state.move();
        }
        String pathAsString = path.toString();
        return pathFactorizer.factorize(pathAsString);
    }

    public boolean finishedMaze() {
        //exitY not relevant, all other tiles are walls at the end
        if (navigator.getXCoord() == exitXCoord) {
            return true;
        }
        return false;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Command getLeftCommand() {
        return turnLeftCommand;
    }
    public Command getRightCommand() {
        return turnRightCommand;
    }
    public Command getForwardCommand() {
        return moveForwardCommand;
    }

}