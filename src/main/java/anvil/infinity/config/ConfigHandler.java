package anvil.infinity.config;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigHandler {

    public static Configuration config;

    public static int powerStoneColor;
    public static int powerStoneShine;
    public static int realityStoneColor;
    public static int realityStoneShine;
    public static int timeStoneColor;
    public static int timeStoneShine;
    public static int mindStoneColor;
    public static int mindStoneShine;
    public static int soulStoneColor;
    public static int soulStoneShine;
    public static int spaceStoneColor;
    public static int spaceStoneShine;

    public static void refreshConfig(File file) {
        config = new Configuration(file);
        config.load();
        syncConfig();
        if (config.hasChanged()) {
            config.save();
        }
    }

    private static void syncConfig() {
        String colorcat = Configuration.CATEGORY_CLIENT;
        powerStoneColor = config.getInt("Power Stone color", colorcat, 0xC32AD1, 0x000000, 0xFFFFFF, "Color of the Power Stone");
        powerStoneShine = config.getInt("Power Stone shine", colorcat, 0xF12AFF, 0x000000, 0xFFFFFF, "Shine color of the Power Stone");
        realityStoneColor = config.getInt("Reality Stone color", colorcat, 0xFF0130, 0x000000, 0xFFFFFF, "Color of the Reality Stone");
        realityStoneShine = config.getInt("Reality Stone shine", colorcat, 0xFF0130, 0x000000, 0xFFFFFF, "Shine color of the Reality Stone");
        timeStoneColor = config.getInt("Time Stone color", colorcat, 0x13CF55, 0x000000, 0xFFFFFF, "Color of the Time Stone");
        timeStoneShine = config.getInt("Time Stone shine", colorcat, 0x12E772, 0x000000, 0xFFFFFF, "Shine color of the Time Stone");
        mindStoneColor = config.getInt("Mind Stone color", colorcat, 0xFFD300, 0x000000, 0xFFFFFF, "Color of the Mind Stone");
        mindStoneShine = config.getInt("Mind Stone shine", colorcat, 0xDAFF0A, 0x000000, 0xFFFFFF, "Shine color of the Mind Stone");
        soulStoneColor = config.getInt("Soul Stone color", colorcat, 0xDE7300, 0x000000, 0xFFFFFF, "Color of the Soul Stone");
        soulStoneShine = config.getInt("Soul Stone shine", colorcat, 0xFF8B00, 0x000000, 0xFFFFFF, "Shine color of the Soul Stone");
        spaceStoneColor = config.getInt("Space Stone color", colorcat, 0x0255ff, 0x000000, 0xFFFFFF, "Color of the Space Stone");
        spaceStoneShine = config.getInt("Space Stone shine", colorcat, 0x6ac5ff, 0x000000, 0xFFFFFF, "Shine color of the Space Stone");

    }

}
