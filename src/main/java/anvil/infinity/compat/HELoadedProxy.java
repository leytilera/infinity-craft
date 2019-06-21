package anvil.infinity.compat;

import lucraft.mods.heroesexpansion.abilities.AbilityBlackHole;
import lucraft.mods.heroesexpansion.abilities.AbilityForceField;
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
    public Ability getAbilityPortal(EntityLivingBase entity) {
        return new AbilityPortal(entity);
    }

    @Override
    public Ability getAbilityForcefield(EntityLivingBase entity) {
        return new AbilityForceField(entity);
    }

    @Override
    public Ability getAbilityBlackhole(EntityLivingBase entity) {
        return new AbilityBlackHole(entity);
    }
}
