package anvil.infinity.items;

import anvil.infinity.api.AbilityAdderHandler;
import anvil.infinity.compat.CompatHandler;
import anvil.infinity.helpers.GauntelHelper;
import lucraft.mods.lucraftcore.infinity.EnumInfinityStone;
import lucraft.mods.lucraftcore.infinity.ModuleInfinity;
import lucraft.mods.lucraftcore.infinity.items.ItemInfinityStone;
import lucraft.mods.lucraftcore.superpowers.abilities.Ability;
import lucraft.mods.lucraftcore.util.abilitybar.EnumAbilityBarColor;
import lucraft.mods.lucraftcore.util.helper.StringHelper;
import net.minecraft.entity.EntityLivingBase;

public class ItemSpaceStone extends ItemInfinityStone {

    public ItemSpaceStone(String name) {
        this.setTranslationKey(name);
        this.setRegistryName(StringHelper.unlocalizedToResourceName(name));
        this.setCreativeTab(ModuleInfinity.TAB);
    }

    @Override
    public EnumInfinityStone getType() {
        return EnumInfinityStone.SPACE;
    }

    @Override
    public boolean isContainer() {
        return false;
    }

    @Override
    public Ability.AbilityMap addStoneAbilities(EntityLivingBase entity, Ability.AbilityMap abilities, Ability.EnumAbilityContext context) {

        if (CompatHandler.isHeroesExpansion) {
            abilities.put("portal", CompatHandler.HeroesExpension.getAbilityPortal(entity).setDataValue(Ability.BAR_COLOR, EnumAbilityBarColor.LIGHT_BLUE));
            abilities.put("grab_entity", CompatHandler.HeroesExpension.getAbilityGrabEntity(entity).setDataValue(Ability.BAR_COLOR, EnumAbilityBarColor.LIGHT_BLUE));
            abilities.put("forcefield", CompatHandler.HeroesExpension.getAbilityForcefield(entity).setMaxCooldown(60).setDataValue(Ability.BAR_COLOR, EnumAbilityBarColor.LIGHT_BLUE));

            if (GauntelHelper.hasPowerStone(entity)) {
                abilities.put("blackhole", CompatHandler.HeroesExpension.getAbilityBlackhole(entity).setMaxCooldown(6000).setDataValue(Ability.BAR_COLOR, EnumAbilityBarColor.LIGHT_BLUE));
            }
        }

        AbilityAdderHandler.addAbilities(EnumInfinityStone.SPACE, entity, abilities);


        return super.addStoneAbilities(entity, abilities, context);
    }


}
