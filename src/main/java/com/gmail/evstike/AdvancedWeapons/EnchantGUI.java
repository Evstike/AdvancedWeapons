package com.gmail.evstike.AdvancedWeapons;

import com.google.common.collect.Lists;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SuppressWarnings("deprecation")
public class EnchantGUI extends API implements CommandExecutor, Listener, TabCompleter {
    
    Fates plugin;
    
    public EnchantGUI(Fates instance) {
        plugin = instance;
    }
    
    public static int num;
    public boolean b = false;
    
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (hasCommandPerm(sender, cmd, commandLabel, plugin.getConfig()) == false) {
            if (cmd.getName().equalsIgnoreCase("enchgui")) {
                if (sender instanceof Player) {
                    Player player = (Player) sender;
                    if (args.length != 2) {
                        player.sendMessage("§cError: §4/" + commandLabel + " [level] [safe/unsafe].");
                        return false;
                    }
                    if (args.length == 2) {
                        if (!isInt(args[0])) {
                            player.sendMessage("§cError: §4Please specify an enchantment level.");
                            return false;
                        }
                    }
                    if (args.length == 2) {
                        if (!(args[1].equalsIgnoreCase("safe") || args[1].equalsIgnoreCase("unsafe"))) {
                            player.sendMessage("§cError: §4/" + commandLabel + " [level] [safe/unsafe].");
                            return false;
                        }
                    }
                    if (args.length == 2) {
                        if (isInt(args[0]) && args[1].equalsIgnoreCase("safe")) {
                            
                            num = Integer.parseInt(args[0]);
                            openGUI(player);
                            return false;
                        }
                    }
                    if (args.length == 2) {
                        if (isInt(args[0]) && args[1].equalsIgnoreCase("unsafe")) {
                            
                            num = Integer.parseInt(args[0]);
                            openUnsafeGUI(player);
                            return false;
                        }
                    }
                }
            }
            if (!(sender instanceof Player)) {
                sender.sendMessage("§cError: §4Only Players can use this command!");
                return true;
            }
        }
        return false;
    }
    
    //SAFE
    private void openGUI(Player player) {
        Inventory inv = Bukkit.createInventory(null, 54, "Enchantment Menu");
        
        ItemStack i = player.getInventory().getItemInHand();
        
        if (i == null || i.getType() == Material.AIR) {
        } else {
            //SHARPNESS
            ItemStack sharp = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta sharpMeta = sharp.getItemMeta();
            sharpMeta.setDisplayName(ChatColor.YELLOW + "Sharpness §7(" + num + ")");
            sharpMeta.addEnchant(Enchantment.DAMAGE_ALL, num, true);
            sharp.setItemMeta(sharpMeta);
            
            if (num >= Enchantment.DAMAGE_ALL.getStartLevel()) {
                if (num <= Enchantment.DAMAGE_ALL.getMaxLevel()) {
                    if (Enchantment.DAMAGE_ALL.canEnchantItem(i)) {
                        inv.addItem(sharp);
                    }
                }
            }
            //SMITE
            ItemStack smite = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta smiteMeta = smite.getItemMeta();
            smiteMeta.setDisplayName(ChatColor.YELLOW + "Smite §7(" + num + ")");
            smiteMeta.addEnchant(Enchantment.DAMAGE_UNDEAD, num, true);
            smite.setItemMeta(smiteMeta);
            
            if (num >= Enchantment.DAMAGE_UNDEAD.getStartLevel()) {
                if (num <= Enchantment.DAMAGE_UNDEAD.getMaxLevel()) {
                    if (Enchantment.DAMAGE_UNDEAD.canEnchantItem(i)) {
                        inv.addItem(smite);
                    }
                }
            }
            //BANE OF ARTHROPODS
            ItemStack bane = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta baneMeta = bane.getItemMeta();
            baneMeta.setDisplayName(ChatColor.YELLOW + "Bane of Arthropods §7(" + num + ")");
            baneMeta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, num, true);
            bane.setItemMeta(baneMeta);
            
            if (num >= Enchantment.DAMAGE_ARTHROPODS.getStartLevel()) {
                if (num <= Enchantment.DAMAGE_ARTHROPODS.getMaxLevel()) {
                    if (Enchantment.DAMAGE_ARTHROPODS.canEnchantItem(i)) {
                        inv.addItem(bane);
                    }
                }
            }
            //KNOCKBACK
            ItemStack knock = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta knockMeta = knock.getItemMeta();
            knockMeta.setDisplayName(ChatColor.YELLOW + "Knockback §7(" + num + ")");
            knockMeta.addEnchant(Enchantment.KNOCKBACK, num, true);
            knock.setItemMeta(knockMeta);
            
            if (num >= Enchantment.KNOCKBACK.getStartLevel()) {
                if (num <= Enchantment.KNOCKBACK.getMaxLevel()) {
                    if (Enchantment.KNOCKBACK.canEnchantItem(i)) {
                        inv.addItem(knock);
                    }
                }
            }
            //FIRE ASPECT
            ItemStack fire = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta fireMeta = fire.getItemMeta();
            fireMeta.setDisplayName(ChatColor.YELLOW + "Fire Aspect §7(" + num + ")");
            fireMeta.addEnchant(Enchantment.FIRE_ASPECT, num, true);
            fire.setItemMeta(fireMeta);
            
            if (num >= Enchantment.FIRE_ASPECT.getStartLevel()) {
                if (num <= Enchantment.FIRE_ASPECT.getMaxLevel()) {
                    if (Enchantment.FIRE_ASPECT.canEnchantItem(i)) {
                        inv.addItem(fire);
                    }
                }
            }
            //SWEEPING EDGE
            ItemStack sweep = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta sweepMeta = sweep.getItemMeta();
            sweepMeta.setDisplayName(ChatColor.YELLOW + "Sweeping Edge §7(" + num + ")");
            sweepMeta.addEnchant(Enchantment.SWEEPING_EDGE, num, true);
            sweep.setItemMeta(sweepMeta);
            
            
            if (num >= Enchantment.SWEEPING_EDGE.getStartLevel()) {
                if (num <= Enchantment.SWEEPING_EDGE.getMaxLevel()) {
                    if (Enchantment.SWEEPING_EDGE.canEnchantItem(i)) {
                        inv.addItem(sweep);
                    }
                }
            }
            //LOOTING
            ItemStack loot = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta lootMeta = loot.getItemMeta();
            lootMeta.setDisplayName(ChatColor.YELLOW + "Looting §7(" + num + ")");
            lootMeta.addEnchant(Enchantment.LOOT_BONUS_MOBS, num, true);
            loot.setItemMeta(lootMeta);
            
            if (num >= Enchantment.LOOT_BONUS_MOBS.getStartLevel()) {
                if (num <= Enchantment.LOOT_BONUS_MOBS.getMaxLevel()) {
                    if (Enchantment.LOOT_BONUS_MOBS.canEnchantItem(i)) {
                        inv.addItem(loot);
                    }
                }
            }
            //UNBREAKING
            ItemStack unb = new ItemStack(Material.BOOK);
            ItemMeta unbMeta = unb.getItemMeta();
            unbMeta.setDisplayName(ChatColor.YELLOW + "Unbreaking §7(" + num + ")");
            unbMeta.addEnchant(Enchantment.DURABILITY, num, true);
            unb.setItemMeta(unbMeta);
            
            if (num >= Enchantment.DURABILITY.getStartLevel()) {
                if (num <= Enchantment.DURABILITY.getMaxLevel()) {
                    if (Enchantment.DURABILITY.canEnchantItem(i)) {
                        inv.addItem(unb);
                    }
                }
            }
            //MENDING
            ItemStack mend = new ItemStack(Material.BOOK);
            ItemMeta mendMeta = mend.getItemMeta();
            mendMeta.setDisplayName(ChatColor.YELLOW + "Mending §7(" + num + ")");
            mendMeta.addEnchant(Enchantment.MENDING, num, true);
            mend.setItemMeta(mendMeta);
            
            if (num >= Enchantment.MENDING.getStartLevel()) {
                if (num <= Enchantment.MENDING.getMaxLevel()) {
                    if (Enchantment.MENDING.canEnchantItem(i)) {
                        inv.addItem(mend);
                    }
                }
            }
            //SILK TOUCH
            ItemStack silk = new ItemStack(Material.DIAMOND_PICKAXE);
            ItemMeta silkMeta = silk.getItemMeta();
            silkMeta.setDisplayName(ChatColor.YELLOW + "Silk Touch §7(" + num + ")");
            silkMeta.addEnchant(Enchantment.SILK_TOUCH, num, true);
            silk.setItemMeta(silkMeta);
            
            if (num >= Enchantment.SILK_TOUCH.getStartLevel()) {
                if (num <= Enchantment.SILK_TOUCH.getMaxLevel()) {
                    if (Enchantment.SILK_TOUCH.canEnchantItem(i)) {
                        inv.addItem(silk);
                    }
                }
            }
            //EFFICIENCY
            ItemStack eff = new ItemStack(Material.DIAMOND_PICKAXE);
            ItemMeta effMeta = eff.getItemMeta();
            effMeta.setDisplayName(ChatColor.YELLOW + "Efficiency §7(" + num + ")");
            effMeta.addEnchant(Enchantment.DIG_SPEED, num, true);
            eff.setItemMeta(effMeta);
            
            if (num >= Enchantment.DIG_SPEED.getStartLevel()) {
                if (num <= Enchantment.DIG_SPEED.getMaxLevel()) {
                    if (Enchantment.DIG_SPEED.canEnchantItem(i)) {
                        inv.addItem(eff);
                    }
                }
            }
            //FORTUNE
            ItemStack fort = new ItemStack(Material.DIAMOND_PICKAXE);
            ItemMeta fortMeta = fort.getItemMeta();
            fortMeta.setDisplayName(ChatColor.YELLOW + "Fortune §7(" + num + ")");
            fortMeta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, num, true);
            fort.setItemMeta(fortMeta);
            
            if (num >= Enchantment.LOOT_BONUS_BLOCKS.getStartLevel()) {
                if (num <= Enchantment.LOOT_BONUS_BLOCKS.getMaxLevel()) {
                    if (Enchantment.LOOT_BONUS_BLOCKS.canEnchantItem(i)) {
                        inv.addItem(fort);
                    }
                }
            }
            //POWER
            ItemStack pow = new ItemStack(Material.BOW);
            ItemMeta powMeta = pow.getItemMeta();
            powMeta.setDisplayName(ChatColor.YELLOW + "Power §7(" + num + ")");
            powMeta.addEnchant(Enchantment.ARROW_DAMAGE, num, true);
            pow.setItemMeta(powMeta);
            
            if (num >= Enchantment.ARROW_DAMAGE.getStartLevel()) {
                if (num <= Enchantment.ARROW_DAMAGE.getMaxLevel()) {
                    if (Enchantment.ARROW_DAMAGE.canEnchantItem(i)) {
                        inv.addItem(pow);
                    }
                }
            }
            //FLAME
            ItemStack flame = new ItemStack(Material.BOW);
            ItemMeta flameMeta = flame.getItemMeta();
            flameMeta.setDisplayName(ChatColor.YELLOW + "Flame §7(" + num + ")");
            flameMeta.addEnchant(Enchantment.ARROW_FIRE, num, true);
            flame.setItemMeta(flameMeta);
            
            if (num >= Enchantment.ARROW_FIRE.getStartLevel()) {
                if (num <= Enchantment.ARROW_FIRE.getMaxLevel()) {
                    if (Enchantment.ARROW_FIRE.canEnchantItem(i)) {
                        inv.addItem(flame);
                    }
                }
            }
            //PUNCH
            ItemStack pun = new ItemStack(Material.BOW);
            ItemMeta punMeta = pun.getItemMeta();
            punMeta.setDisplayName(ChatColor.YELLOW + "Punch §7(" + num + ")");
            punMeta.addEnchant(Enchantment.ARROW_KNOCKBACK, num, true);
            pun.setItemMeta(punMeta);
            
            if (num >= Enchantment.ARROW_KNOCKBACK.getStartLevel()) {
                if (num <= Enchantment.ARROW_KNOCKBACK.getMaxLevel()) {
                    if (Enchantment.ARROW_KNOCKBACK.canEnchantItem(i)) {
                        inv.addItem(pun);
                    }
                }
            }
            //INFINITY
            ItemStack inf = new ItemStack(Material.BOW);
            ItemMeta infMeta = inf.getItemMeta();
            infMeta.setDisplayName(ChatColor.YELLOW + "Infinity §7(" + num + ")");
            infMeta.addEnchant(Enchantment.ARROW_INFINITE, num, true);
            inf.setItemMeta(infMeta);
            
            if (num >= Enchantment.ARROW_INFINITE.getStartLevel()) {
                if (num <= Enchantment.ARROW_INFINITE.getMaxLevel()) {
                    if (Enchantment.ARROW_INFINITE.canEnchantItem(i)) {
                        inv.addItem(inf);
                    }
                }
            }
            //PIERCING
            ItemStack pie = new ItemStack(Material.CROSSBOW);
            ItemMeta pieMeta = pie.getItemMeta();
            pieMeta.setDisplayName(ChatColor.YELLOW + "Piercing §7(" + num + ")");
            pieMeta.addEnchant(Enchantment.PIERCING, num, true);
            pie.setItemMeta(pieMeta);
            
            if (num >= Enchantment.PIERCING.getStartLevel()) {
                if (num <= Enchantment.PIERCING.getMaxLevel()) {
                    if (Enchantment.PIERCING.canEnchantItem(i)) {
                        inv.addItem(pie);
                    }
                }
            }
            //QUICKFIRE
            ItemStack qui = new ItemStack(Material.CROSSBOW);
            ItemMeta quiMeta = qui.getItemMeta();
            quiMeta.setDisplayName(ChatColor.YELLOW + "Quick Charge §7(" + num + ")");
            quiMeta.addEnchant(Enchantment.QUICK_CHARGE, num, true);
            qui.setItemMeta(quiMeta);
            
            if (num >= Enchantment.QUICK_CHARGE.getStartLevel()) {
                if (num <= Enchantment.QUICK_CHARGE.getMaxLevel()) {
                    if (Enchantment.QUICK_CHARGE.canEnchantItem(i)) {
                        inv.addItem(qui);
                    }
                }
            }
            //MULTISHOT
            ItemStack mul = new ItemStack(Material.CROSSBOW);
            ItemMeta mulMeta = mul.getItemMeta();
            mulMeta.setDisplayName(ChatColor.YELLOW + "Multishot §7(" + num + ")");
            mulMeta.addEnchant(Enchantment.MULTISHOT, num, true);
            mul.setItemMeta(mulMeta);
            
            if (num >= Enchantment.MULTISHOT.getStartLevel()) {
                if (num <= Enchantment.MULTISHOT.getMaxLevel()) {
                    if (Enchantment.MULTISHOT.canEnchantItem(i)) {
                        inv.addItem(mul);
                    }
                }
            }
            //AQUA AFFINITY
            ItemStack aff = new ItemStack(Material.DIAMOND_HELMET);
            ItemMeta affMeta = aff.getItemMeta();
            affMeta.setDisplayName(ChatColor.YELLOW + "Aqua Affinity §7(" + num + ")");
            affMeta.addEnchant(Enchantment.WATER_WORKER, num, true);
            aff.setItemMeta(affMeta);
            
            if (num >= Enchantment.WATER_WORKER.getStartLevel()) {
                if (num <= Enchantment.WATER_WORKER.getMaxLevel()) {
                    if (Enchantment.WATER_WORKER.canEnchantItem(i)) {
                        inv.addItem(aff);
                    }
                }
            }
            //RESPIRATION
            ItemStack resp = new ItemStack(Material.DIAMOND_HELMET);
            ItemMeta respMeta = resp.getItemMeta();
            respMeta.setDisplayName(ChatColor.YELLOW + "Respiration §7(" + num + ")");
            respMeta.addEnchant(Enchantment.OXYGEN, num, true);
            resp.setItemMeta(respMeta);
            
            if (num >= Enchantment.OXYGEN.getStartLevel()) {
                if (num <= Enchantment.OXYGEN.getMaxLevel()) {
                    if (Enchantment.OXYGEN.canEnchantItem(i)) {
                        inv.addItem(resp);
                    }
                }
            }
            //PROTECTION
            ItemStack prot = new ItemStack(Material.DIAMOND_CHESTPLATE);
            ItemMeta protMeta = prot.getItemMeta();
            protMeta.setDisplayName(ChatColor.YELLOW + "Protection §7(" + num + ")");
            protMeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, num, true);
            prot.setItemMeta(protMeta);
            
            if (num >= Enchantment.PROTECTION_ENVIRONMENTAL.getStartLevel()) {
                if (num <= Enchantment.PROTECTION_ENVIRONMENTAL.getMaxLevel()) {
                    if (Enchantment.PROTECTION_ENVIRONMENTAL.canEnchantItem(i)) {
                        inv.addItem(prot);
                    }
                }
            }
            //BLAST PROTECTION
            ItemStack bprot = new ItemStack(Material.DIAMOND_CHESTPLATE);
            ItemMeta bprotMeta = bprot.getItemMeta();
            bprotMeta.setDisplayName(ChatColor.YELLOW + "Blast Protection §7(" + num + ")");
            bprotMeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, num, true);
            bprot.setItemMeta(bprotMeta);
            
            if (num >= Enchantment.PROTECTION_EXPLOSIONS.getStartLevel()) {
                if (num <= Enchantment.PROTECTION_EXPLOSIONS.getMaxLevel()) {
                    if (Enchantment.PROTECTION_EXPLOSIONS.canEnchantItem(i)) {
                        inv.addItem(bprot);
                    }
                }
            }
            //FIRE PROTECTION
            ItemStack fprot = new ItemStack(Material.DIAMOND_CHESTPLATE);
            ItemMeta fprotMeta = fprot.getItemMeta();
            fprotMeta.setDisplayName(ChatColor.YELLOW + "Fire Protection §7(" + num + ")");
            fprotMeta.addEnchant(Enchantment.PROTECTION_FIRE, num, true);
            fprot.setItemMeta(fprotMeta);
            
            if (num >= Enchantment.PROTECTION_FIRE.getStartLevel()) {
                if (num <= Enchantment.PROTECTION_FIRE.getMaxLevel()) {
                    if (Enchantment.PROTECTION_FIRE.canEnchantItem(i)) {
                        inv.addItem(fprot);
                    }
                }
            }
            //PROJECTILE PROTECTION
            ItemStack proj = new ItemStack(Material.DIAMOND_CHESTPLATE);
            ItemMeta projMeta = proj.getItemMeta();
            projMeta.setDisplayName(ChatColor.YELLOW + "Projectile Protection §7(" + num + ")");
            projMeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, num, true);
            proj.setItemMeta(projMeta);
            
            if (num >= Enchantment.PROTECTION_PROJECTILE.getStartLevel()) {
                if (num <= Enchantment.PROTECTION_PROJECTILE.getMaxLevel()) {
                    if (Enchantment.PROTECTION_PROJECTILE.canEnchantItem(i)) {
                        inv.addItem(proj);
                    }
                }
            }
            //FEATHER FALLING
            ItemStack fall = new ItemStack(Material.DIAMOND_BOOTS);
            ItemMeta fallMeta = fall.getItemMeta();
            fallMeta.setDisplayName(ChatColor.YELLOW + "Feather Falling §7(" + num + ")");
            fallMeta.addEnchant(Enchantment.PROTECTION_FALL, num, true);
            fall.setItemMeta(fallMeta);
            
            if (num >= Enchantment.PROTECTION_FALL.getStartLevel()) {
                if (num <= Enchantment.PROTECTION_FALL.getMaxLevel()) {
                    if (Enchantment.PROTECTION_FALL.canEnchantItem(i)) {
                        inv.addItem(fall);
                    }
                }
            }
            //THORNS
            ItemStack thorns = new ItemStack(Material.DIAMOND_BOOTS);
            ItemMeta thornsMeta = thorns.getItemMeta();
            thornsMeta.setDisplayName(ChatColor.YELLOW + "Thorns §7(" + num + ")");
            thornsMeta.addEnchant(Enchantment.THORNS, num, true);
            thorns.setItemMeta(thornsMeta);
            
            if (num >= Enchantment.THORNS.getStartLevel()) {
                if (num <= Enchantment.THORNS.getMaxLevel()) {
                    if (Enchantment.THORNS.canEnchantItem(i)) {
                        inv.addItem(thorns);
                    }
                }
            }
            //DEPTH STRIDER
            ItemStack str = new ItemStack(Material.DIAMOND_BOOTS);
            ItemMeta strMeta = str.getItemMeta();
            strMeta.setDisplayName(ChatColor.YELLOW + "Depth Strider §7(" + num + ")");
            strMeta.addEnchant(Enchantment.DEPTH_STRIDER, num, true);
            str.setItemMeta(strMeta);
            
            
            if (num >= Enchantment.DEPTH_STRIDER.getStartLevel()) {
                if (num <= Enchantment.DEPTH_STRIDER.getMaxLevel()) {
                    if (Enchantment.DEPTH_STRIDER.canEnchantItem(i)) {
                        inv.addItem(str);
                    }
                }
            }
            //FROST WALKER
            ItemStack fro = new ItemStack(Material.DIAMOND_BOOTS);
            ItemMeta froMeta = fro.getItemMeta();
            froMeta.setDisplayName(ChatColor.YELLOW + "Frost Walker §7(" + num + ")");
            froMeta.addEnchant(Enchantment.FROST_WALKER, num, true);
            fro.setItemMeta(froMeta);
            
            if (num >= Enchantment.FROST_WALKER.getStartLevel()) {
                if (num <= Enchantment.FROST_WALKER.getMaxLevel()) {
                    if (Enchantment.FROST_WALKER.canEnchantItem(i)) {
                        inv.addItem(fro);
                    }
                }
            }
            //SOUL SPEED
            ItemStack ss = new ItemStack(Material.DIAMOND_BOOTS);
            ItemMeta ssMeta = ss.getItemMeta();
            ssMeta.setDisplayName(ChatColor.YELLOW + "Soul Speed §7(" + num + ")");
            ssMeta.addEnchant(Enchantment.SOUL_SPEED, num, true);
            ss.setItemMeta(ssMeta);
            
            if (num >= Enchantment.SOUL_SPEED.getStartLevel()) {
                if (num <= Enchantment.SOUL_SPEED.getMaxLevel()) {
                    if (Enchantment.SOUL_SPEED.canEnchantItem(i)) {
                        inv.addItem(ss);
                    }
                }
            }
            //LURE
            ItemStack lure = new ItemStack(Material.FISHING_ROD);
            ItemMeta lureMeta = lure.getItemMeta();
            lureMeta.setDisplayName(ChatColor.YELLOW + "Lure §7(" + num + ")");
            lureMeta.addEnchant(Enchantment.LURE, num, true);
            lure.setItemMeta(lureMeta);
            
            if (num >= Enchantment.LURE.getStartLevel()) {
                if (num <= Enchantment.LURE.getMaxLevel()) {
                    if (Enchantment.LURE.canEnchantItem(i)) {
                        inv.addItem(lure);
                    }
                }
            }
            //LUCK OF THE SEA
            ItemStack luck = new ItemStack(Material.FISHING_ROD);
            ItemMeta luckMeta = luck.getItemMeta();
            luckMeta.setDisplayName(ChatColor.YELLOW + "Luck of the Sea §7(" + num + ")");
            luckMeta.addEnchant(Enchantment.LUCK, num, true);
            luck.setItemMeta(luckMeta);
            
            if (num >= Enchantment.LUCK.getStartLevel()) {
                if (num <= Enchantment.LUCK.getMaxLevel()) {
                    if (Enchantment.LUCK.canEnchantItem(i)) {
                        inv.addItem(luck);
                    }
                }
            }
            //CHANNELING
            ItemStack chan = new ItemStack(Material.TRIDENT);
            ItemMeta chanMeta = chan.getItemMeta();
            chanMeta.setDisplayName(ChatColor.YELLOW + "Channeling §7(" + num + ")");
            chanMeta.addEnchant(Enchantment.CHANNELING, num, true);
            chan.setItemMeta(chanMeta);
            
            if (num >= Enchantment.CHANNELING.getStartLevel()) {
                if (num <= Enchantment.CHANNELING.getMaxLevel()) {
                    if (Enchantment.CHANNELING.canEnchantItem(i)) {
                        inv.addItem(chan);
                    }
                }
            }
            //RIPTIDE
            ItemStack rip = new ItemStack(Material.TRIDENT);
            ItemMeta ripMeta = rip.getItemMeta();
            ripMeta.setDisplayName(ChatColor.YELLOW + "Riptide §7(" + num + ")");
            ripMeta.addEnchant(Enchantment.RIPTIDE, num, true);
            rip.setItemMeta(ripMeta);
            
            if (num >= Enchantment.RIPTIDE.getStartLevel()) {
                if (num <= Enchantment.RIPTIDE.getMaxLevel()) {
                    if (Enchantment.RIPTIDE.canEnchantItem(i)) {
                        inv.addItem(rip);
                    }
                }
            }
            //LOYALTY
            ItemStack loy = new ItemStack(Material.TRIDENT);
            ItemMeta loyMeta = loy.getItemMeta();
            loyMeta.setDisplayName(ChatColor.YELLOW + "Loyalty §7(" + num + ")");
            loyMeta.addEnchant(Enchantment.LOYALTY, num, true);
            loy.setItemMeta(loyMeta);
            
            if (num >= Enchantment.LOYALTY.getStartLevel()) {
                if (num <= Enchantment.LOYALTY.getMaxLevel()) {
                    if (Enchantment.LOYALTY.canEnchantItem(i)) {
                        inv.addItem(loy);
                    }
                }
            }
            //CURSE OF BINDING
            ItemStack bind = new ItemStack(Material.SLIME_BALL);
            ItemMeta bindMeta = bind.getItemMeta();
            bindMeta.setDisplayName(ChatColor.RED + "Curse of Binding §7(" + num + ")");
            bindMeta.addEnchant(Enchantment.BINDING_CURSE, num, true);
            bind.setItemMeta(bindMeta);
            
            if (num >= Enchantment.BINDING_CURSE.getStartLevel()) {
                if (num <= Enchantment.BINDING_CURSE.getMaxLevel()) {
                    if (Enchantment.BINDING_CURSE.canEnchantItem(i)) {
                        inv.addItem(bind);
                    }
                }
            }
            //CURSE OF VANISHING
            ItemStack van = new ItemStack(Material.ENDER_EYE);
            ItemMeta vanMeta = van.getItemMeta();
            vanMeta.setDisplayName(ChatColor.RED + "Curse of Vanishing §7(" + num + ")");
            vanMeta.addEnchant(Enchantment.VANISHING_CURSE, num, true);
            van.setItemMeta(vanMeta);
            
            if (num >= Enchantment.VANISHING_CURSE.getStartLevel()) {
                if (num <= Enchantment.VANISHING_CURSE.getMaxLevel()) {
                    if (Enchantment.VANISHING_CURSE.canEnchantItem(i)) {
                        inv.addItem(van);
                    }
                }
            }
        }
        
        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta closeMeta = close.getItemMeta();
        ItemStack lvl = new ItemStack(Material.EXPERIENCE_BOTTLE);
        ItemMeta lvlMeta = lvl.getItemMeta();
        
        closeMeta.setDisplayName(ChatColor.RED + "Close");
        close.setItemMeta(closeMeta);
        
        List<String> Lore = new ArrayList<String>();
        lvlMeta.setDisplayName(ChatColor.GREEN + "Enchantment Level");
        Lore.add("§7Level: " + num);
        lvlMeta.setLore(Lore);
        lvl.setItemMeta(lvlMeta);
        
        inv.setItem(49, close);
        inv.setItem(53, lvl);
        
        player.openInventory(inv);
        
    }
    
    //UNSAFE
    private void openUnsafeGUI(Player player) {
        Inventory inv = Bukkit.createInventory(null, 54, "Unsafe Enchantment Menu");
        
        //SHARPNESS
        ItemStack sharp = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta sharpMeta = sharp.getItemMeta();
        sharpMeta.setDisplayName(ChatColor.YELLOW + "Sharpness §7(" + num + ")");
        sharpMeta.addEnchant(Enchantment.DAMAGE_ALL, num, true);
        sharp.setItemMeta(sharpMeta);
        inv.addItem(sharp);
        //SMITE
        ItemStack smite = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta smiteMeta = smite.getItemMeta();
        smiteMeta.setDisplayName(ChatColor.YELLOW + "Smite §7(" + num + ")");
        smiteMeta.addEnchant(Enchantment.DAMAGE_UNDEAD, num, true);
        smite.setItemMeta(smiteMeta);
        inv.addItem(smite);
        //BANE OF ARTHROPODS
        ItemStack bane = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta baneMeta = bane.getItemMeta();
        baneMeta.setDisplayName(ChatColor.YELLOW + "Bane of Arthropods §7(" + num + ")");
        baneMeta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, num, true);
        bane.setItemMeta(baneMeta);
        inv.addItem(bane);
        //KNOCKBACK
        ItemStack knock = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta knockMeta = knock.getItemMeta();
        knockMeta.setDisplayName(ChatColor.YELLOW + "Knockback §7(" + num + ")");
        knockMeta.addEnchant(Enchantment.KNOCKBACK, num, true);
        knock.setItemMeta(knockMeta);
        inv.addItem(knock);
        //FIRE ASPECT
        ItemStack fire = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta fireMeta = fire.getItemMeta();
        fireMeta.setDisplayName(ChatColor.YELLOW + "Fire Aspect §7(" + num + ")");
        fireMeta.addEnchant(Enchantment.FIRE_ASPECT, num, true);
        fire.setItemMeta(fireMeta);
        inv.addItem(fire);
        //SWEEPING EDGE
        ItemStack sweep = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta sweepMeta = sweep.getItemMeta();
        sweepMeta.setDisplayName(ChatColor.YELLOW + "Sweeping Edge §7(" + num + ")");
        sweepMeta.addEnchant(Enchantment.SWEEPING_EDGE, num, true);
        sweep.setItemMeta(sweepMeta);
        inv.addItem(sweep);
        //LOOTING
        ItemStack loot = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta lootMeta = loot.getItemMeta();
        lootMeta.setDisplayName(ChatColor.YELLOW + "Looting §7(" + num + ")");
        lootMeta.addEnchant(Enchantment.LOOT_BONUS_MOBS, num, true);
        loot.setItemMeta(lootMeta);
        inv.addItem(loot);
        //UNBREAKING
        ItemStack unb = new ItemStack(Material.BOOK);
        ItemMeta unbMeta = unb.getItemMeta();
        unbMeta.setDisplayName(ChatColor.YELLOW + "Unbreaking §7(" + num + ")");
        unbMeta.addEnchant(Enchantment.DURABILITY, num, true);
        unb.setItemMeta(unbMeta);
        inv.addItem(unb);
        //MENDING
        ItemStack mend = new ItemStack(Material.BOOK);
        ItemMeta mendMeta = mend.getItemMeta();
        mendMeta.setDisplayName(ChatColor.YELLOW + "Mending §7(" + num + ")");
        mendMeta.addEnchant(Enchantment.MENDING, num, true);
        mend.setItemMeta(mendMeta);
        inv.addItem(mend);
        //SILK TOUCH
        ItemStack silk = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta silkMeta = silk.getItemMeta();
        silkMeta.setDisplayName(ChatColor.YELLOW + "Silk Touch §7(" + num + ")");
        silkMeta.addEnchant(Enchantment.SILK_TOUCH, num, true);
        silk.setItemMeta(silkMeta);
        inv.addItem(silk);
        //EFFICIENCY
        ItemStack eff = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta effMeta = eff.getItemMeta();
        effMeta.setDisplayName(ChatColor.YELLOW + "Efficiency §7(" + num + ")");
        effMeta.addEnchant(Enchantment.DIG_SPEED, num, true);
        eff.setItemMeta(effMeta);
        inv.addItem(eff);
        //FORTUNE
        ItemStack fort = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta fortMeta = fort.getItemMeta();
        fortMeta.setDisplayName(ChatColor.YELLOW + "Fortune §7(" + num + ")");
        fortMeta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, num, true);
        fort.setItemMeta(fortMeta);
        inv.addItem(fort);
        //POWER
        ItemStack pow = new ItemStack(Material.BOW);
        ItemMeta powMeta = pow.getItemMeta();
        powMeta.setDisplayName(ChatColor.YELLOW + "Power §7(" + num + ")");
        powMeta.addEnchant(Enchantment.ARROW_DAMAGE, num, true);
        pow.setItemMeta(powMeta);
        inv.addItem(pow);
        //FLAME
        ItemStack flame = new ItemStack(Material.BOW);
        ItemMeta flameMeta = flame.getItemMeta();
        flameMeta.setDisplayName(ChatColor.YELLOW + "Flame §7(" + num + ")");
        flameMeta.addEnchant(Enchantment.ARROW_FIRE, num, true);
        flame.setItemMeta(flameMeta);
        inv.addItem(flame);
        //PUNCH
        ItemStack pun = new ItemStack(Material.BOW);
        ItemMeta punMeta = pun.getItemMeta();
        punMeta.setDisplayName(ChatColor.YELLOW + "Punch §7(" + num + ")");
        punMeta.addEnchant(Enchantment.ARROW_KNOCKBACK, num, true);
        pun.setItemMeta(punMeta);
        inv.addItem(pun);
        //INFINITY
        ItemStack inf = new ItemStack(Material.BOW);
        ItemMeta infMeta = inf.getItemMeta();
        infMeta.setDisplayName(ChatColor.YELLOW + "Infinity §7(" + num + ")");
        infMeta.addEnchant(Enchantment.ARROW_INFINITE, num, true);
        inf.setItemMeta(infMeta);
        inv.addItem(inf);
        //PIERCING
        ItemStack pie = new ItemStack(Material.CROSSBOW);
        ItemMeta pieMeta = pie.getItemMeta();
        pieMeta.setDisplayName(ChatColor.YELLOW + "Piercing §7(" + num + ")");
        pieMeta.addEnchant(Enchantment.PIERCING, num, true);
        pie.setItemMeta(pieMeta);
        inv.addItem(pie);
        //QUICKFIRE
        ItemStack qui = new ItemStack(Material.CROSSBOW);
        ItemMeta quiMeta = qui.getItemMeta();
        quiMeta.setDisplayName(ChatColor.YELLOW + "Quick Charge §7(" + num + ")");
        quiMeta.addEnchant(Enchantment.QUICK_CHARGE, num, true);
        qui.setItemMeta(quiMeta);
        inv.addItem(qui);
        //MULTISHOT
        ItemStack mul = new ItemStack(Material.CROSSBOW);
        ItemMeta mulMeta = mul.getItemMeta();
        mulMeta.setDisplayName(ChatColor.YELLOW + "Multishot §7(" + num + ")");
        mulMeta.addEnchant(Enchantment.MULTISHOT, num, true);
        mul.setItemMeta(mulMeta);
        inv.addItem(mul);
        //AQUA AFFINITY
        ItemStack aff = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta affMeta = aff.getItemMeta();
        affMeta.setDisplayName(ChatColor.YELLOW + "Aqua Affinity §7(" + num + ")");
        affMeta.addEnchant(Enchantment.WATER_WORKER, num, true);
        aff.setItemMeta(affMeta);
        inv.addItem(aff);
        //RESPIRATION
        ItemStack resp = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta respMeta = resp.getItemMeta();
        respMeta.setDisplayName(ChatColor.YELLOW + "Respiration §7(" + num + ")");
        respMeta.addEnchant(Enchantment.OXYGEN, num, true);
        resp.setItemMeta(respMeta);
        inv.addItem(resp);
        //PROTECTION
        ItemStack prot = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta protMeta = prot.getItemMeta();
        protMeta.setDisplayName(ChatColor.YELLOW + "Protection §7(" + num + ")");
        protMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, num, true);
        prot.setItemMeta(protMeta);
        inv.addItem(prot);
        //BLAST PROTECTION
        ItemStack bprot = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta bprotMeta = bprot.getItemMeta();
        bprotMeta.setDisplayName(ChatColor.YELLOW + "Blast Protection §7(" + num + ")");
        bprotMeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, num, true);
        bprot.setItemMeta(bprotMeta);
        inv.addItem(bprot);
        //FIRE PROTECTION
        ItemStack fprot = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta fprotMeta = fprot.getItemMeta();
        fprotMeta.setDisplayName(ChatColor.YELLOW + "Fire Protection §7(" + num + ")");
        fprotMeta.addEnchant(Enchantment.PROTECTION_FIRE, num, true);
        fprot.setItemMeta(fprotMeta);
        inv.addItem(fprot);
        //PROJECTILE PROTECTION
        ItemStack proj = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta projMeta = proj.getItemMeta();
        projMeta.setDisplayName(ChatColor.YELLOW + "Projectile Protection §7(" + num + ")");
        projMeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, num, true);
        proj.setItemMeta(projMeta);
        inv.addItem(proj);
        //FEATHER FALLING
        ItemStack fall = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta fallMeta = fall.getItemMeta();
        fallMeta.setDisplayName(ChatColor.YELLOW + "Feather Falling §7(" + num + ")");
        fallMeta.addEnchant(Enchantment.PROTECTION_FALL, num, true);
        fall.setItemMeta(fallMeta);
        inv.addItem(fall);
        //THORNS
        ItemStack thorns = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta thornsMeta = thorns.getItemMeta();
        thornsMeta.setDisplayName(ChatColor.YELLOW + "Thorns §7(" + num + ")");
        thornsMeta.addEnchant(Enchantment.THORNS, num, true);
        thorns.setItemMeta(thornsMeta);
        inv.addItem(thorns);
        //DEPTH STRIDER
        ItemStack str = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta strMeta = str.getItemMeta();
        strMeta.setDisplayName(ChatColor.YELLOW + "Depth Strider §7(" + num + ")");
        strMeta.addEnchant(Enchantment.DEPTH_STRIDER, num, true);
        str.setItemMeta(strMeta);
        inv.addItem(str);
        //FROST WALKER
        ItemStack fro = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta froMeta = fro.getItemMeta();
        froMeta.setDisplayName(ChatColor.YELLOW + "Frost Walker §7(" + num + ")");
        froMeta.addEnchant(Enchantment.FROST_WALKER, num, true);
        fro.setItemMeta(froMeta);
        inv.addItem(fro);
        //SOUL SPEED
        ItemStack ss = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta ssMeta = ss.getItemMeta();
        ssMeta.setDisplayName(ChatColor.YELLOW + "Soul Speed §7(" + num + ")");
        ssMeta.addEnchant(Enchantment.SOUL_SPEED, num, true);
        ss.setItemMeta(ssMeta);
        inv.addItem(ss);
        //LURE
        ItemStack lure = new ItemStack(Material.FISHING_ROD);
        ItemMeta lureMeta = lure.getItemMeta();
        lureMeta.setDisplayName(ChatColor.YELLOW + "Lure §7(" + num + ")");
        lureMeta.addEnchant(Enchantment.LURE, num, true);
        lure.setItemMeta(lureMeta);
        inv.addItem(lure);
        //LUCK OF THE SEA
        ItemStack luck = new ItemStack(Material.FISHING_ROD);
        ItemMeta luckMeta = luck.getItemMeta();
        luckMeta.setDisplayName(ChatColor.YELLOW + "Luck of the Sea §7(" + num + ")");
        luckMeta.addEnchant(Enchantment.LUCK, num, true);
        luck.setItemMeta(luckMeta);
        inv.addItem(luck);
        //CHANNELING
        ItemStack chan = new ItemStack(Material.TRIDENT);
        ItemMeta chanMeta = chan.getItemMeta();
        chanMeta.setDisplayName(ChatColor.YELLOW + "Channeling §7(" + num + ")");
        chanMeta.addEnchant(Enchantment.CHANNELING, num, true);
        chan.setItemMeta(chanMeta);
        inv.addItem(chan);
        //RIPTIDE
        ItemStack rip = new ItemStack(Material.TRIDENT);
        ItemMeta ripMeta = rip.getItemMeta();
        ripMeta.setDisplayName(ChatColor.YELLOW + "Riptide §7(" + num + ")");
        ripMeta.addEnchant(Enchantment.RIPTIDE, num, true);
        rip.setItemMeta(ripMeta);
        inv.addItem(rip);
        //LOYALTY
        ItemStack loy = new ItemStack(Material.TRIDENT);
        ItemMeta loyMeta = loy.getItemMeta();
        loyMeta.setDisplayName(ChatColor.YELLOW + "Loyalty §7(" + num + ")");
        loyMeta.addEnchant(Enchantment.LOYALTY, num, true);
        loy.setItemMeta(loyMeta);
        inv.addItem(loy);
        //CURSE OF BINDING
        ItemStack bind = new ItemStack(Material.SLIME_BALL);
        ItemMeta bindMeta = bind.getItemMeta();
        bindMeta.setDisplayName(ChatColor.RED + "Curse of Binding §7(" + num + ")");
        bindMeta.addEnchant(Enchantment.BINDING_CURSE, num, true);
        bind.setItemMeta(bindMeta);
        inv.addItem(bind);
        //CURSE OF VANISHING
        ItemStack van = new ItemStack(Material.ENDER_EYE);
        ItemMeta vanMeta = van.getItemMeta();
        vanMeta.setDisplayName(ChatColor.RED + "Curse of Vanishing §7(" + num + ")");
        vanMeta.addEnchant(Enchantment.VANISHING_CURSE, num, true);
        van.setItemMeta(vanMeta);
        inv.addItem(van);
        
        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta closeMeta = close.getItemMeta();
        ItemStack lvl = new ItemStack(Material.EXPERIENCE_BOTTLE);
        ItemMeta lvlMeta = lvl.getItemMeta();
        
        closeMeta.setDisplayName(ChatColor.RED + "Close");
        close.setItemMeta(closeMeta);
        
        List<String> Lore = new ArrayList<String>();
        lvlMeta.setDisplayName(ChatColor.GREEN + "Enchantment Level");
        Lore.add("§7Level: " + num);
        lvlMeta.setLore(Lore);
        lvl.setItemMeta(lvlMeta);
        
        inv.setItem(49, close);
        inv.setItem(53, lvl);
        
        player.openInventory(inv);
        
    }
    
    @SuppressWarnings("incomplete-switch")
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!ChatColor.stripColor(event.getView().getTitle()).equals("Enchantment Menu") &&
                !ChatColor.stripColor(event.getView().getTitle()).contains("Unsafe Enchantment Menu"))
            return;
        
        Player player = (Player) event.getWhoClicked();
        if (event.getInventory().getHolder()==null) {
            event.setCancelled(true);
            
            if (event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR) {
                return;
            }
            if (player.getInventory().getItemInHand().getType() == Material.AIR) {
                return;
            }
            Map<Enchantment, Integer> itemEnchants = player.getInventory().getItemInHand().getItemMeta().getEnchants();
            
            if (event.getClickedInventory().getType().equals(InventoryType.CHEST)) {
                
                if (event.getCurrentItem().getType() != Material.BARRIER && event.getCurrentItem().getType() != Material.EXPERIENCE_BOTTLE) {
                    if (event.getCurrentItem().hasItemMeta()) {
                        if (event.getCurrentItem().getItemMeta().hasDisplayName()) {
                            if (player.getInventory().getItemInHand().getType() != Material.AIR) {
                                
                                for (Enchantment enchantment : event.getCurrentItem().getItemMeta().getEnchants().keySet()) {
                                    for (Enchantment ench : itemEnchants.keySet()) {
                                        
                                        if (!ChatColor.stripColor(event.getView().getTitle()).equalsIgnoreCase("Unsafe Enchantment Menu")) {
                                            if (player.getInventory().getItemInHand().getItemMeta().hasEnchants()) {
                                                if (enchantment.conflictsWith(ench)) {
                                                    b = true;
                                                }
                                            }
                                        }
                                    }
                                    
                                    if (b == false) {
                                        ItemMeta meta = player.getInventory().getItemInHand().getItemMeta();
                                        meta.addEnchant(enchantment, num, true);
                                        player.getInventory().getItemInHand().setItemMeta(meta);
                                        b = false;
                                    }
                                    
                                    if (b == true) {
                                        b = false;
                                    }
                                }
                            }
                        }
                    }
                }
                
                switch (event.getCurrentItem().getType()) {
                    case BARRIER:
                        player.closeInventory();
                        break;
                }
            }
        }
        
    }
    
    public List<String> onTabComplete(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("enchgui")) {
            List<String> a = Arrays.asList("1","2","3","4","5");
            List<String> b = Arrays.asList("safe","unsafe");
            
            List<String> f = Lists.newArrayList();
            if (args.length == 1) {
                for (String s : a) {
                    if (s.startsWith(args[0])) f.add(s);
                }
                return f;
            }
            
            List<String> g = Lists.newArrayList();
            if (args.length == 2) {
                for (String s : b) {
                    if (s.startsWith(args[1])) g.add(s);
                }
                return g;
            }
            
            if (args.length > 2) {
                ArrayList<String> noInput = new ArrayList<String>();
                
                noInput.add("");
                
                return noInput;
            }
        }
        return null;
    }
}

