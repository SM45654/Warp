package at.sm45654.warp.commands;

import at.sm45654.warp.Warp;
import at.sm45654.warp.gui.WarpGUI;
import at.sm45654.warp.util.ChatUtil;
import at.sm45654.warp.util.Warplist;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetWarp implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {

        Player p = (Player) s;
        Location loc = p.getLocation();

        if (!(p.hasPermission("warp.setwarp"))) {
            p.sendMessage(Warp.prefix + ChatUtil.RED + "No permission!");
        } else {
            if (args.length == 0) {
                p.sendMessage(Warp.prefix + ChatUtil.RED + "Usage: " + ChatUtil.ORANGE + "/setwarp [warp]");
            } else {
                String warp = args[0];
                if (Warplist.warplist.contains(warp)) {
                    p.sendMessage(Warp.prefix + ChatUtil.RED + "Warp " + ChatUtil.ORANGE + warp + ChatUtil.RED + " already exists!");
                } else {
                    p.sendMessage(Warp.prefix + ChatUtil.LIGHT_GREEN + "Warp set.");
                    Warp.main.wm.setWarp(warp, loc);
                    Warplist.warplist.add(warp);
                    WarpGUI.createItem(warp);


                }
            }

        }
        return false;
    }
}