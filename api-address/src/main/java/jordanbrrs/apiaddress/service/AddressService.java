package jordanbrrs.apiaddress.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import jordanbrrs.apiaddress.model.Address;

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
	
	public boolean Create(JSONObject jsonTransaction) {
		
	}
	
	
	
	
}
