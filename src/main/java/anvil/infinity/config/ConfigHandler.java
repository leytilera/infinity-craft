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
        soulHealthBoost = config.getBoolean("Soul Stone health boost", category, true, "Should the Soul Stone have a health boost");
        useSHRealityAbilities = config.getBoolean("SH Reality Stone abilities", category, false, "Should the Reality Stone have the abilities of the Speedster Heroes Reality Stone if it is installed");
        sizeChanging = config.getBoolean("Size changing", category, true, "Should the Reality Stone be able to change the size");
        size = config.getFloat("Size", category, 0.1f, 0.1f,10, "Which size should the Reality Stone change it's user to");
        soulWorldID = config.getInt("Soul World ID", category, 10, -255, 255, "The ID of the Soul World Dimension");
        snapCreative = config.getBoolean("Can Snap change Gamemode", category, false, "Can the Snap change the Gamemode to Creative");
        heAbilities = config.getBoolean("HeroesExpansion Abilities", category, true, "Should some stones use abilities from HeroesExpansion");
    }

}
