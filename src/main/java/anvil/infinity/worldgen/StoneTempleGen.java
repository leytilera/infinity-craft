package anvil.infinity.worldgen;

import anvil.infinity.Infinity;
import anvil.infinity.items.Items;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;

import java.util.Map;
import java.util.Random;

public class StoneTempleGen extends WorldGenerator {

    @Override
    public boolean generate(World world, Random rand, BlockPos position) {

        if (InfinityWorldGenerator.canGenMind(world)) {
            gen(world, position, Items.MIND_STONE);
            WorldData data = WorldData.get(world);
            data.mind = true;
            data.mindx = position.getX();
            data.mindz = position.getZ();
            data.markDirty();
            sendMessage("Mind", world);
            return true;
        }  else if (InfinityWorldGenerator.canGenSpace(world)) {
            gen(world, position, Items.SPACE_STONE);
            WorldData data = WorldData.get(world);
            data.space = true;
            data.spacex = position.getX();
            data.spacez = position.getZ();
            data.markDirty();
            sendMessage("Space", world);
            return true;
        } else if (InfinityWorldGenerator.canGenReality(world)) {
            gen(world, position, Items.REALITY_STONE);
            WorldData data = WorldData.get(world);
            data.reality = true;
            data.realityx = position.getX();
            data.realityz = position.getZ();
            data.markDirty();
            sendMessage("Reality", world);
            return true;
        } else if (InfinityWorldGenerator.canGenTime(world)) {
            gen(world, position, Items.TIME_STONE);
            WorldData data = WorldData.get(world);
            data.time = true;
            data.timex = position.getX();
            data.timez = position.getZ();
            data.markDirty();
            sendMessage("Time", world);
            return true;
        } else if (InfinityWorldGenerator.canGenSoul(world)) {
            gen(world, position, Items.SOUL_STONE);
            WorldData data = WorldData.get(world);
            data.soul = true;
            data.soulx = position.getX();
            data.soulz = position.getZ();
            data.markDirty();
            sendMessage("Soul", world);
            return true;
        } else if (InfinityWorldGenerator.canGenPower(world)) {
            gen(world, position, Items.POWER_STONE);
            WorldData data = WorldData.get(world);
            data.power = true;
            data.powerx = position.getX();
            data.powerz = position.getZ();
            data.markDirty();
            sendMessage("Power", world);
            return true;
        }
        return false;

    }

    void gen(World world, BlockPos position, Item stone) {
        WorldServer worldserver = (WorldServer) world;
        MinecraftServer minecraftserver = world.getMinecraftServer();
        TemplateManager templatemanager = worldserver.getStructureTemplateManager();
        Template template = templatemanager.getTemplate(minecraftserver, new ResourceLocation(Infinity.MOD_ID+":stonetemple"));


        IBlockState iblockstate = world.getBlockState(position);
        world.notifyBlockUpdate(position, iblockstate, iblockstate, 3);

        PlacementSettings placementsettings = (new PlacementSettings()).setMirror(Mirror.NONE)
                .setRotation(Rotation.NONE).setIgnoreEntities(false).setChunk((ChunkPos) null)
                .setReplacedBlock((Block) null).setIgnoreStructureBlock(false);

        template.getDataBlocks(position, placementsettings);
        template.addBlocksToWorld(world, position.add(0, 1, 0), placementsettings);


        Map<BlockPos, String> map = template.getDataBlocks(position, placementsettings);

        for (Map.Entry<BlockPos, String> entry : map.entrySet()) {
            if ("chest".equals(entry.getValue())) {
                BlockPos blockpos2 = entry.getKey();
                world.setBlockState(blockpos2.up(), Blocks.AIR.getDefaultState(), 3);
                TileEntity tileentity = world.getTileEntity(blockpos2);

                if (tileentity instanceof TileEntityChest) {
                    ((TileEntityChest) tileentity).getSingleChestHandler().insertItem(13, new ItemStack(stone), false);
                }
            }
        }
    }

    void sendMessage(String stone, World world) {
        MinecraftServer server = world.getMinecraftServer();
        assert server != null;
        PlayerList players = server.getPlayerList();
        TextComponentString msg = new TextComponentString("The " + stone + " Stone has been generated");
        msg.getStyle().setColor(TextFormatting.GOLD);
        msg.getStyle().setBold(true);
        players.sendMessage(msg);
    }

}
