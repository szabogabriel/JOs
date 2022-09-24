package os.domain.user.list;

import os.domain.Command;
import os.domain.user.User;
import os.domain.user.Users;

public class UserCommandListNames extends Command<Users> {

	@Override
	public String getCommand() {
		return "cut -d: -f1 /etc/passwd";
	}
	
	@Override
	public void parseResult(String content) {
		content.lines().map(l -> new User(l)).forEach(getContext()::addUser);
	}

}
