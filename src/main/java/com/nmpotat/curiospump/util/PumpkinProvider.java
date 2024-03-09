package com.nmpotat.curiospump.util;

import com.nmpotat.curiospump.util.services.IPumpkinProvider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class PumpkinProvider implements IPumpkinProvider {

	@Override
	public boolean matches(ItemStack stack) {
		return stack.getItem()== Items.CARVED_PUMPKIN;
	}
}
