name := "AquaticCommands Test Plugin"

version := "0.1"

scalaVersion := "2.12.6"

resolvers += Resolver.jcenterRepo
libraryDependencies += "me.maxih" %% "aquaticcommands" % "0.3"

resolvers += Resolver.sonatypeRepo("public")
resolvers += "spigot-repo" at "https://hub.spigotmc.org/nexus/content/repositories/snapshots/"
libraryDependencies += "org.spigotmc" % "spigot-api" % "1.13.1-R0.1-SNAPSHOT" % "provided"
