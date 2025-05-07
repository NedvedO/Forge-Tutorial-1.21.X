package net.nedjose.joselitomod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.nedjose.joselitomod.JoselitoMod;
import net.nedjose.joselitomod.block.ModBlocks;
import net.nedjose.joselitomod.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ATTENDANCE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.ATTENDANCE_SHEET.get())
                .unlockedBy(getHasName(ModItems.ATTENDANCE_SHEET.get()), has(ModItems.ATTENDANCE_SHEET.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ATTENDANCE_SHEET.get(), 9)
                .requires(ModBlocks.ATTENDANCE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ATTENDANCE_BLOCK.get()), has(ModBlocks.ATTENDANCE_BLOCK.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.DIAMOND_BLOCK.asItem())
                .requires(ModBlocks.JAVA_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.JAVA_BLOCK.get()), has(ModBlocks.JAVA_BLOCK.get()))
                .save(pRecipeOutput, JoselitoMod.MOD_ID + ":diamond_block__from_magic_block");


    }
}