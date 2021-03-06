package com.github.xt449.registry;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Jonathan Talcott (xt449/BinaryBanana)
 */
public class SimpleIdRegistry<Key, Value> implements IIdRegistry<Key, Value> {

	private final ConcurrentHashMap<Key, Registration<Value>> map = new ConcurrentHashMap<>();
	private final AtomicInteger nextId;

	public SimpleIdRegistry(int startingId) {
		nextId = new AtomicInteger(startingId);
	}

	public SimpleIdRegistry() {
		nextId = new AtomicInteger();
	}

	@Override
	public IIdRegistration<Value> register(Key key, Value value) throws IllegalArgumentException {
		if(map.containsKey(key)) {
			throw new IllegalArgumentException("Duplicate registry key. \"" + key.toString() + "\n already exists!");
		}
		final Registration<Value> registration = new Registration<>(nextId.getAndIncrement(), value);
		map.put(key, registration);
		return registration;
	}

	public static class Registration<Value> implements IIdRegistration<Value> {

		public final int id;
		public final Value value;

		Registration(int id, Value value) {
			this.id = id;
			this.value = value;
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