package net.nedjose.joselitomod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nedjose.joselitomod.JoselitoMod;

public class ModItems {

    //"hey these are our items, make sure they are registered"
    // Create a DeferredRegister for registering custom items, using the mod's unique ID.
    // This ensures items are registered at the correct time during game initialization.
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, JoselitoMod.MOD_ID);

    // ---------------------------------------------------------------------------------------------------------------------------------

    // All the things registered will be 'public static final'
    // This adds item to game but makes it a black and purple item (bare-bones item)
    // Basic Item with no functionality (Attendance Sheet)
    public static final RegistryObject<Item> ATTENDANCE_SHEET = ITEMS.register("attendance_sheet",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> KAHOOT_TOKEN = ITEMS.register("kahoot_token",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LETTER_A = ITEMS.register("letter_a",
            () -> new Item(new Item.Properties()));

    /* Staff item Professor's Pen (functionality can be added later)
    public static final RegistryObject<Item> PROFESSORS_PEN = ITEMS.register("professor's pen",
            () -> new Item(new Item.Properties().stacksTo(1)));

    */
    // Food item (Kahoot Chocolate Gold Medal) with custom tooltip
    public static final RegistryObject<Item> KAHOOT_GOLD_MEDAL = ITEMS.register("kahoot_gold_medal",
            () -> new Item(new Item.Properties().food(ModFoodProperties.KAHOOT_GOLD_MEDAL))); /*{
                @Override
                public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                    pTooltipComponents.add(Component.translatable("tooltip.joselitomod.kohlrabi"));
                    super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
                }
            });
    */

    // -------------------------------------------------------------------------------------------------------------------------------------

    // Registers the DeferredRegister with the mod event bus so that all items are registered during mod loading.
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
