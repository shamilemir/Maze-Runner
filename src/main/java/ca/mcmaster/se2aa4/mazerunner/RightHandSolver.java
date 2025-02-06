package ca.mcmaster.se2aa4.mazerunner;

public class RightHandSolver implements MazeSolver {

    private Navigator navigator;
    private StringBuilder path;
    private PathFactorizer pathFactorizer;

    public RightHandSolver(Navigator navigator, StringBuilder path, PathFactorizer pathFactorizer) {
        this.navigator = navigator;
        this.path = path;
        this.pathFactorizer = pathFactorizer;
    }


    public String solve() {
        while (!navigator.finishedMaze()) {
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

}