package anvil.infinity.worldgen;

import anvil.infinity.config.ModConfig;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class InfinityWorldGenerator extends WorldGenerator implements IWorldGenerator {

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        return false;
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        int dim = world.provider.getDimension();
        if (ModConfig.Worldgen.debug)
            System.out.println("Chunk generation in Dim: " + dim);

        if ( (chunkX > 1000 || chunkX < -1000) && (chunkZ > 1000 || chunkZ < -1000) && ModConfig.Worldgen.enable ) {
            int blockX = chunkX * 16 + 8;
            int blockZ = chunkZ * 16 + 8;
            if (canGenMind(world) || canGenPower(world) || canGenReality(world) || canGenSoul(world) || canGenSpace(world) || canGenTime(world)) {
                if (ModConfig.Worldgen.debug)
                    System.out.println("A Stone can be generted here");

                if ((int) (Math.random() * 1000) == 0) {
                    int y = getGroundFromAbove(world, blockX, blockZ);
                    BlockPos pos = new BlockPos(blockX, y, blockZ);
                    WorldGenerator structure = new StoneTempleGen();
                    structure.generate(world, random, pos);

                }

            }



        }



    }

    public static int getGroundFromAbove(World world, int x, int z)
    {
        int y = 255;
        boolean foundGround = false;
        while(!foundGround && y-- >= 31)
        {
            Block blockAt = world.getBlockState(new BlockPos(x,y,z)).getBlock();
            foundGround =  blockAt == Blocks.WATER||blockAt == Blocks.FLOWING_WATER||blockAt == Blocks.GRASS || blockAt == Blocks.SAND || blockAt == Blocks.SNOW || blockAt == Blocks.SNOW_LAYER || blockAt == Blocks.GLASS||blockAt == Blocks.MYCELIUM;
        }

        return y;
    }

    public static boolean canSpawnHere(Template template, World world, BlockPos posAboveGround)
    {
        int zwidth = template.getSize().getZ();
        int xwidth = template.getSize().getX();

        boolean corner1 = isCornerValid(world, posAboveGround);
        boolean corner2 = isCornerValid(world, posAboveGround.add(xwidth, 0, zwidth));

        return posAboveGround.getY() > 31 && corner1 && corner2;
    }

    public static boolean isCornerValid(World world, BlockPos pos)
    {
        int variation = 3;
        int highestBlock = getGroundFromAbove(world, pos.getX(), pos.getZ());

        if (highestBlock > pos.getY() - variation && highestBlock < pos.getY() + variation)
            return true;

        return false;
    }

    public static boolean canGenPower(World w) {
        WorldData data = WorldData.get(w);
        int dim = w.provider.getDimension();
        return !data.power && ModConfig.Worldgen.powerDim == dim;
    }

    public static boolean canGenSoul(World w) {
        WorldData data = WorldData.get(w);
        int dim = w.provider.getDimension();
        return !data.soul && ModConfig.Worldgen.soulDim == dim;
    }

    public static boolean canGenSpace(World w) {
        WorldData data = WorldData.get(w);
        int dim = w.provider.getDimension();
        return !data.space && ModConfig.Worldgen.spaceDim == dim;
    }

    public static boolean canGenReality(World w) {
        WorldData data = WorldData.get(w);
        int dim = w.provider.getDimension();
        return !data.reality && ModConfig.Worldgen.realityDim == dim;
    }

    public static boolean canGenTime(World w) {
        WorldData data = WorldData.get(w);
        int dim = w.provider.getDimension();
        return !data.time && ModConfig.Worldgen.timeDim == dim;
    }

    public static boolean canGenMind(World w) {
        WorldData data = WorldData.get(w);
        int dim = w.provider.getDimension();
        return !data.mind && ModConfig.Worldgen.mindDim == dim;
    }

}
