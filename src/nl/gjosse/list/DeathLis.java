package nl.gjosse.list;

import nl.gjosse.DeathSwap;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathLis implements Listener {

	DeathSwap plugin;
	
	public DeathLis(DeathSwap deathSwap) {
		this.plugin = deathSwap;
	}
	
	@EventHandler
	public void onPlayDeath(PlayerDeathEvent event) {
		
	}
	
	

}
