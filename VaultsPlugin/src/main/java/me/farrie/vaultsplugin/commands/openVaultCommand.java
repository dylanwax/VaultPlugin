package me.farrie.vaultsplugin.commands;

import me.farrie.vaultsplugin.utils.VaultUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class openVaultCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){

            Player p = (Player) sender;

            Inventory gui = Bukkit.createInventory(p, 54, "Vault");

            // Retrieve items from file
            List<ItemStack> items = VaultUtils.getItems(p);

            // Set items in GUI
            for (int i = 0; i < items.size() && i < gui.getSize(); i++) {
                gui.setItem(i, items.get(i));
            }

            p.openInventory(gui);

        }

        return true;
    }
}
