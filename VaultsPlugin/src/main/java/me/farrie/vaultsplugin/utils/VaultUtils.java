package me.farrie.vaultsplugin.utils;

import me.farrie.vaultsplugin.VaultsPlugin;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VaultUtils {

    public static void storeItems(List<ItemStack> items, Player p) {
        File file = new File(VaultsPlugin.getPlugin().getDataFolder(), p.getUniqueId().toString() + ".yml");

        if (items.isEmpty()) {
            file.delete();
        } else {
            try {
                FileConfiguration config = new YamlConfiguration();
                ConfigurationSection itemsSection = config.createSection("items");
                Set<String> addedItems = new HashSet<>();

                for (int i = 0; i < items.size(); i++) {
                    ItemStack item = items.get(i);
                    String itemKey = item.getType().toString() + "-" + item.getDurability() + "-" + item.getAmount() + "-" + item.getItemMeta().serialize();

                    addedItems.add(itemKey);
                    itemsSection.set(String.valueOf(i), item);
                }

                config.set("items", itemsSection);
                config.save(file);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static ArrayList<ItemStack> getItems(Player p){

        File file = new File(VaultsPlugin.getPlugin().getDataFolder(), p.getUniqueId().toString() + ".yml");

        ArrayList<ItemStack> items = new ArrayList<>();

        if (file.exists()){
            try{
                FileConfiguration config = YamlConfiguration.loadConfiguration(file);
                ConfigurationSection itemsSection = config.getConfigurationSection("items");

                if (itemsSection != null){
                    for (String key : itemsSection.getKeys(false)){
                        ItemStack item = itemsSection.getItemStack(key);
                        if (item != null){
                            items.add(item);
                        }
                    }
                }

            }catch(Exception ex){
                System.out.println(ex);
            }
        }

        return items;
    }
}