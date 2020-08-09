package jordanbrrs.apiaddress.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import jordanbrrs.apiaddress.model.Address;

@Service
public class AddressService {
	
	private List<Address> addresses;
	
	public AddressService() {
		this.addresses = new ArrayList<Address>();
	}
		
	public boolean isJSONValid(String jsonInString) {
	    try {
	       return new ObjectMapper().readTree(jsonInString) != null;
	    } catch (IOException e) {
	       return false;
	    }
	}
	
	private double parseDouble(String value) {
		return Double.parseDouble(value);
	}
	
	private long parseId(String value) {
		return Long.valueOf(value);
	}
	
	public boolean Create(JSONObject jsonAddress) {	
		Address address = CreateObjectAddress(jsonAddress);
		if(address != null && ValidateAddress(address)) {
			return InsertAddress(address);
		} else {
			return false;	
		}
	}
	
	public boolean Update(Long ID, JSONObject jsonAddress) {
		Address addressUpdate = FindById(ID);
		if(addressUpdate != null) {
			ConvertoJSONToAddress(jsonAddress, addressUpdate);
			return true;
		} else {
			return false;
		}
	}
		
	public boolean Delete(long ID) { 
		if(addresses != null && ID > 0) {
			Address address = FindById(ID);
			return addresses.remove(address);
		} else {
			return false;
		}
	}
	
	private boolean ValidateAddress(Address address) {
		return true;
	}
	
	private Address CreateObjectAddress(JSONObject jsonAddress) {
		Address address = new Address();
		try {
			ConvertoJSONToAddress(jsonAddress, address);		
		}catch(Exception e) {			
			return null;
		}		 			
		return address;
	}
	
	private void ConvertoJSONToAddress(JSONObject jsonAddress, Address address) {
		address.setID(jsonAddress.get("id") != null ? parseId(jsonAddress.get("id").toString()) : address.getID() );
		address.setStreetName(jsonAddress.get("streetName") != null ? jsonAddress.get("streetName").toString() : address.getStreetName() );
		address.setNumber(jsonAddress.get("number") != null ? jsonAddress.get("number").toString() : address.getNumber() );
		address.setComplement(jsonAddress.get("complement") != null ? jsonAddress.get("complement").toString() : address.getComplement() );
		address.setNeighbourhood(jsonAddress.get("neighbourhood") != null ? jsonAddress.get("neighbourhood").toString() : address.getNeighbourhood() );
		address.setCity(jsonAddress.get("city") != null ? jsonAddress.get("city").toString() : address.getCity() );
		address.setState(jsonAddress.get("state") != null ? jsonAddress.get("state").toString() : address.getState() );
		address.setCountry(jsonAddress.get("country") != null ? jsonAddress.get("country").toString() : address.getCountry() );
		address.setZipcode(jsonAddress.get("zipcode") != null ? jsonAddress.get("zipcode").toString() : address.getZipcode() );
		address.setLatitude(jsonAddress.get("latitude") != null ? parseDouble(jsonAddress.get("latitude").toString()) : address.getLatitude() );
		address.setLongitude(jsonAddress.get("longitude") != null ? parseDouble(jsonAddress.get("longitude").toString()) : address.getLongitude());
	}
	
	private boolean InsertAddress(Address address) {
		return addresses.add(address);
	}
	
	public List<Address> Get() {
		return addresses;
	}
	
	public Address FindById(Long id) {
		List<Address> listFind = addresses.stream().filter(t -> id == t.getID()).collect(Collectors.toList());
		if(listFind != null && !listFind.isEmpty()) {
			return listFind.get(0);
		} else {
			return null;
		} 
	}	
}
