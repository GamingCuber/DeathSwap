package mcplugins.io.github.GamingCuber.DeathSwap.commands;

import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitScheduler;

import mcplugins.io.github.GamingCuber.DeathSwap.Main;
import net.md_5.bungee.api.ChatColor;

public class SwapCommand implements CommandExecutor {

	private Main plugin;
	
		public SwapCommand(Main plugin) {
			
			this.plugin = plugin;
			plugin.getCommand("swap").setExecutor(this);
			
		}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		String FirstArg = args[0];
		Server Serv = sender.getServer();
		BukkitScheduler Sched = Serv.getScheduler();
		
		
		if (FirstArg.equalsIgnoreCase("start")) {
			
			
			
		} else if (FirstArg.equalsIgnoreCase("stop")) {
			
			Serv.broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD + "The DeathSwap has ended!");
			plugin.end = true;
			plugin.PlayerList.clear();
			Sched.cancelTasks(plugin);
			
		}
		
		
		
		return false;
	}

}
