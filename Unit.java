package lectureplayer;
import battlecode.common.*;

public class Unit extends Robot {

    public Unit(RobotController r) {
        super(r);
    }

    public void takeTurn() {
        super.takeTurn();
        
        System.out.println("I'm a Unit");
    }
}