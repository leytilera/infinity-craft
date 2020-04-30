package anvil.infinity.worldgen;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.storage.MapStorage;
import net.minecraft.world.storage.WorldSavedData;

public class WorldData extends WorldSavedData {

    static String NAME = "generated_stones";

    public WorldData() {
        super(NAME);
    }

    public WorldData(String name) {
        super(name);
    }

    public boolean power;
    public boolean space;
    public boolean reality;
    public boolean soul;
    public boolean time;
    public boolean mind;

    public int powerx;
    public int spacex;
    public int realityx;
    public int soulx;
    public int timex;
    public int mindx;

    public int powerz;
    public int spacez;
    public int realityz;
    public int soulz;
    public int timez;
    public int mindz;

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        power = nbt.getBoolean("power");
        space = nbt.getBoolean("space");
        reality = nbt.getBoolean("reality");
        soul = nbt.getBoolean("soul");
        time = nbt.getBoolean("time");
        mind = nbt.getBoolean("mind");

        powerx = nbt.getInteger("powerX");
        spacex = nbt.getInteger("spaceX");
        realityx = nbt.getInteger("realityX");
        soulx = nbt.getInteger("soulX");
        timex = nbt.getInteger("timeX");
        mindx = nbt.getInteger("mindX");

        powerz = nbt.getInteger("powerZ");
        spacez = nbt.getInteger("spaceZ");
        realityz = nbt.getInteger("realityZ");
        soulz = nbt.getInteger("soulZ");
        timez = nbt.getInteger("timeZ");
        mindz = nbt.getInteger("mindZ");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setBoolean("power", power);
        compound.setBoolean("space", space);
        compound.setBoolean("reality", reality);
        compound.setBoolean("soul", soul);
        compound.setBoolean("time", time);
        compound.setBoolean("mind", mind);

        compound.setInteger("powerX", powerx);
        compound.setInteger("spaceX", spacex);
        compound.setInteger("realityX", realityx);
        compound.setInteger("soulX", soulx);
        compound.setInteger("timeX", timex);
        compound.setInteger("mindX", mindx);

        compound.setInteger("powerZ", powerz);
        compound.setInteger("spaceZ", spacez);
        compound.setInteger("realityZ", realityz);
        compound.setInteger("soulZ", soulz);
        compound.setInteger("timeZ", timez);
        compound.setInteger("mindZ", mindz);

        return compound;
    }

    public static WorldData get(World world) {
        MapStorage storage = world.getMapStorage();
        WorldData instance = (WorldData) storage.getOrLoadData(WorldData.class, NAME);

        if (instance == null) {
            instance = new WorldData();
            storage.setData(NAME, instance);
        }
        return instance;
    }

}
