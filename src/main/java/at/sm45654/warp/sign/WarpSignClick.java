package at.sm45654.warp.sign;

import at.sm45654.warp.Warp;
import at.sm45654.warp.util.Warplist;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class WarpSignClick implements Listener {

    @EventHandler
    public void onSignClick(PlayerInteractEvent e) {
        if (e.getClickedBlock().getState() instanceof Sign) {
            String warp = (((Sign) e.getClickedBlock().getState()).getLine(2));

            if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                if (((Sign) e.getClickedBlock().getState()).getLine(0).contains("Warp")) {

                    if (Warplist.warplist.contains(warp)) {
                        e.getPlayer().teleport(Warp.main.wm.getWarp(warp));


                    }
                }
            }
        }
    }
}
