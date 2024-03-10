package com.nmpotat.curiospump.integration;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.item.ItemStack;
import org.checkerframework.checker.nullness.qual.NonNull;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurio;

import java.util.UUID;

public class CurioPumpkin implements ICurio {

	private final ItemStack stack;
	public CurioPumpkin(ItemStack stack){
		this.stack=stack;
	}
	@Override
	public ItemStack getStack(){
		return this.stack;
	}
	@Override
	public boolean isEnderMask(SlotContext slotContext, EnderMan enderMan) {
		return true;
	}
	@NonNull
	@Override
	public SoundInfo getEquipSound(SlotContext slotContext){
		return new SoundInfo(SoundEvents.ARMOR_EQUIP_IRON,1.0F,1.0F);
	}
}
