package anvil.infinity.helpers;

import anvil.infinity.registry.Effects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;

public class LookAbilityHelper {
    public static final int KILL = 0;

    public static void activateEntityLookAbility(Entity entity, int abilityID) {
        switch (abilityID) {
            case KILL: if (entity instanceof EntityLivingBase) {
                ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Effects.snapEffect, 1));
            } break;
        }
    }



}
