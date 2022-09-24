package os.domain.user.identify;

import os.domain.Command;
import os.domain.Operation;
import os.domain.user.User;
import os.executor.Executor;

public class UserOperationIdentify extends Operation<User> {

	private static final String MODUL_NAME = "User identify";
	
	public UserOperationIdentify(Executor executor) {
		super(MODUL_NAME, executor);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected Command<User>[] createCommands() {
		return new Command[] {new UserCommandIdentify()};
	}

	@Override
	protected User createContext() {
		return new User();
	}

}
