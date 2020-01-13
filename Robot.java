package lectureplayer;
import battlecode.common.*;

public class Robot {
    RobotController rc;

    public Robot(RobotController r) {
        rc = r;
    }

    public void takeTurn() {
        System.out.println("I'm a robot");
    }
}