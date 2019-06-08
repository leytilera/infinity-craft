package anvil.infinity.snap;

import anvil.infinity.config.ConfigHandler;

public enum SnapResult {

    KILLHALF,
    DESTROYSTONES,
    BRINGBACK,
    RECREATE,
    KILLEVIL,
    CREATIVE;

    final static String KILLHALFID = "Kill half";
    final static String DESTROYSTONESID = "Destroy the Stones";
    final static String BRINGBACKID = "Bring back the dusted (WIP)";
    final static String RECREATEID = "Recreate the Universe (WIP)";
    final static String KILLEVILID = "Kill evil entities";
    final static String CREATIVEID = "Change to Creative";

    public SnapResult next() {
        switch(this) {
            case KILLHALF: return DESTROYSTONES;
            case DESTROYSTONES: return BRINGBACK;
            case BRINGBACK: return RECREATE;
            case RECREATE: return KILLEVIL;
            case KILLEVIL: if (ConfigHandler.snapCreative) {return CREATIVE;} else {return KILLHALF;}
            case CREATIVE: return KILLHALF;
        }
        return KILLHALF;
    }


    @Override
    public String toString() {
        switch (this) {
            case KILLHALF: return KILLHALFID;
            case DESTROYSTONES: return DESTROYSTONESID;
            case BRINGBACK: return BRINGBACKID;
            case RECREATE: return RECREATEID;
            case KILLEVIL: return KILLEVILID;
            case CREATIVE: return CREATIVEID;
        }
        return "Kill half";
    }

    public static SnapResult fromString(String s) {
        switch (s) {
            case KILLHALFID: return KILLHALF;
            case DESTROYSTONESID: return DESTROYSTONES;
            case BRINGBACKID: return BRINGBACK;
            case RECREATEID: return RECREATE;
            case KILLEVILID: return KILLEVIL;
            case CREATIVEID: return CREATIVE;
        }
        return KILLHALF;
    }

}
