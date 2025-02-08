package com.github.lolipoyo.elementmod.main;

import com.github.lolipoyo.elementmod.block.entity.ElementBlockEntityTypes;
import com.github.lolipoyo.elementmod.block.gui.container.ElementContainerTypes;
import com.github.lolipoyo.elementmod.registry.ElementBlocks;
import com.github.lolipoyo.elementmod.registry.ElementItems;
import com.github.lolipoyo.elementmod.registry.tab.ElementTabs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("elementmod")
public class ElementMod {

    public static final String MOD_ID = "elementmod";

    public ElementMod() {

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ElementItems.ITEMS.register(bus);
        ElementBlocks.Blocks.BLOCKS.register(bus);
        ElementBlocks.BlockItems.BLOCK_ITEMS.register(bus);
        ElementBlockEntityTypes.BLOCK_ENTITY_TYPES.register(bus);
        ElementContainerTypes.MENU_TYPES.register(bus);
        ElementTabs.MOD_TABS.register(bus);
    }
}
