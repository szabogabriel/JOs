package os.domain.network.wifi.identify;

import os.domain.Command;
import os.domain.network.wifi.Wifi;
import os.domain.network.wifi.NetworkDetails;

public class WifiCommandList extends Command<Wifi> {

	private int BSSID;
	private int SSID;
	private int MODE;
	private int CHAN;
	private int RATE;
	private int SIGNAL;
	private int BARS;
	private int SECURITY;
	
	@Override
	public String getCommand() {
		return "nmcli dev wifi";
	}

	@Override
	public void parseResult(String content) {
		getContext().clearNetworks();
		content.lines().map(this::parseLine).filter(e -> e != null).forEach(getContext()::addWifiNetwork);
	}
	
	private NetworkDetails parseLine(String line) {
		if (line.startsWith("IN-USE")) {
			BSSID = line.indexOf("BSSID");
			SSID = line.indexOf(" SSID") + 1;
			MODE = line.indexOf("MODE");
			CHAN = line.indexOf("CHAN");
			RATE = line.indexOf("RATE");
			SIGNAL = line.indexOf("SIGNAL");
			BARS = line.indexOf("BARS");
			SECURITY = line.indexOf("SECURITY");
			return null;
		} else {
			boolean inUse = line.startsWith("*");
			String bssid = line.substring(BSSID, SSID).strip();
			String ssid = line.substring(SSID, MODE).strip();
			String mode = line.substring(MODE, CHAN).strip();
			String chan = line.substring(CHAN, RATE).strip();
			String rate = line.substring(RATE, SIGNAL).strip();
			String signal = line.substring(SIGNAL, BARS).strip();
			String security = line.substring(SECURITY).strip();
			return new NetworkDetails(inUse, bssid, ssid, mode, Integer.parseInt(chan), rate, Integer.parseInt(signal), security);
		}
	}

}
