package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class SolversTest {

    ArrayMaker mazeMaker;
    char[][] mazeArray;
    TargetFinder targetFinder;
    int startYCoord;
    int exitYCoord;
    int exitXCoord;
    Navigator navigator; 
    PathFactorizer pathFactorizer; 
    MazeSolver solver; 
    String result;

    void setUp(String filePath) {
        mazeMaker = new ArrayMaker(filePath);
        mazeArray = mazeMaker.prepareMaze();
        targetFinder = new TargetFinder();
        startYCoord = targetFinder.findTarget(mazeArray, Checkpoint.ENTRY);
        exitYCoord = targetFinder.findTarget(mazeArray, Checkpoint.EXIT);
        exitXCoord = mazeArray[0].length - 1;
        navigator = new Navigator(mazeArray, startYCoord);
        pathFactorizer = new PathFactorizer(new StringBuilder());
        solver = new RightHandSolver(navigator, new StringBuilder(), pathFactorizer, exitXCoord);
        result = solver.solve();
    }


    @Test
    void rightHandSolveSmallMazeTest() {
        setUp("./examples/straight.maz.txt");
        assertEquals("4F ", result);
    }



}