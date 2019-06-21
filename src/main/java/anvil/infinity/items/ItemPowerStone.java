package anvil.infinity.items;

import anvil.infinity.abilities.AbilitySaturation;
import anvil.infinity.compat.CompatHandler;
import anvil.infinity.config.ConfigHandler;
import lucraft.mods.lucraftcore.infinity.EnumInfinityStone;
import lucraft.mods.lucraftcore.infinity.ModuleInfinity;
import lucraft.mods.lucraftcore.infinity.items.ItemInfinityStone;
import lucraft.mods.lucraftcore.superpowers.abilities.*;
import lucraft.mods.lucraftcore.superpowers.abilities.supplier.IAbilityProvider;
import lucraft.mods.lucraftcore.util.helper.StringHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

import java.awt.*;

public class ItemPowerStone extends ItemInfinityStone implements IAbilityProvider {

    public ItemPowerStone(String name) {
        this.setTranslationKey(name);
        this.setRegistryName(StringHelper.unlocalizedToResourceName(name));
        this.setCreativeTab(ModuleInfinity.TAB);
    }


    @Override
    public EnumInfinityStone getType() {
        return EnumInfinityStone.POWER;
    }

    @Override
    public boolean isContainer() {
        return false;
    }


    @Override
    public Ability.AbilityMap addStoneAbilities(EntityLivingBase entity, Ability.AbilityMap abilities, Ability.EnumAbilityContext context) {
        abilities.put("blast", new AbilityEnergyBlast(entity).setDataValue(AbilityEnergyBlast.DAMAGE, Float.MAX_VALUE).setDataValue(AbilityEnergyBlast.COLOR, Color.MAGENTA));
        abilities.put("strength", new AbilityStrength(entity).setDataValue(AbilityAttributeModifier.AMOUNT, Float.MAX_VALUE));
        abilities.put("damage", new AbilityPunch(entity).setDataValue(AbilityPunch.AMOUNT, Float.MAX_VALUE));
        abilities.put("resistance", new AbilityDamageResistance(entity).setDataValue(AbilityAttributeModifier.AMOUNT, Float.MAX_VALUE));
        abilities.put("saturation", new AbilitySaturation(entity));
        if (CompatHandler.isStarTech && ConfigHandler.stAbilities) {
            abilities.put("power_blat", CompatHandler.StarTech.getAbilityPowerBlast(entity).setMaxCooldown(ConfigHandler.powerCooldown));
            abilities.put("power_impower", CompatHandler.StarTech.getAbilityPowerImpower(entity));
            abilities.put("power_rocket_burst", CompatHandler.StarTech.getAbilityPowerRocketBurst(entity).setMaxCooldown(100));
            abilities.put("power_tendrils", CompatHandler.StarTech.getAbilityTendrils(entity));
        }
        return super.addStoneAbilities(entity, abilities, context);
    }

    @Override
    public int getEnergyPerTick(ItemStack stack) {
        return Integer.MAX_VALUE;
    }

    @Override
    public Ability.AbilityMap addDefaultAbilities(EntityLivingBase entity, Ability.AbilityMap abilities, Ability.EnumAbilityContext context) {
        abilities.put("blast", new AbilityEnergyBlast(entity).setDataValue(AbilityEnergyBlast.DAMAGE, Float.MAX_VALUE).setDataValue(AbilityEnergyBlast.COLOR, Color.MAGENTA));
        abilities.put("strength", new AbilityStrength(entity).setDataValue(AbilityAttributeModifier.AMOUNT, Float.MAX_VALUE));
        abilities.put("damage", new AbilityPunch(entity).setDataValue(AbilityPunch.AMOUNT, Float.MAX_VALUE));
        abilities.put("resistance", new AbilityDamageResistance(entity).setDataValue(AbilityAttributeModifier.AMOUNT, Float.MAX_VALUE));
        if (CompatHandler.isStarTech && ConfigHandler.stAbilities) {
            abilities.put("power_tendrils", CompatHandler.StarTech.getAbilityTendrils(entity));
            abilities.put("power_cyclone", CompatHandler.StarTech.getAbilityCyclone(entity));
            abilities.put("power_burnout", CompatHandler.StarTech.getAbilityBurnout(entity));
        }
        return abilities;
    }
}
