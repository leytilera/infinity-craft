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
    public boolean hasSpaceStone(EntityLivingBase entity) {
        return true;
    }
}
