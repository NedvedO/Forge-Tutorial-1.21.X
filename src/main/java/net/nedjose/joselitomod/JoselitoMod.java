package net.nedjose.joselitomod;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.nedjose.joselitomod.Villager.ModVillagers;
import net.nedjose.joselitomod.block.ModBlocks;
import net.nedjose.joselitomod.item.ModItems;
import org.slf4j.Logger;


// The value here should match an entry in the META-INF/mods.toml file
// Main class for the mod. This ties everything together.
// The @Mod annotation registers this class as the entry point for the mod.
// @Mod(JoselitoMod.MOD_ID)
@Mod(JoselitoMod.MOD_ID)
public class JoselitoMod {

    // Mod ID used throughout the code for resource locations, registry, etc.
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "joselitomod";

    // Logger for outputting useful information to the console.
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    // Constructor - runs when the mod is first loaded.
    public JoselitoMod() {

        // Get the mod-specific event bus
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register lifecycle listeners
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register with the global MinecraftForge event bus for server-wide events
        MinecraftForge.EVENT_BUS.register(this);

        //--------------------------------------------------------------------------------------------------------

        // Register all mod components to the mod event bus
        // Call ModItems._____(modEventBus); inside JoselitoMod main class constructor.
        // This hooks your _____ list into Forge’s system.
        // Now Forge knows about list created in _______.java class and item is registered in mod
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModVillagers.register(modEventBus);
        // Register creative tab items
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        // Register the config file (common type shared across client/server)
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    // Setup logic that runs after registry, before game starts
    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Adds mod items/blocks to creative mode inventory tabs
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        // This adds our custom item to our INGREDIENTS creative mode tab
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS){
            event.accept(ModItems.ATTENDANCE_SHEET);
            event.accept(ModItems.KAHOOT_TOKEN);
            event.accept(ModItems.LETTER_A);
        }

        // This adds our block item to our BUILDING_BLOCKS creative mode tab
        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.ATTENDANCE_BLOCK);
        }
    }

        //--------------------------------------------------------------------------------------------------------

    // Placeholder for server start logic
    // You can use SubscribeEvent and let the Event Bus discover methods to call    @SubscribeEvent
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Custom logic can be added here when the server starts
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    // Client-side only setup and rendering registration
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        // Called during the client setup phase
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}

/* Terms to know for presentation:

    Deferred Register
    Registry Object
    Event Bus
    SubscribeEvent
    Client
    accept.
    Logger
 */
