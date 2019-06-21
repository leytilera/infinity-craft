package anvil.infinity.api;

import lucraft.mods.lucraftcore.infinity.EnumInfinityStone;
import lucraft.mods.lucraftcore.superpowers.abilities.Ability;
import lucraft.mods.lucraftcore.util.abilitybar.EnumAbilityBarColor;
import net.minecraft.entity.EntityLivingBase;

import java.util.ArrayList;
import java.util.List;

public class AbilityAdderHandler {

    static List<IAbilityAdder> abilityAdders = new ArrayList<>();

    public static void register(IAbilityAdder abilityAdder) {
        abilityAdders.add(abilityAdder);
    }

    public static void addAbilities(EnumInfinityStone stone, EntityLivingBase entity, Ability.AbilityMap abilities) {

        for (IAbilityAdder abilityAdder : abilityAdders) {
            for (StoneAbility ability : abilityAdder.addStoneAbilities(entity, stone)) {
                abilities.put(ability.abilityName, ability.ability.setDataValue(Ability.BAR_COLOR, getStoneColor(stone)));
            }
        }

    }

    public static EnumAbilityBarColor getStoneColor(EnumInfinityStone stone) {
        switch (stone) {
            case MIND: return EnumAbilityBarColor.YELLOW;
            case SOUL: return EnumAbilityBarColor.ORANGE;
            case TIME: return EnumAbilityBarColor.GREEN;
            case POWER: return EnumAbilityBarColor.PURPLE;
            case SPACE: return EnumAbilityBarColor.LIGHT_BLUE;
            case REALITY: return EnumAbilityBarColor.RED;
            default: return EnumAbilityBarColor.WHITE;
        }
    }

}
