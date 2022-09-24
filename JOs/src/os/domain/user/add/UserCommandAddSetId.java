package os.domain.user.add;

import os.domain.Command;
import os.domain.user.User;

public class UserCommandAddSetId extends Command<User>{

	@Override
	public String getCommand() {
		String username = getContext().getUsername();
		
		return "cat /etc/passwd | grep " + username + " | awk -F: '{print $3}'";
	}

	@Override
	public void parseResult(String content) {
		try {
			Integer userid = Integer.parseInt(content);
			getContext().setUserId(userid);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
