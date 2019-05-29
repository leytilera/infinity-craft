package anvil.infinity.items;

import anvil.infinity.Infinity;
import java.awt.*;
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

        POWER_STONE.setTileEntityItemStackRenderer(new ItemRendererInfinityStone(new Color(195, 42, 209), new Color(241, 42, 255)));
        MIND_STONE.setTileEntityItemStackRenderer(new ItemRendererInfinityStone(new Color(255, 211, 0), new Color(218, 255, 10)));
        REALITY_STONE.setTileEntityItemStackRenderer(new ItemRendererInfinityStone(new Color(225, 1, 48), new Color(255, 1, 48)));
        SOUL_STONE.setTileEntityItemStackRenderer(new ItemRendererInfinityStone(new Color(222, 115, 0), new Color(255, 139, 0)));
        TIME_STONE.setTileEntityItemStackRenderer(new ItemRendererInfinityStone(new Color(19, 207, 85), new Color(18, 231, 114)));

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