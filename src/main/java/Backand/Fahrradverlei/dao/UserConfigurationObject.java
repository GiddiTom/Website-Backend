package Backand.Fahrradverlei.dao;



	import java.util.UUID;

	public class UserConfigurationObject {
		
	
		public String firstName;
		public String name;
		public String email;
		public String password;
		public UUID roleID;
		public String street;
		public String number;
		public int plz;
		public String city;
		public byte[] Signatur;
		
	
		
		public UserConfigurationObject(String firstName, String name, String email, String password,
				UUID roleID, String street, String number, int plz, String city, byte[] Signatur) {
			super();
			this.firstName = firstName;
			this.name = name;
			this.email = email;
			this.password = password;
			this.roleID = roleID;
			this.street = street;
			this.number = number;
			this.plz = plz;
			this.city = city;
			this.Signatur = Signatur;
			
		}
		
	}
