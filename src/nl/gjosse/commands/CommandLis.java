package nl.gjosse.commands;

import nl.gjosse.DeathSwap;
import nl.gjosse.DeathSwapArena;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandLis implements CommandExecutor {

	DeathSwap plugin;
	
	public CommandLis(DeathSwap deathSwap) {
		this.plugin = deathSwap;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string,String[] args) {
		if(args.length == 1) {
			String arg1 = args[1];
			
			if(arg1.equalsIgnoreCase("help")) {
				sender.sendMessage("DeathSwap Help Here!");
				return true;
			}
			
			if(arg1.equalsIgnoreCase("join")) {
				int sizeBefore = DeathSwap.ppltoJoin.size();
				if(sizeBefore != 4) {
					DeathSwap.ppltoJoin.add(sender.getName());
					int size = DeathSwap.ppltoJoin.size();
					if(size==4) {
						if(DeathSwap.inProgress) {
							plugin.messageGroup(ChatColor.RED+"A game is still in progress, but you are in the quiue, when that game ends, you will join!");
						} else {
							DeathSwap.arena = new DeathSwapArena(DeathSwap.ppltoJoin, plugin);
							DeathSwap.ppltoJoin.clear();
						}
					} else {
						sender.sendMessage(ChatColor.GOLD+"You are in the quiue to join DeathSwap");
						sender.sendMessage(ChatColor.GOLD+"In the list you are "+ChatColor.AQUA+""+size+ChatColor.GOLD+"/4");
					}
				} else {
					sender.sendMessage(ChatColor.RED+"The quiue is full! Try latter!");
				}
			}
			
		} else if(args.length == 2) {
			
		} else if(args.length >= 3) {
			
		} else { //no aruments!
			return false;
		}
		return false;
	}

}
