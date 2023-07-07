package at.sm45654.warp.commands;

import at.sm45654.warp.util.ChatUtil;
import at.sm45654.warp.util.Warplist;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ListWarp implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {

        Player p = (Player) s;

        p.sendMessage(ChatUtil.GREEN + "--- [" + ChatUtil.LIGHT_GREEN + "WarpList" + ChatUtil.GREEN + "] ---");
        for (String warps : Warplist.warplist) {
            p.sendMessage(ChatUtil.YELLOW + warps);
        }
        return false;
    }
}
