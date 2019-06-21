package anvil.infinity.helpers;

import lucraft.mods.lucraftcore.infinity.EnumInfinityStone;
import lucraft.mods.lucraftcore.infinity.items.ItemInfinityStone;
import lucraft.mods.lucraftcore.superpowers.abilities.Ability;
import net.minecraft.entity.EntityLivingBase;

public class GauntelHelper {

    public static boolean hasPowerStone(EntityLivingBase entity) {
        return ItemInfinityStone.hasStone(entity, Ability.EnumAbilityContext.MAIN_HAND, EnumInfinityStone.POWER) || ItemInfinityStone.hasStone(entity, Ability.EnumAbilityContext.OFF_HAND, EnumInfinityStone.POWER);
    }

    public static boolean hasSpaceStone(EntityLivingBase entity) {
        return ItemInfinityStone.hasStone(entity, Ability.EnumAbilityContext.MAIN_HAND, EnumInfinityStone.SPACE) || ItemInfinityStone.hasStone(entity, Ability.EnumAbilityContext.OFF_HAND, EnumInfinityStone.SPACE);
    }

    public static boolean hasRealityStone(EntityLivingBase entity) {
        return ItemInfinityStone.hasStone(entity, Ability.EnumAbilityContext.MAIN_HAND, EnumInfinityStone.REALITY) || ItemInfinityStone.hasStone(entity, Ability.EnumAbilityContext.OFF_HAND, EnumInfinityStone.REALITY);
    }

    public static boolean hasSoulStone(EntityLivingBase entity) {
        return ItemInfinityStone.hasStone(entity, Ability.EnumAbilityContext.MAIN_HAND, EnumInfinityStone.SOUL) || ItemInfinityStone.hasStone(entity, Ability.EnumAbilityContext.OFF_HAND, EnumInfinityStone.SOUL);
    }

    public static boolean hasTimeStone(EntityLivingBase entity) {
        return ItemInfinityStone.hasStone(entity, Ability.EnumAbilityContext.MAIN_HAND, EnumInfinityStone.TIME) || ItemInfinityStone.hasStone(entity, Ability.EnumAbilityContext.OFF_HAND, EnumInfinityStone.TIME);
    }

    public static boolean hasMindStone(EntityLivingBase entity) {
        return ItemInfinityStone.hasStone(entity, Ability.EnumAbilityContext.MAIN_HAND, EnumInfinityStone.MIND) || ItemInfinityStone.hasStone(entity, Ability.EnumAbilityContext.OFF_HAND, EnumInfinityStone.MIND);
    }

    public static boolean hasFullGauntlet(EntityLivingBase entity) {
        return hasPowerStone(entity) && hasSpaceStone(entity) && hasRealityStone(entity) && hasSoulStone(entity) && hasTimeStone(entity) && hasMindStone(entity);
    }



}
