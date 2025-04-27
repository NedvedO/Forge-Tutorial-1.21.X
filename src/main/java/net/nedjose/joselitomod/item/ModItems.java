package net.nedjose.joselitomod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nedjose.joselitomod.JoselitoMod;

public class ModItems {
    // We need to tell minecraft: "Hey these are our items, make sure that they are registered in the game"
    // A Deferred register class allows this
    /*
    What is a DeferredRegister?
        A list of objects (like items, blocks, etc.) that Minecraft processes at the correct time.
        It's called "deferred" because it waits for a specific time to register until needed.
     */
    // DeferredRegister<Item> = a list/register specifically for items.
    // ForgeRegistries.ITEMS = telling Forge "hey, we're registering items."
    // JoselitoMod.MOD_ID = your mod's namespace, to separate your items from Minecraft’s or other mods' stuff.
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, JoselitoMod.MOD_ID);

    // All the things registered will be 'public static final'
    // This adds item to game but makes it a black and purple item (bare-bones item)
    public static final RegistryObject<Item> ATTENDANCESHEET = ITEMS.register("attendancesheet",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> KAHOOT_TOKEN = ITEMS.register("kahoot_token",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> KAHOOT_GOLD_MEDAL = ITEMS.register("kahoot_gold_medal",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PROFESSORS_PEN = ITEMS.register("professors_pen",
            () -> new Item(new Item.Properties()));

    // Know we also have to register our deferred register
    // This time to Forge however: "Hey Forge, this is our deferred register for our modID"
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}

/* Steps to add a minecraft item:
    1. add these 2 lines in ModItems.java to register item to minecraft:
        public static final RegistryObject<Item> ATTENDANCESHEET = ITEMS.register("attendancesheet",
            () -> new Item(new Item.Properties()));
    2. Adding item to creative mode tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        // This adds our custom item 'attendancesheet' to our ingredients tab
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS){
            event.accept(ModItems.ATTENDANCESHEET);
        }
    }
    3. Adding a translation
    4. Adding the item/json file which points to textures
    5. Add png files to textures:item
 */
// 2nd item is exponentially easier than 1st item
