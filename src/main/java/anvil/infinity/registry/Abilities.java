package anvil.infinity.registry;

import anvil.infinity.Infinity;
import anvil.infinity.abilities.*;
import lucraft.mods.lucraftcore.superpowers.abilities.AbilityEntry;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Infinity.MOD_ID)
public class Abilities {

    @SubscribeEvent
    public static void onRegisterAbilities(RegistryEvent.Register<AbilityEntry> e) {
        e.getRegistry().register(new AbilityEntry(AbilitySnap.class, new ResourceLocation(Infinity.MOD_ID, "snap")));
        e.getRegistry().register(new AbilityEntry(AbilityKill.class, new ResourceLocation(Infinity.MOD_ID, "kill")));
        e.getRegistry().register(new AbilityEntry(AbilityChangeSnap.class, new ResourceLocation(Infinity.MOD_ID, "changesnap")));
        e.getRegistry().register(new AbilityEntry(AbilitySaturation.class, new ResourceLocation(Infinity.MOD_ID, "saturation")));
        e.getRegistry().register(new AbilityEntry(AbilityFastForward.class, new ResourceLocation(Infinity.MOD_ID, "fast_forward")));
        e.getRegistry().register(new AbilityEntry(AbilityStopTime.class, new ResourceLocation(Infinity.MOD_ID, "stop_time")));
        e.getRegistry().register(new AbilityEntry(AbilityLocate.class, new ResourceLocation(Infinity.MOD_ID, "locate")));
    }


}
