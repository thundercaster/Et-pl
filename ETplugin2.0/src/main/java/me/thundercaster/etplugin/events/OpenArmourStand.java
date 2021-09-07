package me.thundercaster.etplugin.events;

import me.thundercaster.etplugin.ETplugin;
import me.thundercaster.etplugin.commands.ArmourStand;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;



public class OpenArmourStand implements Listener {
    ETplugin plugin;

    public OpenArmourStand(ETplugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void ClickMenu(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        ArmorStand a = (ArmorStand) p.getWorld().spawnEntity(p.getLocation(), EntityType.ARMOR_STAND);
        a.setVisible(false);
        a.setInvulnerable(false);
        a.setCustomName(plugin.list.get(0));
        a.setGlowing(true);
        a.setArms(true);
        a.setBasePlate(false);
        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("MainMenu_Name")))){
            switch (e.getCurrentItem().getType()){
                case ARMOR_STAND:
                    p.sendMessage(ChatColor.BLUE + "you chose to proceed to the creation menu");
                    plugin.Custom_Menu(p);
                    break;
                case BARRIER:
                    p.sendMessage(ChatColor.RED + "you closed the mainmenu");
                    p.closeInventory();
                    a.remove();
                    break;

            }

        }
        else if (e.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&',plugin.getConfig().getString("CustomMenu_Name")))){
            switch (e.getCurrentItem().getType()){
                case IRON_SWORD:
                    p.sendMessage(ChatColor.AQUA + "you opened the main weapon menu");
                    plugin.MainHandMenu(p);
                    break;
                case IRON_CHESTPLATE:
                    p.sendMessage(ChatColor.DARK_PURPLE + "you opened the armour menu");
                    plugin.ArmourMenu(p);
                    break;
                case ZOMBIE_HEAD:
                    p.sendMessage(ChatColor.RED + "this isn't ready yet");
                    p.playSound(p.getLocation(), Sound.BLOCK_LAVA_EXTINGUISH,1,1);
                    break;
                case SHIELD:
                    p.sendMessage(ChatColor.RED + "this isn't ready yet");
                    p.playSound(p.getLocation(), Sound.BLOCK_LAVA_EXTINGUISH,1,1);
                    break;
                case ARMOR_STAND:
                    p.sendMessage(ChatColor.RED + "this isn't ready yet");
                    p.playSound(p.getLocation(), Sound.BLOCK_LAVA_EXTINGUISH,1,1);
                    break;
                case GREEN_WOOL:
                    p.sendMessage(ChatColor.GREEN + "you have create your armour stand!");
                    a.setVisible(true);
                    a.setCustomNameVisible(true);
                    p.closeInventory();
                    String f = a.getCustomName();
                    p.sendMessage(ChatColor.MAGIC + f);

                    break;
                case RED_WOOL:
                    p.sendMessage(ChatColor.RED + "you canceled the process");
                    a.remove();
                    p.closeInventory();
                    break;


            }
        }else if(e.getView().getTitle().equalsIgnoreCase(ChatColor.GRAY + "Choose Armour")){
            switch (e.getCurrentItem().getType()){
                case LEATHER_CHESTPLATE:
                    p.sendMessage(ChatColor.BLUE + "you chose the leather armour");
                    plugin.ConfirmMenu(p, Material.LEATHER_CHESTPLATE);
                    break;
                case CHAINMAIL_CHESTPLATE:
                    p.sendMessage(ChatColor.BLUE + "you chose the chainmail armour");
                    plugin.ConfirmMenu(p, Material.CHAINMAIL_CHESTPLATE);
                    break;
                case IRON_CHESTPLATE:
                    p.sendMessage(ChatColor.BLUE + "you chose the iron armour");
                    plugin.ConfirmMenu(p, Material.IRON_CHESTPLATE);
                    break;
                case DIAMOND_CHESTPLATE:
                    p.sendMessage(ChatColor.BLUE + "you chose the diamond armour");
                    plugin.ConfirmMenu(p, Material.DIAMOND_CHESTPLATE);
                    break;
                case BARRIER:
                    p.sendMessage("you went back to the customisation menu");
                    plugin.Custom_Menu(p);
                    break;

            }

        }else if (e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_RED + "Choose Main Weapon")){
            switch (e.getCurrentItem().getType()){
                case IRON_SWORD:
                    p.sendMessage(ChatColor.GOLD + "you chose the iron sword");
                    plugin.ConfirmMenu(p, Material.IRON_SWORD);
                    break;
                case IRON_AXE:
                    p.sendMessage(ChatColor.GOLD + "you chose the iron axe");
                    plugin.ConfirmMenu(p, Material.IRON_AXE);
                    break;
                case DIAMOND_AXE:
                    p.sendMessage(ChatColor.GOLD + "you chose diamond axe");
                    plugin.ConfirmMenu(p, Material.DIAMOND_AXE);
                    break;
                case DIAMOND_SWORD:
                    p.sendMessage(ChatColor.GOLD + "you chose diamond sword");
                    plugin.ConfirmMenu(p, Material.DIAMOND_SWORD);
                    break;
                case BARRIER:
                    p.sendMessage("you went back to the customisation menu");
                    plugin.Custom_Menu(p);
                    break;
            }

        }else if (e.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD + "Confirmation")){
            if(e.getClickedInventory().contains(Material.LEATHER_CHESTPLATE)){
                switch (e.getCurrentItem().getType()){
                    case GREEN_WOOL:
                        a.setHelmet(new ItemStack(Material.LEATHER_HELMET));
                        a.setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
                        a.setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
                        a.setBoots(new ItemStack(Material.LEATHER_BOOTS));
                        p.sendMessage(ChatColor.GREEN + "you have confirmed the leather armour");
                        plugin.Custom_Menu(p);
                        break;
                    case RED_WOOL:
                        plugin.ArmourMenu(p);
                        p.sendMessage(ChatColor.RED + "you went back to the armour menu");
                        break;


                }

            }else if (e.getClickedInventory().contains(Material.IRON_CHESTPLATE)){
                switch (e.getCurrentItem().getType()){
                    case GREEN_WOOL:
                        a.setHelmet(new ItemStack(Material.IRON_HELMET));
                        a.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
                        a.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
                        a.setBoots(new ItemStack(Material.IRON_BOOTS));
                        p.sendMessage(ChatColor.GREEN + "you have confirmed the iron armour");
                        plugin.Custom_Menu(p);
                        break;
                    case RED_WOOL:
                        plugin.ArmourMenu(p);
                        p.sendMessage(ChatColor.RED + "you went back to the armour menu");
                        break;

                }

            }else if(e.getClickedInventory().contains(Material.IRON_SWORD)){
                switch (e.getCurrentItem().getType()){
                    case GREEN_WOOL:
                        p.sendMessage(ChatColor.GREEN + "you have confirmed the iron sword");
                        a.getEquipment().setItemInMainHand(new ItemStack(Material.IRON_SWORD));
                        break;
                    case RED_WOOL:
                        plugin.MainHandMenu(p);
                        p.sendMessage(ChatColor.RED + "you went back to the main weapon menu");
                        break;

                }


            }else if (e.getClickedInventory().contains(Material.IRON_AXE)){
                switch (e.getCurrentItem().getType()){
                    case GREEN_WOOL:
                        p.sendMessage(ChatColor.GREEN + "you have confirmed the iron axe");
                        a.getEquipment().setItemInMainHand(new ItemStack(Material.IRON_AXE));
                        break;
                    case RED_WOOL:
                        plugin.MainHandMenu(p);
                        p.sendMessage(ChatColor.RED + "you went back to the main weapon menu");
                        break;
                }
            }
            else{
                p.sendMessage(ChatColor.RED + "sorry not ready yet");
                plugin.Custom_Menu(p);
            }

        }


        e.setCancelled(true);
    }




}

