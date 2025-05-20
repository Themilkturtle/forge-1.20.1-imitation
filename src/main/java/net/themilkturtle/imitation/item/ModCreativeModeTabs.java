package net.themilkturtle.imitation.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.themilkturtle.imitation.Imitation;
import net.themilkturtle.imitation.block.ModBlocks;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Imitation.MOD_ID);

    public static final RegistryObject<CreativeModeTab> IMITATION = CREATIVE_MODE_TABS.register("imitation",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MOD_LOGO.get()))

                    .title(Component.translatable("creativetab.imitation"))
                    .displayItems((pParmeters, pOutput) -> {
                        pOutput.accept(ModItems.BALL_OF_FLESH.get());
                        pOutput.accept(ModItems.CRITICAL_COAL.get());
                        pOutput.accept(ModItems.INDUSTRIAL_STEEL_INGOT.get());
                        pOutput.accept(ModItems.ARAGONITE.get());
                        pOutput.accept(ModBlocks.MEAT_BLOCK.get());
                        pOutput.accept(ModBlocks.ARAGONITE_DEPOSIT.get());
                        pOutput.accept(ModBlocks.INDUSTRIAL_STEEL_PLATING.get());
                    })

                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
