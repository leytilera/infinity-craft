package anvil.infinity;

import anvil.infinity.capabilities.Factory;
import anvil.infinity.capabilities.ICapabilityPlayerData;
import anvil.infinity.capabilities.Storage;
import anvil.infinity.compat.CompatHandler;
import anvil.infinity.config.ConfigHandler;
import anvil.infinity.config.ModConfig;
import anvil.infinity.networking.LookAbilityPackageHandler;
import anvil.infinity.networking.LookAbilityReturnPackageHandler;
import anvil.infinity.networking.PackageKillAbility;
import anvil.infinity.networking.PackageReq;
import anvil.infinity.worldgen.InfinityWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

//Test

@Mod(
        modid = Infinity.MOD_ID,
        name = Infinity.MOD_NAME,
        version = Infinity.VERSION,
        dependencies = Infinity.DEPENDENCIES
)
public class Infinity {

    public static final String MOD_ID = "infinity";
    public static final String MOD_NAME = "Infinityraft";
    public static final String VERSION = "${version}";
    public static final String DEPENDENCIES = "required-after:lucraftcore@[1.12.2-2.4.4,)";
    public static final SimpleNetworkWrapper NETWORK_WRAPPER = NetworkRegistry.INSTANCE.newSimpleChannel(MOD_ID);

    @Mod.Instance(MOD_ID)
    public static Infinity INSTANCE;

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        ConfigHandler.refreshConfig(event.getSuggestedConfigurationFile());
        CompatHandler.check();
        int netID = 0;
        NETWORK_WRAPPER.registerMessage(LookAbilityReturnPackageHandler.class, PackageKillAbility.class, netID++, Side.SERVER);
        NETWORK_WRAPPER.registerMessage(LookAbilityPackageHandler.class, PackageReq.class, netID++, Side.CLIENT);
        CapabilityManager.INSTANCE.register(ICapabilityPlayerData.class, new Storage(), new Factory());

        if (ModConfig.Worldgen.enable) {
            GameRegistry.registerWorldGenerator(new InfinityWorldGenerator(), 0);
        }

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {

    }


}
