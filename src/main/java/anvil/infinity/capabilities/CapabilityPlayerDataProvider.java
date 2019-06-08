package anvil.infinity.capabilities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class CapabilityPlayerDataProvider implements ICapabilitySerializable<NBTTagCompound> {

    ICapabilityPlayerData instance;

    public CapabilityPlayerDataProvider(ICapabilityPlayerData instance) {
        this.instance = instance;
    }

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == CapabilityPlayerData.capability;
    }

    @Nullable
    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
        return capability == CapabilityPlayerData.capability ? CapabilityPlayerData.capability.<T>cast(instance) : null;
    }

    @Override
    public NBTTagCompound serializeNBT() {
        return (NBTTagCompound) CapabilityPlayerData.capability.getStorage().writeNBT(CapabilityPlayerData.capability, instance, null);
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt) {
        CapabilityPlayerData.capability.getStorage().readNBT(CapabilityPlayerData.capability, instance, null, nbt);
    }
}
