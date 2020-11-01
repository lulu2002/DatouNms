package me.lulu.datounms.v1_9_R2;

import me.lulu.datounms.EnchantHandler;
import net.minecraft.server.v1_9_R2.ContainerEnchantTable;
import org.bukkit.craftbukkit.v1_9_R2.inventory.CraftInventoryView;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author Borlea
 * @Github https://github.com/borlea/
 * @Website http://codingforcookies.com/
 * @since May 24, 2017
 */
public class OldEnchant implements EnchantHandler {

    private Random rand = new Random();
    private ScheduledExecutorService saveThread = Executors.newSingleThreadScheduledExecutor();

    @Override
    public void randomizeSeed(PrepareItemEnchantEvent e) {
        CraftInventoryView view = (CraftInventoryView) e.getView();
        ContainerEnchantTable table = (ContainerEnchantTable) view.getHandle();
        table.f = rand.nextInt();// Set the enchantment seed
    }

    @Override
    public void oldEnchantCosts(PrepareItemEnchantEvent e) {
        CraftInventoryView view = (CraftInventoryView) e.getView();
        ContainerEnchantTable table = (ContainerEnchantTable) view.getHandle();
        generateNewCosts(table.costs, rand, Math.min(e.getEnchantmentBonus(), 15));
    }

    @Override
    public void hideEnchants(PrepareItemEnchantEvent e) {
        CraftInventoryView view = (CraftInventoryView) e.getView();
        ContainerEnchantTable table = (ContainerEnchantTable) view.getHandle();
        saveThread.schedule(new Runnable() {
            @Override
            public void run() {
                clearArray(table.h);
            }
        }, 10, TimeUnit.MILLISECONDS);
    }
}