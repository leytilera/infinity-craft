package anvil.infinity.api;

import lucraft.mods.lucraftcore.infinity.EnumInfinityStone;
import lucraft.mods.lucraftcore.superpowers.abilities.Ability;

public class StoneAbility {

    public String abilityName;
    public Ability ability;

    public StoneAbility(String abilityName, Ability ability) {
        this.abilityName = abilityName;
        this.ability = ability;
    }
}
