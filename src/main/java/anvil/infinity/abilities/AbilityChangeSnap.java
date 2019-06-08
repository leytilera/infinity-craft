package anvil.infinity.abilities;

import anvil.infinity.capabilities.GauntletUserInformation;
import anvil.infinity.capabilities.ICapabilityPlayerData;
import anvil.infinity.items.Items;
import lucraft.mods.lucraftcore.superpowers.abilities.AbilityAction;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class AbilityChangeSnap extends AbilityAction {

    public AbilityChangeSnap(EntityLivingBase entity) {
        super(entity);
    }

    @Override
    public boolean action() {
        ICapabilityPlayerData data = GauntletUserInformation.getDataByEntity(entity);
        data.setSnapResult(data.getSnapResult().next());
        if (entity instanceof EntityPlayer) {
            ((EntityPlayer) entity).sendStatusMessage(new TextComponentString("Selected ability is: " + data.getSnapResult()),true);
        }
        return true;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void drawIcon(Minecraft mc, Gui gui, int x, int y) {
        float zLevel = Minecraft.getMinecraft().getRenderItem().zLevel;
        mc.getRenderItem().zLevel = -100.5F;
        GlStateManager.pushMatrix();
        GlStateManager.translate(x, y, 0);
        mc.getRenderItem().renderItemIntoGUI(new ItemStack(Items.MIND_STONE), 0, 0);
        GlStateManager.popMatrix();
        mc.getRenderItem().zLevel = zLevel;
    }

}
