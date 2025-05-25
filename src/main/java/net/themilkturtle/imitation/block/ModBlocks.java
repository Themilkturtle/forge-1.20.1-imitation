package net.themilkturtle.imitation.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.themilkturtle.imitation.Imitation;
import net.themilkturtle.imitation.block.custom.Sentient_meat_block;
import net.themilkturtle.imitation.block.custom.battery_cell;
import net.themilkturtle.imitation.item.ModItems;

import java.util.function.Supplier;



public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Imitation.MOD_ID);

    public static final RegistryObject<Block> MEAT_BLOCK = registryObject("meat_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHER_WART_BLOCK).sound(SoundType.SCULK)));

    public static final RegistryObject<Block> SENTIENT_MEAT_BLOCK = registryObject("sentient_meat_block",
            () -> new Sentient_meat_block(BlockBehaviour.Properties.copy(Blocks.NETHER_WART_BLOCK).sound(SoundType.SCULK)));

    public static final RegistryObject<Block> BATTERY_CELL = registryObject("battery_cell",
            () -> new battery_cell(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));


    public static final RegistryObject<Block> ARAGONITE_DEPOSIT = registryObject("aragonite_deposit",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHER_WART_BLOCK).sound(SoundType.SCULK)));
    public static final RegistryObject<Block> INDUSTRIAL_STEEL_PLATING = registryObject("industrial_steel_plating",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK)));


    private static <T extends Block>RegistryObject<T> registryObject(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);

        registryBlockItem(name, toReturn);
        return toReturn;
    }


    private static <T extends Block>RegistryObject<Item> registryBlockItem(String name,RegistryObject<T> block) {
return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}