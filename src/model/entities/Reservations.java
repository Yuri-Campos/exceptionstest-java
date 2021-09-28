package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservations {
	private String room;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	public Reservations(String room, Date checkIn, Date checkOut) {
		this.room = room;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}
	
	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duration() {
		long dateDiff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(dateDiff, TimeUnit.MILLISECONDS);
	}
	
	
	public long daysToTrip() {
		long daysToTrip = checkIn.getTime() - System.currentTimeMillis();
		return TimeUnit.DAYS.convert(daysToTrip, TimeUnit.MILLISECONDS);
	}

	public String updateDates(Date checkIn, Date checkOut) {
		Date now = new Date();
		if(checkIn.before(now) || checkOut.before(now)) {
			return "ERROR: The check-in and check-out date must be in a future date";
		}
		if(!checkOut.after(checkIn)) {
			return"ERROR: The check-out date must be after the check-in date";
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}


	@Override
	public String toString() {
		return 
				"Reservations: room: "
				+ room 
				+ ", Check-In: " 
				+ sdf.format(checkIn) 
				+ ", Check-Out: " 
				+ sdf.format(checkOut)
				+ ", duration: "
				+ duration()
				+ " Days";
	}
	
	
	
	
	
	
	
}
