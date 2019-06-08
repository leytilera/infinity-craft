package anvil.infinity.abilities;

import anvil.infinity.snap.SnapHelper;
import lucraft.mods.lucraftcore.infinity.ModuleInfinity;
import lucraft.mods.lucraftcore.superpowers.abilities.AbilityAction;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class AbilitySnap extends AbilityAction {




    public AbilitySnap(EntityLivingBase entity) {
        super(entity);
    }

    @Override
    public boolean action() {
        return SnapHelper.snap(entity);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void drawIcon(Minecraft mc, Gui gui, int x, int y) {
        float zLevel = Minecraft.getMinecraft().getRenderItem().zLevel;
        mc.getRenderItem().zLevel = -100.5F;
        GlStateManager.pushMatrix();
        GlStateManager.translate(x, y, 0);
        mc.getRenderItem().renderItemIntoGUI(new ItemStack(ModuleInfinity.INFINITY_GAUNTLET), 0, 0);
        GlStateManager.popMatrix();
        mc.getRenderItem().zLevel = zLevel;
    }

}
