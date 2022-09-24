package os.domain.user;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Users {
	
	private List<User> users = new ArrayList<>();
	
	public void addUser(User user) {
		users.add(user);
	}
	
	public List<User> getUsers() {
		return users;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Users: [");
		sb.append(users.stream().map(u -> u.toString()).collect(Collectors.joining(", ")));
		sb.append("]");
		return sb.toString();
	}

}
