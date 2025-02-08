package com.github.lolipoyo.elementmod.registry;

import com.github.lolipoyo.elementmod.item.ItemElement;
import com.github.lolipoyo.elementmod.main.ElementMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ElementItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ElementMod.MOD_ID);

    //アイテムを登録
    public static final RegistryObject<Item> HYDROGEN_ELEMENT = ITEMS.register("hydrogen_element", ItemElement::new);
    public static final RegistryObject<Item> CARBONE_ELEMENT = ITEMS.register("carbone_element", ItemElement::new);
}
