package anvil.infinity.api;

import lucraft.mods.lucraftcore.infinity.EnumInfinityStone;
import net.minecraft.entity.EntityLivingBase;

import java.util.List;

public interface IAbilityAdder {

    List<StoneAbility> addStoneAbilities(EntityLivingBase entity, EnumInfinityStone stone);

}
