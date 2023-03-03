package me.farrie.vaultsplugin.listeners;

import me.farrie.vaultsplugin.VaultsPlugin;
import me.farrie.vaultsplugin.utils.VaultUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;

public class Listeners implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        Player p = e.getPlayer();

        VaultUtils.getItems(p); // Load items from file

    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e) {

        Player p = (Player) e.getPlayer();

        if (e.getView().getTitle().equalsIgnoreCase("Vault")){

            ArrayList<ItemStack> prunedItems = new ArrayList<>();

            Arrays.stream(e.getInventory().getContents())
                    .filter(itemStack -> {
                        if (itemStack == null){
                            return false;
                        }
                        return true;
                    })
                    .forEach(itemStack -> prunedItems.add(itemStack));

            System.out.println("size: " + prunedItems.size());

            VaultUtils.storeItems(prunedItems, p);

        }
    }
}
