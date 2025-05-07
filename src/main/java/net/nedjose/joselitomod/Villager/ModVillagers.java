package net.nedjose.joselitomod.Villager;


import com.google.common.collect.ImmutableSet;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nedjose.joselitomod.JoselitoMod;
import net.nedjose.joselitomod.block.ModBlocks;
import net.nedjose.joselitomod.item.ModItems;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, JoselitoMod.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, JoselitoMod.MOD_ID);

    public static final RegistryObject<PoiType> JOSELITO_POI = POI_TYPES.register("joselito_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.ATTENDANCE_BLOCK.get().getStateDefinition().getPossibleStates()),
                    1,1));

    public static final RegistryObject<VillagerProfession> JOSELITO = VILLAGER_PROFESSIONS.register("joselito",
            () -> new VillagerProfession("joselito", holder -> holder.value() == JOSELITO_POI.get(),
                    holder -> holder.value() == JOSELITO_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.HOSTILE_HURT));


    public static void register(IEventBus eventBus)
    {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
