package net.nedjose.joselitomod.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nedjose.joselitomod.JoselitoMod;
import net.nedjose.joselitomod.item.ModItems;


import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
                DeferredRegister.create(ForgeRegistries.BLOCKS, JoselitoMod.MOD_ID);

    // "how do we register a specific block in the game"
    // won't be able to mine block yet, and it won't drop anything yet because loot table has not been defined
    // allows us to spawn in if called in JoselitoMod class in the creative method
    public static final RegistryObject<Block> ATTENDANCE_SHEET_BLOCK = registerBlock("attendance_sheet_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    // Helper method
    // Registers our block item that is associated with registered block
    // Method returns registry object of type T
    // Method takes in as parameters a String name and Supplier of type T (supplier imported from java.util.function)
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    // Helper method
    // Registers our block item in the inventory
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}

/* for Mod Blocks:
 1. register block for specific block
 2. You will use 3 json files: blockstates, model/block, model/block
 3. now make a en_us translation json file in the lang directory for the block item


 */