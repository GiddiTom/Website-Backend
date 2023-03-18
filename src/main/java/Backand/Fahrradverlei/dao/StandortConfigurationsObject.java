package Backand.Fahrradverlei.dao;

public class StandortConfigurationsObject {

	
	
	public String name;
	public String adresse;
	public double longitude;
	public double latitude;
	public String pictureLink;
	
	public StandortConfigurationsObject(String name, String adresse, double longitude, double latitude, String pictureLink) {
		super();
		this.name = name;
		this.adresse = adresse;
		this.longitude = longitude;
		this.latitude = latitude;
		this.pictureLink = pictureLink;
	}
}
