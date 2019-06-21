package anvil.infinity.compat;

import lucraft.mods.lucraftcore.superpowers.abilities.Ability;
import net.minecraft.entity.EntityLivingBase;

public interface HEProxy {

    Ability getAbilityGrabEntity(EntityLivingBase entity);

}
