package com.github.xt449.registry;

public interface IIdRegistry<Key, Value> {

	IIdRegistration<Value> register(Key key, Value value);

	interface IIdRegistration<Value> {

		Value getValue();

		int getId();
	}
}