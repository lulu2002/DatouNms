package me.lulu.datounms.model;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.Material;
import org.bukkit.inventory.EquipmentSlot;

@RequiredArgsConstructor
@Getter
public class ArmorInfo {
    private String material;
    private int equipmentSlotNumber;
    private EquipmentSlot equipmentSlot;

    public static ArmorInfo fromMaterial(Material material) {
        String[] s = material.name().split("_");
        ArmorInfo info = new ArmorInfo();

        info.material = s[0];
        setEquipmentSlots(info, s);

        return info;
    }

    private static void setEquipmentSlots(ArmorInfo info, String[] s) {
        switch (s[1]) {
            case "HELMET":
                info.equipmentSlot = EquipmentSlot.HEAD;
                info.equipmentSlotNumber = 0;
                return;
            case "CHESTPLATE":
                info.equipmentSlot = EquipmentSlot.CHEST;
                info.equipmentSlotNumber = 1;
                return;
            case "LEGGINGS":
                info.equipmentSlot = EquipmentSlot.LEGS;
                info.equipmentSlotNumber = 2;
                return;
            case "BOOTS":
                info.equipmentSlot = EquipmentSlot.FEET;
                info.equipmentSlotNumber = 3;
                return;
        }

        throw new RuntimeException("Could not parse " + s[1] + " to equipment slot");
    }
}
