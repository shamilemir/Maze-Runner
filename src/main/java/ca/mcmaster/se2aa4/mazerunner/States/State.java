package ca.mcmaster.se2aa4.mazerunner.States;
import ca.mcmaster.se2aa4.mazerunner.Commands.*;
import ca.mcmaster.se2aa4.mazerunner.Navigator;
import ca.mcmaster.se2aa4.mazerunner.RightHandSolver;

public abstract class State {

    protected RightHandSolver solver;
    protected Navigator navigator;
    protected StringBuilder path;

    public State(RightHandSolver solver, Navigator navigator, StringBuilder path) {
        this.solver = solver;
        this.navigator = navigator;
        this.path = path;
    }

    public abstract void move();

    public void progress() {
        navigator.setCommand(solver.getForwardCommand());
        path.append("F");
    }
    
}