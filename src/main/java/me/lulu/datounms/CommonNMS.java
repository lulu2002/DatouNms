package me.lulu.datounms;

import me.lulu.datounms.model.ArmorInfo;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public abstract class CommonNMS {

    public abstract float getAbsorptionHeart(Player p);

    protected abstract String getBreakSoundString(Material material);

    public Sound getBlockBreakSound(Material material) {
        String soundName = getBreakSoundString(material).replace(".", "_").toUpperCase();
        return Sound.valueOf(soundName);
    }

    public abstract double getArmorPoint(ArmorInfo armorInfo);

    public abstract void playDeathAnimation(Player p);

    public abstract void setCanPickupExp(Player p, boolean b);

}
