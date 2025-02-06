package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Main {

    private static final Logger logger = LogManager.getLogger();
    public static String MAZE_FILE;
    public static String INPUT_PATH;

    public static void main(String[] args) {

        Options options = new Options();
        options.addOption("i", true, "Maze file");
        options.addOption("p", true, "Input path");
        CommandLineParser parser = new DefaultParser();

        logger.info("** Starting Maze Runner");
        try {

            CommandLine cmd = parser.parse(options, args);
            MAZE_FILE = cmd.getOptionValue("i");
            INPUT_PATH = cmd.getOptionValue("p");

            logger.info("**** Solving the maze from file " + MAZE_FILE);

            ArrayMaker arrayMaker = new ArrayMaker(MAZE_FILE);
            char[][] mazeArray = arrayMaker.prepareMaze();

            MazeSolver solver = new MazeSolver(new Navigator(mazeArray), new StringBuilder());

            String correctPath = solver.solve();

            if (INPUT_PATH == null) {
                System.out.println("The correct path is " + correctPath);
            }
            else if (INPUT_PATH.equals(correctPath)) {
                System.out.println("The given path is correct");
            }
            else {
                System.out.println("The given path is NOT correct");
            }
        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\ {}", e.getMessage(), e);
        }

        logger.info("** End of MazeRunner");

    }
}
