package me.farrie.vaultsplugin;

import me.farrie.vaultsplugin.commands.openVaultCommand;
import me.farrie.vaultsplugin.listeners.Listeners;
import org.bukkit.plugin.java.JavaPlugin;

public final class VaultsPlugin extends JavaPlugin {

    private static VaultsPlugin plugin;

    public static VaultsPlugin getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;

        getCommand("pv").setExecutor(new openVaultCommand());
        getServer().getPluginManager().registerEvents(new Listeners(), this);
    }
}
