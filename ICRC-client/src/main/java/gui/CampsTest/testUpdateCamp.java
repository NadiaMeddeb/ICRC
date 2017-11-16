package gui.CampsTest;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.Camp;
import persistence.Donatoor;
import service.DonatorsServiceRemote;
import service.CampService.CampServiceRemote;

public class testUpdateCamp {
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		CampServiceRemote Csr = (CampServiceRemote) context
				.lookup("ICRC-ear/ICRC-ejb/CampService!service.CampService.CampServiceRemote");
		Camp camp = (Camp) Csr.findCampById(1);

		camp.setBalance(200);

		Csr.updateCamp(camp);

	}

}
