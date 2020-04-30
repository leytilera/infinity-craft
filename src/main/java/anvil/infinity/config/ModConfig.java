package anvil.infinity.config;

import anvil.infinity.Infinity;
import net.minecraftforge.common.config.Config;

@Config(modid = Infinity.MOD_ID)
public class ModConfig {

    @Config(modid = Infinity.MOD_ID, category = "general")
    public static class General {

        @Config.Name("Soul Stone health boost")
        @Config.Comment("Should the Soul Stone have a health boost")
        public static boolean soulHealthBoost = true;

        @Config.Name("SH Reality Stone abilities")
        @Config.Comment("Should the Reality Stone have the abilities of the Speedster Heroes Reality Stone if it is installed")
        public static boolean useSHRealityAbilities = false;

        @Config.Name("Size changing")
        @Config.Comment("Should the Reality Stone be able to change the size")
        public static boolean sizeChanging = false;

        @Config.Name("Size")
        @Config.Comment("Which size should the Reality Stone change it's user to")
        @Config.RangeDouble(min = 0.1f, max = 10)
        public static float size = 0.1f;


        public static int soulWorldID;

        @Config.Name("Can Snap change Gamemode")
        @Config.Comment("Can the Snap change the Gamemode to Creative")
        public static boolean snapCreative = false;

        @Config.Name("HeroesExpansion Abilities")
        @Config.Comment("Should some stones use abilities from HeroesExpansion")
        public static boolean heAbilities = true;

        @Config.Name("StarTech Abilities")
        @Config.Comment("Should the Power Stone use the abilities from the StarTech Power Stone if installed")
        public static boolean stAbilities = true;


        @Config.Name("Power Burst Cooldown")
        @Config.Comment("How big long should the StarTech Power Stone burst cooldown be")
        @Config.RangeInt(min = 0, max = 1000)
        public static int powerCooldown = 100;
    }

    @Config(category = "worldgen", modid = Infinity.MOD_ID)
    public static class Worldgen {

        @Config.Name("Enable Stone worldgen")
        public static boolean enable = true;

        @Config.Name("Power Stone Dimension")
        public static int powerDim = 0;

        @Config.Name("Space Stone Dimension")
        public static int spaceDim = 0;

        @Config.Name("Reality Stone Dimension")
        public static int realityDim = 0;

        @Config.Name("Soul Stone Dimension")
        public static int soulDim = 0;

        @Config.Name("Time Stone Dimension")
        public static int timeDim = 0;

        @Config.Name("Mind Stone Dimension")
        public static int mindDim = 0;

        @Config.Name("Worldgen Debug")
        @Config.Comment("WARNING: Console Spam")
        public static boolean debug = false;

    }

}
