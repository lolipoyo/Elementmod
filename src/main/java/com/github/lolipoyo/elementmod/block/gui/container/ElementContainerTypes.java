package com.github.lolipoyo.elementmod.block.gui.container;

import com.github.lolipoyo.elementmod.main.ElementMod;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ElementContainerTypes {

    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.MENU_TYPES, ElementMod.MOD_ID);

    public static final RegistryObject<MenuType<MachineBlockMenu>> DISASSEMBLE_MACHINE_BLOCK = MENU_TYPES.register("disassemble_machine_block",()->set(MachineBlockMenu::new));

    private static <T extends AbstractContainerMenu>MenuType<T> set(MenuType.MenuSupplier<T> supplier){
        return new MenuType<>(supplier, FeatureFlags.REGISTRY.allFlags());
    }

}
