package com.github.xt449.registry;

public interface IRegistry<Key, Value> {

	IRegistration<Value> register(Key key, Value value);

	interface IRegistration<Value> {

		Value getValue();
	}
}