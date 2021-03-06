package net.hycrafthd.umod.gui;

import java.io.IOException;

import net.hycrafthd.umod.UReference;
import net.hycrafthd.umod.enumtype.EnumTypeGui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ResourceLocation;

public class GuiBase extends GuiContainer{
	
	public ResourceLocation loc;
	public EntityPlayer play;
	public TileEntity ent; 
	public BlockPos pos;

	public GuiBase(ResourceLocation loc,EntityPlayer pl,IInventory tile,Container con) {
		super(con);
		this.loc = loc;
		this.play = pl;
		this.ent = (TileEntity) tile;
		this.pos = ent.getPos();
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
	 @Override
	 protected void keyTyped(char p_73869_1_, int p_73869_2_) throws IOException {
	 super.keyTyped(p_73869_1_, p_73869_2_);
	    	if(p_73869_1_ == 'e'){
	    		play.closeScreen();
	    	}
	 }

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		this.mc.getTextureManager().bindTexture(loc);
		 int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
	}

	@Override
	public void initGui() {
		super.initGui();
		GuiButton ba = new GuiButton(1, this.width/2-(this.xSize/2), 20,20,20, "<");
		GuiButton fo = new GuiButton(2, this.width/2+(this.xSize/2)-20, 20,20,20, ">");
		buttonList.add(ba);
		buttonList.add(fo);
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		switch (button.id) {
		 case 1:
			 this.play.closeScreen();
	    	 this.play.openGui(UReference.modid, EnumTypeGui.BATTERIEINPUT.getID(), this.play.worldObj, this.pos.getX(), this.pos.getY(),this.pos.getZ());
	     break;	   
	     case 2:
	    	   this.play.closeScreen();
	    	   this.play.openGui(UReference.modid, EnumTypeGui.BATTERIE.getID(), this.play.worldObj, this.pos.getX(), this.pos.getY(),this.pos.getZ());
	     break;	   
		}
	}
}
