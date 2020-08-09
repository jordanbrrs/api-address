package jordanbrrs.apiaddress.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jordanbrrs.apiaddress.model.Address;
import jordanbrrs.apiaddress.service.AddressService;

@RestController
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@GetMapping(path = "/address")
	public ResponseEntity<List<Address>> Get() {		
		return ResponseEntity.ok(addressService.Get());
	}
	
	@PostMapping(path = "/address")
	@ResponseBody
	public ResponseEntity<Boolean> create(@RequestBody JSONObject jsonAddress) {
		try {
			if(addressService.isJSONValid(jsonAddress.toString())) {
				boolean addressCreated = addressService.Create(jsonAddress);							
				return ResponseEntity.ok(addressCreated);
			
			}else {
				return ResponseEntity.badRequest().body(null);
			}
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
		}
	}
	
	@PutMapping(path = "/address/{id}", produces = { "application/json" })
	public ResponseEntity<Boolean> create(@PathVariable("id") long id, @RequestBody JSONObject jsonAddress) {
		try {
			if(addressService.isJSONValid(jsonAddress.toString())) {
				boolean addressUpdate = addressService.Update(id, jsonAddress);
				return ResponseEntity.ok(addressUpdate);
				
			}else {
				return ResponseEntity.badRequest().body(null);
			}
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
		}
	}
	
	@DeleteMapping(path = "/address/{id}", produces = { "application/json" })
	public ResponseEntity<Boolean> delete(@PathVariable("id") long id) {
		try {
			addressService.Delete(id);
			return ResponseEntity.noContent().build();
		}catch(Exception e) {			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}	
	
}
