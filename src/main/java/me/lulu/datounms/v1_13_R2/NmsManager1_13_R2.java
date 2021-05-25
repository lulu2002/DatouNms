package me.lulu.datounms.v1_13_R2;

import me.lulu.datounms.NmsManager;


public class NmsManager1_13_R2 extends NmsManager {

    public NmsManager1_13_R2() {
        super(
                new BiomeReplacer(),
                new CraftCommonNMS(),
                new CraftWorldNMS(),
                new OldEnchant());
    }
}
