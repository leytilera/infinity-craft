package anvil.infinity.abilities;

import anvil.infinity.Infinity;
import anvil.infinity.conditions.ICondition;
import anvil.infinity.networking.PackageReq;
import io.netty.buffer.ByteBuf;
import lucraft.mods.lucraftcore.superpowers.abilities.AbilityAction;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class AbilityKill extends AbilityAction {

    ICondition condition;

    public AbilityKill(EntityLivingBase entity) {
        super(entity);
        condition = new ICondition<EntityLivingBase>() {
            @Override
            public boolean isFulfilled(EntityLivingBase information) {
                return true;
            }
        };
    }

    public AbilityKill(EntityLivingBase entity, ICondition condition) {
        super(entity);
        this.condition = condition;
    }

    @Override
    public boolean action() {
        if (condition.isFulfilled(entity) && entity instanceof EntityPlayerMP) {
            Infinity.NETWORK_WRAPPER.sendTo(new PackageReq(), (EntityPlayerMP) entity);
            return true;
        }
        return false;
    }



}
