package service;

import javax.ejb.Remote;


import persistence.Fournisseur;
import utilities.IGenericDAO;

@Remote
public interface FournisseurServiceRemote extends IGenericDAO<Fournisseur> {

}
