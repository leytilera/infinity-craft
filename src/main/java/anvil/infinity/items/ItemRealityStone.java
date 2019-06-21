package anvil.infinity.items;

import anvil.infinity.api.AbilityAdderHandler;
import anvil.infinity.compat.CompatHandler;
import anvil.infinity.config.ConfigHandler;
import lucraft.mods.lucraftcore.infinity.EnumInfinityStone;
import lucraft.mods.lucraftcore.infinity.ModuleInfinity;
import lucraft.mods.lucraftcore.infinity.items.ItemInfinityStone;
import lucraft.mods.lucraftcore.superpowers.abilities.Ability;
import lucraft.mods.lucraftcore.superpowers.abilities.AbilityInvisibility;
import lucraft.mods.lucraftcore.superpowers.abilities.AbilitySizeChange;
import lucraft.mods.lucraftcore.util.abilitybar.EnumAbilityBarColor;
import lucraft.mods.lucraftcore.util.helper.StringHelper;
import net.minecraft.entity.EntityLivingBase;

public class ItemRealityStone extends ItemInfinityStone {

    public ItemRealityStone(String name) {
        this.setTranslationKey(name);
        this.setRegistryName(StringHelper.unlocalizedToResourceName(name));
        this.setCreativeTab(ModuleInfinity.TAB);
    }


    @Override
    public EnumInfinityStone getType() {
        return EnumInfinityStone.REALITY;
    }

    @Override
    public boolean isContainer() {
        return false;
    }


    @Override
    public Ability.AbilityMap addStoneAbilities(EntityLivingBase entity, Ability.AbilityMap abilities, Ability.EnumAbilityContext context) {
        if (ConfigHandler.sizeChanging) {
            abilities.put("size", new AbilitySizeChange(entity).setDataValue(AbilitySizeChange.SIZE, ConfigHandler.size).setDataValue(Ability.BAR_COLOR, EnumAbilityBarColor.RED));
        }
        abilities.put("invisibility", new AbilityInvisibility(entity).setDataValue(Ability.BAR_COLOR, EnumAbilityBarColor.RED));
        if (CompatHandler.isSpeedsterHeroes && ConfigHandler.useSHRealityAbilities) {
            abilities.put("save_block", CompatHandler.SpeedsterHeroes.getAbilitySaveBlock(entity).setDataValue(Ability.BAR_COLOR, EnumAbilityBarColor.RED));
            abilities.put("change_block", CompatHandler.SpeedsterHeroes.getAbilityChangeBlock(entity).setDataValue(Ability.BAR_COLOR, EnumAbilityBarColor.RED));
            abilities.put("turn_into_bubbles", CompatHandler.SpeedsterHeroes.getAbilityTurnIntoBubbles(entity).setDataValue(Ability.BAR_COLOR, EnumAbilityBarColor.RED));
        }

        AbilityAdderHandler.addAbilities(EnumInfinityStone.REALITY, entity, abilities);

        return super.addStoneAbilities(entity, abilities, context);
    }

}
