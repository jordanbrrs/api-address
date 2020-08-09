package jordanbrrs.apiaddress.model;

public class Address {
	
	private Long ID;	 
	private String StreetName;
	private String Number;
	private String Complement;
	private String Neighbourhood;
	private String City;
	private String State;
	private String Country;
	private String Zipcode;
	private float latitude;
	private float longitude;
	
	public Address() {
		this.latitude = -15.7801f;
	}

}
