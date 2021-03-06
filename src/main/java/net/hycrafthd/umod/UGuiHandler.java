package net.hycrafthd.umod;

import net.hycrafthd.umod.api.IPowerProvieder;
import net.hycrafthd.umod.container.ContainerBattery;
import net.hycrafthd.umod.container.ContainerChargeStation;
import net.hycrafthd.umod.container.ContainerPulverizer;
import net.hycrafthd.umod.enumtype.EnumTypeGui;
import net.hycrafthd.umod.gui.GuiBatterieInput;
import net.hycrafthd.umod.gui.GuiBattery;
import net.hycrafthd.umod.gui.GuiChargstation;
import net.hycrafthd.umod.gui.GuiPulverizer;
import net.hycrafthd.umod.gui.GuiSolarPanel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class UGuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		BlockPos p = new BlockPos(x, y, z);
		TileEntity ent = world.getTileEntity(p);

		switch (EnumTypeGui.byID(ID)) {
		case PULVERISER:
			return new ContainerPulverizer((IInventory) ent, player, world);
		case CHARGESTATION:
			return new ContainerChargeStation((IInventory) ent, player, p, world);
		case BATTERIEINPUT:
			return new ContainerBattery((IInventory) ent, player, p, world);
		default:
			return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		BlockPos p = new BlockPos(x, y, z);
		TileEntity ent = world.getTileEntity(p);
		switch (EnumTypeGui.byID(ID)) {
		case PULVERISER:
			return new GuiPulverizer(player, (IInventory) ent, world, p);
		case SOLARPANEL:
			return new GuiSolarPanel(world,(IPowerProvieder) ent);
		case BATTERIE:
			return new GuiBattery(world, (IPowerProvieder) ent, player, p, 0);
		case CHARGESTATION:
			return new GuiChargstation(player, (IInventory) ent);
		case BATTERIEINPUT:
            return new GuiBatterieInput(player, (IInventory) ent);
		default:
			return null;
		}

	}

}
