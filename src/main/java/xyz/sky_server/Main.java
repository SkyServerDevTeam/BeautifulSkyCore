package xyz.sky_server;

import lombok.Getter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.sky_server.Commands.Utils.HubCommand;
import xyz.sky_server.EventListener.EventListener;

import java.util.logging.Level;

public class Main extends JavaPlugin {
    @Getter
    FileConfiguration config = getConfig();

    @Override
    public void onEnable(){
        initConfig();
        getCommand("hub").setExecutor(new HubCommand());
        getServer().getPluginManager().registerEvents(new EventListener(),this);
        getLogger().log(Level.INFO,
                """
                         ____                   _   _  __       _ ____  _           ____              \s
                        | __ )  ___  __ _ _   _| |_(_)/ _|_   _| / ___|| | ___   _ / ___|___  _ __ ___\s
                        |  _ \\ / _ \\/ _` | | | | __| | |_| | | | \\___ \\| |/ / | | | |   / _ \\| '__/ _ \\
                        | |_) |  __/ (_| | |_| | |_| |  _| |_| | |___) |   <| |_| | |__| (_) | | |  __/
                        |____/ \\___|\\__,_|\\__,_|\\__|_|_|  \\__,_|_|____/|_|\\_\\\\__, |\\____\\___/|_|  \\___|
                                                                             |___/                    \s
                        BeautifulSkyCoreが起動しました""");
    }
    @Override
    public void onDisable(){
        getLogger().log(Level.INFO,"BeautifulSkyCoreが終了しました");
    }
    public void initConfig(){
        saveDefaultConfig();
        saveConfig();
    }
}
