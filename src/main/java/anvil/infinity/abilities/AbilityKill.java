package anvil.infinity.abilities;

import anvil.infinity.Infinity;
import anvil.infinity.conditions.ICondition;
import anvil.infinity.items.Items;
import anvil.infinity.networking.PackageReq;
import io.netty.buffer.ByteBuf;
import lucraft.mods.lucraftcore.superpowers.abilities.AbilityAction;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class AbilityKill extends AbilityAction {

    ICondition condition;

    public AbilityKill(EntityLivingBase entity) {
        super(entity);
        condition = new ICondition<EntityLivingBase>() {
            @Override
            public boolean isFulfilled(EntityLivingBase information) {
                return true;
            }
        };
    }

    public AbilityKill(EntityLivingBase entity, ICondition condition) {
        super(entity);
        this.condition = condition;
    }

    @Override
    public boolean action() {
        if (condition.isFulfilled(entity) && entity instanceof EntityPlayerMP) {
            Infinity.NETWORK_WRAPPER.sendTo(new PackageReq(), (EntityPlayerMP) entity);
            return true;
        }
        return false;
    }


    @SideOnly(Side.CLIENT)
    @Override
    public void drawIcon(Minecraft mc, Gui gui, int x, int y) {
        float zLevel = Minecraft.getMinecraft().getRenderItem().zLevel;
        mc.getRenderItem().zLevel = -100.5F;
        GlStateManager.pushMatrix();
        GlStateManager.translate(x, y, 0);
        mc.getRenderItem().renderItemIntoGUI(new ItemStack(Items.SOUL_STONE), 0, 0);
        GlStateManager.popMatrix();
        mc.getRenderItem().zLevel = zLevel;
    }



}
