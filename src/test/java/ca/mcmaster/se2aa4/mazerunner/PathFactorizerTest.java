package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class PathFactorizerTest {

    PathFactorizer pathFactorizer;

    @BeforeEach
    void setUp() {
        pathFactorizer = new PathFactorizer(new StringBuilder());
    }

    @Test
    void factorizeTest() {
        String path = "F LL RRR L RR FFF R FF LLL";
        assertEquals("F 2L 3R L 2R 3F R 2F 3L ", pathFactorizer.factorize(path));
    }

    @Test
    void unfactorizeTest() {
        String path = "F 2L 3R L 2R 3F R 2F 3L";
        assertEquals("F LL RRR L RR FFF R FF LLL ", pathFactorizer.unfactorize(path));
    }

    @Test
    void appendFrequencyOne() {
        pathFactorizer.factorizeAppend(1, 'F');
        assertEquals("F ", pathFactorizer.getPathString());
    }

    @Test
    void appendFrequencyMoreThanOne() {
        pathFactorizer.factorizeAppend(5, 'F');
        assertEquals("5F ", pathFactorizer.getPathString());
    }

}