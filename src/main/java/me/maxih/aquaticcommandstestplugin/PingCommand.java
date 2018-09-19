package me.maxih.aquaticcommandstestplugin;

import me.maxih.aquaticcommands.framework.Command;
import me.maxih.aquaticcommands.framework.CommandException;
import me.maxih.aquaticcommands.framework.LiteralNode;
import me.maxih.aquaticcommands.framework.util.ParsedArgument;
import org.bukkit.command.CommandSender;
import scala.collection.Seq;
import scala.collection.immutable.Map;

public class PingCommand implements Command {
    private LiteralNode rootNode = new LiteralNode("ping", true);

    @Override
    public LiteralNode rootNode() {
        return rootNode;
    }

    @Override
    public void execute(CommandSender sender, Map<String, ParsedArgument> arguments, Seq<String> literals) throws CommandException {
        sender.sendMessage("Pong!");
    }

}
