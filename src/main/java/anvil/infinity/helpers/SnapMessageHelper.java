package anvil.infinity.helpers;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class SnapMessageHelper {

    public static MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();

    public static void deathMessage(EntityLivingBase entity) {
        TextComponentString msg = new TextComponentString(entity.getName() + " ");
        msg.appendSibling(new TextComponentTranslation("infinity.snap.death"));
        server.getPlayerList().sendMessage(msg);

    }

}
