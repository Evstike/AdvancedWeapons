package com.gmail.evstike.AdvancedWeapons;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class WeaponGUI extends API implements CommandExecutor, Listener {
    
    Fates plugin;
    
    public WeaponGUI(Fates instance) {
        plugin = instance;
    }
    
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (hasCommandPerm(sender, cmd, commandLabel, plugin.getConfig()) == false) {
            if (cmd.getName().equalsIgnoreCase("weapons")) {
                if (sender instanceof Player) {
                    Player player = (Player) sender;
                    openGUI(player);
                    return false;
                }
                if (!(sender instanceof Player)) {
                    sender.sendMessage("§cError: §4Only Players can use this command!");
                    return true;
                }
            }
        }
        return false;
    }
    
    private void openGUI(Player player) {
        Inventory inv = Bukkit.createInventory(null, 9, "Weapons");
        
        //Items
        ItemStack comp = new ItemStack(XMaterial.RED_STAINED_GLASS_PANE.parseItem());
        ItemMeta compMeta = comp.getItemMeta();
        ItemStack un = new ItemStack(XMaterial.YELLOW_STAINED_GLASS_PANE.parseItem());
        ItemMeta unMeta = un.getItemMeta();
        ItemStack dest = new ItemStack(XMaterial.DIAMOND_SWORD.parseMaterial());
        ItemMeta destMeta = dest.getItemMeta();
        ItemStack slay = new ItemStack(XMaterial.DIAMOND_AXE.parseMaterial());
        ItemMeta slayMeta = slay.getItemMeta();
        ItemStack drop = new ItemStack(XMaterial.STICK.parseMaterial());
        ItemMeta dropMeta = drop.getItemMeta();
        ItemStack rod = new ItemStack(XMaterial.BLAZE_ROD.parseMaterial());
        ItemMeta rodMeta = rod.getItemMeta();
        ItemStack bo = new ItemStack(XMaterial.BONE.parseMaterial());
        ItemMeta boMeta = bo.getItemMeta();
        ItemStack snow = new ItemStack(XMaterial.SNOWBALL.parseMaterial());
        ItemMeta snowMeta = snow.getItemMeta();
        ItemStack lead = new ItemStack(XMaterial.LEAD.parseMaterial());
        ItemMeta leadMeta = snow.getItemMeta();
        ItemStack custom = new ItemStack(XMaterial.CHEST.parseMaterial());
        ItemMeta customMeta = custom.getItemMeta();
        
        //Item Meta
        List<String> Lore0 = new ArrayList<String>();
        compMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "INCOMPATIBLE");
        Lore0.add("");
        Lore0.add("§cThis item is not compatible");
        Lore0.add("§cwith your server version.");
        Lore0.add("§aIt is recommended to update to a newer");
        Lore0.add("§aversion for full compatibility.");
        Lore0.add("");
        compMeta.setLore(Lore0);
        comp.setItemMeta(compMeta);
        
        List<String> Lores = new ArrayList<String>();
        unMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "COMING SOON");
        Lores.add("");
        Lores.add("§cThis item has not");
        Lores.add("§cbeen released yet.");
        Lores.add("§7It will be available");
        Lores.add("§7in a future update.");
        Lores.add("");
        unMeta.setLore(Lores);
        un.setItemMeta(unMeta);
        
        List<String> Lore = new ArrayList<String>();
        destMeta.setDisplayName(ChatColor.RED + "The Destroyer");
        int num = plugin.getConfig().getInt(ChatColor.stripColor("weapon." +
                destMeta.getDisplayName().toLowerCase().replace(" ", "-") + ".cost"));
        destMeta.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
        destMeta.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
        Lore.add("§7Rush I");
        Lore.add("");
        Lore.add("§7This sword from the infernal");
        Lore.add("§7depths emits fire when swung.");
        Lore.add("");
        Lore.add("§b" + num + "x " + "§7DUST");
        destMeta.setLore(Lore);
        dest.setItemMeta(destMeta);
        
        List<String> Lore2 = new ArrayList<String>();
        slayMeta.setDisplayName(ChatColor.RED + "The Slayer");
        int num2 = plugin.getConfig().getInt(ChatColor.stripColor("weapon." +
                slayMeta.getDisplayName().toLowerCase().replace(" ", "-") + ".cost"));
        slayMeta.addEnchant(Enchantment.DAMAGE_UNDEAD, 3, true);
        slayMeta.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
        Lore2.add("§7Butcher II");
        Lore2.add("");
        Lore2.add("§7This deadly axe is rumoured");
        Lore2.add("§7to heal its user at low health");
        Lore2.add("§7in exchange for durability.");
        Lore2.add("");
        Lore2.add("§b" + num2 + "x " + "§7DUST");
        slayMeta.setLore(Lore2);
        slay.setItemMeta(slayMeta);
        
        List<String> Lore3 = new ArrayList<String>();
        dropMeta.setDisplayName(ChatColor.RED + "The Dropper");
        int num3 = plugin.getConfig().getInt(ChatColor.stripColor("weapon." +
                dropMeta.getDisplayName().toLowerCase().replace(" ", "-") + ".cost"));
        Lore3.add("");
        Lore3.add("§7This silly stick drops levitating");
        Lore3.add("§7bullets while its user is crouching.");
        Lore3.add("§75 ammo");
        Lore3.add("");
        Lore3.add("§b" + num3 + "x " + "§7DUST");
        dropMeta.setLore(Lore3);
        drop.setItemMeta(dropMeta);
        
        List<String> Lore4 = new ArrayList<String>();
        rodMeta.setDisplayName(ChatColor.RED + "Fireball Launcher");
        int num4 = plugin.getConfig().getInt(ChatColor.stripColor("weapon." +
                rodMeta.getDisplayName().toLowerCase().replace(" ", "-") + ".cost"));
        Lore4.add("");
        Lore4.add("§7This rod of flames shoots fireballs");
        Lore4.add("§7while its user is crouching.");
        Lore4.add("§75 ammo");
        Lore4.add("");
        Lore4.add("§b" + num4 + "x " + "§7DUST");
        rodMeta.setLore(Lore4);
        rod.setItemMeta(rodMeta);
        
        List<String> Lore5 = new ArrayList<String>();
        boMeta.setDisplayName(ChatColor.RED + "The Skeletal Sword");
        int num5 = plugin.getConfig().getInt(ChatColor.stripColor("weapon." +
                boMeta.getDisplayName().toLowerCase().replace(" ", "-") + ".cost"));
        Lore5.add("");
        Lore5.add("§7This fragile sword summons something");
        Lore5.add("§7spooky when a soul is offered.");
        Lore5.add("§75 ammo");
        Lore5.add("");
        Lore5.add("§b" + num5 + "x " + "§7DUST");
        boMeta.setLore(Lore5);
        bo.setItemMeta(boMeta);
        
        List<String> Lore6 = new ArrayList<String>();
        snowMeta.setDisplayName(ChatColor.RED + "Ice Chunk");
        int num6 = plugin.getConfig().getInt(ChatColor.stripColor("weapon." +
                snowMeta.getDisplayName().toLowerCase().replace(" ", "-") + ".cost"));
        Lore6.add("");
        Lore6.add("§7This frozen chunk of ice");
        Lore6.add("§7freezes those who are hit by it.");
        Lore6.add("§76 ammo");
        Lore6.add("");
        Lore6.add("§b" + num6 + "x " + "§7DUST");
        snowMeta.setLore(Lore6);
        snow.setItemMeta(snowMeta);
        
        List<String> Lore7 = new ArrayList<String>();
        leadMeta.setDisplayName(ChatColor.RED + "Spirit Leash");
        int num7 = plugin.getConfig().getInt(ChatColor.stripColor("weapon." +
                leadMeta.getDisplayName().toLowerCase().replace(" ", "-") + ".cost"));
        Lore7.add("");
        Lore7.add("§7This rope binds the spirit of its target");
        Lore7.add("§7and brings them to its user.");
        Lore7.add("§73 ammo");
        Lore7.add("");
        Lore7.add("§b" + num7 + "x " + "§7DUST");
        leadMeta.setLore(Lore7);
        lead.setItemMeta(leadMeta);
        
        List<String> LoreF = new ArrayList<String>();
        customMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "More Weapons");
        LoreF.add("§7Check out additional weapons");
        LoreF.add("§7not from AdvancedWeapons.");
        if (player.hasPermission("advancedweapons.admin")) {
            LoreF.add("§aAdd weapons with §b/advancedweapons config");
        }
        customMeta.setLore(LoreF);
        custom.setItemMeta(customMeta);
        
        //Inventory set
        inv.setItem(0, dest);
        inv.setItem(1, slay);
        if (serverIs19()) {
            inv.setItem(2, drop);
        }
        if (!serverIs19()) {
            inv.setItem(2, comp);
        }
        
        inv.setItem(3, rod);
        inv.setItem(4, bo);
        inv.setItem(5, snow);
        if (serverIs111()) {
            inv.setItem(6, lead);
        }
        if (!serverIs111()) {
            inv.setItem(6, comp);
        }
        inv.setItem(7, un);
        
        inv.setItem(8, custom);
        
        player.openInventory(inv);
        
    }
    
    
    @SuppressWarnings({"incomplete-switch"})
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!ChatColor.stripColor(event.getView().getTitle())
                .equalsIgnoreCase("Weapons") && !ChatColor.stripColor(event.getView().getTitle())
                .equalsIgnoreCase("More Weapons"))
            return;
        Player player = (Player) event.getWhoClicked();
        if (event.getInventory().getHolder()==null) {
            event.setCancelled(true);
            
            
            if (event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR || !event.getCurrentItem().hasItemMeta()) {
                
                return;
            }
            ItemStack back = new ItemStack(XMaterial.ARROW.parseItem());
            ItemMeta backMeta = back.getItemMeta();
            backMeta.setDisplayName(ChatColor.GREEN + "Back");
            
            List<String> Lores = new ArrayList<String>();
            Lores.add("§7Go back to the weapons menu");
            Lores.add("");
            backMeta.setLore(Lores);
            back.setItemMeta(backMeta);
            Lores.clear();
            
            String s = plugin.getConfig().getString("insufficient-space-msg");
            
            ItemStack glow = dust(plugin.getConfig().getStringList("dust-item")).clone();
            
            if (event.getClickedInventory().getType().equals(InventoryType.CHEST)) {
                if (ChatColor.stripColor(event.getView().getTitle()).equalsIgnoreCase("Weapons")) {
                    switch (XMaterial.matchXMaterial(event.getCurrentItem())) {
                        case DIAMOND_SWORD:
                            
                            try {
                                
                                List<String> Lore = new ArrayList<String>();
                                ItemStack dest = new ItemStack(XMaterial.DIAMOND_SWORD.parseMaterial(), 1);
                                ItemMeta destMeta = dest.getItemMeta();
                                destMeta.setDisplayName(ChatColor.RED + "The Destroyer");
                                Lore.add("§7Rush I");
                                destMeta.setLore(Lore);
                                dest.setItemMeta(destMeta);
                                int num = plugin.getConfig().getInt(ChatColor.stripColor("weapon." +
                                        destMeta.getDisplayName().toLowerCase().replace(" ", "-") + ".cost"));
                                glow.setAmount(num);
                                
                                if (player.getInventory().containsAtLeast(glow, num)) {
                                    player.getInventory().removeItem(glow);
                                    dest.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 3);
                                    dest.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
                                    hasAvaliableSlot(player, dest, s);
                                    return;
                                    
                                } else {
                                    player.sendMessage(plugin.getConfig().getString("insufficient-dust-msg").replace('&', '§'));
                                }
                                
                            } catch (Exception ignored) {
                                player.closeInventory();
                                return;
                            }
                    }
                    switch (XMaterial.matchXMaterial(event.getCurrentItem())) {
                        case DIAMOND_AXE:
                            
                            try {
                                
                                List<String> Lore = new ArrayList<String>();
                                ItemStack slay = new ItemStack(XMaterial.DIAMOND_AXE.parseMaterial(), 1);
                                ItemMeta slayMeta = slay.getItemMeta();
                                slayMeta.setDisplayName(ChatColor.RED + "The Slayer");
                                Lore.add("§7Butcher II");
                                slayMeta.setLore(Lore);
                                slay.setItemMeta(slayMeta);
                                int num = plugin.getConfig().getInt(ChatColor.stripColor("weapon." +
                                        slayMeta.getDisplayName().toLowerCase().replace(" ", "-") + ".cost"));
                                glow.setAmount(num);
                                
                                if (player.getInventory().containsAtLeast(glow, num)) {
                                    player.getInventory().removeItem(glow);
                                    slay.addUnsafeEnchantment(Enchantment.DAMAGE_UNDEAD, 3);
                                    slay.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
                                    hasAvaliableSlot(player, slay, s);
                                    return;
                                } else {
                                    player.sendMessage(plugin.getConfig().getString("insufficient-dust-msg").replace('&', '§'));
                                }
                                
                            } catch (Exception ignored) {
                                player.closeInventory();
                                return;
                            }
                    }
                    switch (XMaterial.matchXMaterial(event.getCurrentItem())) {
                        case STICK:
                            
                            try {
                                
                                List<String> Lore3 = new ArrayList<String>();
                                ItemStack sig = new ItemStack(XMaterial.STICK.parseMaterial(), 1);
                                ItemMeta sigMeta = sig.getItemMeta();
                                sigMeta.setDisplayName(ChatColor.RED + "The Dropper");
                                Lore3.add("§75");
                                sigMeta.setLore(Lore3);
                                sig.setItemMeta(sigMeta);
                                int num = plugin.getConfig().getInt(ChatColor.stripColor("weapon." +
                                        sigMeta.getDisplayName().toLowerCase().replace(" ", "-") + ".cost"));
                                glow.setAmount(num);
                                
                                if (player.getInventory().containsAtLeast(glow, num)) {
                                    player.getInventory().removeItem(glow);
                                    hasAvaliableSlot(player, sig, s);
                                    return;
                                    
                                } else {
                                    player.sendMessage(plugin.getConfig().getString("insufficient-dust-msg").replace('&', '§'));
                                }
                                
                            } catch (Exception ignored) {
                                player.closeInventory();
                                return;
                            }
                    }
                    switch (XMaterial.matchXMaterial(event.getCurrentItem())) {
                        case BLAZE_ROD:
                            
                            try {
                                
                                List<String> Lore4 = new ArrayList<String>();
                                ItemStack rod = new ItemStack(XMaterial.BLAZE_ROD.parseMaterial(), 1);
                                ItemMeta rodMeta = rod.getItemMeta();
                                rodMeta.setDisplayName(ChatColor.RED + "Fireball Launcher");
                                Lore4.add("§75");
                                rodMeta.setLore(Lore4);
                                rod.setItemMeta(rodMeta);
                                int num = plugin.getConfig().getInt(ChatColor.stripColor("weapon." +
                                        rodMeta.getDisplayName().toLowerCase().replace(" ", "-") + ".cost"));
                                glow.setAmount(num);
                                
                                if (player.getInventory().containsAtLeast(glow, num)) {
                                    player.getInventory().removeItem(glow);
                                    hasAvaliableSlot(player, rod, s);
                                    return;
                                    
                                } else {
                                    player.sendMessage(plugin.getConfig().getString("insufficient-dust-msg").replace('&', '§'));
                                    
                                    //Fireball Shooter
                                    //if(i == Material.BLAZE_ROD){
                                    //Location loc = p.getEyeLocation().toVector().add(p.getLocation().getDirection().multiply(2)).toLocation(p.getWorld(), p.getLocation().getYaw(), p.getLocation().getPitch());
                                    //Fireball fireball = p.getWorld().spawn(loc, Fireball.class);
                                    //fireball.setIsIncendiary(false);
                                    //fireball.setFireTicks(0);
                                    //p.getInventory().removeItem(new ItemStack(Material.BLAZE_ROD));
                                    //ActionBarAPI.sendActionBar(p,"**§6§lFIREBALL§f**", 40);
                                }
                                
                            } catch (Exception ignored) {
                                player.closeInventory();
                                return;
                            }
                    }
                    switch (XMaterial.matchXMaterial(event.getCurrentItem())) {
                        case BONE:
                            
                            try {
                                
                                List<String> Lore5 = new ArrayList<String>();
                                ItemStack bo = new ItemStack(XMaterial.BONE.parseMaterial(), 1);
                                ItemMeta boMeta = bo.getItemMeta();
                                boMeta.setDisplayName(ChatColor.RED + "The Skeletal Sword");
                                Lore5.add("§75");
                                boMeta.setLore(Lore5);
                                bo.setItemMeta(boMeta);
                                int num = plugin.getConfig().getInt(ChatColor.stripColor("weapon." +
                                        boMeta.getDisplayName().toLowerCase().replace(" ", "-") + ".cost"));
                                glow.setAmount(num);
                                
                                if (player.getInventory().containsAtLeast(glow, num)) {
                                    player.getInventory().removeItem(glow);
                                    hasAvaliableSlot(player, bo, s);
                                    return;
                                } else {
                                    player.sendMessage(plugin.getConfig().getString("insufficient-dust-msg").replace('&', '§'));
                                }
                                
                            } catch (Exception ignored) {
                                player.closeInventory();
                                return;
                            }
                    }
                    switch (XMaterial.matchXMaterial(event.getCurrentItem())) {
                        case SNOWBALL:
                            
                            try {
                                List<String> Lore6 = new ArrayList<String>();
                                ItemStack snow = new ItemStack(XMaterial.SNOWBALL.parseMaterial(), 6);
                                ItemMeta snowMeta = snow.getItemMeta();
                                snowMeta.setDisplayName(ChatColor.RED + "Ice Chunk");
                                snowMeta.setLore(Lore6);
                                snow.setItemMeta(snowMeta);
                                int num = plugin.getConfig().getInt(ChatColor.stripColor("weapon." +
                                        snowMeta.getDisplayName().toLowerCase().replace(" ", "-") + ".cost"));
                                glow.setAmount(num);
                                
                                if (player.getInventory().containsAtLeast(glow, num)) {
                                    player.getInventory().removeItem(glow);
                                    hasAvaliableSlot(player, snow, s);
                                    return;
                                } else {
                                    player.sendMessage(plugin.getConfig().getString("insufficient-dust-msg").replace('&', '§'));
                                }
                                
                            } catch (Exception ignored) {
                                player.closeInventory();
                                return;
                            }
                    }
                    switch (XMaterial.matchXMaterial(event.getCurrentItem())) {
                        case LEAD:
                            
                            try {
                                List<String> Lore7 = new ArrayList<String>();
                                ItemStack lead = new ItemStack(XMaterial.LEAD.parseMaterial(), 1);
                                ItemMeta leadMeta = lead.getItemMeta();
                                leadMeta.setDisplayName(ChatColor.RED + "Spirit Leash");
                                Lore7.add("§73");
                                leadMeta.setLore(Lore7);
                                lead.setItemMeta(leadMeta);
                                int num = plugin.getConfig().getInt(ChatColor.stripColor("weapon." +
                                        leadMeta.getDisplayName().toLowerCase().replace(" ", "-") + ".cost"));
                                glow.setAmount(num);
                                
                                if (player.getInventory().containsAtLeast(glow, num)) {
                                    player.getInventory().removeItem(glow);
                                    hasAvaliableSlot(player, lead, s);
                                    return;
                                } else {
                                    player.sendMessage(plugin.getConfig().getString("insufficient-dust-msg").replace('&', '§'));
                                }
                                
                            } catch (Exception ignored) {
                                player.closeInventory();
                                return;
                            }
                    }
                    switch (XMaterial.matchXMaterial(event.getCurrentItem())) {
                        case CHEST:
                            File wname = plugin.createFile("customweapons.yml");
                            FileConfiguration wconfig = plugin.createYamlFile(wname);
                            
                            Inventory inv8 = Bukkit.createInventory(null, 27, "More Weapons");
                            inv8.setItem(22, back);
                            
                            for (String key : wconfig.getKeys(false)) {
                                ConfigurationSection item = wconfig.getConfigurationSection(key);
                                
                                ItemStack m = item.getItemStack("item");
                                ItemMeta mMeta = m.getItemMeta();
                                List<String> Lore2 = new ArrayList<String>();
                                if (mMeta.hasLore()) {
                                    Lore2.addAll(mMeta.getLore());
                                }
                                Lore2.add(ChatColor.GRAY + item.getString("cost") + "x DUST");
                                mMeta.setLore(Lore2);
                                m.setItemMeta(mMeta);
                                Lore2.clear();
                                int e = Integer.parseInt(key);
                                if (e < 9) {
                                    inv8.setItem(e, m);
                                }
                                if (Integer.parseInt(key) >= 9) {
                                    int f = e - 9;
                                    inv8.setItem(f, m);
                                }
                            }
                            player.openInventory(inv8);
                    }
                }
                if (ChatColor.stripColor(event.getView().getTitle()).equalsIgnoreCase("More Weapons")) {
                    if (!event.getCurrentItem().isSimilar(back)) {
                        ItemStack i = event.getCurrentItem().clone();
                        ItemMeta iMeta = i.getItemMeta();
                        List<String> Lore = new ArrayList<String>();
                        if (iMeta.hasLore()) {
                            Lore.addAll(iMeta.getLore());
                        }
                        int e = Lore.size() - 1;
                        String s0 = Lore.get(e);
                        String s1 = s0.replace("§7", "");
                        String s2 = s1.replace("x DUST", "");
                        int f = Integer.parseInt(s2);
                        Lore.remove(e);
                        iMeta.setLore(Lore);
                        i.setItemMeta(iMeta);
                        glow.setAmount(f);
                        
                        if (player.getInventory().containsAtLeast(glow, f)) {
                            player.getInventory().removeItem(glow);
                            hasAvaliableSlot(player, i, s);
                            
                        } else {
                            player.sendMessage(plugin.getConfig().getString("insufficient-dust-msg").replace('&', '§'));
                        }
                    }
                    switch (XMaterial.matchXMaterial(event.getCurrentItem())) {
                        case ARROW:
                            openGUI(player);
                            break;
                    }
                    
                }
            }
        }
    }
}
			 								



	

