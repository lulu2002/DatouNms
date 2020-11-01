package me.lulu.datounms;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;

public interface WorldNMS {

    void setBlockSuperFast(World world, int x, int y, int z, Material material, byte data, boolean applyPhysics);

    void setBlockSuperFast(Location loc, Material material, byte data, boolean applyPhysics);

    void spawnOrb(Location location, int amount, int value);

    int getMinecraftRegistryBlockID(Material material);
}
