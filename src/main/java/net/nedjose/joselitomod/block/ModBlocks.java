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

    // Register for all custom blocks in the mod
    public static final DeferredRegister<Block> BLOCKS =
                DeferredRegister.create(ForgeRegistries.BLOCKS, JoselitoMod.MOD_ID);

    //-----------------------------------------------------------------------------------------------------------------------------------

    // "how do we register a specific block in the game"
    // won't be able to mine block yet, and it won't drop anything yet because loot table has not been defined
    // allows us to spawn in if called in JoselitoMod class in the creative method
    // Basic block types (custom ores, blocks)
    public static final RegistryObject<Block> ATTENDANCE_BLOCK = registerBlock("attendance_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    //-----------------------------------------------------------------------------------------------------------------------------------

    //    NEEDED
    // Helper method to register both a block and its corresponding item
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    // Helper method to register the block as an item (so it shows up in inventories)
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    // Call this method to register all blocks with the event bus
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}

/* for Mod Blocks:
 1. register block for specific block
 2. You will use 3 json files: blockstates, model/block, model/block
 3. now make a en_us translation json file in the lang directory for the block item


 */