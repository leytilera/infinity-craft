package anvil.infinity.config;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigHandler {

    public static Configuration config;
    public static boolean soulHealthBoost;
    public static boolean useSHRealityAbilities;
    public static boolean sizeChanging;
    public static float size;
    public static int soulWorldID;
    public static boolean snapCreative;
    public static boolean heAbilities;
    public static int powerCooldown;
    public static boolean stAbilities;

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
        String category = Configuration.CATEGORY_GENERAL;
        String colorcat = Configuration.CATEGORY_CLIENT;
        soulHealthBoost = config.getBoolean("Soul Stone health boost", category, true, "Should the Soul Stone have a health boost");
        useSHRealityAbilities = config.getBoolean("SH Reality Stone abilities", category, false, "Should the Reality Stone have the abilities of the Speedster Heroes Reality Stone if it is installed");
        sizeChanging = config.getBoolean("Size changing", category, true, "Should the Reality Stone be able to change the size");
        size = config.getFloat("Size", category, 0.1f, 0.1f,10, "Which size should the Reality Stone change it's user to");
        soulWorldID = config.getInt("Soul World ID", category, 10, -255, 255, "The ID of the Soul World Dimension");
        snapCreative = config.getBoolean("Can Snap change Gamemode", category, false, "Can the Snap change the Gamemode to Creative");
        heAbilities = config.getBoolean("HeroesExpansion Abilities", category, true, "Should some stones use abilities from HeroesExpansion");
        stAbilities = config.getBoolean("StarTech Abilities", category, true, "Should the Power Stone use the abilities from the StarTech Power Stone if installed");
        powerCooldown = config.getInt("Power Burst Cooldown", category, 100, 0, 1000, "How big long should the StarTech Power Stone burst cooldown be");

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

    }

}
