package os.domain.network.wifi.identify;

import os.domain.Command;
import os.domain.Operation;
import os.domain.network.wifi.Wifi;
import os.executor.Executor;

public class WifiOperationIdentify extends Operation<Wifi> {
	
	private static final String MODULE_NAME = "Wifi identifier";

	public WifiOperationIdentify(Executor executor) {
		super(MODULE_NAME, executor);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Command<Wifi>[] createCommands() {
		return new Command[] {new WifiCommandEnabled(), new WifiCommandList()};
	}

	@Override
	public Wifi createContext() {
		return new Wifi();
	}


}
