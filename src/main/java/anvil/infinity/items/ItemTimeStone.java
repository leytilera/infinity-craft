package anvil.infinity.items;

import anvil.infinity.abilities.AbilityFastForward;
import anvil.infinity.abilities.AbilityStopTime;
import lucraft.mods.lucraftcore.infinity.EnumInfinityStone;
import lucraft.mods.lucraftcore.infinity.ModuleInfinity;
import lucraft.mods.lucraftcore.infinity.items.ItemInfinityStone;
import lucraft.mods.lucraftcore.superpowers.abilities.Ability;
import lucraft.mods.lucraftcore.util.abilitybar.EnumAbilityBarColor;
import lucraft.mods.lucraftcore.util.helper.StringHelper;
import net.minecraft.entity.EntityLivingBase;

public class ItemTimeStone extends ItemInfinityStone {

    public ItemTimeStone(String name) {
        this.setTranslationKey(name);
        this.setRegistryName(StringHelper.unlocalizedToResourceName(name));
        this.setCreativeTab(ModuleInfinity.TAB);
    }


    @Override
    public EnumInfinityStone getType() {
        return EnumInfinityStone.TIME;
    }

    @Override
    public boolean isContainer() {
        return false;
    }


    @Override
    public Ability.AbilityMap addStoneAbilities(EntityLivingBase entity, Ability.AbilityMap abilities, Ability.EnumAbilityContext context) {
        abilities.put("fast_forward", new AbilityFastForward(entity).setDataValue(Ability.BAR_COLOR, EnumAbilityBarColor.GREEN));
        abilities.put("stop_time", new AbilityStopTime(entity).setDataValue(Ability.BAR_COLOR, EnumAbilityBarColor.GREEN));


        return super.addStoneAbilities(entity, abilities, context);
    }

}
