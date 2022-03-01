package mcplugins.io.github.GamingCuber.DeathSwap.commands.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import mcplugins.io.github.GamingCuber.DeathSwap.Main;
import net.md_5.bungee.api.ChatColor;

public class DeathListener implements Listener {

	private Main plugin;

	public DeathListener(Main plugin) {

		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);

	}

	@EventHandler
	public void onDeath(EntityDeathEvent e) {

		if (e.getEntityType().equals(EntityType.PLAYER)) {

			Server Serv = e.getEntity().getServer();
			Player DeadPlayer = (Player) e.getEntity();
			for (Player p : plugin.PlayerList) {

				if (DeadPlayer.equals(p)) {

					Serv.broadcastMessage(ChatColor.DARK_AQUA + DeadPlayer.getName() + " has died!");
					plugin.PlayerList.remove(DeadPlayer);

				}

			}

		}

	}

}
