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
	@Table(name="Fahrrad")
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
		
		public Fahrrad() {
			
		}

		public Fahrrad(@NotNull String model,@NotNull int amount ) {
			super();
			this.model = model;
			this.price = amount;
			
		}

		public UUID getId() {
			return id;
		}

		public void setId(UUID id) {
			this.id = id;
		}
		
		public String getModel(String model) {
			return model;
		}

		public void setModel(String model) {
			this.model = model;
		}

		
		public int getPrice() {
			return price;
		}

		public void setPrice(int amount) {
			this.price = amount;
		}

		
		
	}


