package at.sm45654.warp.util;

import at.sm45654.warp.Warp;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class WarpManager {

    public static File file = new File("plugins/" + Warp.main.getName() + "/List", "warps.yml");

    public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    public void setWarp(String name, Location loc) {

        cfg.set(name, name);

        cfg.set(name + ".world", loc.getWorld().getName());
        cfg.set(name + ".x", loc.getX());
        cfg.set(name + ".y", loc.getY());
        cfg.set(name + ".z", loc.getZ());

        cfg.set(name + ".yaw", loc.getYaw());
        cfg.set(name + ".pitch", loc.getPitch());
        saveCfg();
    }


    public Location getWarp(String name) {
        Location loc;
            World w = Bukkit.getWorld(cfg.getString(name + ".world"));
            double x = cfg.getDouble(name + ".x");
            double y = cfg.getDouble(name + ".y");
            double z = cfg.getDouble(name + ".z");
            loc = new Location(w, x, y, z);
            loc.setPitch(cfg.getInt(name + ".yaw"));
            loc.setPitch(cfg.getInt(name + ".pitch"));


        return loc;
    }

    public void saveCfg() {
        try {
            cfg.save(file);
        } catch (IOException e) {
            //
        }
    }
}

