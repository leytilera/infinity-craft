package anvil.infinity.compat;

import com.nic.st.power.*;
import lucraft.mods.lucraftcore.superpowers.abilities.Ability;
import net.minecraft.entity.EntityLivingBase;

public class STLoadedProxy implements STProxy {

    @Override
    public Ability getAbilityPowerBlast(EntityLivingBase entity) {
        return new AbilityPowerBlast(entity);
    }

    @Override
    public Ability getAbilityPowerImpower(EntityLivingBase entity) {
        return new AbilityPowerImpower(entity);
    }

    @Override
    public Ability getAbilityPowerRocketBurst(EntityLivingBase entity) {
        return new AbilityRocketBurst(entity);
    }

    @Override
    public Ability getAbilityTendrils(EntityLivingBase entity) {
        return new AbilityTendrils(entity);
    }

    @Override
    public Ability getAbilityCyclone(EntityLivingBase entity) {
        return new AbilityPowerCyclone(entity);
    }

    @Override
    public Ability getAbilityBurnout(EntityLivingBase entity) {
        return new AbilityGiveBurnout(entity);
    }
}
