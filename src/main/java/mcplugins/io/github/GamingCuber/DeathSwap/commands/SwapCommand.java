package mcplugins.io.github.GamingCuber.DeathSwap.commands;

import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitScheduler;

import mcplugins.io.github.GamingCuber.DeathSwap.Main;
import mcplugins.io.github.GamingCuber.DeathSwap.tabcompleter.SwapTabCompleter;
import net.md_5.bungee.api.ChatColor;

public class SwapCommand implements CommandExecutor {

	private Main plugin;
	private int FirstCountDown;

	public SwapCommand(Main plugin) {

		this.plugin = plugin;
		plugin.getCommand("swap").setExecutor(this);
		plugin.getCommand("swap").setTabCompleter(new SwapTabCompleter(plugin));

	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		String FirstArg = args[0];
		Server Serv = sender.getServer();
		BukkitScheduler Sched = Serv.getScheduler();

		if (FirstArg.equalsIgnoreCase("start")) {

			FirstCountDown = Sched.scheduleSyncRepeatingTask(plugin, new Runnable() {

				@Override
				public void run() {
					// this basically just does the first countdown, before the swap techincally
					// starts
					int cnt = 10;
					cnt--;
					if (cnt == 0) {

						Serv.broadcastMessage(ChatColor.BLUE + "The Death Swap has started! GO!!!!!!");
						Sched.cancelTask(FirstCountDown);

					} else if (cnt == 1) {

						Serv.broadcastMessage(ChatColor.GREEN + "Starting in 1 second!");

					} else {

						Serv.broadcastMessage(ChatColor.GREEN + "Starting in " + cnt + " seconds...");

					}

				}

			}, 0, 20L);

			Sched.scheduleSyncRepeatingTask(plugin, new Runnable() {

				@Override
				public void run() {

					int cnt = 10;
					cnt--;
					if (cnt == 0) {

						Serv.broadcastMessage(ChatColor.BLUE + "Swapping!");
						if (plugin.PlayerList.size() % 2 == 0) {

							int PlayerListSize = plugin.PlayerList.size();
							// teleports the players
							for (int i = 0; i < PlayerListSize - 1; i++) {

								plugin.PlayerList.get(i).teleport(plugin.PlayerList.get(i + 1));

							}

						}

					} else if (cnt == 1) {

						Serv.broadcastMessage(ChatColor.GREEN + "Swapping in 1 second!");

					} else {

						Serv.broadcastMessage(ChatColor.GREEN + "Swapping in " + cnt + " seconds...");

					}

				}

			}, 10 * 20L + 5 * 60 * 20L, 5 * 60 * 20L);

		} else if (FirstArg.equalsIgnoreCase("stop")) {

			Serv.broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD + "The DeathSwap has ended!");
			plugin.end = true;
			plugin.PlayerList.clear();
			Sched.cancelTasks(plugin);

		}

		if (plugin.PlayerList.isEmpty()) {

			sender.sendMessage(ChatColor.DARK_RED + "You forget to add players to the swap!");

		}

		return false;
	}

}
