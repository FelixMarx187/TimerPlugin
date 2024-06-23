package de.kokosfrucht.timer.QuitAndJoinListeners;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        event.setQuitMessage(ChatColor.WHITE.toString() + ChatColor.BOLD + player.getName() + ChatColor.RED + "hat den Server verlassen!");
    }
}
