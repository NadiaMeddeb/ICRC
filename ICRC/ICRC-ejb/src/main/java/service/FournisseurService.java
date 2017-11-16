package service;

import javax.ejb.Stateless;
import persistence.Fournisseur;
import utilities.GenericDAO;

/**
 * Session Bean implementation class FournisseurService
 */
@Stateless
public class FournisseurService extends GenericDAO<Fournisseur> implements FournisseurServiceRemote, FournisseurServiceLocal {
       
    /**
     * @see Fournisseur#Fournisseur()
     */
    public FournisseurService() {
        super(Fournisseur.class);
        
    }

}
