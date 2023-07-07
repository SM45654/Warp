package at.sm45654.warp.commands;

import at.sm45654.warp.Warp;
import at.sm45654.warp.gui.WarpGUI;
import at.sm45654.warp.util.ChatUtil;
import at.sm45654.warp.util.Warplist;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class DeleteWarp implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {

        Player p = (Player) s;

        if (!(p.hasPermission("warp.deletewarp"))) {
            p.sendMessage(Warp.prefix + ChatUtil.RED + "No permission!");
        } else {
            if (args.length == 0) {
                p.sendMessage(Warp.prefix + ChatUtil.RED + "Usage: " + ChatUtil.ORANGE + "/deletewarp [warp]");
            } else {
                String warp = args[0];
                if (!(Warplist.warplist.contains(warp))) {
                    p.sendMessage(Warp.prefix + ChatUtil.RED + "Warp " + ChatUtil.ORANGE + warp + ChatUtil.RED + " does not exist.");
                } else {
                        p.sendMessage(Warp.prefix + ChatUtil.LIGHT_GREEN + "Warp deleted.");
                        Warplist.warplist.remove(warp);
                        WarpGUI.deleteItem(warp);


                }
            }
        }
        return false;
    }
}
