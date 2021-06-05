/**
 * @author Jonathan Talcott (xt449/BinaryBanana)
 */
public class Thing {

	public final int someValue;

	public Thing(int someValue) {
		this.someValue = someValue;
	}

	@Override
	public int hashCode() {
		return someValue;
	}

	@Override
	public boolean equals(Object other) {
		if(this == other) return true;
		if(other == null || Thing.class != other.getClass()) return false;
		return someValue == ((Thing) other).someValue;
	}

	@Override
	public String toString() {
		return "Thing{" + someValue + '}';
	}
}
