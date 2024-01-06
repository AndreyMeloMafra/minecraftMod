package com.factorybr.testMod.items;

import com.factorybr.testMod.TestMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS_DEFERRED_REGISTER =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TestMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MOD_TAB = CREATIVE_MODE_TABS_DEFERRED_REGISTER.register("mod_tab",
            () -> CreativeModeTab
                    .builder()
                    .icon(() -> new ItemStack(ModItems.ZIRCON.get()))
                    .title(Component.translatable("creativetab.mod_tab"))
                    .displayItems(((itemDisplayParameters, output) -> {
                        output.accept(ModItems.ZIRCON.get());
                        output.accept(ModItems.RAW_ZIRCON.get());
                    }))
                    .build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS_DEFERRED_REGISTER.register(eventBus);
    }
}
