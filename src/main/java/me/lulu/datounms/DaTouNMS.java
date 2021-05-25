package me.lulu.datounms;

import org.mineacademy.fo.Common;
import org.mineacademy.fo.MinecraftVersion;

public class DaTouNMS {
    private static WorldNMS worldNMS;
    private static CommonNMS commonNMS;
    private static BiomeHandler biomeHandler;
    private static EnchantHandler enchantHandler;

    private static NmsManager nmsManager;

    public static void setup() throws UnSupportedNmsException {
        NmsManagerFactory managerFactory = new NmsManagerFactory();
        String version = MinecraftVersion.getServerVersion();

        NmsManager nmsManager = managerFactory.getNmsManager(version);
        DaTouNMS.nmsManager = nmsManager;
        Common.log("&aNms Version: &f" + version);
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

