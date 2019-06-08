package anvil.infinity.capabilities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

import java.util.ArrayList;
import java.util.List;

public class GauntletUserInformation {

    public static ICapabilityPlayerData getDataByEntity(EntityLivingBase entity) {
        if (entity instanceof EntityPlayer && entity.hasCapability(CapabilityPlayerData.capability, null)) {
            return entity.getCapability(CapabilityPlayerData.capability, null);
        }
        return new CapabilityPlayerData();
    }

}
