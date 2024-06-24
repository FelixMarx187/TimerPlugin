package de.kokosfrucht.timer.Timer;

import de.kokosfrucht.timer.Main;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static net.md_5.bungee.api.ChatColor.BOLD;

public class Timer {

    private boolean running;
    private int time;

    public Timer(boolean running, int time) {

        this.running = running;
        this.time = time;

        run();
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public int getTime() {
        return time;
    }
    public String getFormattedTime() {
        int days = time / 86400;
        int hours = (time % 86400) / 3600;
        int minutes = (time % 3600) / 60;
        int seconds = time % 60;

        if (days > 0) {
            return String.format("%d %s %02d:%02d:%02d",
                    days, (days == 1 ? "Tag" : "Tage"), hours, minutes, seconds);
        } else if (hours > 0) {
            return String.format("%02d:%02d:%02d", hours, minutes, seconds);
        } else {
            return String.format("%02d:%02d", minutes, seconds);
        }
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void sencActionBar() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (!isRunning()) {
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.RED + "Timer ist pausiert"));
                continue;
            }

            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.LIGHT_PURPLE.toString() + BOLD + getFormattedTime()));

        }
    }

    private void run() {
        new BukkitRunnable() {
            @Override
            public void run() {

                sencActionBar();

                if (!isRunning()) {
                    return;
                }

                setTime(getTime()+1);
            }
        }.runTaskTimer(Main.getInstance(), 20,20);
    }
}
