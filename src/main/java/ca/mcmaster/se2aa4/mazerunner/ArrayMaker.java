package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayMaker {

    private String mazeFile;

    public ArrayMaker(String mazeFile) {
        this.mazeFile = mazeFile;
    }


    public char[][] getSizedArray() {

        BufferedReader reader = new BufferedReader(new FileReader(getMazeFile()));

        String line = reader.readLine();
        
        int xLength = line.length();
        int yLength = -1;

        // switched from while loop to just use one 'line' String
        do {
            yLength++;
        }
        while ((line = reader.readLine()) != null);

        char[][] mazeArray = new char[yLength][xLength];
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

    public String getMazeFile() {
        return mazeFile;
    }

}