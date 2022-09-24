package os.domain.network.wifi;

public class NetworkDetails {

	private boolean isInUse;
	private String bssid;
	private String ssid;
	private String mode;
	private int channel;
	private String rate;
	private int signal;
	private String security;
	private String password;

	public NetworkDetails() {
		isInUse = false;
		bssid = "";
		ssid = "";
		mode = "";
		channel = 0;
		rate = "";
		signal = 0;
		security = "";
		password = "";
	}

	public NetworkDetails(boolean isInUse, String bssid, String ssid, String mode, int channel, String rate, int signal,
			String security) {
		this.isInUse = isInUse;
		this.bssid = bssid;
		this.ssid = ssid;
		this.mode = mode;
		this.channel = channel;
		this.rate = rate;
		this.signal = signal;
		this.security = security;
	}

	public void setInUse(boolean isInUse) {
		this.isInUse = isInUse;
	}

	public void setBssid(String bssid) {
		this.bssid = bssid;
	}

	public void setSsid(String ssid) {
		this.ssid = ssid;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public void setSignal(int signal) {
		this.signal = signal;
	}

	public void setSecurity(String security) {
		this.security = security;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isInUse() {
		return isInUse;
	}

	public String getBssid() {
		return bssid;
	}

	public String getSsid() {
		return ssid;
	}

	public String getMode() {
		return mode;
	}

	public int getChannel() {
		return channel;
	}

	public String getRate() {
		return rate;
	}

	public int getSignal() {
		return signal;
	}

	public String getSecurity() {
		return security;
	}
	
	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		StringBuilder ret = new StringBuilder();
		ret.append("(Wifi:").append("IN USE: ").append(isInUse).append(", ").append("BSSID: ").append(bssid)
				.append(", ").append("SSID: ").append(ssid).append(", ").append("MODE: ").append(mode).append(", ")
				.append("CHANNEL: ").append(channel).append(", ").append("RATE: ").append(rate).append(", ")
				.append("SIGNAL: ").append(signal).append(", ").append("SECURITY: ").append(security).append(", ")
				.append("PASSWORD: ").append(password).append(")");
		return ret.toString();
	}

}
