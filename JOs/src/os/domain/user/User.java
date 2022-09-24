package os.domain.user;

import java.io.File;

public class User {

	private int userId;
	private String username;
	private Group group;
	private Group[] groups;
	private File homeFolder;

	public User() {

	}
	
	public User(String username) {
		this.username = username;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public void setGroups(Group[] groups) {
		this.groups = groups;
	}

	public int getUserId() {
		return userId;
	}

	public String getUsername() {
		return username;
	}

	public Group getGroup() {
		return group;
	}

	public Group[] getGroups() {
		return groups;
	}
	
	public void setHomeFolder(File folder) {
		this.homeFolder = folder;
	}
	
	public File getHomeFolder() {
		return homeFolder;
	}

	@Override
	public String toString() {
		StringBuilder ret = new StringBuilder();
		ret.append("uid=").append(userId).append("(").append(username).append(") ").append("gid=")
				.append(group.toString()).append(" ").append("groups=");
		for (int i = 0; i < groups.length; i++) {
			ret.append(groups[i].toString());
			if (i + 1 < groups.length)
				ret.append(",");
		}
		return ret.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userId != other.userId)
			return false;
		return true;
	}

}
