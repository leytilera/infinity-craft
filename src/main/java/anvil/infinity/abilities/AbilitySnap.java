package anvil.infinity.abilities;

import anvil.infinity.compat.CompatHandler;
import anvil.infinity.registry.Effects;
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

    MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();


    public AbilitySnap(EntityLivingBase entity) {
        super(entity);
    }

    @Override
    public boolean action() {
        if (CompatHandler.HeroesExpension.hasFullGauntlet(entity)) {
            World w = entity.getEntityWorld();
                List<Entity> entities = w.loadedEntityList;
                boolean kill = false;

                PlayerList players = server.getPlayerList();

                TextComponentString msg = new TextComponentString(entity.getName() + ": ");
                msg.appendSibling(new TextComponentTranslation("infinity.snap.text"));
                msg.getStyle().setColor(TextFormatting.DARK_PURPLE);
                msg.getStyle().setBold(true);
                players.sendMessage(msg);
                Random random = new Random();


                for (int i = 0; i < entities.size(); i++) {
                    if (entities.get(i) != entity && entities.get(i) instanceof EntityLivingBase && kill && !(entities.get(i) instanceof EntityRabbit)) {
                        EntityLivingBase e = ((EntityLivingBase) entities.get(i));
                        e.addPotionEffect(new PotionEffect(Effects.snapEffect, random.nextInt((1200 - 10) + 1) - 10));
                    }
                    kill = !kill;
                }
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
        mc.getRenderItem().renderItemIntoGUI(new ItemStack(ModuleInfinity.INFINITY_GAUNTLET), 0, 0);
        GlStateManager.popMatrix();
        mc.getRenderItem().zLevel = zLevel;
    }

}
