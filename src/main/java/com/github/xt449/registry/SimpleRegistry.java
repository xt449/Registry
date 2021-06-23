package com.github.xt449.registry;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Jonathan Talcott (xt449/BinaryBanana)
 */
public class SimpleRegistry<Key, Value> implements IRegistry<Key, Value> {

	private final ConcurrentHashMap<Key, Registration<Value>> map = new ConcurrentHashMap<>();

	public SimpleRegistry() {

	}

	@Override
	public IRegistration<Value> register(Key key, Value value) throws IllegalArgumentException {
		if(map.containsKey(key)) {
			throw new IllegalArgumentException("Duplicate registry key. \"" + key.toString() + "\n already exists!");
		}
		final Registration<Value> registration = new Registration<>(value);
		map.put(key, registration);
		return registration;
	}

	public static class Registration<Value> implements IRegistration<Value> {

		public final Value value;

		Registration(Value value) {
			this.value = value;
		}

		@Override
		public Value getValue() {
			return value;
		}
	}
}