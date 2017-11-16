package service.CampService;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import persistence.Camp;
import persistence.Donatoor;

@Stateless
public class CampService implements CampServiceLocal, CampServiceRemote {
	@PersistenceContext
	private EntityManager entityManager;

	public CampService() {
	}

	@Override
	public void saveOrUpdateCamp(Camp camp) {
		entityManager.merge(camp);

	}

	@Override
	public void addCamp(Camp camp) {
		entityManager.persist(camp);

	}

	@Override
	public void deleteCamp(Camp camp) {
		entityManager.remove(camp);

	}

	@Override
	public Camp findCampById(int id) {
		return entityManager.find(Camp.class, id);

	}

	@Override
	public void updateCamp(Camp camp) {
		entityManager.merge(camp);

	}

	@Override
	public void deleteCampById(int id) {
		entityManager.remove(findCampById(id));

	}

	@Override
	public List<Camp> findAllCamps() {
		String jpql = "SELECT c FROM Camp c";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();

	}

	@Override
	public boolean hasCurrancy(int id, double amount) {
		Camp d = findCampById(id);
		if (d.getBalance() >= amount) {
			return true;
		}
		return false;

	}

	@Override
	public void updateBalance(int id, double amount) {
		Camp d = findCampById(id);
		d.setBalance(d.getBalance()-amount);
		updateCamp(d);
	}

	@Override
	public void addingBlance(int id, double amount) {
		Camp d = findCampById(id);
		d.setBalance(d.getBalance()+amount);
		updateCamp(d);
		
	}

}
