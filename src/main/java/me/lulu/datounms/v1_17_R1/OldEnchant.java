package me.lulu.datounms.v1_17_R1;

import me.lulu.datounms.EnchantHandler;
import me.lulu.datounms.utils.ReflectionUtil;
import net.minecraft.world.inventory.ContainerEnchantTable;
import net.minecraft.world.inventory.ContainerProperty;
import org.bukkit.craftbukkit.v1_17_R1.inventory.CraftInventoryView;
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

    private final Random rand = new Random();
    private final ScheduledExecutorService saveThread = Executors.newSingleThreadScheduledExecutor();

    @Override
    public void randomizeSeed(PrepareItemEnchantEvent e) {
        CraftInventoryView view = ( CraftInventoryView ) e.getView();
        ContainerEnchantTable table = ( ContainerEnchantTable ) view.getHandle();

        ContainerProperty property = ReflectionUtil.getFieldContent(ContainerEnchantTable.class, "q", table);
        property.set(rand.nextInt()); // Set the enchantment seed
    }

    @Override
    public void oldEnchantCosts(PrepareItemEnchantEvent e) {
        CraftInventoryView view = ( CraftInventoryView ) e.getView();
        ContainerEnchantTable table = ( ContainerEnchantTable ) view.getHandle();
        generateNewCosts(table.k, rand, Math.min(e.getEnchantmentBonus(), 15));
    }

    @Override
    public void hideEnchants(PrepareItemEnchantEvent e) {
        CraftInventoryView view = ( CraftInventoryView ) e.getView();
        ContainerEnchantTable table = ( ContainerEnchantTable ) view.getHandle();
        saveThread.schedule(() -> clearArray(table.l), 10, TimeUnit.MILLISECONDS);
    }
}
