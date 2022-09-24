# JOs
Java bridge for configuring operating systems

## Motivation

This project was created as a necessity for the [Password Pi](https://github.com/szabogabriel/PasswordPI) project so it would be able to list and connect to WiFi without the necessity to implement the command line commands. The tool currently focuses on the Linux operating system.

## Operation

The API consist of two main classes; the [Operation](https://github.com/szabogabriel/JOs/blob/main/JOs/src/os/domain/Operation.java) and the [Command](https://github.com/szabogabriel/JOs/blob/main/JOs/src/os/domain/Command.java) classes, where one Operation can consist of several Commands. Every Command receives a context object which is pre-defined as the domain object during the execution.

The available Operations can be acquired via the [Os](https://github.com/szabogabriel/JOs/blob/main/JOs/src/os/Os.java) class. This class doesn't perform any classpath scan, so it either creates Operation instances by using reflection based on the Operation class name, or it parses the configuration file provided either as an environment variable `os.api.config` or the default `os.properties`, if present.

Code examples can be found in the [Test](https://github.com/szabogabriel/JOs/blob/main/JOs/test/os/Test.java). An example code for listing available users can be as follows

``` Java
package os;

import java.util.stream.Collectors;

import os.domain.user.Users;
import os.domain.user.list.UserOperationList;

public class Test {
	
	public static void main(String [] args) {
		System.out.println("---");
		Users users = Os.getOperation(UserOperationList.class).execute();
		System.out.println("Number of users: " + users.getUsers().size());
		System.out.println("Users: " + users.getUsers().stream().map(User::getUsername).collect(Collectors.joining(", ")));
	}

}

```

## Limitations

The JOs utility builds on shell commands like `cat` or `nmcli`. These commands must be available in the system. 

The privileges of the user running this library must match the privilege and group requirements of the given commands.
