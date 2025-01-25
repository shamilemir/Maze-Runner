package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MazeSolver {

    private String mazeFile;
    private String inputPath;

    public MazeSolver(String mazeFile, String inputPath) {
        this.mazeFile = mazeFile;
        this.inputPath = inputPath;
    }

    private static final Logger logger = LogManager.getLogger();


    public int findEntry() {

        BufferedReader reader = new BufferedReader(new FileReader(getMazeFile()));

        int yCoord = 0;

        String line;
        while ((line = reader.readLine()) != null) {
            if (line.charAt(0) == ' ') {
                return yCoord;
            }
            yCoord++;
        }

        logger.info("Faulty maze: no entry point");
        return -1;
        
    }

    public char[][] getMazeArray() {

        BufferedReader reader = new BufferedReader(new FileReader(getMazeFile()));

        String xLine = reader.readLine();
        int xSize = xLine.length();

        String yLine;
        int ySize = 0;
        while ((yLine = reader.readLine()) != null) {
            ySize++;
        }

        char[][] mazeArray = new char[ySize][xSize];
        return mazeArray;

    }

    public void fillMazeArray(char[][] mazeArray) {

        BufferedReader reader = new BufferedReader(new FileReader(getMazeFile()));

        String line;
        int j = 0;
        while ((line = reader.readLine()) != null) {
            for (int i = 0; i < line.length(); i++) {
                mazeArray[j][i] = line.charAt(i);
            }
            j++;
        }

    }

    public String solve(char[][] mazeArray, int yCoord) {

        int xCoord = 0;
        int exitCoord = mazeArray[0].length - 1;
        
        char direction = 'R';

        String path = "";

        while (xCoord != exitCoord) {
            if (mazeArray[yCoord][xCoord] == ' '){
                moveDirection(direction, xCoord, yCoord);
                path = path + "F";
            }
            else if (mazeArray[yCoord][xCoord] == '#'){
                moveBack(direction, xCoord, yCoord);
                turnRight(direction);
                path = path + "R";
                // if (mazeArray[yCoord][xCoord] == ' ') {
                //     turnRight(direction);
                // }
                // else if (mazeArray[yCoord][xCoord] == '#') {
                //     turnLeft(direction);
                // }
            }
        }
        
        return path;
    }

    public void moveDirection(char direction, int xCoord, int yCoord) {
        switch(direction) {
            case 'R':
                xCoord++;
                break;
            case 'L':
                xCoord--;
                break;
            case 'U':
                yCoord++;
                break;
            case 'D':
                yCoord--;
                break;
        }
    }
    
    public void moveBack(char direction, int xCoord, int yCoord) {
        switch(direction) {
            case 'R':
                xCoord--;
                break;
            case 'L':
                xCoord++;
                break;
            case 'U':
                yCoord--;
                break;
            case 'D':
                yCoord++;
                break;
        }
    }

    public void turnLeft(char direction) {
        switch(direction) {
            case 'R':
                direction = 'U';
                break;
            case 'L':
                direction = 'D';
                break;
            case 'U':
                direction = 'L';
                break;
            case 'D':
                direction = 'R';
                break;
        }
    }
    
    public void turnRight(char direction) {
        switch(direction) {
            case 'R':
                direction = 'D';
                break;
            case 'L':
                direction = 'U';
                break;
            case 'U':
                direction = 'R';
                break;
            case 'D':
                direction = 'L';
                break;
        }
    }

    public String getMazeFile() {
        return mazeFile;
    }

    public String getInputPath() {
        return inputPath;
    }


}