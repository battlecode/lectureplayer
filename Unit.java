package lectureplayer;
import battlecode.common.*;

public class Unit extends Robot {
    
    MapLocation hqLoc;

    public Unit(RobotController r) {
        super(r);
    }

    public void takeTurn() throws GameActionException {
        super.takeTurn();
        
        System.out.println("I'm a Unit");
    }

    public void findHQ() throws GameActionException {
        if (hqLoc == null) {
            // search surroundings for HQ
            RobotInfo[] robots = rc.senseNearbyRobots();
            for (RobotInfo robot : robots) {
                if (robot.type == RobotType.HQ && robot.team == rc.getTeam()) {
                    hqLoc = robot.location;
                }
            }
            if(hqLoc == null) {
                // if still null, search the blockchain
                hqLoc = comms.getHqLocFromBlockchain();
            }
        }
    }
}