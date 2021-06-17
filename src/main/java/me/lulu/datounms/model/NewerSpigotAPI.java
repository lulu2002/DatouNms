package me.lulu.datounms.model;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Directional;
import org.bukkit.block.data.type.Chest;

/**
 * 2019-06-22 下午 09:43
 */
public class NewerSpigotAPI {

    public static void mergeChest(Block leftSide, Block rightSide) {
        BlockData leftData = leftSide.getBlockData();
        (( Directional ) leftData).setFacing(BlockFace.EAST);
        leftSide.setBlockData(leftData);

        Chest chestDataLeft = ( Chest ) leftData;
        chestDataLeft.setType(Chest.Type.RIGHT);
        leftSide.setBlockData(chestDataLeft);


        BlockData rightData = rightSide.getBlockData();
        (( Directional ) rightData).setFacing(BlockFace.EAST);
        rightSide.setBlockData(rightData);

        Chest chestDataRight = ( Chest ) rightData;
        chestDataRight.setType(Chest.Type.LEFT);
        rightSide.setBlockData(chestDataRight);
    }
}
