package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RightHandSolver implements MazeSolver {

    private Navigator navigator;
    private StringBuilder path;
    private PathFactorizer pathFactorizer;
    private int exitXCoord;

    public RightHandSolver(Navigator navigator, StringBuilder path, PathFactorizer pathFactorizer, int exitXCoord) {
        this.navigator = navigator;
        this.path = path;
        this.pathFactorizer = pathFactorizer;
        this.exitXCoord = exitXCoord;
    }


    public String solve() {
        while (!finishedMaze()) {
            if (navigator.rightSpaceOpen()){
                navigator.turnRight();
                path.append(" R ");
            }
            else if (navigator.frontSpaceOpen()){
                //do nothing, break 'if' statement
            }
            else if (navigator.leftSpaceOpen()){
                navigator.turnLeft();
                path.append(" L ");
            }
            else {
                //turn around
                navigator.turnLeft();
                navigator.turnLeft();
                path.append(" LL ");
            }
            navigator.moveForward();
            path.append("F");
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

}