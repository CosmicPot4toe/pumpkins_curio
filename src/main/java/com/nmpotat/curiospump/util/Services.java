package com.nmpotat.curiospump.util;

import com.nmpotat.curiospump.CPumpConst;
import com.nmpotat.curiospump.util.services.IPumpkinPlatform;

import java.util.ServiceLoader;

public class Services {

	public static final IPumpkinPlatform PUMPKIN = load(IPumpkinPlatform.class);
	public static <T> T load(Class<T> clazz) {
		final T loadedService = ServiceLoader.load(clazz)
			.findFirst()
			.orElseThrow(
					() -> new NullPointerException("Failed to load service for " + clazz.getName()));
		CPumpConst.LOG.debug("Loaded {} for service {}", loadedService, clazz);
		return loadedService;
	}
}
