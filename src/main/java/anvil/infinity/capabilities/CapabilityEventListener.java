package anvil.infinity.capabilities;

import anvil.infinity.Infinity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Infinity.MOD_ID)
public class CapabilityEventListener {

    @SubscribeEvent
    public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> e) {
        Entity entity = e.getObject();
        if (entity instanceof EntityPlayer) {
            e.addCapability(new ResourceLocation(Infinity.MOD_ID, "playerCapability"), new CapabilityPlayerDataProvider(new CapabilityPlayerData()));
        }
    }

}
