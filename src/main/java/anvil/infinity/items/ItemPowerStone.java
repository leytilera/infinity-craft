package anvil.infinity.items;

import anvil.infinity.abilities.AbilitySaturation;
import anvil.infinity.api.AbilityAdderHandler;
import anvil.infinity.compat.CompatHandler;
import anvil.infinity.config.ConfigHandler;
import anvil.infinity.config.ModConfig;
import lucraft.mods.lucraftcore.infinity.EnumInfinityStone;
import lucraft.mods.lucraftcore.infinity.ModuleInfinity;
import lucraft.mods.lucraftcore.infinity.items.ItemInfinityStone;
import lucraft.mods.lucraftcore.superpowers.abilities.*;
import lucraft.mods.lucraftcore.superpowers.abilities.supplier.IAbilityProvider;
import lucraft.mods.lucraftcore.util.abilitybar.EnumAbilityBarColor;
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
        abilities.put("blast", new AbilityEnergyBlast(entity).setDataValue(AbilityEnergyBlast.DAMAGE, Float.MAX_VALUE).setDataValue(AbilityEnergyBlast.COLOR, Color.MAGENTA).setDataValue(Ability.BAR_COLOR, EnumAbilityBarColor.PURPLE));
        abilities.put("strength", new AbilityStrength(entity).setDataValue(AbilityAttributeModifier.AMOUNT, Float.MAX_VALUE).setDataValue(Ability.BAR_COLOR, EnumAbilityBarColor.PURPLE));
        abilities.put("damage", new AbilityPunch(entity).setDataValue(AbilityPunch.AMOUNT, Float.MAX_VALUE).setDataValue(Ability.BAR_COLOR, EnumAbilityBarColor.PURPLE));
        abilities.put("resistance", new AbilityDamageResistance(entity).setDataValue(AbilityAttributeModifier.AMOUNT, Float.MAX_VALUE).setDataValue(Ability.BAR_COLOR, EnumAbilityBarColor.PURPLE));
        abilities.put("saturation", new AbilitySaturation(entity));
        if (CompatHandler.isStarTech && ModConfig.General.stAbilities) {
            abilities.put("power_blat", CompatHandler.StarTech.getAbilityPowerBlast(entity).setMaxCooldown(ModConfig.General.powerCooldown).setDataValue(Ability.BAR_COLOR, EnumAbilityBarColor.PURPLE));
            abilities.put("power_impower", CompatHandler.StarTech.getAbilityPowerImpower(entity).setDataValue(Ability.BAR_COLOR, EnumAbilityBarColor.PURPLE));
            abilities.put("power_rocket_burst", CompatHandler.StarTech.getAbilityPowerRocketBurst(entity).setMaxCooldown(100).setDataValue(Ability.BAR_COLOR, EnumAbilityBarColor.PURPLE));
            abilities.put("power_tendrils", CompatHandler.StarTech.getAbilityTendrils(entity).setDataValue(Ability.BAR_COLOR, EnumAbilityBarColor.PURPLE));
        }

        AbilityAdderHandler.addAbilities(EnumInfinityStone.POWER, entity, abilities);


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
        if (CompatHandler.isStarTech && ModConfig.General.stAbilities) {
            abilities.put("power_tendrils", CompatHandler.StarTech.getAbilityTendrils(entity));
            abilities.put("power_cyclone", CompatHandler.StarTech.getAbilityCyclone(entity));
            abilities.put("power_burnout", CompatHandler.StarTech.getAbilityBurnout(entity));
        }
        return abilities;
    }
}
