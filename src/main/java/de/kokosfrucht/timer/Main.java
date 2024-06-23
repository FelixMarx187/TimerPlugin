package de.kokosfrucht.timer;

import de.kokosfrucht.timer.Command.TimerCommand;
import de.kokosfrucht.timer.QuitAndJoinListeners.JoinListener;
import de.kokosfrucht.timer.QuitAndJoinListeners.QuitListener;
import de.kokosfrucht.timer.Timer.Timer;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static Main getInstance() {
        return instance;
    }

    private static Main instance;

    public Timer getTimer() {
        return timer;
    }

    private Timer timer;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "TimerPlugin Loaded!");

        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(new JoinListener(), this);
        manager.registerEvents(new QuitListener(), this);

        getCommand("timer").setExecutor(new TimerCommand());
        timer = new Timer(false, 0);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
