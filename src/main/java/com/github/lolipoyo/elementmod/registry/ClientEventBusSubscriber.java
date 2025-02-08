package com.github.lolipoyo.elementmod.registry;

import com.github.lolipoyo.elementmod.block.gui.container.ElementContainerTypes;
import com.github.lolipoyo.elementmod.block.gui.screen.MachineBlockScreen;
import com.github.lolipoyo.elementmod.main.ElementMod;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = ElementMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event){
        blockScreenRegister();
    }

    private static void blockScreenRegister(){
        MenuScreens.register(ElementContainerTypes.DISASSEMBLE_MACHINE_BLOCK.get(), MachineBlockScreen::new);
    }
}
