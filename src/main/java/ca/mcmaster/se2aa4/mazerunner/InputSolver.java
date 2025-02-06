package ca.mcmaster.se2aa4.mazerunner;

public class InputSolver implements MazeSolver {

    private Navigator navigator;
    private String inputPath;
    private PathFactorizer pathFactorizer;

    public InputSolver (Navigator navigator, String inputPath, PathFactorizer pathFactorizer) {
        this.navigator = navigator;
        this.inputPath = inputPath;
        this.pathFactorizer = pathFactorizer;
    }

    public String solve() {
        return " ";
        // return "correct"
        // return "NOT correct"
    }

}