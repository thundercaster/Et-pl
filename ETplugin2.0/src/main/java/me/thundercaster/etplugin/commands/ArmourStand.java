package me.thundercaster.etplugin.commands;

import me.thundercaster.etplugin.ETplugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ArmourStand implements CommandExecutor {
    ETplugin plugin;

    public ArmourStand(ETplugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player p){
            if (args.length!=1){
                p.sendMessage(ChatColor.RED + "please enter name of the armour stand");
            }
            else{
                plugin.MainMenu(p);
                String name = args[0];
                plugin.list.add(name);
                p.sendMessage(ChatColor.GREEN + "the name is =" + name);

            }


        }

        return true;
    }

}
