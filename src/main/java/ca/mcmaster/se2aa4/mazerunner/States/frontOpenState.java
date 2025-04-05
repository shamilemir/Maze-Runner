package ca.mcmaster.se2aa4.mazerunner.States;
import ca.mcmaster.se2aa4.mazerunner.Commands.*;
import ca.mcmaster.se2aa4.mazerunner.Navigator;
import ca.mcmaster.se2aa4.mazerunner.RightHandSolver;

public class frontOpenState extends State {

    public frontOpenState(RightHandSolver solver, Navigator navigator, StringBuilder path) {
        super(solver, navigator, path);
    }

    @Override
    public void move() {
        if (navigator.frontSpaceOpen()){
            solver.setState(new rightOpenState(solver, navigator, path));
        }
        else {
            solver.setState(new leftOpenState(solver, navigator, path));
        }
        progress();
    }
    
}