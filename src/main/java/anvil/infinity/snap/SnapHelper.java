package anvil.infinity.snap;

import anvil.infinity.config.ConfigHandler;
import anvil.infinity.data.GauntletUserInformation;
import anvil.infinity.helpers.GauntelHelper;
import anvil.infinity.registry.Effects;
import lucraft.mods.lucraftcore.infinity.ModuleInfinity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerList;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.GameType;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;

import java.util.List;
import java.util.Random;

public class SnapHelper {

    static MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();

    public static boolean snap(EntityLivingBase entity) {
        if (GauntelHelper.hasFullGauntlet(entity)) {
            World w = entity.getEntityWorld();
            if (GauntletUserInformation.getDataByEntity(entity).selectedSnapResult == SnapResult.KILLHALF) {
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
            } else if (GauntletUserInformation.getDataByEntity(entity).selectedSnapResult == SnapResult.DESTROYSTONES) {
                entity.setHealth(1);
                ItemStack gauntlet;
                if (entity.getHeldItem(EnumHand.MAIN_HAND).getItem().equals(ModuleInfinity.INFINITY_GAUNTLET)) {
                    gauntlet = entity.getHeldItem(EnumHand.MAIN_HAND);
                } else {
                    gauntlet = entity.getHeldItem(EnumHand.OFF_HAND);
                }

            } else if (GauntletUserInformation.getDataByEntity(entity).selectedSnapResult == SnapResult.CREATIVE) {
                if (ConfigHandler.snapCreative) {
                    if (entity instanceof EntityPlayer) {
                        ((EntityPlayer) entity).setGameType(GameType.CREATIVE);
                        return true;
                    }
                }
            } else if (GauntletUserInformation.getDataByEntity(entity).selectedSnapResult == SnapResult.BRINGBACK) {

            } else if (GauntletUserInformation.getDataByEntity(entity).selectedSnapResult == SnapResult.RECREATE) {
                
            }
        }
        return false;
    }

}
