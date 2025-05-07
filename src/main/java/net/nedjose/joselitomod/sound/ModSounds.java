package net.nedjose.joselitomod.sound;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nedjose.joselitomod.JoselitoMod;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, JoselitoMod.MOD_ID);

    //---------------------------------------------------------------------------------------------------------------------------------------------------

    public static final RegistryObject<SoundEvent> KAHOOT_TOKEN_USE = registerSoundEvent("kahoot_token_use");

    public static final RegistryObject<SoundEvent> KAHOOT_SONG = registerSoundEvent("kahoot_song");
    public static final ResourceKey<JukeboxSong> KAHOOT_SONG_KEY = ResourceKey.create(Registries.JUKEBOX_SONG,
            ResourceLocation.fromNamespaceAndPath(JoselitoMod.MOD_ID, "kahoot_song"));


    //---------------------------------------------------------------------------------------------------------------------------------------------------

    private static RegistryObject<SoundEvent> registerSoundEvent(String name){
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(JoselitoMod.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
