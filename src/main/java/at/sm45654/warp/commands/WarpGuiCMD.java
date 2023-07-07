package at.sm45654.warp.commands;

import at.sm45654.warp.Warp;
import at.sm45654.warp.gui.WarpGUI;
import at.sm45654.warp.util.ChatUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WarpGuiCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {

        Player p = (Player) s;
        if (!Warp.main.cfg.getBoolean("warpGUI")) {
            p.sendMessage(Warp.prefix + ChatUtil.RED + "WarpGUI is disabled!");
            return false;
        }

            p.openInventory(WarpGUI.warpgui);


        return false;
    }
}
