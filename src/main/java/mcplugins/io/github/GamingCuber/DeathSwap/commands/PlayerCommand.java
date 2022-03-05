package mcplugins.io.github.GamingCuber.DeathSwap.commands;

import java.util.ArrayList;

import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import mcplugins.io.github.GamingCuber.DeathSwap.Main;
import mcplugins.io.github.GamingCuber.DeathSwap.tabcompleter.PlayerTabCompleter;

public class PlayerCommand implements CommandExecutor {

	private Main plugin;

	public PlayerCommand(Main plugin) {

		this.plugin = plugin;
		plugin.getCommand("player").setExecutor(this);
		plugin.getCommand("player").setTabCompleter(new PlayerTabCompleter(plugin));

	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		String FirstArg = args[0];
		Server Serv = sender.getServer();
		if (FirstArg.equalsIgnoreCase("add")) {

			for (int i = 1; i < args.length - 1; i++) {

				plugin.PlayerList.add(Serv.getPlayer(args[i]));

			}

		} else if (FirstArg.equalsIgnoreCase("remove")) {

			ArrayList<Player> RemovedList = new ArrayList<>();
			for (int i = 1; i < args.length - 1; i++) {

				RemovedList.add(Serv.getPlayer(args[i]));

			}
			plugin.PlayerList.removeAll(RemovedList);

		}

		return false;
	}

}
