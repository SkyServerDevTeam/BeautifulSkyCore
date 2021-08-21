package xyz.sky_server.Commands.Utils;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.sky_server.Main;

import static org.bukkit.Bukkit.getServer;

public class HubCommand implements CommandExecutor {
    Main main;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(sender instanceof Player p) {
            p.sendMessage("ハブへ転送します...");
            Location hubLoc = new Location(getServer().getWorld(main.getConfig().getString("worldname","RPGhub")),main.getConfig().getInt("HubLoc.x"),main.getConfig().getInt("HubLoc.y"),main.getConfig().getInt("HubLoc.z"));
            p.teleport(hubLoc);
        }
        return true;
    }
}
