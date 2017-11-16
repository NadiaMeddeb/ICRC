package service;

import javax.ejb.Stateless;

import persistence.Commande;
import utilities.GenericDAO;

/**
 * Session Bean implementation class CommandService
 */
@Stateless
public class CommandService extends GenericDAO<Commande> implements CommandServiceRemote, CommandServiceLocal {

    /**
     * Default constructor. 
     */
    public CommandService() {
      super(Commande.class);
    }

}
