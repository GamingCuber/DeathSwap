package mcplugins.io.github.GamingCuber.DeathSwap;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import mcplugins.io.github.GamingCuber.DeathSwap.commands.PlayerCommand;
import mcplugins.io.github.GamingCuber.DeathSwap.commands.SwapCommand;
import mcplugins.io.github.GamingCuber.DeathSwap.listeners.DeathListener;
import mcplugins.io.github.GamingCuber.DeathSwap.tabcompleter.PlayerTabCompleter;
import mcplugins.io.github.GamingCuber.DeathSwap.tabcompleter.SwapTabCompleter;

public class Main extends JavaPlugin {

	public ArrayList<Player> PlayerList = new ArrayList<>();
	public boolean end = true;

	@Override
	public void onEnable() {

		new SwapCommand(this);
		new PlayerCommand(this);
		new DeathListener(this);
		new SwapTabCompleter(this);
		new PlayerTabCompleter(this);

	}

}
