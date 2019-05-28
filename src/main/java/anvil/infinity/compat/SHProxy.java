package anvil.infinity.compat;

import lucraft.mods.lucraftcore.superpowers.abilities.Ability;
import net.minecraft.entity.EntityLivingBase;

public interface SHProxy {

    Ability getAbilitySaveBlock(EntityLivingBase entity);

    Ability getAbilityChangeBlock(EntityLivingBase entity);

    Ability getAbilityTurnIntoBubbles(EntityLivingBase entity);

    boolean hasRealityStone(EntityLivingBase entity);

}
