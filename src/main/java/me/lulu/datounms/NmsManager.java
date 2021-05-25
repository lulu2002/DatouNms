package me.lulu.datounms;

import lombok.Getter;

@Getter
public abstract class NmsManager {
    private BiomeHandler biomeHandler;
    private CommonNMS commonNMS;
    private WorldNMS worldNMS;
    private EnchantHandler enchantHandler;

    public NmsManager(BiomeHandler biomeHandler,
                      CommonNMS commonNMS,
                      WorldNMS worldNMS,
                      EnchantHandler enchantHandler) {
        this.biomeHandler = biomeHandler;
        this.commonNMS = commonNMS;
        this.worldNMS = worldNMS;
        this.enchantHandler = enchantHandler;
    }
}
