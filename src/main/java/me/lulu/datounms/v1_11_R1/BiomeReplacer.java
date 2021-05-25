package me.lulu.datounms.v1_11_R1;

import me.lulu.datounms.BiomeHandler;
import me.lulu.datounms.model.BiomeData;
import net.minecraft.server.v1_11_R1.BiomeBase;
import net.minecraft.server.v1_11_R1.MinecraftKey;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BiomeReplacer implements BiomeHandler {

    Map<String, BiomeBase> biomeBackup = new HashMap<>();

    public BiomeReplacer() {
        Set<MinecraftKey> base = BiomeBase.REGISTRY_ID.keySet();

        for (MinecraftKey b : base) {
            biomeBackup.put(b.a(), BiomeBase.REGISTRY_ID.get(b));
        }
    }

    @Override
    public void swap(BiomeData from, BiomeData to) throws NoSuchFieldException {
        int fromId = getBiomeID(from);
        changeBase(fromId, to);
    }

    private int getBiomeID(BiomeData data) throws NoSuchFieldException {
        BiomeBase base = biomeBackup.get(data.name().toLowerCase());
        int fromId = BiomeBase.REGISTRY_ID.a(base);

        if (fromId == 0 && data != BiomeData.OCEAN)
            throw new NoSuchFieldException();

        return fromId;
    }

    private void changeBase(int fromId, BiomeData data) {
        String toName = data.name().toLowerCase();
        BiomeBase toBase = biomeBackup.get(toName);

        BiomeBase.REGISTRY_ID.a(fromId, new MinecraftKey(toName), toBase);
    }

    @Override
    public void swap(BiomeData to) {
    }
}
