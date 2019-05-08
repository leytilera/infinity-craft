package anvil.infinity.items;

import anvil.infinity.abilities.AbilityHasPowerStone;
import lucraft.mods.lucraftcore.infinity.EnumInfinityStone;
import lucraft.mods.lucraftcore.infinity.ModuleInfinity;
import lucraft.mods.lucraftcore.infinity.items.ItemInfinityStone;
import lucraft.mods.lucraftcore.superpowers.abilities.*;
import lucraft.mods.lucraftcore.util.helper.StringHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

import java.awt.*;
import java.util.UUID;

public class ItemPowerStone extends ItemInfinityStone {

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
        abilities.put("power", new AbilityHasPowerStone(entity));
        abilities.put("blast", new AbilityEnergyBlast(entity).setDataValue(AbilityEnergyBlast.DAMAGE, Float.MAX_VALUE).setDataValue(AbilityEnergyBlast.COLOR, Color.MAGENTA));
        abilities.put("strength", new AbilityStrength(entity).setDataValue(AbilityAttributeModifier.AMOUNT, Float.MAX_VALUE));
        abilities.put("damage", new AbilityPunch(entity).setDataValue(AbilityPunch.AMOUNT, Float.MAX_VALUE));
        abilities.put("resistance", new AbilityDamageResistance(entity).setDataValue(AbilityAttributeModifier.AMOUNT, Float.MAX_VALUE));
        return super.addStoneAbilities(entity, abilities, context);
    }

    @Override
    public int getEnergyPerTick(ItemStack stack) {
        return Integer.MAX_VALUE;
    }


}
