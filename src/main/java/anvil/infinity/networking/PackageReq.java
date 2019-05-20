package anvil.infinity.networking;

import anvil.infinity.helpers.LookAbilityHelper;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PackageReq implements IMessage {

    int id;

    public PackageReq() {
        id = LookAbilityHelper.KILL;
    }

    public PackageReq(int abilityID) {
        id = abilityID;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        id = Integer.parseInt(ByteBufUtils.readUTF8String(buf));

    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf, "" + id);
    }
}
