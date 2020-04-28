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

    public boolean power;
    public boolean space;
    public boolean reality;
    public boolean soul;
    public boolean time;
    public boolean mind;

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        power = nbt.getBoolean("power");
        space = nbt.getBoolean("space");
        reality = nbt.getBoolean("reality");
        soul = nbt.getBoolean("soul");
        time = nbt.getBoolean("time");
        mind = nbt.getBoolean("mind");

    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setBoolean("power", power);
        compound.setBoolean("space", space);
        compound.setBoolean("reality", reality);
        compound.setBoolean("soul", soul);
        compound.setBoolean("time", time);
        compound.setBoolean("mind", mind);

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
