package anvil.infinity.items;

import anvil.infinity.abilities.AbilityHasSoulStone;
import anvil.infinity.abilities.AbilityKill;
import anvil.infinity.abilities.AbilitySnap;
import anvil.infinity.conditions.ICondition;
import anvil.infinity.config.ConfigHandler;
import anvil.infinity.helpers.GauntelHelper;
import lucraft.mods.lucraftcore.infinity.EnumInfinityStone;
import lucraft.mods.lucraftcore.infinity.ModuleInfinity;
import lucraft.mods.lucraftcore.infinity.items.ItemInfinityStone;
import lucraft.mods.lucraftcore.superpowers.abilities.Ability;
import lucraft.mods.lucraftcore.superpowers.abilities.AbilityAttributeModifier;
import lucraft.mods.lucraftcore.superpowers.abilities.AbilityHealing;
import lucraft.mods.lucraftcore.superpowers.abilities.AbilityHealth;
import lucraft.mods.lucraftcore.util.helper.StringHelper;
import net.minecraft.entity.EntityLivingBase;

public class ItemSoulStone extends ItemInfinityStone {

    ICondition killCond = new ICondition<EntityLivingBase>() {
        @Override
        public boolean isFulfilled(EntityLivingBase information) {
            return GauntelHelper.hasPowerStone(information) && GauntelHelper.hasSpaceStone(information) && GauntelHelper.hasRealityStone(information) && GauntelHelper.hasSoulStone(information);
        }
    };

    public ItemSoulStone(String name) {
        this.setTranslationKey(name);
        this.setRegistryName(StringHelper.unlocalizedToResourceName(name));
        this.setCreativeTab(ModuleInfinity.TAB);
    }


    @Override
    public EnumInfinityStone getType() {
        return EnumInfinityStone.SOUL;
    }

    @Override
    public boolean isContainer() {
        return false;
    }


    @Override
    public Ability.AbilityMap addStoneAbilities(EntityLivingBase entity, Ability.AbilityMap abilities, Ability.EnumAbilityContext context) {
        if (ConfigHandler.soulHealthBoost) {
            abilities.put("immortality", new AbilityHealth(entity).setDataValue(AbilityAttributeModifier.AMOUNT, Float.MAX_VALUE));
        }
        abilities.put("healing", new AbilityHealing(entity).setDataValue(AbilityHealing.FREQUENCY, 1));
        abilities.put("soul", new AbilityHasSoulStone(entity));
        abilities.put("kill", new AbilityKill(entity, killCond));
        abilities.put("snap", new AbilitySnap(entity));
        return super.addStoneAbilities(entity, abilities, context);
    }

}
