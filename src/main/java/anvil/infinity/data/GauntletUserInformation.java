package anvil.infinity.data;

import net.minecraft.entity.EntityLivingBase;

import java.util.ArrayList;
import java.util.List;

public class GauntletUserInformation {

    public static List<EntityData> gauntletUsers = new ArrayList<>();

    public static EntityData getDataByEntity(EntityLivingBase entity) {
        for (int i = 0; i < gauntletUsers.size(); i++) {
            if (gauntletUsers.get(i).entity.equals(entity)) {
                return gauntletUsers.get(i);
            }
        }
        EntityData data = new EntityData(entity);
        gauntletUsers.add(data);
        return data;
    }

}
