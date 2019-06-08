package anvil.infinity.capabilities;

import anvil.infinity.snap.SnapResult;
import net.minecraft.nbt.NBTTagCompound;

public interface ICapabilityPlayerData {

    int getXPos();
    int getYPos();
    int getZPos();
    int getDim();

    void setXPos(int xPos);
    void setYPos(int yPos);
    void setZPos(int zPos);
    void setDim(int dim);

    SnapResult getSnapResult();
    void setSnapResult(SnapResult snapResult);

    void readNBT(NBTTagCompound nbt);
    NBTTagCompound writeNBT();

}
