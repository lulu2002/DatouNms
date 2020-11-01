package me.lulu.datounms;

import lombok.Getter;
import me.lulu.datounms.v1_8_R3.BiomeReplacer;
import me.lulu.datounms.v1_8_R3.CraftCommonNMS;
import me.lulu.datounms.v1_8_R3.CraftWorldNMS;
import me.lulu.datounms.v1_8_R3.OldEnchant;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.MinecraftVersion;

public class DaTouNMS {
    @Getter
    private static WorldNMS worldNMS;
    @Getter
    private static CommonNMS commonNMS;
    @Getter
    private static BiomeHandler biomeHandler;
    @Getter
    private static EnchantHandler enchantHandler;


    public static void setup() throws UnSupportedNmsException {
        try {
            String serverVersion = MinecraftVersion.getServerVersion();

            commonNMS = ((CommonNMS) Class.forName(getClassNamePath(CraftCommonNMS.class)).newInstance());
            worldNMS = ((WorldNMS) Class.forName(getClassNamePath(CraftWorldNMS.class)).newInstance());
            biomeHandler = ((BiomeHandler) Class.forName(getClassNamePath(BiomeReplacer.class)).newInstance());
            enchantHandler = ((EnchantHandler) Class.forName(getClassNamePath(OldEnchant.class)).newInstance());
            Common.log("&aNms Version: &f" + serverVersion);
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            throw new UnSupportedNmsException("&cUnsupported Nms version, only supports 1.8 ~ 1.16");
        }
    }

    private static String getClassNamePath(Class<?> clazz) {
        return clazz.getName().replace("v1_8_R3", MinecraftVersion.getServerVersion());
    }
}

