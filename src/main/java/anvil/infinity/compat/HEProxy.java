package anvil.infinity.compat;

import lucraft.mods.lucraftcore.superpowers.abilities.Ability;
import net.minecraft.entity.EntityLivingBase;

public interface HEProxy {

    Ability getAbilityGrabEntity(EntityLivingBase entity);

    Ability getAbilityPortal(EntityLivingBase entity);

    Ability getAbilityForcefield(EntityLivingBase entity);

    Ability getAbilityBlackhole(EntityLivingBase entity);

}
