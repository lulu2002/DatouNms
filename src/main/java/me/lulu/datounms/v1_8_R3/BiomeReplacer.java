package me.lulu.datounms.v1_8_R3;

import me.lulu.datounms.model.BiomeData;
import me.lulu.datounms.BiomeHandler;
import net.minecraft.server.v1_8_R3.BiomeBase;

import java.util.Arrays;

public class BiomeReplacer implements BiomeHandler {
    public BiomeBase[] copy;
    public BiomeBase[] biomes;

    public BiomeReplacer() {
        biomes = BiomeBase.getBiomes();
        copy = Arrays.copyOf(biomes, biomes.length);
    }

    @Override
    public void swap(BiomeData from, BiomeData to) throws IndexOutOfBoundsException {
        if (biomes[from.getId()] == null)
            throw new IndexOutOfBoundsException();
        biomes[from.getId()] = copy[to.getId()];
    }

    @Override
    public void swap(BiomeData to) {
        for (int i = 0; i < biomes.length; i++) {
            if (i != to.getId() && biomes[i] != null)
                biomes[i] = copy[to.getId()];
        }
    }
}
