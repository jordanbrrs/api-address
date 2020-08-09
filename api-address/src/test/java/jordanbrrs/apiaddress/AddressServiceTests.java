package jordanbrrs.apiaddress;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.json.simple.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;

import jordanbrrs.apiaddress.model.Address;
import jordanbrrs.apiaddress.service.AddressService;

import org.junit.jupiter.api.TestInstance.Lifecycle;

@SpringBootTest
@ActiveProfiles("test")
@TestInstance(Lifecycle.PER_CLASS)
public class AddressServiceTests {
			
	private List<Address> adresses;
	private JSONObject jsonAddress;
	private AddressService addressService;
	
	@BeforeAll
	public void setUp() {
		AddressCreateMocked();
		addressService = new AddressService();
	}	
	
	@Test
	public void CreateTest() throws JsonProcessingException {	
		boolean insert = this.addressService.Create(this.jsonAddress).getSuccess();
		assertEquals(true, insert);
	}
	
	@Test	
	public void Get(){		
		assertEquals(true, !addressService.Get().isEmpty());
	}
	
	@Test
	public void UpdateTest() throws JsonProcessingException {
		this.jsonAddress.put("streetName", "Rua teste update");
		boolean update = this.addressService.Update(1l, this.jsonAddress);
		assertEquals(true, update);
	}
	
	@Test
	public void DeleteTest() throws JsonProcessingException {
		JSONObject jsonAddressDeleted = AddressMockedDeleted();
		this.addressService.Create(jsonAddressDeleted);
		boolean delete = this.addressService.Delete(2l);
		assertEquals(true, delete);
	}	
		
	private void AddressCreateMocked() {
		jsonAddress = new JSONObject();
		jsonAddress.put("id",1l);
		jsonAddress.put("streetName","Rua xyz");
		jsonAddress.put("number", "452");
		jsonAddress.put("complement","23");
		jsonAddress.put("neighbourhood","Jardim Europa");
		jsonAddress.put("city","Campinas");
		jsonAddress.put("state", "SP");
		jsonAddress.put("country","Brasil");
		jsonAddress.put("zipcode","13030-240");
		jsonAddress.put("latitude",-22.8987796);
		jsonAddress.put("longitude",-89.0667198);
	}
	
	private JSONObject AddressMockedDeleted() {
		JSONObject jsonAddressDeleted = new JSONObject();
		jsonAddressDeleted.put("id",2l);
		jsonAddressDeleted.put("streetName","Rua x");
		jsonAddressDeleted.put("number", "12");
		jsonAddressDeleted.put("complement","");
		jsonAddressDeleted.put("neighbourhood","Bairro x");
		jsonAddressDeleted.put("city","Campinas");
		jsonAddressDeleted.put("state", "SP");
		jsonAddressDeleted.put("country","Brasil");
		jsonAddressDeleted.put("zipcode","13020-240");
		jsonAddressDeleted.put("latitude",-22.8987864);
		jsonAddressDeleted.put("longitude",-47.0667198);
		
		return jsonAddressDeleted;
	}
	

}
