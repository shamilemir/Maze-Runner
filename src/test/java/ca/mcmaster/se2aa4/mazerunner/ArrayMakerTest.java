package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayMakerTest {

    ArrayMaker mazeMaker;
    char[][] mazeArray;

    void setUp(String filePath) {
        mazeMaker = new ArrayMaker(filePath);
        mazeArray = mazeMaker.prepareMaze();
    }


    @Test
    void smallMazeElevenRows() {
        setUp("./examples/small.maz.txt");
        assertEquals(11, mazeArray.length);
    }

    @Test
    void smallMazeElevenColumns() {
        setUp("./examples/small.maz.txt");
        assertEquals(11, mazeArray[0].length);
    }

    @Test
    void smallMazeExitLocation() {
        setUp("./examples/small.maz.txt");
        int farthestRight = mazeArray.length - 1;
        assertEquals(' ', mazeArray[5][farthestRight]);
    }


    @Test
    void directMazeSevenRows() {
        setUp("./examples/direct.maz.txt");
        assertEquals(7, mazeArray.length);
    }

    @Test
    void directMazeEightColumns() {
        setUp("./examples/direct.maz.txt");
        assertEquals(8, mazeArray[0].length);
    }

    @Test
    void directMazeExitLocation() {
        setUp("./examples/direct.maz.txt");
        int farthestRight = mazeArray.length - 1;
        assertEquals(' ', mazeArray[5][farthestRight]);
    }

}