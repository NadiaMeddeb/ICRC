package service;

import javax.ejb.Local;

import persistence.Commande;

import utilities.IGenericDAO;

@Local
public interface CommandServiceLocal extends IGenericDAO<Commande> {

}
