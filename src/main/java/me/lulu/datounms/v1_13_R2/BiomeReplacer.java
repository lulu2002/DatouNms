package me.lulu.datounms.v1_13_R2;

import me.lulu.datounms.model.BiomeData;
import me.lulu.datounms.BiomeHandler;
import net.minecraft.server.v1_13_R2.BiomeBase;
import net.minecraft.server.v1_13_R2.IRegistry;
import net.minecraft.server.v1_13_R2.MinecraftKey;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BiomeReplacer implements BiomeHandler {

    Map<String, BiomeBase> biomeBackup = new HashMap<>();

    public BiomeReplacer() {
        List<BiomeBase> base = IRegistry.BIOME.f().collect(Collectors.toList());
        for (BiomeBase b : base) {
            biomeBackup.put(IRegistry.BIOME.getKey(b).getKey(), b);
        }
    }

    @Override
    public void swap(BiomeData from, BiomeData to) {
        IRegistry.BIOME.a(from.getId(), new MinecraftKey(to.getKey_1_13().toLowerCase()), biomeBackup.get(to.getKey_1_13().toLowerCase()));
    }

    @Override
    public void swap(BiomeData to) {
    }
}