package anvil.infinity.data;

import anvil.infinity.snap.SnapResult;
import net.minecraft.entity.EntityLivingBase;

public class EntityData {

    public EntityLivingBase entity;
    public int xPos;
    public int yPos;
    public int zPos;
    public int dim;

    public SnapResult selectedSnapResult;

    public EntityData(EntityLivingBase entity) {
        this.entity = entity;
        selectedSnapResult = SnapResult.KILLHALF;
    }

}
