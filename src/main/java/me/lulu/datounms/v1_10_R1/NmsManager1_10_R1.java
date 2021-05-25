package me.lulu.datounms.v1_10_R1;

import me.lulu.datounms.NmsManager;


public class NmsManager1_10_R1 extends NmsManager {

    public NmsManager1_10_R1() {
        super(
                new BiomeReplacer(),
                new CraftCommonNMS(),
                new CraftWorldNMS(),
                new OldEnchant());
    }
}
