package jordanbrrs.apiaddress.model;

import java.util.ArrayList;
import java.util.List;

public class ResultResponse {
		
	private List<String> erros;
	private boolean success;
	
	public ResultResponse() {
		erros = new ArrayList<String>();
	}
	
	public void AddError(String erro) {
		erros.add(erro);
	} 
	
	public List<String> getErros(){
		return this.erros;
	}
	
	public boolean getSuccess() {
		this.success = this.erros.isEmpty();
		return this.success; 
	}
}
