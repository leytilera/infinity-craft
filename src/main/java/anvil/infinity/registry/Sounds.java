package anvil.infinity.registry;

import anvil.infinity.Infinity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Infinity.MOD_ID)
public class Sounds {

    public static SoundEvent snap = new SoundEvent(new ResourceLocation(Infinity.MOD_ID, "snap"));

    @SubscribeEvent
    public static void onRegisterSoundEvents(RegistryEvent.Register<SoundEvent> e) {

        snap.setRegistryName("soundSnap");

        e.getRegistry().register(snap);
    }

}
