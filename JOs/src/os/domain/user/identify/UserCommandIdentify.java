package os.domain.user.identify;

import java.util.ArrayList;
import java.util.List;

import os.domain.Command;
import os.domain.user.Group;
import os.domain.user.User;

public class UserCommandIdentify extends Command<User> {
	
	private String username;
	
	public UserCommandIdentify() {
		this(null);
	}
	
	public UserCommandIdentify(String username) {
		this.username = username;
	}
	
	@Override
	public String getCommand() {
		return "id" + ((username != null) ? " username" : "");
	}

	@Override
	public void parseResult(String response) {
		parseIdLine(response, getContext());
	}
	
	private void parseIdLine(String line, User user) {
		String[] tmp = line.split(" ");
		
		for (String it : tmp) {
			if (it.startsWith("uid")) {
				String[] tmp2 = it.substring(4).split("[\\(]");
				user.setUserId(Integer.parseInt(tmp2[0]));
				user.setUsername(tmp2[1].substring(0, tmp2[1].length() - 1));
			}
			if (it.startsWith("gid")) {
				Group group = null;
				String[] tmp2 = it.substring(4).split("[\\(]");
				String gid = tmp2[0];
				String gidname = tmp2[1].substring(0, tmp2[1].length() - 1);
				group = new Group(Integer.parseInt(gid), gidname);
				user.setGroup(group);
			}
			if (it.startsWith("groups")) {
				List<Group> groups = new ArrayList<>();
				String[] tmp2 = it.substring(7).split(",");
				for (String it2 : tmp2) {
					String[] tmp3 = it2.split("[\\(]");
					Group tmpgroup = new Group(Integer.parseInt(tmp3[0]), tmp3[1].substring(0, tmp3[1].length() - 1));
					groups.add(tmpgroup);
				}
				user.setGroups(groups.toArray(Group[]::new));
			}
		}
	}

}
