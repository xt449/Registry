package com.github.xt449.registry;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Jonathan Talcott (xt449/BinaryBanana)
 */
public class StaticRegistry {

	private static final Set<Thing> registered = new HashSet<>();

	/**
	 * DANGEROUS:
	 * Gets an immutable set of all of the registered things. (shallow copy)
	 */
	public static Set<Thing> getAll() {
		return Collections.unmodifiableSet(StaticRegistry.registered);
	}

	public static boolean register(Thing thing) {
		return StaticRegistry.registered.add(thing);
	}

	public static void registerCarefully(Thing thing) throws IllegalArgumentException {
		if(!StaticRegistry.register(thing)) {
			throw new IllegalArgumentException("Equivalent Object already registered");
		}
	}
}
