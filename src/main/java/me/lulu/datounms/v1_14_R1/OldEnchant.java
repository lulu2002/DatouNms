package me.lulu.datounms.v1_14_R1;

import me.lulu.datounms.EnchantHandler;
import net.minecraft.server.v1_14_R1.ContainerEnchantTable;
import net.minecraft.server.v1_14_R1.ContainerProperty;
import org.bukkit.craftbukkit.v1_14_R1.inventory.CraftInventoryView;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;
import org.mineacademy.fo.ReflectionUtil;

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

    private final Random rand = new Random();
    private final ScheduledExecutorService saveThread = Executors.newSingleThreadScheduledExecutor();

    @Override
    public void randomizeSeed(PrepareItemEnchantEvent e) {
        CraftInventoryView view = (CraftInventoryView) e.getView();
        ContainerEnchantTable table = (ContainerEnchantTable) view.getHandle();

        ContainerProperty property = ReflectionUtil.getFieldContent(ContainerEnchantTable.class, "i", table);
        property.set(rand.nextInt()); // Set the enchantment seed
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
                clearArray(table.enchantments);
            }
        }, 10, TimeUnit.MILLISECONDS);
        ;
    }
}