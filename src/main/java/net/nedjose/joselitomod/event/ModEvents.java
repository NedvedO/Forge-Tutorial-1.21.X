package net.nedjose.joselitomod.event;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.nedjose.joselitomod.JoselitoMod;
import net.nedjose.joselitomod.Villager.ModVillagers;
import net.nedjose.joselitomod.block.ModBlocks;
import net.nedjose.joselitomod.item.ModItems;

import java.util.Optional;


@Mod.EventBusSubscriber(modid = JoselitoMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event)
    {
        if(event.getType() == ModVillagers.JOSELITO.get())
        {
            var trades = event.getTrades();

            // Tier 1 Trades
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(ModItems.ATTENDANCE_SHEET.get(),   1),
                    new ItemStack(ModItems.LETTER_A.get(), 1), 64, 1, 0.05f));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(ModItems.LETTER_A.get(), 1),
                    new ItemStack(Items.COOKED_BEEF, 9), 64, 1, 0.05f));

            // Tier 2 Trades
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.DIAMOND_BLOCK, 6),
                    new ItemStack(ModItems.KAHOOT_TOKEN.get(), 1), 64, 10, 0.05f));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(ModItems.KAHOOT_TOKEN.get(), 1),
                    Optional.of(new ItemCost(Items.NETHERITE_INGOT, 1)),
                    new ItemStack(ModItems.KAHOOT_GOLD_MEDAL.get(), 1), 64, 20, 0.05f));

            // Tier 3 Trades
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(ModItems.KAHOOT_TOKEN.get(), 1),
                    Optional.of(new ItemCost(ModItems.KAHOOT_GOLD_MEDAL.get(), 1)),
                    new ItemStack(ModItems.KAHOOT_SONG_MUSIC_DISC.get(), 1), 1, 20, 0.05f));

            // Optional Fun Trade
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(ModItems.KAHOOT_TOKEN.get(),   1),
                    new ItemStack(Items.EMERALD_BLOCK, 12), 5, 20, 0.05f));

            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.NETHER_STAR,   3),
                    Optional.of(new ItemCost(ModItems.KAHOOT_GOLD_MEDAL.get(), 3)),
                    new ItemStack(ModBlocks.JAVA_BLOCK.get(), 1), 1, 30, 0.05f));
        }
        }
    }

