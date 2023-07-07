package at.sm45654.warp;

import at.sm45654.warp.commands.*;
import at.sm45654.warp.gui.WarpGUI;
import at.sm45654.warp.gui.WarpGuiList;
import at.sm45654.warp.sign.WarpSignClick;
import at.sm45654.warp.sign.WarpSignCreate;
import at.sm45654.warp.util.*;
import at.sm45654.warp.util.Warplist;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public final class Warp extends JavaPlugin {

    public static String prefix = ChatUtil.GREEN + "[" + ChatUtil.LIGHT_GREEN + "Warp" + ChatUtil.GREEN + "] ";
    public static Warp main;

    public WarpManager wm;

    public Warplist warplist;
    public Config cfg;




    @Override
    public void onEnable() {
        main = this;
        WarpGUI.WarpGui();
        WarpGuiList.loadList();
        Warplist.loadList();
        warplist = new Warplist();
        wm = new WarpManager();
        wm.saveCfg();
        cfg = new Config();
        cfg.register();
        Config.saveCfg();
        new bStats().registerbStats(this);
        this.getCommand("setwarp").setExecutor(new SetWarp());
        this.getCommand("deletewarp").setExecutor(new DeleteWarp());
        this.getCommand("warp").setExecutor(new at.sm45654.warp.commands.Warp());
        this.getCommand("listwarp").setExecutor(new ListWarp());
        this.getCommand("warpgui").setExecutor(new WarpGuiCMD());
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new WarpSignCreate(), this);
        pluginManager.registerEvents(new WarpSignClick(), this);
        pluginManager.registerEvents(new WarpGUI(), this);
    }

    @Override
    public void onDisable() {
        Warplist.saveList();
        WarpGuiList.saveList();
    }




}


