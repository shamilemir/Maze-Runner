package ca.mcmaster.se2aa4.mazerunner.States;
import ca.mcmaster.se2aa4.mazerunner.Commands.*;
import ca.mcmaster.se2aa4.mazerunner.Navigator;
import ca.mcmaster.se2aa4.mazerunner.RightHandSolver;

public class leftOpenState extends State {

    public leftOpenState(RightHandSolver solver, Navigator navigator, StringBuilder path) {
        super(solver, navigator, path);
    }

    @Override
    public void move() {
        if (navigator.leftSpaceOpen()){
            navigator.setCommand(solver.getLeftCommand());
            path.append(" L ");
        }
        else {
            //turn around
            navigator.setCommand(solver.getLeftCommand());
            navigator.setCommand(solver.getLeftCommand());
            path.append(" LL ");
        }
        solver.setState(new rightOpenState(solver, navigator, path));
        progress();
    }
    
}