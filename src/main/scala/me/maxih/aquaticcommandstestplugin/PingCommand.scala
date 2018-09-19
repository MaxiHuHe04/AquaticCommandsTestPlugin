package me.maxih.aquaticcommandstestplugin

import me.maxih.aquaticcommands.framework.util.ParsedArgument
import me.maxih.aquaticcommands.framework.{Command, LiteralNode}
import org.bukkit.command.CommandSender

/**
  * Created by Maxi H. on 13.09.2018
  */
class PingCommand extends Command {
  override val rootNode: LiteralNode = new LiteralNode("ping", true)

  override def execute(sender: CommandSender, arguments: Map[String, ParsedArgument], literals: Seq[String]): Unit =
    sender.sendMessage("Pong!")
}
