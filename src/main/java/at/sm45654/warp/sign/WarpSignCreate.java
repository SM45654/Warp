package at.sm45654.warp.sign;

import at.sm45654.warp.Warp;
import at.sm45654.warp.util.ChatUtil;
import at.sm45654.warp.util.Warplist;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class WarpSignCreate implements Listener {

    @EventHandler
    public void onSignCreate(SignChangeEvent e) {

        Player p = e.getPlayer();
        String warp = e.getLine(2);

        if (e.getLine(0).equalsIgnoreCase("[warp]")) {
            if (!(p.hasPermission("warp.sign"))) {
                p.sendMessage(Warp.prefix + ChatUtil.RED + "No permission!");
            } else {
                if (!(Warplist.warplist.contains(warp))) {
                    p.sendMessage(Warp.prefix + ChatUtil.RED + "Warp " + ChatUtil.ORANGE + warp + ChatUtil.RED + " does not exist.");
                    e.setLine(0, "");
                    e.setLine(1, "");
                    e.setLine(2, "");
                    e.setLine(3, "");
                } else {
                    e.setLine(0, ChatUtil.GREEN + "[" + ChatUtil.LIGHT_GREEN + "Warp" + ChatUtil.GREEN + "]");
                    e.setLine(2, warp);
                    p.sendMessage(Warp.prefix + ChatUtil.LIGHT_GREEN + "Warp sign created.");
                }
            }


        }
    }
}