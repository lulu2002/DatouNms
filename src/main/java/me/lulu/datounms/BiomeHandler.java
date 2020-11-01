package me.lulu.datounms;

import me.lulu.datounms.model.BiomeData;

public interface BiomeHandler {
    void swap(BiomeData from, BiomeData to) throws IllegalAccessException, NoSuchFieldException, IndexOutOfBoundsException, Exception;

    void swap(BiomeData to);
}
