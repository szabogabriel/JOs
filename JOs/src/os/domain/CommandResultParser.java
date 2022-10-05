package os.domain;

public abstract class CommandResultParser<T> {
	
	protected T context;
	
	public CommandResultParser(T context) {
		this.context = context;
	}
	
	public abstract void parse(String output);
	
	protected T getContext() {
		return context;
	}

}
