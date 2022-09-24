package os.domain.user.add;

import os.domain.Command;
import os.domain.user.Group;
import os.domain.user.User;

public class UserCommandAddAdd extends Command<User> {

	@Override
	public String getCommand() {
		StringBuilder sb = new StringBuilder();
		User context = getContext();
		
		sb.append("useradd");
		
		if (context.getHomeFolder() != null) {
			sb.append(" -d ").append(context.getHomeFolder().getAbsolutePath());
		}
		if (context.getGroups() != null) {
			sb.append(" -G ");
			Group[] groups = context.getGroups();
			for (int i = 0; i < groups.length; i++) {
				sb.append(groups[i].getName());
				if (i != groups.length - 1) {
					sb.append(",");
				}
			}
		} else
		if (context.getGroup() != null) {
			sb.append(" -g ");
			sb.append(context.getGroup());
		}
		sb.append(" ").append(context.getUsername());
		
		return sb.toString();
	}

	@Override
	public void parseResult(String content) {
		// TODO Auto-generated method stub
		
	}

}
