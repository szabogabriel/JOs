package os.domain.system.process.list;

import java.io.BufferedReader;
import java.io.StringReader;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

import os.domain.Command;
import os.domain.system.process.Process;
import os.domain.user.User;

public class ProcessCommandList extends Command<List<Process>> {
	
	private final String username;
	
	public ProcessCommandList(String username) {
		this.username = username;
	}

	@Override
	public String getCommand() {
		String ret = "ps -f";
		if (username != null) {
			ret += " -u " + username;
		}
		return ret;
	}

	@Override
	public void parseResult(String content) {
		try (BufferedReader in = new BufferedReader(new StringReader(content))) { 
			in.readLine(); // skip header
			String line;
			while ((line = in.readLine()) != null) {
				getContext().add(createProcess(line));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Process createProcess(String line) {
		Process ret = new Process();
		String [] lineParts = line.split("\\s");
		int i = 0, skipped = 0;
		String buffer = "";
		while (i < lineParts.length) {
			buffer += lineParts[i];
			if (buffer.length() > 0) {
				switch (i - skipped) {
				case 0 : ret.setUser(getUserByName(buffer)); buffer = ""; break;
				case 1 : ret.setPid(Integer.parseInt(buffer)); buffer = ""; break;
				case 2 : ret.setParentPid(Integer.parseInt(buffer)); buffer = ""; break;
				case 3 : ret.setProcessClass(buffer); buffer = ""; break;
				case 4 : /*ret.setStartTime(LocalTime.parse(buffer)); */ buffer = ""; break; //TODO
				case 5 : ret.setTty(buffer); buffer = ""; break;
				case 6 : /* ret.setDuration(Duration.parse(buffer)); */ buffer = ""; break; //TODO
				default : buffer += " "; break;
				}
			} else {
				skipped++;
			}
			i++;
		}
		ret.setCommand(buffer);
		
		return ret;
	}
	
	private User getUserByName(String username) {
		//TODO: load the username dynamically from the system.
		User ret = new User();
		ret.setUsername(username);
		return ret;
	}

}
