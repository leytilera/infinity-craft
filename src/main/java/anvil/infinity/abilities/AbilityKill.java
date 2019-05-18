package anvil.infinity.abilities;

import anvil.infinity.conditions.ICondition;
import anvil.infinity.registry.Effects;
import lucraft.mods.lucraftcore.superpowers.abilities.AbilityAction;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;

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
        if (condition.isFulfilled(entity)) {
            if (FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER) {
                World w = FMLCommonHandler.instance().getMinecraftServerInstance().getEntityWorld();
                RayTraceResult result = Minecraft.getMinecraft().objectMouseOver;
                System.out.println(result.typeOfHit);
                if (result.typeOfHit == RayTraceResult.Type.ENTITY) {
                    Entity e = w.getEntityByID(result.entityHit.getEntityId());
                    if (e instanceof EntityLivingBase) {
                        ((EntityLivingBase) e).addPotionEffect(new PotionEffect(Effects.snapEffect, 1));
                        return true;
                    }
                }
            }
        }
        return false;
    }



}
