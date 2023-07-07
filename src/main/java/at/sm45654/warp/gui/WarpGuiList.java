package at.sm45654.warp.gui;

import at.sm45654.warp.Warp;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class WarpGuiList {

    public static File listFile;

    public static YamlConfiguration cfg;

    static {
        listFile = new File("plugins/" + Warp.main.getName() + "/List", "warpguilist.yml");
        cfg = YamlConfiguration.loadConfiguration(listFile);
    }



    public static void saveList() {
        cfg.set("WarpGUI", WarpGUI.warpgui.getContents());
        try {
            cfg.save(listFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadList() {
        ArrayList<ItemStack> content = (ArrayList<ItemStack>) cfg.getList("WarpGUI");
        ItemStack[] items = new ItemStack[content.size()];
        for (int i = 0; i < content.size(); i++) {
            ItemStack item = content.get(i);
            if (item != null) {
                items[i] = item;
            } else {
                items[i] = null;
            }
        }

        WarpGUI.warpgui.setContents(items);

    }

}
