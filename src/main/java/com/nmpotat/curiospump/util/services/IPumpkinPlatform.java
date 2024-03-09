package com.nmpotat.curiospump.util.services;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import java.util.function.Function;

public interface IPumpkinPlatform {
	boolean isEquipped(LivingEntity livingEntity);

	ItemStack getEquipped(LivingEntity livingEntity);

	void processSlots(LivingEntity livingEntity, Function<ItemStack, Boolean> processor);
}
