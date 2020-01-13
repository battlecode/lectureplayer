package lectureplayer;
import battlecode.common.*;

public class Communications {
    RobotController rc;

    // state related only to communications should go here

    // all messages from our team should start with this so we can tell them apart
    static final int teamSecret = 444444444;
    // the second entry in every message tells us what kind of message it is. e.g. 0 means it contains the HQ location
    static final String[] messageType = {
        "HQ loc",
        "design school created",
        "soup location",
    };

    public Communications(RobotController r) {
        rc = r;
    }

    public void sendHqLoc(MapLocation loc) throws GameActionException {
        int[] message = new int[7];
        message[0] = teamSecret;
        message[1] = 0;
        message[2] = loc.x; // x coord of HQ
        message[3] = loc.y; // y coord of HQ
        if (rc.canSubmitTransaction(message, 3))
            rc.submitTransaction(message, 3);
    }

    public MapLocation getHqLocFromBlockchain() throws GameActionException {
        for (int i = 1; i < rc.getRoundNum(); i++){
            for(Transaction tx : rc.getBlock(i)) {
                int[] mess = tx.getMessage();
                if(mess[0] == teamSecret && mess[1] == 0){
                    System.out.println("found the HQ!");
                    return new MapLocation(mess[2], mess[3]);
                }
            }
        }
        return null;
    }
}
