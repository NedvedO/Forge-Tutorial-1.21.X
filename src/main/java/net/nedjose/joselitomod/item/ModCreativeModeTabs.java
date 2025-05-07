package net.nedjose.joselitomod.item;

import com.mojang.brigadier.LiteralMessage;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.nedjose.joselitomod.JoselitoMod;
import net.nedjose.joselitomod.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, JoselitoMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> JOSELITO_ITEMS_TAB = CREATIVE_MODE_TABS.register("joselito_items_tab",
            () -> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.ATTENDANCE_SHEET.get()))
                    .title(Component.translatable("creativetab.joselitomod.joselito_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.ATTENDANCE_SHEET.get());
                        output.accept(ModItems.KAHOOT_TOKEN.get());
                        output.accept(ModItems.LETTER_A.get());

                        output.accept(ModItems.KAHOOT_GOLD_MEDAL.get());
                        output.accept(ModItems.KAHOOT_SONG_MUSIC_DISC.get());



                    }).build());

    public static final RegistryObject<CreativeModeTab> JOSELITO_BLOCKS_TAB = CREATIVE_MODE_TABS.register("joselito_blocks_tab",
            () -> CreativeModeTab.builder().icon(()-> new ItemStack(ModBlocks.ATTENDANCE_BLOCK.get()))
                    .withTabsBefore(JOSELITO_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.joselitomod.joselito_block"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.ATTENDANCE_BLOCK.get());
                        output.accept(ModBlocks.JAVA_BLOCK.get());


                    }).build());



    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
