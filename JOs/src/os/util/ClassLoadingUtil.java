package os.util;

import java.lang.reflect.Constructor;

import os.config.ExitCodes;
import os.domain.Operation;
import os.executor.Executor;

public class ClassLoadingUtil {

	public static Operation<?> loadClass(String className) {
		try {
			Class<?> cl = Class.forName(className);
			
			Constructor<?> constructor = cl.getConstructor(Executor.class);
			
			return (Operation<?>) constructor.newInstance(new Executor());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.exit(ExitCodes.ERROR_WHEN_LOADING_CLASS);		
		return null;
	}
	
}
