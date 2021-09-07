package me.thundercaster.etplugin;


import me.thundercaster.etplugin.commands.ArmourStand;
import me.thundercaster.etplugin.events.OpenArmourStand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class ETplugin extends JavaPlugin {

    @Override
    public void onEnable() {
        //linking other files
        getCommand("armorstand").setExecutor(new ArmourStand(this));
        getServer().getPluginManager().registerEvents(new OpenArmourStand(this), this);
        getConfig().options().copyDefaults();
        saveDefaultConfig();

    }
    public static ArrayList<String> list ;
    public void MainMenu(Player p){
        Inventory mainmenu = Bukkit.createInventory(p, 9, ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("MainMenu_Name")));

        ItemStack Create = new ItemStack(Material.ARMOR_STAND);
        ItemMeta create_meta = Create.getItemMeta();
        create_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',this.getConfig().getString("Create")));
        Create.setItemMeta(create_meta);

        ItemStack Close = new ItemStack(Material.BARRIER);
        ItemMeta close_meta = Create.getItemMeta();
        close_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',this.getConfig().getString("Close")));
        Close.setItemMeta(close_meta);

        mainmenu.setItem(0,Create);
        mainmenu.setItem(8,Close);
        p.openInventory(mainmenu);

    }
    public void Custom_Menu(Player p){
        Inventory customizationmenu = Bukkit.createInventory(p, 9, ChatColor.translateAlternateColorCodes('&',this.getConfig().getString("CustomMenu_Name")));

        //items of custon menu
        ItemStack mainhand = new ItemStack(Material.IRON_SWORD);
        ItemMeta mainhand_meta = mainhand.getItemMeta();
        mainhand_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',this.getConfig().getString("MainHand")));
        mainhand.setItemMeta(mainhand_meta);

        ItemStack offhand = new ItemStack(Material.SHIELD);
        ItemMeta offhand_meta = offhand.getItemMeta();
        offhand_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',this.getConfig().getString("OffHand")));
        offhand.setItemMeta(offhand_meta);

        ItemStack head = new ItemStack(Material.ZOMBIE_HEAD);
        ItemMeta head_meta = head.getItemMeta();
        head_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',this.getConfig().getString("Head")));
        head.setItemMeta(head_meta);

        ItemStack armour = new ItemStack(Material.IRON_CHESTPLATE);
        ItemMeta armour_meta = armour.getItemMeta();
        armour_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',this.getConfig().getString("Armor")));
        armour.setItemMeta(armour_meta);

        ItemStack position = new ItemStack(Material.ARMOR_STAND);
        ItemMeta position_meta = position.getItemMeta();
        position_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',this.getConfig().getString("Position")));
        position.setItemMeta(position_meta);

        ItemStack confirm = new ItemStack(Material.GREEN_WOOL);
        ItemMeta confirm_meta = confirm.getItemMeta();
        confirm_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',this.getConfig().getString("Confirm")));
        confirm.setItemMeta(confirm_meta);

        ItemStack cancel = new ItemStack(Material.BARRIER);
        ItemMeta cancel_meta = cancel.getItemMeta();
        cancel_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',this.getConfig().getString("Cancel")));
        cancel.setItemMeta(cancel_meta);

        //adding items to menu
        customizationmenu.setItem(0, mainhand);
        customizationmenu.setItem(1,offhand);
        customizationmenu.setItem(3, head);
        customizationmenu.setItem(4, armour);
        customizationmenu.setItem(5,position);
        customizationmenu.setItem(7,confirm);
        customizationmenu.setItem(8,cancel);
        p.openInventory(customizationmenu);
    }
    public void ConfirmMenu(Player p, Material m){
        Inventory confirmmenu = Bukkit.createInventory(p, 36, ChatColor.GOLD + "Confirmation");
        ItemStack m_item = new ItemStack(m);
        ItemMeta m_meta = m_item.getItemMeta();
        ItemStack mat = new ItemStack(m);

        ItemStack yes = new ItemStack(Material.GREEN_WOOL);
        ItemMeta yes_meta = yes.getItemMeta();
        yes_meta.setDisplayName(ChatColor.GREEN + "YES");
        yes.setItemMeta(yes_meta);

        ItemStack no = new ItemStack(Material.RED_WOOL);
        ItemMeta no_meta = no.getItemMeta();
        no_meta.setDisplayName(ChatColor.RED + "NO");
        no.setItemMeta(no_meta);

        confirmmenu.setItem(22, m_item);
        confirmmenu.setItem(21, no);
        confirmmenu.setItem(23,yes);

        p.openInventory(confirmmenu);


    }
    public void ArmourMenu(Player p){
        Inventory armourmenu = Bukkit.createInventory(p, 9, ChatColor.GRAY + "Choose Armour");
        ItemStack iron_gear = new ItemStack(Material.IRON_CHESTPLATE);
        ItemStack chainmain_gear = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
        ItemStack Leather_gear = new ItemStack(Material.LEATHER_CHESTPLATE);
        ItemStack Diamond_gear = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemStack no = new ItemStack(Material.BARRIER);

        armourmenu.setItem(0, Leather_gear);
        armourmenu.setItem(1, chainmain_gear);
        armourmenu.setItem(2, iron_gear);
        armourmenu.setItem(3,Diamond_gear);
        armourmenu.setItem(8,no);
        p.openInventory(armourmenu);
    }
    public void MainHandMenu(Player p){
        Inventory mainhandmenu = Bukkit.createInventory(p,9, ChatColor.DARK_RED + "Choose Main Weapon");
        ItemStack iron_sword = new ItemStack(Material.IRON_SWORD);
        ItemStack iron_axe = new ItemStack(Material.IRON_AXE);
        ItemStack diamond_sword = new ItemStack(Material.DIAMOND_SWORD);
        ItemStack diamond_axe = new ItemStack(Material.DIAMOND_AXE);
        ItemStack no = new ItemStack(Material.BARRIER);

        mainhandmenu.setItem(0, iron_axe);
        mainhandmenu.setItem(1, iron_sword);
        mainhandmenu.setItem(2, diamond_axe);
        mainhandmenu.setItem(3, diamond_sword);
        mainhandmenu.setItem(8, no);
        p.openInventory(mainhandmenu);

    }
}
