package net.hycrafthd.umod;

import net.hycrafthd.umod.tileentity.TileEntityChargeStation;
import net.hycrafthd.umod.tileentity.TileEntityPipe;
import net.hycrafthd.umod.tileentity.TileEntityPulverizer;
import net.hycrafthd.umod.tileentity.TileEntitySolarPanel;
import net.hycrafthd.umod.utils.CommonRegistryUtils;

public class UTiles {

	public UTiles() {
		register();
	}

	public void register() {
		CommonRegistryUtils.registerTileEntity(TileEntityPulverizer.class, "tile.pulver.entity");
		CommonRegistryUtils.registerTileEntity(TileEntitySolarPanel.class, "tile.solar.entity");
		CommonRegistryUtils.registerTileEntity(TileEntityPipe.class, "tile.pipe.entity");
		CommonRegistryUtils.registerTileEntity(TileEntityChargeStation.class, "tile.charge.entity");
	}

}
