package anvil.infinity.command;

import anvil.infinity.worldgen.WorldData;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
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
        WorldData data = WorldData.get(server.getWorld(0));
        ITextComponent msg = new TextComponentString("Generated: ");
        msg.appendText("\n Space Stone: " + data.space);
        msg.appendText("\n Power Stone: " + data.power);
        msg.appendText("\n Mind Stone: " + data.mind);
        msg.appendText("\n Soul Stone: " + data.soul);
        msg.appendText("\n Time Stone: " + data.time);
        msg.appendText("\n Reality Stone: " + data.reality);
        sender.sendMessage(msg);
    }
}
