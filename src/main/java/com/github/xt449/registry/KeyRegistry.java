package com.github.xt449.registry;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Jonathan Talcott (xt449/BinaryBanana)
 */
public class KeyRegistry<Key, Value> implements IRegistry<Key, Value> {

	private final ConcurrentHashMap<Key, Registration<Key, Value>> map = new ConcurrentHashMap<>();

	public KeyRegistry() {

	}

	@Override
	public Registration<Key, Value> register(Key key, Value value) throws IllegalArgumentException {
		if(map.containsKey(key)) {
			throw new IllegalArgumentException("Duplicate registry key. \"" + key.toString() + "\n already exists!");
		}
		final Registration<Key, Value> registration = new Registration<>(key, value);
		map.put(key, registration);
		return registration;
	}

	public static class Registration<Key, Value> implements IRegistration<Value> {

		public final Key key;
		public final Value value;

		Registration(Key key, Value value) {
			this.key = key;
			this.value = value;
		}

		public Key getKey() {
			return key;
		}

		@Override
		public Value getValue() {
			return value;
		}
	}
}