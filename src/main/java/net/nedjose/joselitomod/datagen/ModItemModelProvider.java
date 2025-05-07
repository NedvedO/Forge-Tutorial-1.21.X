package net.nedjose.joselitomod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nedjose.joselitomod.JoselitoMod;
import net.nedjose.joselitomod.block.ModBlocks;
import net.nedjose.joselitomod.item.ModItems;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, JoselitoMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.ATTENDANCE_SHEET.get());
        basicItem(ModItems.KAHOOT_TOKEN.get());
        basicItem(ModItems.LETTER_A.get());

        // basicItem(ModItems.CHISEL.get());
        basicItem(ModItems.KAHOOT_GOLD_MEDAL.get());
        basicItem(ModItems.KAHOOT_SONG_MUSIC_DISC.get());


        //withExistingParent(ModItems.TRICERATOPS_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }



    private ItemModelBuilder simpleBlockItem(RegistryObject<? extends Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(JoselitoMod.MOD_ID,"item/" + item.getId().getPath()));
    }
}

