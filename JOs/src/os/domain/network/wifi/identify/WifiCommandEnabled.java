package os.domain.network.wifi.identify;

import os.domain.Command;
import os.domain.network.wifi.Wifi;

public class WifiCommandEnabled extends Command<Wifi> {

	@Override
	public String getCommand() {
		return "nmcli radio wifi";
	}

	@Override
	public void parseResult(String content) {
		getContext().setEnabled(content.startsWith("enabled"));
	}

}
