package ca.mcmaster.se2aa4.mazerunner.Commands;
import ca.mcmaster.se2aa4.mazerunner.Navigator;

public interface Command {

    void execute(Navigator navigator);
    
}