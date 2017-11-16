package service;

import java.util.List;

import javax.ejb.Remote;

import persistence.Country;

@Remote
public interface CountriesServiceRemote {
	void saveOrUpdateCountry(Country Country);

	void addCountry(Country Country);

	void deleteCountry(Country Country);

	Country findCountryById(int id);

	void updateCountry(Country Country);

	void deleteCountryById(int id);

	List<Country> findAllCountrys();

}
