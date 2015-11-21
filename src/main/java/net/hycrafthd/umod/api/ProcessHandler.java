package net.hycrafthd.umod.api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.hycrafthd.umod.interfaces.IProcess;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class ProcessHandler {
	private static List<IProcess> processes = new ArrayList<IProcess>();
	private static List<IProcess> newProcesses = new ArrayList<IProcess>();

	public static void init(){
		FMLCommonHandler.instance().bus().register(new ProcessHandler());
		MinecraftForge.EVENT_BUS.register(new ProcessHandler());
	}

	@SubscribeEvent
	public void onServerTick(TickEvent.ServerTickEvent event){
		if (event.phase == TickEvent.Phase.START){

			Iterator<IProcess> i = processes.iterator();

			while (i.hasNext()){
				IProcess process = i.next();
				if (process.isDead()) i.remove();
				else process.updateProcess();
			}

			if (!newProcesses.isEmpty()){
				processes.addAll(newProcesses);
				newProcesses.clear();
			}
		}
	}

	@SubscribeEvent
	public void onWorldClose(WorldEvent.Unload event){
		processes.clear();
		newProcesses.clear();
	}

	public static void addProcess(IProcess process) { newProcesses.add(process); }
}
