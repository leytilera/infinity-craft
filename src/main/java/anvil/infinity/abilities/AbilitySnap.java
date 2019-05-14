package anvil.infinity.abilities;

import anvil.infinity.compat.CompatHandler;
import anvil.infinity.data.GauntletUserInformation;
import anvil.infinity.helpers.GauntelHelper;
import anvil.infinity.registry.Effects;
import anvil.infinity.snap.SnapHelper;
import anvil.infinity.snap.SnapResult;
import lucraft.mods.lucraftcore.infinity.ModuleInfinity;
import lucraft.mods.lucraftcore.superpowers.abilities.AbilityAction;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerList;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

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
