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
    public Ability getAbilityForcefield(EntityLivingBase entity) {
        return null;
    }

    @Override
    public Ability getAbilityPortal(EntityLivingBase entity) {
        return null;
    }

    @Override
    public Ability getAbilityBlackhole(EntityLivingBase entity) {
        return null;
    }

    @Override
    public boolean canLocate(EntityLivingBase entity) {
        return false;
    }
}
