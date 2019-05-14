package anvil.infinity.abilities;

import lucraft.mods.lucraftcore.superpowers.abilities.AbilityConstant;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

public class AbilitySaturation extends AbilityConstant {

    public AbilitySaturation(EntityLivingBase entity) {
        super(entity);
    }

    @Override
    public void updateTick() {
        if (entity instanceof EntityPlayer) {
            ((EntityPlayer) entity).getFoodStats().setFoodLevel(20);
        }
    }

}
