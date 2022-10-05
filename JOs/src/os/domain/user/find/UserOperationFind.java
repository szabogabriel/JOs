package os.domain.user.find;

import os.domain.Command;
import os.domain.Operation;
import os.domain.user.Users;
import os.executor.Executor;

public class UserOperationFind extends Operation<Users>{

	private static final String MODULE_NAME = "User find";
	
	private String usernameToFind;
	
	private Users context = new Users();
	
	public UserOperationFind(Executor executor) {
		super(MODULE_NAME, executor);
	}
	
	public void setUsernameToFind(String username) {
		this.usernameToFind = username;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Command<Users>[] createCommands() {
		return new Command[] {new UserCommandFind(usernameToFind)};
	}

	@Override
	public Users createContext() {
		return context;
	}

}
