package ca.mcmaster.se2aa4.mazerunner.States;
import ca.mcmaster.se2aa4.mazerunner.Commands.*;
import ca.mcmaster.se2aa4.mazerunner.Navigator;
import ca.mcmaster.se2aa4.mazerunner.RightHandSolver;

public class rightOpenState extends State {

    public rightOpenState(RightHandSolver solver, Navigator navigator, StringBuilder path) {
        super(solver, navigator, path);
    }

    @Override
    public void move() {
        if (navigator.rightSpaceOpen()){
            navigator.setCommand(solver.getRightCommand());
            path.append(" R ");
        }
        else {
            solver.setState(new frontOpenState(solver, navigator, path));
        }
        progress();
    }
    
}