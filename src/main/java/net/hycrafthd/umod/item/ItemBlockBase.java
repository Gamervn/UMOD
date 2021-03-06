package net.hycrafthd.umod.item;

import java.util.List;

import net.hycrafthd.umod.UReference;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockBase extends ItemBlock {

	public ItemBlockBase(Block block) {
		super(block);
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List tooltip, boolean advanced) {
		UReference.proxy.addTooltip(stack, player, tooltip, advanced);
	}

}
