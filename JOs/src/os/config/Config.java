package os.config;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Config {

	private static final String ENV_VARIABLE_NAME = "os.api.config";
	private static final String DEFAULT_CONFIG_FILE = "./os.properties";
	
	private static final String OPERATION_PREFIX = "operation";

	private Map<String, String> configValues = new HashMap<>();

	public Config() {
		File fileToRead = new File(DEFAULT_CONFIG_FILE);
		String env = System.getenv(ENV_VARIABLE_NAME);
		if (env != null) {
			fileToRead = new File(env);
		}
		if (!fileToRead.exists()) {
			throw new IllegalArgumentException("Missing configuration file.");
		}
		try {
			parseConfigFile(fileToRead);
		} catch (IOException e) {
			throw new IllegalArgumentException("Missing configuration file.");
		}
	}

	private void parseConfigFile(File configFile) throws IOException {
		List<String> configLines = Files.readAllLines(configFile.toPath());
		
		for (String line : configLines) {
			String[] parsedLine = line.split("=");
			String key = parsedLine[0].strip();
			String value = parsedLine[1].strip();
			configValues.put(key, value);
		}
	}

	public List<String> getModuleClassName() {
		return configValues.keySet().stream()
				.filter(key -> key.startsWith(OPERATION_PREFIX))
				.map(key -> configValues.get(key))
				.collect(Collectors.toList());
	}
	
}
