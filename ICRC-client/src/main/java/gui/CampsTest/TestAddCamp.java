package gui.CampsTest;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.Camp;
import persistence.Donatoor;
import service.DonatorsServiceRemote;
import service.CampService.CampServiceRemote;

public class TestAddCamp {
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		CampServiceRemote CSR = (CampServiceRemote) context
				.lookup("ICRC-ear/ICRC-ejb/CampService!service.CampService.CampServiceRemote");
		Camp camp = new Camp();
		camp.setName("CampPNERF");
		camp.setBalance(3000);
		CSR.addCamp(camp);

		
			
	}

}
