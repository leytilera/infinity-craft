package anvil.infinity.abilities;

import anvil.infinity.items.Items;
import lucraft.mods.lucraftcore.superpowers.abilities.AbilityToggle;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class AbilityStopTime extends AbilityToggle {

    World w;

    public AbilityStopTime(EntityLivingBase entity) {
        super(entity);
        w = entity.getEntityWorld();
    }

    @Override
    public void updateTick() {
        long time = w.getWorldTime();
        w.setWorldTime(time - 1);

    }

    @SideOnly(Side.CLIENT)
    @Override
    public void drawIcon(Minecraft mc, Gui gui, int x, int y) {
        float zLevel = Minecraft.getMinecraft().getRenderItem().zLevel;
        mc.getRenderItem().zLevel = -100.5F;
        GlStateManager.pushMatrix();
        GlStateManager.translate(x, y, 0);
        mc.getRenderItem().renderItemIntoGUI(new ItemStack(Items.TIME_STONE), 0, 0);
        GlStateManager.popMatrix();
        mc.getRenderItem().zLevel = zLevel;
    }
}
