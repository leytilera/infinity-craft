package anvil.infinity.networking;

import anvil.infinity.helpers.LookAbilityHelper;
import anvil.infinity.registry.Effects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class LookAbilityReturnPackageHandler implements IMessageHandler<PackageKillAbility, IMessage> {

    @Override
    public IMessage onMessage(PackageKillAbility message, MessageContext ctx) {
        LookAbilityHelper.activateEntityLookAbility(message.entity, message.abilityID);
        return null;
    }
}
