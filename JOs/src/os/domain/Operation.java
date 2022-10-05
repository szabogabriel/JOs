package os.domain;

import os.executor.Executor;

public abstract class Operation<T> {
	
	private final String name;
	protected final Executor executor;
	
	public Operation(String name, Executor executor) {
		this.name = name;
		this.executor = executor;
	}
	
	public String getName() {
		return name;
	}
	
	public T execute() {
		T context = createContext();
		
		try {
			for (Command<T> it : createCommands()) {
				it.setContext(context);
				executor.execute(it);
			}
		} catch (IllegalArgumentException ex) {
			ex.printStackTrace();
		}
		
		return context;
	}
	
	public abstract Command<T>[] createCommands();
	
	public abstract T createContext();
	
}
