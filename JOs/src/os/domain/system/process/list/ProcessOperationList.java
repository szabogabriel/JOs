package os.domain.system.process.list;

import java.util.ArrayList;
import java.util.List;

import os.domain.Command;
import os.domain.Operation;
import os.executor.Executor;

public class ProcessOperationList extends Operation<List<Process>> {

	private static final String MODULE_NAME = "Process list";
	
	private List<Process> context = new ArrayList<>();
	
	private String username = null;
	
	public ProcessOperationList(Executor executor) {
		super(MODULE_NAME, executor);
	}
	
	public void setTargetUsername(String username) {
		this.username = username;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Command<List<Process>>[] createCommands() {
		return new Command[] {new ProcessCommandList(username)};
	}

	@Override
	protected List<Process> createContext() {
		return context;
	}

}
