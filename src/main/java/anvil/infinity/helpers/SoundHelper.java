package anvil.infinity.helpers;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.SoundEvent;

public class SoundHelper {

    public static void playSoundAtEntity(EntityLivingBase entity, SoundEvent sound) {
        entity.world.playSound(entity.getPosition().getX(), entity.getPosition().getY(), entity.getPosition().getZ(), sound, null, 5, 0, true);
    }

}
