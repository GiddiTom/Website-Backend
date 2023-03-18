package Backand.Fahrradverlei.dao;

import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import Backand.Fahrradverlei.entities.Standort;

public class BookingConfigurationsObject {
	
	public Date bookingDate;
	public Date apprxReturnDate;
	public UUID userID;
	public UUID fahrradID;
	public UUID startID;
	public UUID endeID;
	public boolean aktiv;
	
	public BookingConfigurationsObject(Date bookingDate, Date apprxReturnDate, UUID userID, UUID fahrradID, UUID startID, UUID endeID,boolean aktiv) {
		super();
		this.bookingDate = bookingDate;
		this.apprxReturnDate = apprxReturnDate;
		this.userID = userID;
		this.fahrradID = fahrradID;
		this.startID = startID;
		this.endeID = endeID;
		this.aktiv = aktiv;
	}
	
}
