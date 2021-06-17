package me.lulu.datounms;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class DaTouNMS {
    private static WorldNMS worldNMS;
    private static CommonNMS commonNMS;
    private static BiomeHandler biomeHandler;
    private static EnchantHandler enchantHandler;

    private static NmsManager nmsManager;

    @Getter
    private static JavaPlugin plugin;

    public static void setup(JavaPlugin plugin) throws UnSupportedNmsException {
        NmsManagerFactory managerFactory = new NmsManagerFactory();
        String version = getServerVersion();

        NmsManager nmsManager = managerFactory.getNmsManager(version);
        DaTouNMS.nmsManager = nmsManager;
        DaTouNMS.plugin = plugin;

        System.out.println("Nms Version: " + version);
    }

    private static String getServerVersion() {
        String a = Bukkit.getServer().getClass().getPackage().getName();
        String version = a.substring(a.lastIndexOf('.') + 1);

        return version;
    }

    public static WorldNMS getWorldNMS() {
        return nmsManager.getWorldNMS();
    }

    public static CommonNMS getCommonNMS() {
        return nmsManager.getCommonNMS();
    }

    public static BiomeHandler getBiomeHandler() {
        return nmsManager.getBiomeHandler();
    }

    public static EnchantHandler getEnchantHandler() {
        return nmsManager.getEnchantHandler();
    }
}

