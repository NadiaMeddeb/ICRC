package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Synchronization;
import javax.transaction.TransactionSynchronizationRegistry;

import persistence.Country;
import persistence.Transaction;

@Stateless
public class TransactionService implements TransactionServiceLocal,TransactionServiceRemote {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public TransactionService() {
	}

	
	@Override
	public void saveOrUpdateTransaction(Transaction Transaction) {
		entityManager.merge(Transaction);		
	}

	@Override
	public void addTransaction(Transaction Transaction) {
		entityManager.merge(Transaction);
		
	}

	@Override
	public void deleteTransaction(Transaction Transaction) {
		entityManager.remove(Transaction);
		
	}

	@Override
	public Transaction findTransactionById(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(Transaction.class, id);
	}

	@Override
	public void updateTransaction(Transaction Transaction) {
		entityManager.merge(Transaction);
		
	}

	@Override
	public void deleteTransactionById(int id) {
		// TODO Auto-generated method stub
		entityManager.remove(findTransactionById(id));
		
	}

	@Override
	public List<Transaction> findAllTransactions() {
		String jpql = "SELECT u FROM Transaction u";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

}
