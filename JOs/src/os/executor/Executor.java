package os.executor;

import java.io.ByteArrayOutputStream;
import java.io.File;

import os.domain.Command;

public class Executor {

	private ScriptExecutor scriptExecutor = new ScriptExecutor(new File("."));
	
	public <T> void execute(Command<T> command) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int returnCode = scriptExecutor.execute(command.getCommand(), command.getAttributes(), command.getBody(), out);
		String content = out.toString();
		command.parseResult(returnCode, content);
	}
	
}
