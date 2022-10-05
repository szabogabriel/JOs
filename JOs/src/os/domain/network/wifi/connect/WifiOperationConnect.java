package os.domain.network.wifi.connect;

import os.domain.Command;
import os.domain.Operation;
import os.domain.network.wifi.Wifi;
import os.domain.network.wifi.identify.WifiCommandList;
import os.executor.Executor;

public class WifiOperationConnect extends Operation<Wifi> {
	
	private static final String MODULE_NAME = "Wifi Connect";
	
	private String ssid = null;
	private String password = null;
	
	public WifiOperationConnect(Executor executor) {
		super(MODULE_NAME, executor);
	}
	
	public void setTargetNetwork(String ssid, String password) {
		this.ssid = ssid;
		this.password = password;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Command<Wifi>[] createCommands() {
		if (ssid == null || password == null) {
			throw new NullPointerException("No target network set.");
		}
		
		return new Command[] {new WifiCommandList(), new WifiCommandConnect(ssid, password), new WifiCommandList()};
	}

	@Override
	public Wifi createContext() {
		return new Wifi();
	}

}
