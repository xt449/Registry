import com.github.xt449.registry.Registry;

import java.util.Arrays;
import java.util.List;

/**
 * @author Jonathan Talcott (xt449/BinaryBanana)
 */
public class Main {

	public static void main(String[] args) {

		final Registry<String, Thing> registry = new Registry<>();

		final List<Registry.Registration<String, Thing>> thingRegistrations = Arrays.asList(
				registry.register("Thing 0", new Thing(4)),
				registry.register("Thing 1", new Thing(1)),
				registry.register("Thing 2", new Thing(2)),
				registry.register("Thing 3", new Thing(17)),
				registry.register("Thing 4", new Thing(9)),
				registry.register("Thing 5", new Thing(2)),
				registry.register("Thing 6", new Thing(3)),
				registry.register("Thing 7", new Thing(-23))
		);

		for(Registry.Registration<String, Thing> registration : thingRegistrations) {
			System.out.println(registration.key + " (" + registration.id + "): " + registration.value);
		}
	}
}
