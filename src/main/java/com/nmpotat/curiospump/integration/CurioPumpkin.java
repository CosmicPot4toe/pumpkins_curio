package com.nmpotat.curiospump.integration;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.item.ItemStack;
import org.checkerframework.checker.nullness.qual.NonNull;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurio;

import java.util.UUID;

public class CurioPumpkin implements ICurio {
	public static final AttributeModifier PUMPKIN_CURIO_MODIFIER =
			new AttributeModifier(UUID.fromString("2a38e1a7-9ed4-4241-ab88-734b850666c2"),
					"Carved Pumpkin Curio Modifier", 1.0D, AttributeModifier.Operation.ADDITION);
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
