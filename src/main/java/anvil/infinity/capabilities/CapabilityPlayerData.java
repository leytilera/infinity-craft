package anvil.infinity.capabilities;

import anvil.infinity.snap.SnapResult;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class CapabilityPlayerData implements ICapabilityPlayerData {

    @CapabilityInject(ICapabilityPlayerData.class)
    public static final Capability<ICapabilityPlayerData> capability = null;

    public int xPos;
    public int yPos;
    public int zPos;
    public int dim;

    public SnapResult selectedSnapResult;

    public CapabilityPlayerData() {
        selectedSnapResult = SnapResult.KILLHALF;
    }

    @Override
    public int getXPos() {
        return xPos;
    }

    @Override
    public int getYPos() {
        return yPos;
    }

    @Override
    public int getZPos() {
        return zPos;
    }

    @Override
    public int getDim() {
        return dim;
    }

    @Override
    public void setXPos(int xPos) {
        this.xPos = xPos;
    }

    @Override
    public void setYPos(int yPos) {
        this.yPos = yPos;
    }

    @Override
    public void setZPos(int zPos) {
        this.zPos = zPos;
    }

    @Override
    public void setDim(int dim) {
        this.dim = dim;
    }

    @Override
    public SnapResult getSnapResult() {
        return selectedSnapResult;
    }

    @Override
    public void setSnapResult(SnapResult snapResult) {
        selectedSnapResult = snapResult;
    }


    @Override
    public void readNBT(NBTTagCompound tag) {
            setXPos(tag.getInteger("xPos"));
            setYPos(tag.getInteger("YPos"));
            setZPos(tag.getInteger("zPos"));
            setDim(tag.getInteger("dim"));
            setSnapResult(SnapResult.fromString(tag.getString("snapResult")));
    }

    @Override
    public NBTTagCompound writeNBT() {
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setInteger("xPos", getXPos());
        nbt.setInteger("yPos", getYPos());
        nbt.setInteger("zPos", getZPos());
        nbt.setInteger("dim", getDim());
        nbt.setString("snapResult", getSnapResult().toString());
        return nbt;
    }

}
