package anvil.infinity.compat;

import lucraft.mods.lucraftcore.superpowers.abilities.Ability;
import net.minecraft.entity.EntityLivingBase;

public interface STProxy {

    Ability getAbilityPowerBlast(EntityLivingBase entity);

    Ability getAbilityPowerImpower(EntityLivingBase entity);

    Ability getAbilityPowerRocketBurst(EntityLivingBase entity);

    Ability getAbilityTendrils(EntityLivingBase entity);

    Ability getAbilityCyclone(EntityLivingBase entity);

    Ability getAbilityBurnout(EntityLivingBase entity);

}
