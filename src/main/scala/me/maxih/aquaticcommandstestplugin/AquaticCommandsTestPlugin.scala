package me.maxih.aquaticcommandstestplugin

import me.maxih.aquaticcommands.framework.Commands
import org.bukkit.plugin.java.JavaPlugin

/**
  * Created by Maxi H. on 13.09.2018
  */
class AquaticCommandsTestPlugin extends JavaPlugin {
  override def onEnable(): Unit = {
    Commands.register(new PingCommand, new NukeCommand)
  }
}
