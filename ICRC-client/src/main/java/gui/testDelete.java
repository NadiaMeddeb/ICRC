package gui;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.Donatoor;
import service.DonatorsServiceRemote;

public class testDelete {
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		DonatorsServiceRemote DSR = (DonatorsServiceRemote) context
				.lookup("ICRC-ear/ICRC-ejb/DonatorsService!service.DonatorsServiceRemote");

		
		

		DSR.deleteDonatorById(1);
	}
	

}
