package anvil.infinity.items;

import anvil.infinity.abilities.AbilityChangeSnap;
import anvil.infinity.api.AbilityAdderHandler;
import anvil.infinity.compat.CompatHandler;
import anvil.infinity.config.ConfigHandler;
import anvil.infinity.config.ModConfig;
import lucraft.mods.lucraftcore.infinity.EnumInfinityStone;
import lucraft.mods.lucraftcore.infinity.ModuleInfinity;
import lucraft.mods.lucraftcore.infinity.items.ItemInfinityStone;
import lucraft.mods.lucraftcore.superpowers.abilities.Ability;
import lucraft.mods.lucraftcore.superpowers.abilities.AbilityFlight;
import lucraft.mods.lucraftcore.util.abilitybar.EnumAbilityBarColor;
import lucraft.mods.lucraftcore.util.helper.StringHelper;
import net.minecraft.entity.EntityLivingBase;


public class ItemMindStone extends ItemInfinityStone {

    public ItemMindStone(String name) {
        this.setTranslationKey(name);
        this.setRegistryName(StringHelper.unlocalizedToResourceName(name));
        this.setCreativeTab(ModuleInfinity.TAB);
    }


    @Override
    public EnumInfinityStone getType() {
        return EnumInfinityStone.MIND;
    }

    @Override
    public boolean isContainer() {
        return false;
    }


    @Override
    public Ability.AbilityMap addStoneAbilities(EntityLivingBase entity, Ability.AbilityMap abilities, Ability.EnumAbilityContext context) {
        abilities.put("flight", new AbilityFlight(entity).setDataValue(AbilityFlight.SPEED, 1f).setDataValue(Ability.BAR_COLOR, EnumAbilityBarColor.YELLOW));
        abilities.put("changesnap", new AbilityChangeSnap(entity).setDataValue(Ability.BAR_COLOR, EnumAbilityBarColor.YELLOW));
        if (CompatHandler.isHeroesExpansion && ModConfig.General.heAbilities) {
            abilities.put("telekinesis", CompatHandler.HeroesExpension.getAbilityGrabEntity(entity).setDataValue(Ability.BAR_COLOR, EnumAbilityBarColor.YELLOW));
        }

        AbilityAdderHandler.addAbilities(EnumInfinityStone.MIND, entity, abilities);

        return super.addStoneAbilities(entity, abilities, context);
    }

}
