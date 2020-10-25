package com.github.xt449.registry;

/**
 * @author Jonathan Talcott (xt449/BinaryBanana)
 */
public class Main {

	public static void main(String[] args) {
		Thing[] things = {
				new Thing(1),
				new Thing(2),
				new Thing(4),
				new Thing(17),
				new Thing(9),
				new Thing(2),
				new Thing(3)
		};

		for(int i = 0; i < things.length; i++) {
			System.out.println(things[i].someValue + " " + StaticRegistry.register(things[i]));
		}

		for(Thing thing : StaticRegistry.getAll()) {
			System.out.println(thing.someValue);
		}

		/*
		Using Object#hashcode() and Object#equals(Object)

			1 true
			2 true
			4 true
			17 true
			9 true
			2 true
			3 true
			2
			9
			3
			17
			2
			1
			4
		 */

		/*
		Using Object#hashcode() and Thing#equals(Object)

			1 true
			2 true
			4 true
			17 true
			9 true
			2 true
			3 true
			2
			9
			3
			17
			2
			1
			4
		 */

		/*
		Using Thing#hashcode() and Object#equals(Object)

			1 true
			2 true
			4 true
			17 true
			9 true
			2 true
			3 true
			1
			17
			2
			2
			3
			4
			9
		 */

		/*
		Using Thing#hashcode() and Thing#equals(Object)

			1 true
			2 true
			4 true
			17 true
			9 true
			2 false
			3 true
			1
			17
			2
			3
			4
			9
		 */
	}
}
