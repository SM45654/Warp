package at.sm45654.warp;

import org.bstats.bukkit.Metrics;
import org.bstats.charts.SimplePie;

public class bStats {

    public void registerbStats(Warp plugin) {
        int pluginId = 18553;
        Metrics metrics = new Metrics(plugin, pluginId);
        metrics.addCustomChart(new SimplePie("warpgui", () -> String.valueOf(Warp.main.cfg.getBoolean("warpGUI"))));
        metrics.addCustomChart(new SimplePie("compass", () -> String.valueOf(Warp.main.cfg.getBoolean("compass"))));
    }

}
