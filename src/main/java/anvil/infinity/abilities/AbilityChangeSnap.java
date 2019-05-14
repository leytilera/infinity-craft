package anvil.infinity.abilities;

import anvil.infinity.data.EntityData;
import anvil.infinity.data.GauntletUserInformation;
import lucraft.mods.lucraftcore.superpowers.abilities.AbilityAction;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;

public class AbilityChangeSnap extends AbilityAction {

    public AbilityChangeSnap(EntityLivingBase entity) {
        super(entity);
    }

    @Override
    public boolean action() {
        EntityData data = GauntletUserInformation.getDataByEntity(entity);
        data.selectedSnapResult = data.selectedSnapResult.next();
        if (entity instanceof EntityPlayer) {
            ((EntityPlayer) entity).sendStatusMessage(new TextComponentString("Selected ability is: " + data.selectedSnapResult),true);
        }
        return true;
    }

}
