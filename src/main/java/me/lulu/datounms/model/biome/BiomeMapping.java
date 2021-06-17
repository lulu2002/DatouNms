package me.lulu.datounms.model.biome;

public interface BiomeMapping {
    String getField(BiomeData data);

    BiomeData getBiomeData(String field);
}
