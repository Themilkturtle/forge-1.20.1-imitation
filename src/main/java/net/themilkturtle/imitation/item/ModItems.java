package net.themilkturtle.imitation.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.themilkturtle.imitation.Imitation;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Imitation.MOD_ID);

public static final RegistryObject<Item> MOD_LOGO = ITEMS.register("mod_logo",
        () ->new Item(new Item.Properties()));

    public static final RegistryObject<Item> BALL_OF_FLESH = ITEMS.register("ball_of_flesh",
            () ->new Item(new Item.Properties()));
    public static final RegistryObject<Item> ARAGONITE = ITEMS.register("aragonite",
            () ->new Item(new Item.Properties()));

    public static final RegistryObject<Item> INDUSTRIAL_STEEL_INGOT = ITEMS.register("industrial_steel_ingot",
            () ->new Item(new Item.Properties()));

    public static final RegistryObject<Item> CRITICAL_COAL = ITEMS.register("critical_coal",
            () ->new Item(new Item.Properties()));

    //---------------------------------------------------------

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
