package me.lulu.datounms.v1_15_R1;

import me.lulu.datounms.BiomeHandler;
import me.lulu.datounms.model.biome.BiomeData;
import net.minecraft.server.v1_15_R1.BiomeBase;
import net.minecraft.server.v1_15_R1.IRegistry;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BiomeReplacer implements BiomeHandler {

    Map<String, BiomeBase> biomeBackup = new HashMap<>();

    public BiomeReplacer() {
        List<BiomeBase> base = IRegistry.BIOME.d().collect(Collectors.toList());
        for (BiomeBase b : base) {
            biomeBackup.put(IRegistry.BIOME.getKey(b).getKey(), b);
        }
    }

    @Override
    public void swap(BiomeData from, BiomeData to) throws Exception {
        IRegistry.a(IRegistry.BIOME, from.getId(), to.getKey_1_13().toLowerCase(), biomeBackup.get(to.getKey_1_13().toLowerCase()));
    }

    @Override
    public void swap(BiomeData to) {
    }
}
