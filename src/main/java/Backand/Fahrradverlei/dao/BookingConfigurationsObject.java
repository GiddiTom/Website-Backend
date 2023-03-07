package Backand.Fahrradverlei.dao;

import java.sql.Date;
import java.util.UUID;

public class BookingConfigurationsObject {
	
	public Date bookingDate;
	public Date apprxReturnDate;
	public UUID userID;
	public UUID fahrradID;
	
	public BookingConfigurationsObject(Date bookingDate, Date apprxReturnDate, UUID userID, UUID fahrradID) {
		super();
		this.bookingDate = bookingDate;
		this.apprxReturnDate = apprxReturnDate;
		this.userID = userID;
		this.fahrradID = fahrradID;
	}
	
}
