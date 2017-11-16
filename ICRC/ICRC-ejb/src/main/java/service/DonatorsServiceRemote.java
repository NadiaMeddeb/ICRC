package service;

import java.util.List;

import javax.ejb.Remote;

import persistence.Donatoor;

@Remote
public interface DonatorsServiceRemote {
	void saveOrUpdateDonator(Donatoor donator);

	void addDonator(Donatoor donator);

	void deleteDonator(Donatoor donator);

	Donatoor findDonatorById(int id);

	void updateDonator(Donatoor donator);

	void deleteDonatorById(int id);

	Donatoor login(String login, String password);

	List<Donatoor> findAllDonators();
	
	boolean hasCurrancy(int id, double amount);

	void updateBalance(int id, double amount);
	
	void addingBlance(int id, double amount);

}
