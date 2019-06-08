package anvil.infinity.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;
import java.util.List;

public class Storage implements Capability.IStorage<ICapabilityPlayerData> {

    @Nullable
    @Override
    public NBTBase writeNBT(Capability<ICapabilityPlayerData> capability, ICapabilityPlayerData instance, EnumFacing side) {
       return instance.writeNBT();
    }

    @Override
    public void readNBT(Capability<ICapabilityPlayerData> capability, ICapabilityPlayerData instance, EnumFacing side, NBTBase nbt) {

        if (nbt instanceof NBTTagCompound) {
            instance.readNBT((NBTTagCompound) nbt);
        }

    }
}
