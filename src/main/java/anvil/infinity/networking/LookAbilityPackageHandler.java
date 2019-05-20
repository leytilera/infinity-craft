package anvil.infinity.networking;

import anvil.infinity.Infinity;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class LookAbilityPackageHandler implements IMessageHandler<PackageReq, IMessage> {

    @Override
    public IMessage onMessage(PackageReq message, MessageContext ctx) {
        RayTraceResult result = Minecraft.getMinecraft().objectMouseOver;
        if (result.typeOfHit == RayTraceResult.Type.ENTITY) {
            PackageKillAbility pack = new PackageKillAbility();
            pack.entity = result.entityHit;
            pack.abilityID = message.id;
            Infinity.NETWORK_WRAPPER.sendToServer(pack);
        }

        return null;
    }
}
