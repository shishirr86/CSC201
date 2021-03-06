// Student: Mahbub Rahman

// Fig. 8.5: Time2Tick.java
// Time2Tick class declaration with overloaded constructors.  

public class Time2Tick {
	private int hour; // 0 - 23
	private int minute; // 0 - 59
	private int second; // 0 - 59

	// Time2Tick no-argument constructor:
	// initializes each instance variable to zero
	public Time2Tick() {
		this(0, 0, 0); // invoke constructor with three arguments
	}

	// Time2Tick constructor: hour supplied, minute and second defaulted to 0
	public Time2Tick(int hour) {
		this(hour, 0, 0); // invoke constructor with three arguments
	}

	// Time2Tick constructor: hour and minute supplied, second defaulted to 0
	public Time2Tick(int hour, int minute) {
		this(hour, minute, 0); // invoke constructor with three arguments
	}

	// Time2Tick constructor: hour, minute and second supplied
	public Time2Tick(int hour, int minute, int second) {
		if (hour < 0 || hour >= 24)
			throw new IllegalArgumentException("hour must be 0-23");

		if (minute < 0 || minute >= 60)
			throw new IllegalArgumentException("minute must be 0-59");

		if (second < 0 || second >= 60)
			throw new IllegalArgumentException("second must be 0-59");

		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	// Time2Tick constructor: another Time2Tick object supplied
	public Time2Tick(Time2Tick time) {
		// invoke constructor with three arguments
		this(time.getHour(), time.getMinute(), time.getSecond());
	}

	// Set Methods
	// set a new time value using universal time;
	// validate the data
	public void setTime(int hour, int minute, int second) {
		if (hour < 0 || hour >= 24)
			throw new IllegalArgumentException("hour must be 0-23");

		if (minute < 0 || minute >= 60)
			throw new IllegalArgumentException("minute must be 0-59");

		if (second < 0 || second >= 60)
			throw new IllegalArgumentException("second must be 0-59");

		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	// validate and set hour
	public void setHour(int hour) {
		if (hour < 0 || hour >= 24)
			throw new IllegalArgumentException("hour must be 0-23");

		this.hour = hour;
	}

	// validate and set minute
	public void setMinute(int minute) {
		if (minute < 0 || minute >= 60)
			throw new IllegalArgumentException("minute must be 0-59");

		this.minute = minute;
	}

	// validate and set second
	public void setSecond(int second) {
		if (second < 0 || second >= 60)
			throw new IllegalArgumentException("second must be 0-59");

		this.second = second;
	}

	// Get Methods
	// get hour value
	public int getHour() {
		return hour;
	}

	// get minute value
	public int getMinute() {
		return minute;
	}

	// get second value
	public int getSecond() {
		return second;
	}

	// increment second
	public void tick() {
		if (getSecond() == 59) {
			setSecond(0);
			incrementMinute();
		}
		else
			setSecond(getSecond() + 1);
	}

	// increment minute
	public void incrementMinute() {
		if (getMinute() == 59) {
			setMinute(0);
			incrementHour();
		}
		else
			setMinute(getMinute() + 1);
	}

	// increment hour
	public void incrementHour() {
		if (getHour() == 23) 
			setHour(0);
		else
			setHour(getHour() + 1);
	}

	// convert to String in universal-time format (HH:MM:SS)
	public String toUniversalString() {
		return String.format("%02d:%02d:%02d", getHour(), getMinute(), getSecond());
	}

	// convert to String in standard-time format (H:MM:SS AM or PM)
	public String toString() {
		return String.format("%d:%02d:%02d %s", ((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12),
				getMinute(), getSecond(), (getHour() < 12 ? "AM" : "PM"));
	}
} // end class Time2Tick

/**************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and * Pearson Education,
 * Inc. All Rights Reserved. * * DISCLAIMER: The authors and publisher of this
 * book have used their * best efforts in preparing the book. These efforts
 * include the * development, research, and testing of the theories and programs
 * * to determine their effectiveness. The authors and publisher make * no
 * warranty of any kind, expressed or implied, with regard to these * programs
 * or to the documentation contained in these books. The authors * and publisher
 * shall not be liable in any event for incidental or * consequential damages in
 * connection with, or arising out of, the * furnishing, performance, or use of
 * these programs. *
 *************************************************************************/
