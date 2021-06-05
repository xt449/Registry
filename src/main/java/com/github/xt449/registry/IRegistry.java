package com.github.xt449.registry;

/**
 * @author Jonathan Talcott (xt449 / BinaryBanana)
 */
public interface IRegistry<Key, Value> {

	IRegistration<Value> register(Key key, Value value);

	interface IRegistration<Value> {

		Value getValue();

		int getId();
	}
}
