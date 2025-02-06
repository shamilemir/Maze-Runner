package ca.mcmaster.se2aa4.mazerunner;

public class MazeSolver {

    private StringBuilder path;
    private Navigator navigator;

    public MazeSolver(Navigator navigator, StringBuilder path) {
        this.navigator = navigator;
        this.path = path;
    }


    public String solve() {
        while (!navigator.finishedMaze()) {
            if (navigator.rightSpaceOpen()){
                navigator.turnRight();
                path.append("R");
            }
            else if (navigator.frontSpaceOpen()){
                //do nothing, break 'if' statement
            }
            else if (navigator.leftSpaceOpen()){
                navigator.turnLeft();
                path.append("L");
            }
            else {
                //turn around
                navigator.turnLeft();
                navigator.turnLeft();
                path.append("LL");
            }
            navigator.moveForward();
            path.append("F");
        }
        return path.toString();
    }

}