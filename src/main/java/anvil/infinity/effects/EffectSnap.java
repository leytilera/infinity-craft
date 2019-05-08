package anvil.infinity.effects;

import anvil.infinity.Infinity;
import anvil.infinity.SoundHelper;
import anvil.infinity.registry.Effects;
import anvil.infinity.registry.Sounds;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;


@Mod.EventBusSubscriber(modid = Infinity.MOD_ID)
public class EffectSnap extends Potion {

    public EffectSnap(boolean p_i46815_1_, int p_i46815_2_) {
        super(p_i46815_1_, p_i46815_2_);
    }

    @SubscribeEvent
    public static void onTick(LivingEvent.LivingUpdateEvent e) {
        if (e.getEntityLiving().getActivePotionEffect(Effects.snapEffect) != null) {
            if (e.getEntityLiving().getActivePotionEffect(Effects.snapEffect).getDuration() == 1) {
                e.getEntityLiving().playSound(Sounds.snap, 5, 0);
                e.getEntityLiving().setHealth(0);




            }
        }
    }

    @Override
    public List<ItemStack> getCurativeItems() {
        return new ArrayList<>();
    }







}
