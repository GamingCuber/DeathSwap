package mcplugins.io.github.GamingCuber.DeathSwap.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import mcplugins.io.github.GamingCuber.DeathSwap.Main;

public class PlayerCommand implements CommandExecutor {

	private Main plugin;
	
		public PlayerCommand(Main plugin) {
			
			this.plugin = plugin;
			plugin.getCommand("player").setExecutor(this);
			
		}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		String FirstArg = args[0];
		if (FirstArg.equalsIgnoreCase("add")) {
			
			
			
		} else if (FirstArg.equalsIgnoreCase("remove")) {
			
			
			
		}
		
		
		return false;
	}
	
		
	
}
