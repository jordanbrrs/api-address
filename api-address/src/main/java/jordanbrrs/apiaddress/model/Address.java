package jordanbrrs.apiaddress.model;

public class Address {
	
	private Long ID;	 
	private String streetName;
	private String number;
	private String complement;
	private String neighbourhood;
	private String city;
	private String state;
	private String country;
	private String zipcode;
	private double latitude;
	private double longitude;
	
	public Long getID() {
		return this.ID;
	}
	
	public void setID(Long ID) {
		this.ID = ID;
	}
	
	public String getStreetName() {
		return this.streetName;
	}
	
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	
	public String getNumber(){
		return this.number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getComplement() {
		return this.complement;
	}
	
	public void setComplement(String complement) {
		this.complement = complement;
	} 
	
	public String getNeighbourhood() {
		return this.neighbourhood;
	}
	
	public void setNeighbourhood(String neighbourhood) {
		this.neighbourhood = neighbourhood;
	}
	
	public String getCity() {
		return this.city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
		
	public String getState() {
		return this.state;
	} 
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getCountry() {
		return this.country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getZipcode() {
		return this.zipcode;
	}
	
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	public double getLatitude() {
		return this.latitude;
	}
	
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public double getLongitude() {
		return this.longitude;
	}
	
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}		
}
