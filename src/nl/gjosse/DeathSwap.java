package nl.gjosse;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import nl.gjosse.commands.CommandLis;
import nl.gjosse.list.DeathLis;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class DeathSwap extends JavaPlugin {
	
	Logger log = Logger.getLogger("Minecraft");
	public static ArrayList<String> ppltoJoin = new ArrayList<String>();
	public static ArrayList<String> inGame = new ArrayList<String>();
	public static boolean inProgress = false;
	public static DeathSwapArena arena;
	
	public void onEnable() {
		message("DeathSwap starting up!");
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new DeathLis(this), this);
		
		getCommand("deathswap").setExecutor(new CommandLis(this));
	}
	
	public void onDisable() {
		message("DeathSwap disabled!");
	}
	
	public void message(String message) {
		log.log(Level.INFO, message);
	}

	public void messageGroup(String string) {
		for(String ppl : ppltoJoin) {
			Player player = Bukkit.getPlayer(ppl);
			player.sendMessage(string);
		}
	}
	
}
