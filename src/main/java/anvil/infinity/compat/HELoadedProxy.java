package anvil.infinity.compat;

import anvil.infinity.abilities.*;
import lucraft.mods.heroesexpansion.abilities.AbilityGrabEntity;
import lucraft.mods.heroesexpansion.abilities.AbilityPortal;
import lucraft.mods.lucraftcore.superpowers.abilities.Ability;
import net.minecraft.entity.EntityLivingBase;

public class HELoadedProxy implements HEProxy {

    @Override
    public Ability getAbilityGrabEntity(EntityLivingBase entity) {
        return new AbilityGrabEntity(entity);
    }

    @Override
    public boolean hasFullGauntlet(EntityLivingBase entity) {
        return Ability.hasAbility(entity, AbilityPortal.class) && Ability.hasAbility(entity, AbilityHasPowerStone.class) && Ability.hasAbility(entity, AbilityHasRealityStone.class) && Ability.hasAbility(entity, AbilityHasSoulStone.class) && Ability.hasAbility(entity, AbilityHasTimeStone.class) && Ability.hasAbility(entity, AbilityHasMindStone.class);
    }
}
