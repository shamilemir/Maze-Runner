package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TargetFinder {

    private static final Logger logger = LogManager.getLogger();

    public TargetFinder() {

    }

    public int findTarget(char[][] mazeArray, Checkpoint target) {
        int targetCoord = 0;
        int horizontalCoord = -1;
        if (target == Checkpoint.ENTRY) {
            horizontalCoord = 0;
        }
        else if (target == Checkpoint.EXIT) {
            horizontalCoord = mazeArray[0].length - 1;
        }

        for (int i = 0; i < mazeArray.length; i++) {
            if (mazeArray[i][horizontalCoord] == ' ') {
                return targetCoord;
            }
            targetCoord++;
        }

        logger.info("Faulty maze: no entry point");
        return -1;
        
    }

}