package service;

import javax.ejb.Local;

import persistence.Fournisseur;
import utilities.IGenericDAO;

@Local
public interface FournisseurServiceLocal extends IGenericDAO<Fournisseur> {

}
