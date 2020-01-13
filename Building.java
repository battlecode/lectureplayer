package lectureplayer;
import battlecode.common.*;

public class Building extends Robot {

    public Building(RobotController r) {
        super(r);
    }

    public void takeTurn() {
        super.takeTurn();

        System.out.println("I'm a building");
    }
}