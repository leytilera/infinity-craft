package anvil.infinity.compat;

import lucraft.mods.lucraftcore.superpowers.abilities.Ability;
import net.minecraft.entity.EntityLivingBase;

public class STNotLoadedProxy implements STProxy {

    @Override
    public Ability getAbilityPowerBlast(EntityLivingBase entity) {
        return null;
    }

    @Override
    public Ability getAbilityPowerImpower(EntityLivingBase entity) {
        return null;
    }

    @Override
    public Ability getAbilityPowerRocketBurst(EntityLivingBase entity) {
        return null;
    }

    @Override
    public Ability getAbilityTendrils(EntityLivingBase entity) {
        return null;
    }

    @Override
    public Ability getAbilityCyclone(EntityLivingBase entity) {
        return null;
    }

    @Override
    public Ability getAbilityBurnout(EntityLivingBase entity) {
        return null;
    }
}
