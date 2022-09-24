package os.domain.user.add;

import os.domain.Command;
import os.domain.Operation;
import os.domain.user.User;
import os.executor.Executor;

public class UserOperationAdd extends Operation<User> {
	
	private static final String MODUL_NAME = "User add";
	
	private User targetUser;

	public UserOperationAdd(Executor executor) {
		super(MODUL_NAME, executor);
	}
	
	public void setTargetUser(User user) {
		this.targetUser = user;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Command<User>[] createCommands() {
		return new Command[]{
				new UserCommandAddAdd(),
				new UserCommandAddSetId()
			};
	}

	@Override
	protected User createContext() {
		return targetUser;
	}

}
