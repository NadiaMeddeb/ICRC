package service.CampService;

import java.util.List;

import javax.ejb.Remote;

import persistence.Camp;

@Remote
public interface CampServiceRemote {
	void saveOrUpdateCamp(Camp camp);

	void addCamp(Camp camp);

	void deleteCamp(Camp camp);

	Camp findCampById(int id);

	void updateCamp(Camp camp);

	void deleteCampById(int id);

	List<Camp> findAllCamps();

	boolean hasCurrancy(int id, double amount);

	void updateBalance(int id, double amount);

	void addingBlance(int id, double amount);
}
