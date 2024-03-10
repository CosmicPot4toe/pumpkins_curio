package com.nmpotat.curiospump;

import com.nmpotat.curiospump.integration.CurioPumpkin;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import top.theillusivec4.curios.api.CuriosCapability;
import top.theillusivec4.curios.api.type.capability.ICurio;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CPumpConst.MOD_ID)
public class CuriosPumpkinMod
{
    public CuriosPumpkinMod() {
        CPumpCommon.init();
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::setup);
    }
    private void setup(final FMLCommonSetupEvent event) {
        // Some common setup code
        MinecraftForge.EVENT_BUS.addGenericListener(ItemStack.class,this::attachCapabilities);
    }
    private void attachCapabilities(final AttachCapabilitiesEvent<ItemStack> evt){
        ItemStack stack = evt.getObject();
        if (CPumpCommon.IS_PUMPKIN.test(stack)){
            final LazyOptional<ICurio> pumpkinCurio = LazyOptional.of(()-> new CurioPumpkin(stack));
            evt.addCapability(CuriosCapability.ID_ITEM, new ICapabilityProvider() {
                @NotNull
                @Override
                public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap,
                                                         @Nullable Direction side) {
                    return CuriosCapability.ITEM.orEmpty(cap,pumpkinCurio);
                }
            });
            evt.addListener(pumpkinCurio::invalidate);
        }
    }

    @SubscribeEvent
    public void gatherData(GatherDataEvent evt){
        
    }
}
