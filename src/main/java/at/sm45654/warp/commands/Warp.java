package at.sm45654.warp.commands;

import at.sm45654.warp.util.ChatUtil;
import at.sm45654.warp.util.Warplist;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Warp implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {

        Player p = (Player) s;

        if (args.length == 0) {
            p.sendMessage(at.sm45654.warp.Warp.prefix + ChatUtil.RED + "Usage: " + ChatUtil.ORANGE + "/warp [warp]");
        } else {
            String warp = args[0];
            if (!(Warplist.warplist.contains(warp))) {
                p.sendMessage(at.sm45654.warp.Warp.prefix + ChatUtil.RED + "Warp " + ChatUtil.ORANGE + warp + ChatUtil.RED + " does not exist.");
            } else {

                p.teleport(at.sm45654.warp.Warp.main.wm.getWarp(warp));


            }
        }
        return false;
    }


}
