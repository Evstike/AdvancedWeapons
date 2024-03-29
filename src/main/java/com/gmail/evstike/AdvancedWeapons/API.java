package com.gmail.evstike.AdvancedWeapons;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SuppressWarnings("deprecation")
public class API implements InventoryHolder {
    
    Fates plugin;
    
    public API(Fates instance) {
        plugin = instance;
    }
    
    public API() {
    }
    
    //VERSIONS
    public boolean serverIs118() {
        if (Bukkit.getVersion().contains("1.18")) {
            return true;
        }
        return false;
    }
    
    //ITEMS
    public boolean armorHasLore(PlayerInventory inv, String lore) {
        if (inv.getHelmet() != null && inv.getHelmet().hasItemMeta() && inv.getHelmet().getItemMeta().hasLore()
                && inv.getHelmet().getItemMeta().getLore().contains(lore)
                || inv.getChestplate() != null && inv.getChestplate().hasItemMeta()
                && inv.getChestplate().getItemMeta().hasLore()
                && inv.getChestplate().getItemMeta().getLore().contains(lore)
                || inv.getLeggings() != null && inv.getLeggings().hasItemMeta()
                && inv.getLeggings().getItemMeta().hasLore()
                && inv.getLeggings().getItemMeta().getLore().contains(lore)
                || inv.getBoots() != null && inv.getBoots().hasItemMeta() && inv.getBoots().getItemMeta().hasLore()
                && inv.getBoots().getItemMeta().getLore().contains(lore)) {
            return true;
        }
        return false;
    }
    
    public boolean itemHasLore(PlayerInventory inv, String lore) {
        if (inv.getItemInHand().getType() != Material.AIR) {
            if (inv.getItemInHand().hasItemMeta()) {
                if (inv.getItemInHand().getItemMeta().hasLore()) {
                    if (inv.getItemInHand().getItemMeta().getLore().contains(lore)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean isWeapon(Player player) {
        if (player.getInventory().getItemInHand().getType().toString().toLowerCase()
                .contains("sword") || player.getInventory().getItemInHand().getType().toString().toLowerCase()
                .contains("_axe")) {
            return true;
        }
        return false;
    }
    
    public boolean isArmor(Player player) {
        if (player.getInventory().getItemInHand().getType().toString().toLowerCase()
                .contains("helmet") || player.getInventory().getItemInHand().getType().toString().toLowerCase()
                .contains("chestplate") || player.getInventory().getItemInHand().getType().toString().toLowerCase()
                .contains("leggings") || player.getInventory().getItemInHand().getType().toString().toLowerCase()
                .contains("boots")) {
            return true;
        }
        return false;
    }
    
    public boolean isTool(Player player) {
        if (player.getInventory().getItemInHand().getType().toString().toLowerCase()
                .contains("pickaxe") || player.getInventory().getItemInHand().getType().toString().toLowerCase()
                .contains("_axe") || player.getInventory().getItemInHand().getType().toString().toLowerCase()
                .contains("shovel") || player.getInventory().getItemInHand().getType().toString().toLowerCase()
                .contains("_hoe") || player.getInventory().getItemInHand().getType().toString().toLowerCase()
                .contains("shears")) {
            return true;
        }
        return false;
    }
    
    public boolean isBow(Player player) {
        if (player.getInventory().getItemInHand().getType().toString().toLowerCase()
                .contains("bow") || player.getInventory().getItemInHand().getType().toString().toLowerCase()
                .contains("trident")) {
            return true;
        }
        return false;
    }
    
    //ENCHANTMENT
    public int enchlevel(Player p, String s, ItemStack i) {
        for (String l : i.getItemMeta().getLore()) {
    
            if (ChatColor.stripColor(l).equals(ChatColor.stripColor(s))) {
                String test = ChatColor.stripColor(l);
                String lastWord = test.substring(test.lastIndexOf(" ") + 1);
        
                if (lastWord.equals(ChatColor.stripColor("I"))) {
                    return 1;
                }
                if (lastWord.equals(ChatColor.stripColor("II"))) {
                    return 2;
                }
                if (lastWord.equals(ChatColor.stripColor("III"))) {
                    return 3;
                }
                if (lastWord.equals(ChatColor.stripColor("IV"))) {
                    return 4;
                }
                if (lastWord.equals(ChatColor.stripColor("V"))) {
                    return 5;
                }
            }
        }
        return 0;
    }
    
    public int enchlevelString(String s) {
        String lastWord = s.substring(s.lastIndexOf(" ") + 1);
    
        if (lastWord.equals(ChatColor.stripColor("I"))) {
            return 1;
        }
        if (lastWord.equals(ChatColor.stripColor("II"))) {
            return 2;
        }
        if (lastWord.equals(ChatColor.stripColor("III"))) {
            return 3;
        }
        if (lastWord.equals(ChatColor.stripColor("IV"))) {
            return 4;
        }
        if (lastWord.equals(ChatColor.stripColor("V"))) {
            return 5;
        }
        return 0;
    }
    public String enchNumeral(int i) {
        
        if (i==1) {
            return "I";
        }
        if (i==2) {
            return "II";
        }
        if (i==3) {
            return "III";
        }
        if (i==4) {
            return "IV";
        }
        if (i==5) {
            return "V";
        }
        return "0";
    }
    
    //COMMAND
    public boolean hasCommandPerm(CommandSender sender, Command cmd, String commandLabel, FileConfiguration f) {
        if (sender instanceof Player) {
            if (!sender.hasPermission("advancedweapons." + cmd.getName())) {
                sender.sendMessage(f.getString("no-permission-msg").replace('&', '§').replace("{cmd}", commandLabel));
                return true;
            }
        }
        return false;
    }
    
    public boolean moduleIsDisabled(String module, FileConfiguration f) {
        return !f.getBoolean(module);
    }
    
    public static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    
    public static boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    
    public static int getAmount(Player arg0, ItemStack arg1) {
        if (arg1 == null)
            return 0;
        int amount = 0;
        for (int i = 0; i < 36; i++) {
            ItemStack slot = arg0.getInventory().getItem(i);
            if (slot == null || !slot.isSimilar(arg1))
                continue;
            amount += slot.getAmount();
        }
        return amount;
    }
    
    public ItemStack autominer() {
        ItemStack autominer = new ItemStack(Material.HOPPER);
        ItemMeta autominerMeta = autominer.getItemMeta();
        autominerMeta.setDisplayName("§bAutoMiner");
        autominer.setItemMeta(autominerMeta);
        return autominer;
    }
    
    public ItemStack dust(List<String> s) {
        List<String> Lore = new ArrayList();
        ItemStack glow = new ItemStack(Material.GUNPOWDER, 1);
        ItemMeta glowMeta = glow.getItemMeta();
        glowMeta.setDisplayName(ChatColor.GREEN + "Dust");
        for (String l : s) {
            Lore.add(l.replace('&', '§'));
        }
        Lore.add("§8§oDust");
        glowMeta.setLore(Lore);
        glow.setItemMeta(glowMeta);
        return glow;
    }
    
    public ItemStack dustold() {
        List<String> Lore = new ArrayList();
        ItemStack glow = new ItemStack(Material.GUNPOWDER, 1);
        ItemMeta glowMeta = glow.getItemMeta();
        glowMeta.setDisplayName(ChatColor.GREEN + "Dust");
        Lore.add("§7This Dust has magical properties");
        Lore.add("§7which make it a valuable currency.");
        glowMeta.setLore(Lore);
        glow.setItemMeta(glowMeta);
        return glow;
    }
    
    public ItemStack back() {
        ItemStack back = new ItemStack(Material.ARROW);
        ItemMeta backMeta = back.getItemMeta();
        backMeta.setDisplayName(ChatColor.GREEN + "Back");
        back.setItemMeta(backMeta);
        return back;
    }
    
    public void hasAvaliableSlot(Player playerP, ItemStack item, String s) {
        HashMap<Integer, ItemStack> leftOver = new HashMap<Integer, ItemStack>();
        leftOver.putAll((playerP.getInventory().addItem(item)));
        if (!leftOver.isEmpty()) {
            Location loc = playerP.getLocation();
            ItemStack item2 = item.clone();
            item2.setAmount(leftOver.get(0).getAmount());
            playerP.getWorld().dropItem(loc, item2);
            playerP.sendMessage(s.replace('&', '§'));
        }
    }
    
    public void sendActionBar(Player p, String s) {
        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(s));
    }
    
    public int maxSize(int i) {
        
        int size = 64;
        if (i == 0) {
            size = 32;
        }
        if (i == 1) {
            size = 48;
        }
        if (i == 2) {
            size = 64;
        }
        if (i == 3) {
            size = 64;
        }
        
        return size;
    }
    
    public boolean buy(Player p, int n, FileConfiguration c) {
        ItemStack glow = dust(c.getStringList("dust-item")).clone();
        glow.setAmount(n);
        if (p.getInventory().containsAtLeast(glow, n)) {
            p.getInventory().removeItem(glow);
            return true;
        } else {
            p.sendMessage(c.getString("insufficient-dust-msg").replace('&', '§'));
        }
        return false;
    }
    
    @Override
    public Inventory getInventory() {
        return null;
    }
    
    public List<String> poison = Arrays.asList("ZOMBIE", "HUSK", "SKELETON", "STRAY", "WITHER", "WITHER_SKELETON",
            "SPIDER", "CAVE_SPIDER", "DROWNED", "LIGHTNING", "PRIMED_TNT", "ZOMBIE_VILLAGER", "PIG_ZOMBIE",
            "SKELETON_HORSE", "ZOMBIE_HORSE", "PHANTOM", "ARMOR_STAND");
    public List<String> undead = Arrays.asList("ZOMBIE", "HUSK", "SKELETON", "STRAY", "WITHER", "WITHER_SKELETON",
            "DROWNED", "ZOMBIE_VILLAGER", "PIG_ZOMBIE", "SKELETON_HORSE", "ZOMBIE_HORSE", "PHANTOM");
    
}