package anvil.infinity.compat;

import anvil.infinity.abilities.AbilityHasRealityStone;
import lucraft.mods.lucraftcore.superpowers.abilities.Ability;
import net.minecraft.entity.EntityLivingBase;

public class SHNotLoadedProxy implements SHProxy {

    @Override
    public Ability getAbilitySaveBlock(EntityLivingBase entity) {
        return null;
    }

    @Override
    public Ability getAbilityChangeBlock(EntityLivingBase entity) {
        return null;
    }

    @Override
    public Ability getAbilityTurnIntoBubbles(EntityLivingBase entity) {
        return null;
    }


    @Override
    public boolean hasRealityStone(EntityLivingBase entity) {
        return Ability.hasAbility(entity, AbilityHasRealityStone.class);
    }
}
