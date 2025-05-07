package net.nedjose.joselitomod.event;

import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.nedjose.joselitomod.JoselitoMod;
import net.nedjose.joselitomod.Villager.ModVillagers;
import net.nedjose.joselitomod.item.ModItems;

import static net.nedjose.joselitomod.Villager.ModVillagers.*;

@Mod.EventBusSubscriber(modid = JoselitoMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event)
    {
        if(event.getType() == ModVillagers.JOSELITO.get())
        {
            var trades = event.getTrades();

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(ModItems.ATTENDANCE_SHEET.get(), 1),
                    new ItemStack(ModItems.LETTER_A.get(), 1),1,1,0.05f));
        }
    }

}
