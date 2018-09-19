package me.maxih.aquaticcommandstestplugin;

import me.maxih.aquaticcommands.framework.*;
import me.maxih.aquaticcommands.framework.util.Implicits;
import me.maxih.aquaticcommands.framework.util.ParsedArgument;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.util.Vector;
import scala.collection.Seq;
import scala.collection.immutable.Map;

public class NukeCommand implements Command {
    private LiteralNode rootNode = new LiteralNode("nuke", true)
            .add(ScalaUtil.varargs(new ArgumentNode("amount", new Parsers.IntParser(false), true)))
            .add(ScalaUtil.varargs(new ArgumentNode("radius", new Parsers.DoubleParser(false), true)));

    public LiteralNode rootNode() {
        return rootNode;
    }

    public void execute(CommandSender sender, Map<String, ParsedArgument> arguments, Seq<String> literals) throws CommandException {
        Location loc = Implicits.RichCommandSender(sender).locationOrError();

        int amount = Implicits.RichOption(arguments.get("amount")).mapOrElse(v1 -> (Integer) v1.parsed(), () -> 30);
        double radius = Implicits.RichOption(arguments.get("radius")).mapOrElse(v1 -> (Double) v1.parsed(), () -> 1.0);

        if (radius > 3) throw new CommandException("Radius is too high");

        for (int i = 0; i < amount; i++) {
            double rad = Math.toRadians(((double) i) / amount * 360);

            TNTPrimed tnt = loc.getWorld().spawn(loc, TNTPrimed.class);
            tnt.setVelocity(new Vector(radius * Math.cos(rad), 1, radius * Math.sin(rad)));
        }

    }
}
