package anvil.infinity.compat;

import anvil.infinity.abilities.*;
import lucraft.mods.lucraftcore.superpowers.abilities.Ability;
import net.minecraft.entity.EntityLivingBase;

public class HENotLoadedProxy implements HEProxy {

    @Override
    public Ability getAbilityGrabEntity(EntityLivingBase entity) {
        return null;
    }

    @Override
    public boolean hasFullGauntlet(EntityLivingBase entity) {
        return Ability.hasAbility(entity, AbilityHasPowerStone.class) && Ability.hasAbility(entity, AbilityHasRealityStone.class) && Ability.hasAbility(entity, AbilityHasSoulStone.class) && Ability.hasAbility(entity, AbilityHasTimeStone.class) && Ability.hasAbility(entity, AbilityHasMindStone.class);
    }
}
