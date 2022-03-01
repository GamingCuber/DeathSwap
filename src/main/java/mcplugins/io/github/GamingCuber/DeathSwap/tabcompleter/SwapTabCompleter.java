package mcplugins.io.github.GamingCuber.DeathSwap.tabcompleter;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import mcplugins.io.github.GamingCuber.DeathSwap.Main;

public class SwapTabCompleter implements TabCompleter {

	private Main plugin;
	
		public SwapTabCompleter(Main plugin) {
			
			this.plugin = plugin;
			
		}

		@Override
		public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
			
			if (args.length == 1) {
				
				List<String> TabArray = new ArrayList<>();
				TabArray.add("start");
				TabArray.add("stop");
				return TabArray;
			} else 
				return null;
			
			
			
		}
	
	
		
}
