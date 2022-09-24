package os.domain;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public abstract class Command<T> {
	
	private int returnCode;
	
	private T context;
	
	public int getReturnCode() {
		return returnCode;
	}
	
	public void setReturnCode(int code) {
		this.returnCode = code;
	}
	
	public void setContext(T context) {
		this.context = context;
	}
	
	public T getContext() {
		return context;
	}
	
	public abstract String getCommand();
	
	public String[] getAttributes() {
		return new String[] {};
	}
	
	public InputStream getBody() {
		return new ByteArrayInputStream(new byte[] {});
	}
	
	public void parseResult(int returnCode, String content) {
		setReturnCode(returnCode);
		parseResult(content);
	}
	
	public abstract void parseResult(String content);

}
