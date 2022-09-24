package os;

import java.util.stream.Collectors;

import os.domain.network.wifi.Wifi;
import os.domain.network.wifi.connect.WifiOperationConnect;
import os.domain.network.wifi.identify.WifiOperationIdentify;
import os.domain.user.User;
import os.domain.user.Users;
import os.domain.user.identify.UserOperationIdentify;
import os.domain.user.list.UserOperationList;

public class Test {
	
	public static void main(String [] args) {
		WifiOperationIdentify operation = Os.getOperation(WifiOperationIdentify.class);
		Wifi wifi = operation.execute();
		System.out.println("Enabled: " + wifi.isEnabled());
		System.out.println("Networks: " + wifi.getNetworks());
		
		System.out.println("---");
		User user = Os.getOperation(UserOperationIdentify.class).execute();
		System.out.println("Username: " + user.getUsername());
		
		System.out.println("---");
		Users users = Os.getOperation(UserOperationList.class).execute();
		System.out.println("Number of users: " + users.getUsers().size());
		System.out.println("Users: " + users.getUsers().stream().map(User::getUsername).collect(Collectors.joining(", ")));
	
		WifiOperationConnect connect = Os.getOperation(WifiOperationConnect.class);
		connect.setTargetNetwork("SID", "Password");
		Wifi wifi2 = connect.execute();
		System.out.println("Is connected: " + wifi2.getActiveNetwork().get().getSsid());
	}

}
