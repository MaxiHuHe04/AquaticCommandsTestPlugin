package me.maxih.aquaticcommandstestplugin;

import me.maxih.aquaticcommands.framework.Commands;
import org.bukkit.plugin.java.JavaPlugin;

public class AquaticCommandsTestPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        Commands.register(ScalaUtil.varargs(new PingCommand(), new NukeCommand()));
    }

}
