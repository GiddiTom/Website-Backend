package Backand.Fahrradverlei.dao;

import java.util.UUID;

public class FahrradConfigurationsObject {
	

	
		
		
		public String model;
		public int price;
		public UUID standortid;
		public String pictureLink;
		
		public FahrradConfigurationsObject(String model, int price, UUID sid, String pictureLink) {
			super();
			this.model = model;
			this.price = price;;
			this.standortid = sid;
			this.pictureLink = pictureLink;
		}
	
		
		
	
}
