package os;

import java.util.List;
import java.util.stream.Collectors;

import os.config.Config;
import os.domain.Operation;
import os.domain.network.wifi.Wifi;
import os.domain.network.wifi.connect.WifiOperationConnect;
import os.domain.network.wifi.identify.WifiOperationIdentify;
import os.domain.user.User;
import os.domain.user.Users;
import os.domain.user.identify.UserOperationIdentify;
import os.domain.user.list.UserOperationList;
import os.util.ClassLoadingUtil;

public class Os {
	
	private static final Config CONFIG = new Config();
	
	public static List<Operation<?>> getOperations() {
		return CONFIG.getModuleClassName()
			.stream()
			.map(className -> ClassLoadingUtil.loadClass(className))
			.collect(Collectors.toList());
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends Operation<?>> T getOperation(Class<T> toClass) {
		Operation<?> ret = null;
		if (toClass != null) {
			String className = toClass.getCanonicalName();
			ret = ClassLoadingUtil.loadClass(className);
		}
		
		return (T)ret;
	}
	
}
