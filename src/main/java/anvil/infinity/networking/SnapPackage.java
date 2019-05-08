package anvil.infinity.networking;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class SnapPackage implements IMessage {

    int entityID;

    public SnapPackage(int entityID) {
        this.entityID = entityID;
    }

    @Override
    public void fromBytes(ByteBuf byteBuf) {
        entityID = byteBuf.readInt();
    }

    @Override
    public void toBytes(ByteBuf byteBuf) {
        byteBuf.writeInt(entityID);
    }
}
