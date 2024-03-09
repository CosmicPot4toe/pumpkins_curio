package com.nmpotat.curiospump;

import com.nmpotat.curiospump.util.PumpkinProvider;
import com.nmpotat.curiospump.util.Services;
import com.nmpotat.curiospump.util.services.IPumpkinProvider;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class CPumpCommon {

	public static final Predicate<ItemStack> IS_PUMPKIN = new Predicate<>() {
		@Override
		public boolean test(ItemStack stack) {
			for (IPumpkinProvider provider : PROVIDERS){
				if (provider.matches(stack)){
					return true;
				}
			}
			return false;
		}
	};

	private static final List<IPumpkinProvider> PROVIDERS = new LinkedList<>();

	public static void init() {
		PROVIDERS.add(new PumpkinProvider());
	}

	public static boolean isEquipped(final LivingEntity livingEntity) {
		return Services.PUMPKIN.isEquipped(livingEntity);
	}

	public static boolean canEquip(final LivingEntity livingEntity) {
		return !IS_PUMPKIN.test(livingEntity.getItemBySlot(EquipmentSlot.HEAD)) &&
							 !Services.PUMPKIN.isEquipped(livingEntity);
	}
}
