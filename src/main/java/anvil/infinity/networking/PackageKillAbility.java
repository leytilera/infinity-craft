package anvil.infinity.networking;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PackageKillAbility implements IMessage {

    Entity entity;
    public int abilityID;

    public PackageKillAbility(Entity entity) {
        super();
        this.entity = entity;
    }

    public PackageKillAbility() {
        super();
    }


    @Override
    public void fromBytes(ByteBuf buf) {

        String input = ByteBufUtils.readUTF8String(buf);
        String[] inputs = input.split(":");
        int dim = Integer.parseInt(inputs[0]);
        int id = Integer.parseInt(inputs[1]);
        abilityID = Integer.parseInt(inputs[2]);
        World world = FMLCommonHandler.instance().getMinecraftServerInstance().getWorld(dim);
        entity = world.getEntityByID(id);

    }

    @Override
    public void toBytes(ByteBuf buf) {

        ByteBufUtils.writeUTF8String(buf, entity.dimension + ":" + entity.getEntityId() + ":" + abilityID);

    }
}
