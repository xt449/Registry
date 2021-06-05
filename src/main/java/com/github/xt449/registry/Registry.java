package com.github.xt449.registry;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Jonathan Talcott (xt449/BinaryBanana)
 */
public class Registry<Key, Value> implements IRegistry<Key, Value> {

	private final ConcurrentHashMap<Key, Registration<Key, Value>> map = new ConcurrentHashMap<>();
	private final AtomicInteger nextId;

	public Registry(int startingId) {
		nextId = new AtomicInteger(startingId);
	}

	public Registry() {
		nextId = new AtomicInteger();
	}

	@Override
	public Registration<Key, Value> register(Key key, Value value) throws IllegalArgumentException {
		if(map.containsKey(key)) {
			throw new IllegalArgumentException("Duplicate registry key. \"" + key.toString() + "\n already exists!");
		}
		final Registration<Key, Value> registration = new Registration<>(key, nextId.getAndIncrement(), value);
		map.put(key, registration);
		return registration;
	}

	public static class Registration<Key, Value> implements IRegistration<Value> {

		public final Key key;
		public final int id;
		public final Value value;

		Registration(Key key, int id, Value value) {
			this.key = key;
			this.id = id;
			this.value = value;
		}

		public Key getKey() {
			return key;
		}

		@Override
		public int getId() {
			return id;
		}

		@Override
		public Value getValue() {
			return value;
		}
	}
}
