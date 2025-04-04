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

            //setup
            ArrayMaker arrayMaker = new ArrayMaker(MAZE_FILE);
            char[][] mazeArray = arrayMaker.prepareMaze();

            TargetFinder targetFinder = new TargetFinder();
            int startYCoord = targetFinder.findTarget(mazeArray, Checkpoint.ENTRY);

            int exitYCoord = targetFinder.findTarget(mazeArray, Checkpoint.EXIT);
            int exitXCoord = mazeArray[0].length - 1;

            Navigator navigator = new Navigator(mazeArray, startYCoord);

            PathFactorizer pathFactorizer = new PathFactorizer(new StringBuilder());

            //declarations
            MazeSolver rightHandSolver = new RightHandSolver(navigator, new StringBuilder(), pathFactorizer, exitXCoord);
            String correctPath;

            MazeSolver inputSolver = new InputSolver(navigator, INPUT_PATH, pathFactorizer, exitXCoord, exitYCoord);
            String confirmation;

            if (INPUT_PATH == null) {
                correctPath = rightHandSolver.solve();
                System.out.println("The correct path is " + correctPath); //factorized path
            }
            else {
                confirmation = inputSolver.solve();
                System.out.println("The given path is " + confirmation); //correct or not correct
            }
        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\ {}", e.getMessage(), e);
        }

        logger.info("** End of MazeRunner");

    }
}
