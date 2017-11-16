package service;

import java.util.List;

import javax.ejb.Local;

import persistence.Transaction;

@Local
public interface TransactionServiceLocal {
	void saveOrUpdateTransaction(Transaction Transaction);

	void addTransaction(Transaction Transaction);

	void deleteTransaction(Transaction Transaction);

	Transaction findTransactionById(int id);

	void updateTransaction(Transaction Transaction);

	void deleteTransactionById(int id);

	List<Transaction> findAllTransactions();

}
