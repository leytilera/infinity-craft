package anvil.infinity.networking;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class SnapPackageHandler implements IMessageHandler<SnapPackage, IMessage> {

    @Override
    public IMessage onMessage(SnapPackage snapPackage, MessageContext messageContext) {
        World w = FMLCommonHandler.instance().getMinecraftServerInstance().getWorld(0);

        EntityLivingBase snapEntity = (EntityLivingBase) w.getEntityByID(snapPackage.entityID);



        return null;
    }

}
