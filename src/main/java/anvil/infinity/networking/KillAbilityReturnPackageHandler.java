package anvil.infinity.networking;

import anvil.infinity.registry.Effects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class KillAbilityReturnPackageHandler implements IMessageHandler<PackageKillAbility, IMessage> {

    @Override
    public IMessage onMessage(PackageKillAbility message, MessageContext ctx) {
        Entity e = message.entity;
        if (e instanceof EntityLivingBase) {
            ((EntityLivingBase) e).addPotionEffect(new PotionEffect(Effects.snapEffect, 1));
        }
        return null;
    }
}
