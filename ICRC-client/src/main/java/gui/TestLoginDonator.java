package gui;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.Donatoor;
import service.DonatorsServiceRemote;

public class TestLoginDonator {
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		DonatorsServiceRemote dsr = (DonatorsServiceRemote) context
				.lookup("ICRC-ear/ICRC-ejb/DonatorsService!service.DonatorsServiceRemote");
		Donatoor donator = dsr.login("tt", "tt");
		System.out.println(donator.getFirstName());
		

	}

}
