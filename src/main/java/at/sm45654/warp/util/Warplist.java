package at.sm45654.warp.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import at.sm45654.warp.Warp;
import org.bukkit.configuration.file.YamlConfiguration;

    public class Warplist {

        public static ArrayList<String> warplist = new ArrayList<String>();
        public static File listFile;

        public static YamlConfiguration cfg;

        static {
            listFile = new File("plugins/" + Warp.main.getName() + "/List", "warplist.yml");
            cfg = YamlConfiguration.loadConfiguration(listFile);
        }



        public static void saveList() {
            cfg.set("WarpList", warplist);
            try {
                cfg.save(listFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void loadList() {
            warplist = (ArrayList<String>) cfg.getStringList("WarpList");
        }

    }


