package me.lulu.datounms.v1_17_R1;

import me.lulu.datounms.CommonNMS;
import me.lulu.datounms.DaTouNMS;
import me.lulu.datounms.model.ArmorInfo;
import net.minecraft.core.IRegistry;
import net.minecraft.network.protocol.game.PacketPlayOutEntityStatus;
import net.minecraft.network.protocol.game.PacketPlayOutNamedEntitySpawn;
import net.minecraft.network.protocol.game.PacketPlayOutPlayerInfo;
import net.minecraft.resources.MinecraftKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.EntityPlayer;
import net.minecraft.server.level.WorldServer;
import net.minecraft.server.network.PlayerConnection;
import net.minecraft.sounds.SoundEffect;
import net.minecraft.world.entity.EnumItemSlot;
import net.minecraft.world.item.EnumArmorMaterial;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundEffectType;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_17_R1.CraftServer;
import org.bukkit.craftbukkit.v1_17_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class CraftCommonNMS extends CommonNMS {
    @Override
    public float getAbsorptionHeart(Player p) {
        return (( CraftPlayer ) p).getHandle().getAbsorptionHearts();
    }

    @Override
    protected String getBreakSoundString(Material material) {
        MinecraftKey materialKey = new MinecraftKey(material.name().toLowerCase());
        Block nmsBlock = IRegistry.W.get(materialKey).getBlockData().getBlock();
        SoundEffectType soundEffectType = nmsBlock.getStepSound(null);

        try {
            Field breakSound = SoundEffectType.class.getDeclaredField("aA");
            breakSound.setAccessible(true);
            SoundEffect soundEffect = ( SoundEffect ) breakSound.get(soundEffectType);
            MinecraftKey keyInSoundRegistry = IRegistry.T.getKey(soundEffect);
            String soundName = keyInSoundRegistry.getKey();
            return soundName;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public double getArmorPoint(ArmorInfo armorInfo) {
        return EnumArmorMaterial
                .valueOf(armorInfo.getMaterial())
                .b(EnumItemSlot.valueOf(armorInfo.getEquipmentSlot().name()));
    }

    @Override
    public void playDeathAnimation(Player player) {
        MinecraftServer nmsServer = (( CraftServer ) Bukkit.getServer()).getServer();
        WorldServer nmsWorld = (( CraftWorld ) player.getWorld()).getHandle();
        CraftPlayer cp = ( CraftPlayer ) player;
        EntityPlayer realPlayer = cp.getHandle();
        EntityPlayer npc = new EntityPlayer(nmsServer, nmsWorld, cp.getProfile());
        npc.setLocation(player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ(), player.getLocation().getYaw(), player.getLocation().getPitch());
        PacketPlayOutPlayerInfo removeRealPlayer = new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.e, cp.getHandle());
        PacketPlayOutPlayerInfo addPlayer = new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.a, npc);
        PacketPlayOutPlayerInfo removePlayer = new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.e, npc);
        PacketPlayOutPlayerInfo addRealPlayer = new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.a, cp.getHandle());
        PacketPlayOutNamedEntitySpawn entitySpawn = new PacketPlayOutNamedEntitySpawn(npc);
        PacketPlayOutEntityStatus entityDeath = new PacketPlayOutEntityStatus(npc, ( byte ) 3);
        List<Player> toPlayRemove = new ArrayList<>();
        for (Entity o : player.getNearbyEntities(16, 16, 16)) {
            if (o instanceof Player) {
                PlayerConnection connection = (( CraftPlayer ) o).getHandle().b;
                connection.sendPacket(removeRealPlayer);
                connection.sendPacket(addPlayer);
                connection.sendPacket(entitySpawn);
                connection.sendPacket(entityDeath);
                toPlayRemove.add(( Player ) o);
            }
        }
        Bukkit.getScheduler().runTaskLater(DaTouNMS.getPlugin(), () -> {
            for (Player o : toPlayRemove) {
                if (o.isOnline()) {
                    PlayerConnection connection = ((CraftPlayer) o).getHandle().b;
                    connection.sendPacket(removePlayer);
                    if (cp.isOnline()) {
                        connection.sendPacket(addRealPlayer);
                    }
                }
            }
        }, 1L);
    }

    @Override
    public void setCanPickupExp(Player p, boolean b) {
        CraftPlayer craftPlayer = ( CraftPlayer ) p;
        EntityPlayer entityPlayer = craftPlayer.getHandle();

        entityPlayer.cb = b ? 0 : Integer.MAX_VALUE;
    }
}
