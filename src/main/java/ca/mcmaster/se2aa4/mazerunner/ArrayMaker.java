package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayMaker {

    private static final Logger logger = LogManager.getLogger();
    private String mazeFile;

    public ArrayMaker(String mazeFile) {
        this.mazeFile = mazeFile;
    }


    private char[][] getSizedArray() {

        char[][] mazeArray = new char[0][0];

        try 
        {
            BufferedReader reader = new BufferedReader(new FileReader(getMazeFile()));

            String line = reader.readLine();
            
            int xLength = line.length();
            int yLength = 0;

            // switched from while loop to just use one 'line' String
            do {
                yLength++;
            }
            while ((line = reader.readLine()) != null);

            mazeArray = new char[yLength][xLength];
        } catch (FileNotFoundException e) {
            logger.error("Error reading file: ", e.getMessage(), e);
        } catch (IOException e) {
            logger.error("Error reading file: ", e.getMessage(), e);
        }

        return mazeArray;
    }

    private void fillMazeArray(char[][] mazeArray) {

        try 
        {
            BufferedReader reader = new BufferedReader(new FileReader(getMazeFile()));
            String line;
            int j = 0;
            while ((line = reader.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    mazeArray[j][i] = line.charAt(i);
                }
                j++;
            }
        } catch (FileNotFoundException e) {
            logger.error("Error reading file: ", e.getMessage(), e);
        } catch (IOException e) {
            logger.error("Error reading file: ", e.getMessage(), e);
        }

    }

    public String getMazeFile() {
        return mazeFile;
    }

    public char[][] prepareMaze() {
        char[][] mazeArray = getSizedArray();
        fillMazeArray(mazeArray);
        return mazeArray;
    }

}