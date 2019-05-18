package anvil.infinity.snap;

import anvil.infinity.config.ConfigHandler;

public enum SnapResult {

    KILLHALF,
    DESTROYSTONES,
    BRINGBACK,
    RECREATE,
    CREATIVE;

    public SnapResult next() {
        switch(this) {
            case KILLHALF: return DESTROYSTONES;
            case DESTROYSTONES: return BRINGBACK;
            case BRINGBACK: return RECREATE;
            case RECREATE: if (ConfigHandler.snapCreative) {return CREATIVE;} else {return KILLHALF;}
            case CREATIVE: return KILLHALF;
        }
        return KILLHALF;
    }


    @Override
    public String toString() {
        switch (this) {
            case KILLHALF: return "Kill half";
            case DESTROYSTONES: return "Destroy the Stones";
            case BRINGBACK: return "Bring back the dusted (WIP)";
            case RECREATE: return "Recreate the Universe (WIP)";
            case CREATIVE: return "Change to Creative";
        }
        return "Kill half";
    }
}
