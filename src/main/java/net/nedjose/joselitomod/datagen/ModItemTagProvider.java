package net.nedjose.joselitomod.datagen;

import net.minecraft.core.HolderLookup;
import net.nedjose.joselitomod.util.ModTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.nedjose.joselitomod.JoselitoMod;
import net.nedjose.joselitomod.block.ModBlocks;
import net.nedjose.joselitomod.item.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture,
                              CompletableFuture<TagLookup<Block>> lookupCompletableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, completableFuture, lookupCompletableFuture, JoselitoMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.ATTENDANCE_SHEET.get())
                .add(ModItems.LETTER_A.get())
                .add(ModItems.KAHOOT_TOKEN.get())
                .add(Items.COAL)
                .add(Items.STICK)
                .add(Items.COMPASS);

        tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.ATTENDANCE_BLOCK.get().asItem());
    }
}

