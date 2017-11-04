package databases;
public class Artifact {

	protected static String[] name;

	protected static String[] description;

	public static String getName(byte id) {
		return name[id];
	}

	public static String getDescription(byte id) {
		return description[id];
	}

}
