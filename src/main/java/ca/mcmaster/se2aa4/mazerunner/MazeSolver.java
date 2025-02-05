package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MazeSolver {

    private ArrayMaker arrayMaker;
    private Navigator navigator;
    private int yCoord;
    private int xCoord = 0;

    public MazeSolver(ArrayMaker arrayMaker, Navigator navigator) {
        this.arrayMaker = arrayMaker;
        this.navigator = navigator;
    }

    private static final Logger logger = LogManager.getLogger();


    private int findEntry(char[][] mazeArray) {

        int entryCoord = 0;

        for (int i = 0; i < mazeArray.length; i++) {
            if (mazeArray[i][0] == ' ') {
                return entryCoord;
            }
            entryCoord++;
        }

        logger.info("Faulty maze: no entry point");
        return -1;
        
    }

    private char[][] prepareMaze() {
        char[][] mazeArray = arrayMaker.getSizedArray();
        arrayMaker.fillMazeArray(mazeArray);
        return mazeArray;
    }


    public String solve() {

        char[][] mazeArray = prepareMaze();

        yCoord = findEntry(mazeArray);

        //exitY not relevant, all other tiles are walls at the end
        int exitXCoord = mazeArray[0].length - 1;

        while (xCoord != exitXCoord) {
            if (mazeArray[yCoord][xCoord] == ' '){

                navigator.addToPath();
            }
            else if (mazeArray[yCoord][xCoord] == '#'){

                navigator.addToPath();
            }
        }
        
        navigator.getPath();
    }

}