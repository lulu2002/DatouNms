package me.lulu.datounms.model.biome;

import java.util.HashMap;

public class BiomeMapping1_17 implements BiomeMapping {

    private HashMap<String, BiomeData> fieldToBiomeMap = new HashMap<>();
    private HashMap<BiomeData, String> biomeToFieldMap = new HashMap<>();

    private void addPair(BiomeData data, String field) {
        fieldToBiomeMap.put(field, data);
        biomeToFieldMap.put(data, field);
    }

    @Override
    public String getField(BiomeData data) {
        return biomeToFieldMap.get(data);
    }

    @Override
    public BiomeData getBiomeData(String field) {
        return fieldToBiomeMap.get(field);
    }

    public BiomeMapping1_17() {
        addPair(BiomeData.OCEAN, "a");
        addPair(BiomeData.PLAINS, "b");
        addPair(BiomeData.DESERT, "c");
        addPair(BiomeData.EXTREME_HILLS, "d");
        addPair(BiomeData.FOREST, "e");
        addPair(BiomeData.TAIGA, "f");
        addPair(BiomeData.SWAMPLAND, "g");
        addPair(BiomeData.RIVER, "h");
        addPair(BiomeData.HELL, "i");
        addPair(BiomeData.SKY, "j");
        addPair(BiomeData.FROZEN_OCEAN, "k");
        addPair(BiomeData.FROZEN_RIVER, "l");
        addPair(BiomeData.ICE_FLATS, "m");
        addPair(BiomeData.ICE_MOUNTAINS, "n");
        addPair(BiomeData.MUSHROOM_ISLAND, "o");
        addPair(BiomeData.MUSHROOM_ISLAND_SHORE, "p");
        addPair(BiomeData.BEACHES, "q");
        addPair(BiomeData.DESERT_HILLS, "r");
        addPair(BiomeData.FOREST_HILLS, "s");
        addPair(BiomeData.TAIGA_HILLS, "t");
        addPair(BiomeData.SMALLER_EXTREME_HILLS, "u");
        addPair(BiomeData.JUNGLE, "v");
        addPair(BiomeData.JUNGLE_HILLS, "w");
        addPair(BiomeData.JUNGLE_EDGE, "x");
        addPair(BiomeData.DEEP_OCEAN, "y");
        addPair(BiomeData.STONE_BEACH, "z");
        addPair(BiomeData.COLD_BEACH, "A");
        addPair(BiomeData.BIRCH_FOREST, "B");
        addPair(BiomeData.BIRCH_FOREST_HILLS, "C");
        addPair(BiomeData.ROOFED_FOREST, "D");
        addPair(BiomeData.TAIGA_COLD, "E");
        addPair(BiomeData.TAIGA_COLD_HILLS, "F");
        addPair(BiomeData.MEGA_TAIGA, "G");
        addPair(BiomeData.MEGA_TAIGA_HILLS, "H");
        addPair(BiomeData.EXTREME_HILLS_PLUS, "I");
        addPair(BiomeData.SAVANNA, "J");
        addPair(BiomeData.SAVANNA_ROCK, "K");
        addPair(BiomeData.MESA, "L");
        addPair(BiomeData.MESA_ROCK, "M");
        addPair(BiomeData.MESA_CLEAR_ROCK, "N");
        addPair(BiomeData.SMALL_END_ISLANDS, "O");
        addPair(BiomeData.END_MIDLANDS, "P");
        addPair(BiomeData.END_HIGHLANDS, "Q");
        addPair(BiomeData.END_BARRENS, "R");
        addPair(BiomeData.WARM_OCEAN, "S");
        addPair(BiomeData.LUKEWARM_OCEAN, "T");
        addPair(BiomeData.COLD_OCEAN, "U");
        addPair(BiomeData.DEEP_WARM_OCEAN, "V");
        addPair(BiomeData.DEEP_LUKEWARM_OCEAN, "W");
        addPair(BiomeData.DEEP_COLD_OCEAN, "X");
        addPair(BiomeData.DEEP_FROZEN_OCEAN, "Y");
        addPair(BiomeData.VOID, "Z");
        addPair(BiomeData.MUTATED_PLAINS, "aa");
        addPair(BiomeData.MUTATED_DESERT, "ab");
        addPair(BiomeData.MUTATED_EXTREME_HILLS, "ac");
        addPair(BiomeData.MUTATED_FOREST, "ad");
        addPair(BiomeData.MUTATED_TAIGA, "ae");
        addPair(BiomeData.MUTATED_SWAMPLAND, "af");
        addPair(BiomeData.MUTATED_ICE_FLATS, "ag");
        addPair(BiomeData.MUTATED_JUNGLE, "ah");
        addPair(BiomeData.MUTATED_JUNGLE_EDGE, "ai");
        addPair(BiomeData.MUTATED_BIRCH_FOREST, "aj");
        addPair(BiomeData.MUTATED_BIRCH_FOREST_HILLS, "ak");
        addPair(BiomeData.MUTATED_ROOFED_FOREST, "al");
        addPair(BiomeData.MUTATED_TAIGA_COLD, "am");
        addPair(BiomeData.MUTATED_REDWOOD_TAIGA, "an");
        addPair(BiomeData.MUTATED_REDWOOD_TAIGA_HILLS, "ao");
        addPair(BiomeData.MUTATED_EXTREME_HILLS_PLUS, "ap");
        addPair(BiomeData.MUTATED_SAVANNA, "aq");
        addPair(BiomeData.MUTATED_SAVANNA_ROCK, "ar");
        addPair(BiomeData.MUTATED_MESA, "as");
        addPair(BiomeData.MUTATED_MESA_ROCK, "at");
        addPair(BiomeData.MUTATED_MESA_CLEAR_ROCK, "au");
        addPair(BiomeData.BAMBOO_JUNGLE, "av");
        addPair(BiomeData.BAMBOO_JUNGLE_HILLS, "aw");
        addPair(BiomeData.SOUL_SAND_VALLEY, "ax");
        addPair(BiomeData.CRIMSON_FOREST, "ay");
        addPair(BiomeData.WARPED_FOREST, "az");
        addPair(BiomeData.BASALT_DELTAS, "aA");
        addPair(BiomeData.DRIPSTONE_CAVES, "aB");
        addPair(BiomeData.LUSH_CAVES, "aC");
    }

}
