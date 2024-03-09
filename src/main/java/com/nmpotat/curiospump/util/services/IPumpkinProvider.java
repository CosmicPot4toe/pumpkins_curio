package com.nmpotat.curiospump.util.services;

import net.minecraft.world.item.ItemStack;

public interface IPumpkinProvider {
	boolean matches(ItemStack stack);
}
