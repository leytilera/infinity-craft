package anvil.infinity.items;

import anvil.infinity.Infinity;
import java.awt.*;

import anvil.infinity.config.ConfigHandler;
import lucraft.mods.lucraftcore.infinity.render.ItemRendererInfinityStone;
import lucraft.mods.lucraftcore.util.helper.ItemHelper;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber(modid = Infinity.MOD_ID)
public class Items {

    public static Item POWER_STONE = new ItemPowerStone("power_stone");
    public static Item MIND_STONE = new ItemMindStone("mind_stone");
    public static Item REALITY_STONE = new ItemRealityStone("reality_stone");
    public static Item SOUL_STONE = new ItemSoulStone("soul_stone");
    public static Item TIME_STONE = new ItemTimeStone("time_stone");

    @SubscribeEvent
    public static void onRegisterItems(RegistryEvent.Register<Item> e) {

        e.getRegistry().register(POWER_STONE);
        e.getRegistry().register(MIND_STONE);
        e.getRegistry().register(REALITY_STONE);
        e.getRegistry().register(SOUL_STONE);
        e.getRegistry().register(TIME_STONE);

    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void onRegisterModels(ModelRegistryEvent e) {
        OBJLoader.INSTANCE.addDomain(Infinity.MOD_ID);

        POWER_STONE.setTileEntityItemStackRenderer(new ItemRendererInfinityStone(new Color(ConfigHandler.powerStoneColor), new Color(ConfigHandler.powerStoneShine)));
        MIND_STONE.setTileEntityItemStackRenderer(new ItemRendererInfinityStone(new Color(ConfigHandler.mindStoneColor), new Color(ConfigHandler.mindStoneShine)));
        REALITY_STONE.setTileEntityItemStackRenderer(new ItemRendererInfinityStone(new Color(ConfigHandler.realityStoneColor), new Color(ConfigHandler.realityStoneShine)));
        SOUL_STONE.setTileEntityItemStackRenderer(new ItemRendererInfinityStone(new Color(ConfigHandler.soulStoneColor), new Color(ConfigHandler.soulStoneShine)));
        TIME_STONE.setTileEntityItemStackRenderer(new ItemRendererInfinityStone(new Color(ConfigHandler.timeStoneColor), new Color(ConfigHandler.timeStoneShine)));


        ItemHelper.registerItemModel(POWER_STONE, Infinity.MOD_ID, "power_stone");
        ItemHelper.registerItemModel(MIND_STONE, Infinity.MOD_ID, "mind_stone");
        ItemHelper.registerItemModel(REALITY_STONE, Infinity.MOD_ID, "reality_stone");
        ItemHelper.registerItemModel(SOUL_STONE, Infinity.MOD_ID, "soul_stone");
        ItemHelper.registerItemModel(TIME_STONE, Infinity.MOD_ID, "time_stone");

    }

    @SubscribeEvent
    public static void onMissingRegistries(RegistryEvent.MissingMappings<Item> e) {


    }
}