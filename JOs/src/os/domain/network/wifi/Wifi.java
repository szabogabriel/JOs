package os.domain.network.wifi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Wifi {
	
	private boolean enabled = false;
	private List<NetworkDetails> networks = new ArrayList<>();
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void addWifiNetwork(NetworkDetails network) {
		networks.add(network);
	}
	
	public void clearNetworks() { 
		networks.clear();
	}

	public List<NetworkDetails> getNetworks() {
		return networks;
	}
	
	public Optional<NetworkDetails> getActiveNetwork() {
		return networks.stream().filter(n -> n.isInUse()).findAny();
	}
	
}
