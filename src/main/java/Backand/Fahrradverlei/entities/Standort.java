package Backand.Fahrradverlei.entities;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="standort")
public class Standort {

	@Id
	@Column(columnDefinition= "VARBINARY(16)")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@Column
	@NotNull
	private String name;

	@Column
	@NotNull
	private String adresse;
	
	@Column
	@NotNull
	private double longitude;
	
	@Column
	@NotNull
	private double latitude;
	
	@Column
	@NotNull
	private String pictureLink;
	
	
	public Standort() {
		
	}

	public Standort(UUID id, @NotNull String name, @NotNull String adresse, @NotNull double longitude,
			@NotNull double latitude, String pictureLink) {
		super();
		this.id = id;
		this.name = name;
		this.adresse = adresse;
		this.longitude = longitude;
		this.latitude = latitude;
		this.pictureLink = pictureLink;
	}


	public UUID getId() {
		return id;
	}


	public void setId(UUID id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public double getLongitude() {
		return longitude;
	}


	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


	public double getLatitude() {
		return latitude;
	}


	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String getPictureLink() {
		return pictureLink;
	}

	public void setPictureLink(String pictureLink) {
		this.pictureLink = pictureLink;
	}
	
	
}
