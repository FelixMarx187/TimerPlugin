package de.kokosfrucht.timer.QuitAndJoinListeners;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        event.setJoinMessage(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + player.getName() + ChatColor.BLUE + " hat den Server betreten");
    }
}
