package me.maxih.aquaticcommandstestplugin

import me.maxih.aquaticcommands.framework._
import me.maxih.aquaticcommands.framework.util.Implicits._
import me.maxih.aquaticcommands.framework.util.ParsedArgument
import org.bukkit.command.CommandSender
import org.bukkit.entity.TNTPrimed
import org.bukkit.util.Vector

/**
  * Created by Maxi H. on 14.09.2018
  */
class NukeCommand extends Command {
  override val rootNode: LiteralNode =
    new LiteralNode("nuke", true)
      .add(new ArgumentNode("amount", new Parsers.IntParser, true)
        .add(new ArgumentNode("radius", new Parsers.DoubleParser, true)))

  override def execute(sender: CommandSender, arguments: Map[String, ParsedArgument], literals: Seq[String]): Unit = {
    val loc = sender.locationOrError
    val amount = arguments.get("amount").mapOrElse(_.int.get, 30)
    val radius = arguments.get("radius").mapOrElse(_.double.get, 1.0)
    if (radius > 3) throw CommandException("Radius is too high")

    for (i <- 0 until amount) {
      val rad = math.toRadians(i.doubleValue() / amount * 360)

      val tnt = loc.getWorld.spawn(loc, classOf[TNTPrimed])
      tnt.setVelocity(new Vector(radius * math.cos(rad), 1, radius * math.sin(rad)))
    }

  }
}
