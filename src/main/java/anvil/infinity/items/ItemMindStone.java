package anvil.infinity.items;

import anvil.infinity.abilities.AbilityChangeSnap;
import anvil.infinity.abilities.AbilityHasMindStone;
import anvil.infinity.compat.CompatHandler;
import lucraft.mods.lucraftcore.infinity.EnumInfinityStone;
import lucraft.mods.lucraftcore.infinity.ModuleInfinity;
import lucraft.mods.lucraftcore.infinity.items.ItemInfinityStone;
import lucraft.mods.lucraftcore.superpowers.abilities.Ability;
import lucraft.mods.lucraftcore.superpowers.abilities.AbilityFlight;
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
        abilities.put("flight", new AbilityFlight(entity).setDataValue(AbilityFlight.SPEED, 1f));
        abilities.put("mind", new AbilityHasMindStone(entity));
        abilities.put("changesnap", new AbilityChangeSnap(entity));
        if (CompatHandler.isHeroesExpansion) {
            abilities.put("telekinesis", CompatHandler.HeroesExpension.getAbilityGrabEntity(entity));
        }
        return super.addStoneAbilities(entity, abilities, context);
    }

}
