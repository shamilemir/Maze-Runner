package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class TargetFinderTest {
    

    ArrayMaker mazeMaker;
    char[][] mazeArray;
    TargetFinder targetFinder = new TargetFinder();

    void setUp(String filePath) {
        mazeMaker = new ArrayMaker(filePath);
        mazeArray = mazeMaker.prepareMaze();
    }

    @Test
    void smallMazeEntranceEight() {
        setUp("./examples/small.maz.txt");
        assertEquals(8, targetFinder.findTarget(mazeArray, Checkpoint.ENTRY));
    }

    @Test
    void smallMazeExitFive() {
        setUp("./examples/small.maz.txt");
        assertEquals(5, targetFinder.findTarget(mazeArray, Checkpoint.EXIT));
    }

    @Test
    void directMazeEntranceOne() {
        setUp("./examples/direct.maz.txt");
        assertEquals(1, targetFinder.findTarget(mazeArray, Checkpoint.ENTRY));
    }

    @Test
    void directMazeExitFive() {
        setUp("./examples/direct.maz.txt");
        assertEquals(5, targetFinder.findTarget(mazeArray, Checkpoint.EXIT));
    }
    @Test
    void giantMazeEntranceTwentyOne() {
        setUp("./examples/giant.maz.txt");
        assertEquals(21, targetFinder.findTarget(mazeArray, Checkpoint.ENTRY));
    }

    @Test
    void giantMazeExitFiftyThree() {
        setUp("./examples/giant.maz.txt");
        assertEquals(53, targetFinder.findTarget(mazeArray, Checkpoint.EXIT));
    }

}