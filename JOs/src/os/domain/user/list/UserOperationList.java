package os.domain.user.list;

import os.domain.Command;
import os.domain.Operation;
import os.domain.user.Users;
import os.executor.Executor;

public class UserOperationList extends Operation<Users>{
	
	private static final String MODULE_NAME = "Users List";

	public UserOperationList(Executor executor) {
		super(MODULE_NAME, executor);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Command<Users>[] createCommands() {
		return new Command[] {new UserCommandListNames()};
	}

	@Override
	protected Users createContext() {
		return new Users();
	}

}
