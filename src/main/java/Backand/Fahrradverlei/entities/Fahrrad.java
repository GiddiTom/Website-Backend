package Backand.Fahrradverlei.entities;


	
	import java.util.UUID;

	import javax.persistence.Column;
	import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
	import javax.validation.constraints.NotNull;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

	

	@Entity
	@Table(name="fahrrad")
	public class Fahrrad {
		
		@Id
		@Column(columnDefinition= "VARBINARY(16)")
		@GeneratedValue(strategy = GenerationType.AUTO)
		private UUID id;
		
		@Column
		@NotNull
		private String model;

		@Column
		@NotNull
		private int price;
		
		@ManyToOne(fetch=FetchType.LAZY)
		@NotFound(action=NotFoundAction.IGNORE)
		@JoinColumn(name = "standort_id", referencedColumnName = "id")
		private Standort standort;
		
		
		
		public Fahrrad() {
			
		}



		public Fahrrad(UUID id, @NotNull String model, @NotNull int price, Standort standort) {
			super();
			this.id = id;
			this.model = model;
			this.price = price;
			this.standort = standort;
		}



		public UUID getId() {
			return id;
		}



		public void setId(UUID id) {
			this.id = id;
		}



		public String getModel() {
			return model;
		}



		public void setModel(String model) {
			this.model = model;
		}



		public int getPrice() {
			return price;
		}



		public void setPrice(int price) {
			this.price = price;
		}



		public Standort getStandort() {
			return standort;
		}



		public void setStandort(Standort standort) {
			this.standort = standort;
		}

		
		
		
	}


