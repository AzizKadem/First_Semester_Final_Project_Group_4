package model;

import java.time.LocalDateTime;
import java.time.format.*;

public class Date {
	private LocalDateTime dateTime;
	
	public Date() {
		dateTime = LocalDateTime.now();
	}

	/**
	 * Get date and time
	 * @return String of the date and time
	 */
	public String getDateTime() {
		return dateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
	}
	
	/**
	 * Get time
	 * @return String of time
	 */
	public String getTime() {
		return dateTime.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM));
	}
	
	/**
	 * Get date
	 * @return String of date
	 */
	public String getDate() {
		return dateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));
	}
	
	/**
	 * Update the time to the current time
	 */
	public void updateTime() {
		dateTime = LocalDateTime.now();
	}
}
