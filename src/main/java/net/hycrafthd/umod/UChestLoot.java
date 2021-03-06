package net.hycrafthd.umod;

import net.hycrafthd.umod.enumtype.EnumTypeBaseStuff;
import net.hycrafthd.umod.enumtype.EnumTypeChestLooting;
import net.hycrafthd.umod.utils.ChestLootUtils;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class UChestLoot {

	public UChestLoot() {
		addinfestedruin();
	}

	private void addinfestedruin() {
		ChestLootUtils.addStack(EnumTypeChestLooting.INFESTEDRUIN1, new ItemStack(Items.diamond), 1, 2, 5);
		ChestLootUtils.addStack(EnumTypeChestLooting.INFESTEDRUIN1, new ItemStack(Blocks.obsidian), 3, 6, 10);
		ChestLootUtils.addStack(EnumTypeChestLooting.INFESTEDRUIN1, new ItemStack(Items.iron_pickaxe), 1, 1, 1);
		ChestLootUtils.addStack(EnumTypeChestLooting.INFESTEDRUIN1, new ItemStack(Items.iron_axe), 1, 1, 1);
		ChestLootUtils.addStack(EnumTypeChestLooting.INFESTEDRUIN1, new ItemStack(Items.iron_sword), 1, 1, 1);
		ChestLootUtils.addStack(EnumTypeChestLooting.INFESTEDRUIN1, new ItemStack(Items.iron_shovel), 1, 1, 1);
		ChestLootUtils.addStack(EnumTypeChestLooting.INFESTEDRUIN1, new ItemStack(Items.stone_pickaxe), 1, 1, 2);
		ChestLootUtils.addStack(EnumTypeChestLooting.INFESTEDRUIN1, new ItemStack(Items.stone_axe), 1, 1, 2);
		ChestLootUtils.addStack(EnumTypeChestLooting.INFESTEDRUIN1, new ItemStack(Items.stone_sword), 1, 1, 2);
		ChestLootUtils.addStack(EnumTypeChestLooting.INFESTEDRUIN1, new ItemStack(Items.stone_shovel), 1, 1, 2);
		ChestLootUtils.addStack(EnumTypeChestLooting.INFESTEDRUIN1, new ItemStack(UBlocks.ores, 1, EnumTypeBaseStuff.URAN.getMetadata()), 1, 3, 50);
		ChestLootUtils.addStack(EnumTypeChestLooting.INFESTEDRUIN1, new ItemStack(Items.coal), 4, 9, 30);
		ChestLootUtils.addStack(EnumTypeChestLooting.INFESTEDRUIN1, new ItemStack(UBlocks.infectedLog), 6, 14, 30);
		ChestLootUtils.addStack(EnumTypeChestLooting.INFESTEDRUIN1, new ItemStack(UBlocks.infectedPlank), 14, 19, 20);
		ChestLootUtils.addStack(EnumTypeChestLooting.INFESTEDRUIN1, new ItemStack(UItems.infectedcrop), 4, 10, 30);
	}

}
