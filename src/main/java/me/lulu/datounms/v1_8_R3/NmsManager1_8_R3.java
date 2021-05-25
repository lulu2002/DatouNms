package me.lulu.datounms.v1_8_R3;

import me.lulu.datounms.*;

public class NmsManager1_8_R3 extends NmsManager {

    public NmsManager1_8_R3() {
        super(
                new BiomeReplacer(),
                new CraftCommonNMS(),
                new CraftWorldNMS(),
                new OldEnchant());
    }
}
