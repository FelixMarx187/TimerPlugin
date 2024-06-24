package de.kokosfrucht.timer.Command;

import de.kokosfrucht.timer.Main;
import de.kokosfrucht.timer.Timer.Timer;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TimerCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sendUsage(commandSender);
            return true;
        }

        switch (args[0].toLowerCase()) {
            case "resume": {
                Timer timer = Main.getInstance().getTimer();

                if (timer.isRunning()) {
                    commandSender.sendMessage(ChatColor.RED + "Der Timer läuft bereits!");
                    break;
                }
                timer.setRunning(true);
                commandSender.sendMessage(ChatColor.GRAY + "Der Timer wurde gestartet!");
                break;
            }
            case "pause": {
                Timer timer = Main.getInstance().getTimer();

                if (!timer.isRunning()) {
                    commandSender.sendMessage(ChatColor.RED + "Der Timer läuft nicht!");
                    break;
                }
                timer.setRunning(true);
                commandSender.sendMessage(ChatColor.GRAY + "Der Timer wurde gestoppt!");
                break;
            }
            case "set": {
                Timer timer = Main.getInstance().getTimer();
                if (args.length != 2) {
                    commandSender.sendMessage(ChatColor.GRAY + "Verwendung: " + ChatColor.BLUE + "/timer set <Zeit>");
                    return true;
                }
                try {
                    timer.setTime(Integer.parseInt(args[1]));
                    commandSender.sendMessage(ChatColor.GRAY + "Zeit wurde gesetzt!");
                } catch (NumberFormatException e) {
                    commandSender.sendMessage(ChatColor.RED + "Dein Parameter 2 muss eine Zahl sein!");
                }
                break;
            }
            case "reset":{
                Timer timer = Main.getInstance().getTimer();

                timer.setRunning(false);
                timer.setTime(0);
                commandSender.sendMessage(ChatColor.GRAY + "Der Timer wurde zurückgesetzt!");
                break;
            }
            default:
                sendUsage(commandSender);
                break;
        }
        return false;
    }
    private void sendUsage(CommandSender sender) {
        sender.sendMessage(ChatColor.GRAY + "Verwendung: " + ChatColor.DARK_GRAY + "/timer resume, / timer pause, /timer set <Zeit>, /timer reset");
    }
}
