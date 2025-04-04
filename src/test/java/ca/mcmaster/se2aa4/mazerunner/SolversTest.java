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
        setUp("./examples/small.maz.txt");
        assertEquals("F R F 2L 2F R 2F R 2F 2L 4F R 2F R 4F 2L 2F R 4F R 2F R 2F 2L 2F L 2F L 4F R 2F R 2F 2L 4F R 2F R 2F 2L 2F R 2F R 4F R 2F L 2F R 2F L F ", result);
    }

    @Test
    void rightHandSolveDirectMazeTest() {
        setUp("./examples/direct.maz.txt");
        assertEquals("F R 2F L 3F R F L F R F L 2F ", result);
    }

    @Test
    void rightHandSolveStraightMazeTest() {
        setUp("./examples/straight.maz.txt");
        assertEquals("4F ", result);
    }


}