package com.github.lolipoyo.elementmod.registry.tab;

import com.github.lolipoyo.elementmod.main.ElementMod;
import com.github.lolipoyo.elementmod.registry.ElementItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ElementTabs {

    public static final DeferredRegister<CreativeModeTab> MOD_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ElementMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ELEMENT_TABS = MOD_TABS.register("element_main",
            ()-> {return CreativeModeTab.builder()
                .icon(()->new ItemStack(ElementItems.HYDROGEN.get()))
                .title(Component.translatable("itemGroup.element_main"))
                .displayItems((itemDisplayParameters, output) -> {
                    for(Item item:ElementMain.items){
                        output.accept(item);
                    }
                })
                .build();
    });

    //↓タブ複製は上コピーで下に記述
}
