package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import persistence.Country;

@Stateless
public class CountriesService implements CountriesServiceLocal,CountriesServiceRemote {
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public CountriesService() {
	}

	@Override
	public void saveOrUpdateCountry(Country Country) {
		entityManager.merge(Country);
		
	}

	@Override
	public void addCountry(Country Country) {
		entityManager.persist(Country);
		
	}

	@Override
	public void deleteCountry(Country Country) {
		entityManager.remove(Country);
		
	}

	@Override
	public Country findCountryById(int id) {
		return entityManager.find(Country.class, id);
		
	}

	@Override
	public void updateCountry(Country Country) {
		entityManager.merge(Country);
		
	}

	@Override
	public void deleteCountryById(int id) {
		entityManager.remove(findCountryById(id));
		
	}

	@Override
	public List<Country> findAllCountrys() {
		String jpql = "SELECT u FROM Country u";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
		
	}

}
