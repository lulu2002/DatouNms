package me.lulu.datounms.v1_16_R3;

import me.lulu.datounms.NmsManager;

public class NmsManager1_16_R3 extends NmsManager {

    public NmsManager1_16_R3() {
        super(
                new BiomeReplacer(),
                new CraftCommonNMS(),
                new CraftWorldNMS(),
                new OldEnchant());
    }
}
