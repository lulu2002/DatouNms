package me.lulu.datounms.model;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.mineacademy.fo.remain.CompEquipmentSlot;
import org.mineacademy.fo.remain.CompMaterial;

@RequiredArgsConstructor
@Getter
public class ArmorInfo {
    private String material;
    private int equipmentSlotNumber;
    private CompEquipmentSlot equipmentSlot;

    public static ArmorInfo fromMaterial(CompMaterial material) {
        String[] s = material.name().split("_");
        ArmorInfo info = new ArmorInfo();

        info.material = s[0];
        setEquipmentSlots(info, s);

        return info;
    }

    private static void setEquipmentSlots(ArmorInfo info, String[] s) {
        switch (s[1]) {
            case "HELMET":
                info.equipmentSlot = CompEquipmentSlot.HEAD;
                info.equipmentSlotNumber = 0;
                return;
            case "CHESTPLATE":
                info.equipmentSlot = CompEquipmentSlot.CHEST;
                info.equipmentSlotNumber = 1;
                return;
            case "LEGGINGS":
                info.equipmentSlot = CompEquipmentSlot.LEGS;
                info.equipmentSlotNumber = 2;
                return;
            case "BOOTS":
                info.equipmentSlot = CompEquipmentSlot.FEET;
                info.equipmentSlotNumber = 3;
                return;
        }

        throw new RuntimeException("Could not parse " + s[1] + " to equipment slot");
    }
}
