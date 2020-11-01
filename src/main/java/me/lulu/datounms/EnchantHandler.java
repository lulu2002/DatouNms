package me.lulu.datounms;

import org.bukkit.event.enchantment.PrepareItemEnchantEvent;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public interface EnchantHandler {

    void randomizeSeed(PrepareItemEnchantEvent e);

    void oldEnchantCosts(PrepareItemEnchantEvent e);

    void hideEnchants(PrepareItemEnchantEvent e);

    default void generateNewCosts(int[] costs, Random rand, int books) {
        int base = (rand.nextInt(8) + 1)
                + (books > 0 ? rand.nextInt((int) Math.floor(books / 2D))
                + rand.nextInt(books)
                : 0);// Randomize the enchant costs
        costs[0] = Math.max(base / 3, 1);
        costs[1] = (base * 2) / 3 + 1;
        int first = Math.min(base, books * 2);
        int last = Math.max(base, books * 2);
        costs[2] = ThreadLocalRandom.current().nextInt(first, last) + 1;// Before v1.1
    }

    default void clearArray(int[] array) {// Since we can't use a mutable array and I want shit clean
        for (int in = 0; in < array.length; in++)
            array[in] = -1;
    }
}
