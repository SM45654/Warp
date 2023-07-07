package at.sm45654.warp;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;

public class Config {

    public  static File file = new File("plugins/"+ Warp.main.getName(),"config.yml");
    public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);



    public void register() {
        cfg.options().copyDefaults(true);
        cfg.addDefault("warpGUI", true);
        saveCfg();
    }

    public boolean getBoolean(String path) {
        return cfg.getBoolean(path);
    }



    public static void saveCfg() {
        try {
            cfg.save(file);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

}

