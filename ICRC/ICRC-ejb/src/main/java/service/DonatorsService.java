package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import persistence.Donatoor;

/**
 * Session Bean implementation class BasicOps
 */
@Stateless
public class DonatorsService implements DonatorsServiceLocal, DonatorsServiceRemote {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public DonatorsService() {
	}

	@Override
	public void addDonator(Donatoor donator) {
		entityManager.persist(donator);
	}

	@Override
	public void deleteDonator(Donatoor donator) {
		entityManager.remove(donator);
	}

	@Override
	public Donatoor findDonatorById(int id) {
		return entityManager.find(Donatoor.class, id);
	}

	@Override
	public void updateDonator(Donatoor donator) {
		entityManager.merge(donator);
	}

	@Override
	public void deleteDonatorById(int id) {
		entityManager.remove(findDonatorById(id));
	}

	@Override
	public Donatoor login(String login, String password) {
		Donatoor donator = new Donatoor();
		Query query = entityManager
				.createQuery("SELECT u FROM Donatoor u WHERE u.login=:param1 AND u.password=:param2");
		query.setParameter("param1", login);
		query.setParameter("param2", password);
		try {
			donator = (Donatoor) query.getSingleResult();
		} catch (Exception e) {
			System.err.println("user not found");
		}
		return donator;
	}

	@Override
	public void saveOrUpdateDonator(Donatoor donator) {
		entityManager.merge(donator);

	}

	@Override
	public List<Donatoor> findAllDonators() {
		String jpql = "SELECT u FROM Donatoor u";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();

	}

	@Override
	public boolean hasCurrancy(int id, double amount) {
		Donatoor d = findDonatorById(id);
		if(d.getBalance() >= amount)
		{
			return true ;
		}
		return false;
	}

	@Override
	public void updateBalance(int id, double amount) {
		Donatoor d = findDonatorById(id);
		d.setBalance(d.getBalance()-amount);
		updateDonator(d);
		
	}

	@Override
	public void addingBlance(int id, double amount) {
		Donatoor d = findDonatorById(id);
		d.setBalance(d.getBalance()+amount);
		updateDonator(d);
		
	}

}
