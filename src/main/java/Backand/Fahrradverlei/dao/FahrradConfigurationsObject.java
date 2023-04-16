package Backand.Fahrradverlei.dao;

import java.util.UUID;

public class FahrradConfigurationsObject {
	

	
		
		
		public String model;
		public UUID standortid;
		public String pictureLink;
		
		public FahrradConfigurationsObject(String model, UUID sid, String pictureLink) {
			super();
			this.model = model;
			this.standortid = sid;
			this.pictureLink = pictureLink;
		}
	
		
		
	
}
