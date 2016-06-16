import java.util.HashMap;
import java.util.Map;

public class AvatarLibrary {
	private Map<String, Avatar> avatars = new HashMap<String, Avatar>();
	public void add(String name, String ext){
		avatars.put(name, new Avatar(name,ext));
	}
	public Avatar get(String name){
		return avatars.get(name);
	}
}
