package net.hycrafthd.umod.uschematic;

import java.util.Random;

import net.hycrafthd.umod.enumtype.EnumTypeChestLooting;
import net.hycrafthd.umod.utils.GenerationUtils;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class USchematicInfectedRuin extends USchematic {

	public USchematicInfectedRuin() {
		super("infestedruin");
	}

	@Override
	public void generate(World world, int x, int y, int z) {
		int blocks = width * length;
		for (BlockObject obj : blockObjects) {
			BlockPos pos = obj.getPositionWithOffset(x, y, z);
			world.setBlockState(pos, obj.getState());

			if (world.getTileEntity(pos) instanceof TileEntityChest) {
				world.setTileEntity(pos, GenerationUtils.generateChestLoot((TileEntityChest) world.getTileEntity(pos), EnumTypeChestLooting.INFESTEDRUIN1, 4, 8));
			}

			if (world.getTileEntity(pos) instanceof TileEntityFurnace) {
				TileEntityFurnace tile = (TileEntityFurnace) world.getTileEntity(pos);
				tile.setInventorySlotContents(1, new ItemStack(Items.coal, MathHelper.getRandomIntegerInRange(new Random(), 5, 22)));
				world.setTileEntity(pos, tile);
			}

			if (blocks != 0) {
				pos = pos.down();
				for (int posy = pos.getY(); posy > 0; posy--) {
					IBlockState stats = world.getBlockState(pos);
					Block block = stats.getBlock();
					if (!block.isSolidFullCube()) {
						IBlockState state = Blocks.cobblestone.getDefaultState();
						int ran = new Random().nextInt(7);
						if (ran == 0 || ran == 5) {
							state = Blocks.mossy_cobblestone.getDefaultState();
						}
						world.setBlockState(pos, state);
						pos = pos.down();
					}
				}
				blocks--;
			}

		}
	}

}
