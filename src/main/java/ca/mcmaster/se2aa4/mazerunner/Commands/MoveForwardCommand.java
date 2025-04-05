package ca.mcmaster.se2aa4.mazerunner.Commands;
import ca.mcmaster.se2aa4.mazerunner.Navigator;

public class MoveForwardCommand implements Command {

    @Override
    public void execute(Navigator navigator) {
        int newXCoord = navigator.getXCoord() + navigator.getDirection().getXMove();
        int newYCoord = navigator.getYCoord() + navigator.getDirection().getYMove();
        navigator.setXCoord(newXCoord);
        navigator.setYCoord(newYCoord);
    }
    
}