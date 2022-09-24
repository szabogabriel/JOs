package os.domain.network.wifi.connect;

import os.config.ExitCodes;
import os.domain.Command;
import os.domain.network.wifi.Wifi;

public class WifiCommandConnect extends Command<Wifi> {
	
	private final String ssid;
	private final String password;

	public WifiCommandConnect(String ssid, String password) {
		this.ssid = ssid;
		this.password = password;
	}
	
	@Override
	public void setContext(Wifi network) {
		super.setContext(network);
		
		if (network.getNetworks().stream().filter(n -> ssid.equals(n.getSsid())).findAny().isEmpty()) {
			setReturnCode(ExitCodes.NO_SUCH_WIFI_SSID_PRESENT);
			throw new IllegalArgumentException("No such network present.");
		}
	}
	
	@Override
	public String getCommand() {
		return "nmcli dev wifi connect " + ssid + " password " + password;
	}

	@Override
	public void parseResult(String content) {
//		getContext().setInUse(content.contains("successfully activated"));
		//TODO
	}

}
