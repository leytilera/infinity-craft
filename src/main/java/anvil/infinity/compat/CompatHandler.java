package anvil.infinity.compat;

import net.minecraftforge.fml.common.Loader;

public class CompatHandler {
    public static boolean isHeroesExpansion;
    public static boolean isSpeedsterHeroes;
    public static boolean isStarTech;

    public static HEProxy HeroesExpension;
    public static SHProxy SpeedsterHeroes;
    public static STProxy StarTech;

    public static void check() {
        isHeroesExpansion = Loader.isModLoaded("heroesexpansion");
        isSpeedsterHeroes = Loader.isModLoaded("speedsterheroes");
        isStarTech = Loader.isModLoaded("star-tech");

        if (isHeroesExpansion) {
            HeroesExpension = new HELoadedProxy();
        } else {
            HeroesExpension = new HENotLoadedProxy();
        }

        if (isSpeedsterHeroes) {
            SpeedsterHeroes = new SHLoadedProxy();
        } else {
            SpeedsterHeroes = new SHNotLoadedProxy();
        }

        if (isStarTech) {
            StarTech = new STLoadedProxy();
        } else {
            StarTech = new STNotLoadedProxy();
        }

    }
}
