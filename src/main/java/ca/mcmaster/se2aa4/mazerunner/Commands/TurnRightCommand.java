package ca.mcmaster.se2aa4.mazerunner.Commands;
import ca.mcmaster.se2aa4.mazerunner.Navigator;
import ca.mcmaster.se2aa4.mazerunner.Direction;

public class TurnRightCommand implements Command {

    @Override
    public void execute(Navigator navigator) {
        Direction newDirection = navigator.getDirection().getRightDirection();
        navigator.setDirection(newDirection);
    }
    
}