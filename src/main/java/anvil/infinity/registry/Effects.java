package anvil.infinity.registry;

import anvil.infinity.Infinity;
import anvil.infinity.effects.EffectSnap;
import net.minecraft.potion.Potion;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


@Mod.EventBusSubscriber(modid = Infinity.MOD_ID)
public class Effects {

    public static Potion snapEffect = new EffectSnap(true, 0x000000);

    @SubscribeEvent
    public static void onRegisterPotions(RegistryEvent.Register<Potion> e) {

        snapEffect.setRegistryName("effectSnap");

        e.getRegistry().register(snapEffect);
    }




}
