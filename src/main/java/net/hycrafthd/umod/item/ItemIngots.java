package net.hycrafthd.umod.item;

import java.util.List;

import net.hycrafthd.umod.enumtype.EnumTypeBaseStuff;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemIngots extends Item {

	public ItemIngots() {
		super();
		this.hasSubtypes = true;
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		EnumTypeBaseStuff type = EnumTypeBaseStuff.byMetadata(stack.getMetadata());
		return "item.ingot" + type.getName();
	}

	@Override
	public int getMetadata(int damage) {
		return damage;
	}

	@Override
	public void getSubItems(Item item, CreativeTabs creativetab, List list) {
		for (int i = 0; i < EnumTypeBaseStuff.values().length; i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}

}
