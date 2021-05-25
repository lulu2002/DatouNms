package me.lulu.datounms;

import me.lulu.datounms.v1_10_R1.NmsManager1_10_R1;
import me.lulu.datounms.v1_11_R1.NmsManager1_11_R1;
import me.lulu.datounms.v1_12_R1.NmsManager1_12_R1;
import me.lulu.datounms.v1_13_R1.NmsManager1_13_R1;
import me.lulu.datounms.v1_13_R2.NmsManager1_13_R2;
import me.lulu.datounms.v1_14_R1.NmsManager1_14_R1;
import me.lulu.datounms.v1_15_R1.NmsManager1_15_R1;
import me.lulu.datounms.v1_16_R1.NmsManager1_16_R1;
import me.lulu.datounms.v1_16_R2.NmsManager1_16_R2;
import me.lulu.datounms.v1_16_R3.NmsManager1_16_R3;
import me.lulu.datounms.v1_8_R3.NmsManager1_8_R3;
import me.lulu.datounms.v1_9_R1.NmsManager1_9_R1;
import me.lulu.datounms.v1_9_R2.NmsManager1_9_R2;

public class NmsManagerFactory {

    public NmsManager getNmsManager(String version) throws UnSupportedNmsException {
        switch (version) {
            case "v1_8_R3":
                return new NmsManager1_8_R3();
            case "v1_9_R1":
                return new NmsManager1_9_R1();
            case "v1_9_R2":
                return new NmsManager1_9_R2();
            case "v1_10_R1":
                return new NmsManager1_10_R1();
            case "v1_11_R1":
                return new NmsManager1_11_R1();
            case "v1_12_R1":
                return new NmsManager1_12_R1();
            case "v1_13_R1":
                return new NmsManager1_13_R1();
            case "v1_13_R2":
                return new NmsManager1_13_R2();
            case "v1_14_R1":
                return new NmsManager1_14_R1();
            case "v1_15_R1":
                return new NmsManager1_15_R1();
            case "v1_16_R1":
                return new NmsManager1_16_R1();
            case "v1_16_R2":
                return new NmsManager1_16_R2();
            case "v1_16_R3":
                return new NmsManager1_16_R3();
            default:
                throw new UnSupportedNmsException("&cUnsupported Nms version, only supports 1.8 ~ 1.16");
        }
    }

}
