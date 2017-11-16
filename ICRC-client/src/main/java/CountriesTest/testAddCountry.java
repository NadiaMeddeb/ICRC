package CountriesTest;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.Country;
import persistence.Donatoor;
import service.CountriesServiceLocal;
import service.CountriesServiceRemote;
import service.DonatorsServiceRemote;

public class testAddCountry {
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		CountriesServiceRemote csr = (CountriesServiceRemote) context
				.lookup("ICRC-ear/ICRC-ejb/CountriesService!service.CountriesServiceRemote");

		Country country = new Country();
		country.setName("Tunisia");
		country.setPib(300000);
		country.setSmig(2300);
	    csr.addCountry(country);

		
	}
	

}
