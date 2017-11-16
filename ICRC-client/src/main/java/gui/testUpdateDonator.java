package gui;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.Donatoor;
import persistence.Fournisseur;
import service.DonatorsServiceRemote;
import service.FournisseurServiceRemote;

public class testUpdateDonator {
	public static void main(String[] args) throws NamingException {
		
		
		Context context = new InitialContext();
		FournisseurServiceRemote fsr = (FournisseurServiceRemote) context
				.lookup("ICRC-ear/ICRC-ejb/FournisseurService!service.FournisseurServiceRemote");
		Fournisseur fournisseur= new Fournisseur();
		fournisseur.setAdresse("ss");
		fournisseur.setCodePostale(55);
		

		fsr.save(fournisseur);

	}
}
