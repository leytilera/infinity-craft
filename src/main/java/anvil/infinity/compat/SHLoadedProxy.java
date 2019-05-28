package anvil.infinity.compat;

import anvil.infinity.abilities.AbilityHasRealityStone;
import lucraft.mods.lucraftcore.superpowers.abilities.Ability;
import lucraft.mods.speedsterheroes.abilities.AbilityChangeBlocks;
import lucraft.mods.speedsterheroes.abilities.AbilitySaveBlock;
import lucraft.mods.speedsterheroes.abilities.AbilityTurnIntoBubbles;
import net.minecraft.entity.EntityLivingBase;

public class SHLoadedProxy implements SHProxy {

    @Override
    public Ability getAbilitySaveBlock(EntityLivingBase entity) {
        return new AbilitySaveBlock(entity);
    }

    @Override
    public Ability getAbilityChangeBlock(EntityLivingBase entity) {
        return new AbilityChangeBlocks(entity);
    }

    @Override
    public Ability getAbilityTurnIntoBubbles(EntityLivingBase entity) {
        return new AbilityTurnIntoBubbles(entity);
    }

    @Override
    public boolean hasRealityStone(EntityLivingBase entity) {
        return Ability.hasAbility(entity, AbilityHasRealityStone.class) || Ability.hasAbility(entity, AbilitySaveBlock.class);
    }

}
