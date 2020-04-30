package anvil.infinity.command;

import anvil.infinity.abilities.AbilityLocate;
import anvil.infinity.compat.CompatHandler;
import anvil.infinity.config.ModConfig;
import anvil.infinity.worldgen.WorldData;
import lucraft.mods.heroesexpansion.superpowers.HESuperpowers;
import lucraft.mods.lucraftcore.superpowers.SuperpowerHandler;
import lucraft.mods.lucraftcore.superpowers.abilities.Ability;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class GeneratedCommand extends CommandBase {
    @Override
    public String getName() {
        return "generatedStones";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "Shows, which stones are generated";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        boolean locate = false;
        if (sender instanceof EntityLivingBase) {
            locate = Ability.hasAbility((EntityLivingBase) sender, AbilityLocate.class);
            if (CompatHandler.isHeroesExpansion) {
                locate = locate || CompatHandler.HeroesExpension.canLocate((EntityLivingBase) sender);
            }
        }
        WorldData data = WorldData.get(server.getWorld(0));
        ITextComponent msg = new TextComponentString("Generated: ");
        msg.appendText("\n Space Stone: " + data.space);
        if (locate)
            msg.appendText("\n X: " + data.spacex + "\n Z: " + data.spacez + "\n Dim: " + ModConfig.Worldgen.spaceDim);
        msg.appendText("\n Power Stone: " + data.power);
        if (locate)
            msg.appendText("\n X: " + data.powerx + "\n Z: " + data.powerz + "\n Dim: " + ModConfig.Worldgen.powerDim);
        msg.appendText("\n Mind Stone: " + data.mind);
        if (locate)
            msg.appendText("\n X: " + data.mindx + "\n Z: " + data.mindz + "\n Dim: " + ModConfig.Worldgen.mindDim);
        msg.appendText("\n Soul Stone: " + data.soul);
        if (locate)
            msg.appendText("\n X: " + data.soulx + "\n Z: " + data.soulz + "\n Dim: " + ModConfig.Worldgen.soulDim);
        msg.appendText("\n Time Stone: " + data.time);
        if (locate)
            msg.appendText("\n X: " + data.timex + "\n Z: " + data.timez + "\n Dim: " + ModConfig.Worldgen.timeDim);
        msg.appendText("\n Reality Stone: " + data.reality);
        if (locate)
            msg.appendText("\n X: " + data.realityx + "\n Z: " + data.realityz + "\n Dim: " + ModConfig.Worldgen.realityDim);
        sender.sendMessage(msg);
    }
}
