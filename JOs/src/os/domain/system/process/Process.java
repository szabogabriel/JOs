package os.domain.system.process;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

import os.domain.user.User;

public class Process {

	private int pid;
	private User user;
	private int parentPid;
	private String processClass;
	private LocalDateTime startDateTime;
	private String tty;
	private Duration duration;
	private String command;
	
	public Process() {
		
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getParentPid() {
		return parentPid;
	}

	public void setParentPid(int parentPid) {
		this.parentPid = parentPid;
	}

	public String getProcessClass() {
		return processClass;
	}

	public void setProcessClass(String processClass) {
		this.processClass = processClass;
	}

	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}

	public void setStartLocalDateTime(LocalDateTime startTime) {
		this.startDateTime = startTime;
	}

	public String getTty() {
		return tty;
	}

	public void setTty(String tty) {
		this.tty = tty;
	}

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}
	
	@Override
	public String toString() {
		return "Process [pid=" + pid + ", user=" + user + ", parentPid=" + parentPid + ", processClass=" + processClass
				+ ", startTime=" + startDateTime + ", tty=" + tty + ", duration=" + duration + ", command=" + command + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(command, duration, parentPid, pid, processClass, startDateTime, tty, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Process other = (Process) obj;
		return Objects.equals(command, other.command) && Objects.equals(duration, other.duration)
				&& parentPid == other.parentPid && pid == other.pid && Objects.equals(processClass, other.processClass)
				&& Objects.equals(startDateTime, other.startDateTime) && Objects.equals(tty, other.tty)
				&& Objects.equals(user, other.user);
	}

}
