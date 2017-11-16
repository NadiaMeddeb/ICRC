package service;

import javax.ejb.Remote;

import persistence.Commande;
import utilities.IGenericDAO;

@Remote
public interface CommandServiceRemote extends IGenericDAO<Commande>{

}
