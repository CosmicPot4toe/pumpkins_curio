package com.nmpotat.curiospump;

import net.minecraft.client.Minecraft;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CPumpConst.MOD_ID)
public class CuriosPumpkinMod
{
    public CuriosPumpkinMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup); // Register the commonSetup method for modloading

				// CPumpConst.BLOCKS.register(modEventBus); //register deferred registers on the event bus so things actually happen
				// CPumpConst.ITEMS.register(modEventBus);
				// CPumpConst.CREATIVE_MODE_TABS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        // modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
    private void commonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code
        CPumpConst.LOG.info("HELLO FROM COMMON SETUP");

        if (Config.logDirtBlock)
            CPumpConst.LOG.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.CARVED_PUMPKIN));

        CPumpConst.LOG.info(Config.magicNumberIntroduction + Config.magicNumber);

        Config.items.forEach((item) -> CPumpConst.LOG.info("ITEM >> {}", item.toString()));
    }

    // Add the example block item to the building blocks tab
    /*private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
            event.accept(EXAMPLE_BLOCK_ITEM);
    }*/

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    /*@SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
    }*/

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = CPumpConst.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            // CPumpConst.LOG.info("HELLO FROM CLIENT SETUP");
            // CPumpConst.LOG.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
