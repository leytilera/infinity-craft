package anvil.infinity.helpers;

import anvil.infinity.abilities.*;
import anvil.infinity.compat.CompatHandler;
import lucraft.mods.lucraftcore.superpowers.abilities.Ability;
import net.minecraft.entity.EntityLivingBase;

public class GauntelHelper {

    public static boolean hasPowerStone(EntityLivingBase entity) {
        return Ability.hasAbility(entity, AbilityHasPowerStone.class);
    }

    public static boolean hasSpaceStone(EntityLivingBase entity) {
        return CompatHandler.HeroesExpension.hasSpaceStone(entity);
    }

    public static boolean hasRealityStone(EntityLivingBase entity) {
        if (CompatHandler.isSpeedsterHeroes) {
            return CompatHandler.SpeedsterHeroes.hasRealityStone(entity);
        }
        return Ability.hasAbility(entity, AbilityHasRealityStone.class);
    }

    public static boolean hasSoulStone(EntityLivingBase entity) {
        return Ability.hasAbility(entity, AbilityHasSoulStone.class);
    }

    public static boolean hasTimeStone(EntityLivingBase entity) {
        return Ability.hasAbility(entity, AbilityHasTimeStone.class);
    }

    public static boolean hasMindStone(EntityLivingBase entity) {
        return Ability.hasAbility(entity, AbilityHasMindStone.class);
    }

    public static boolean hasFullGauntlet(EntityLivingBase entity) {
        return hasPowerStone(entity) && hasSpaceStone(entity) && hasRealityStone(entity) && hasSoulStone(entity) && hasTimeStone(entity) && hasMindStone(entity);
    }



}
