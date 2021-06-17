package me.lulu.datounms.v1_13_R1;

import me.lulu.datounms.BiomeHandler;
import me.lulu.datounms.model.biome.BiomeData;
import net.minecraft.server.v1_13_R1.BiomeBase;
import net.minecraft.server.v1_13_R1.MinecraftKey;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BiomeReplacer implements BiomeHandler {

    Map<String, BiomeBase> biomeBackup = new HashMap<>();

    public BiomeReplacer() {
        List<BiomeBase> base = BiomeBase.REGISTRY_ID.e().collect(Collectors.toList());
        for (BiomeBase b : base) {
            biomeBackup.put(BiomeBase.REGISTRY_ID.b(b).getKey(), b);
        }
    }

    @Override
    public void swap(BiomeData from, BiomeData to) {
        BiomeBase.REGISTRY_ID.a(from.getId(), new MinecraftKey(to.getKey_1_13().toLowerCase()), biomeBackup.get(to.getKey_1_13().toLowerCase()));
    }

    @Override
    public void swap(BiomeData to) {
    }
}
