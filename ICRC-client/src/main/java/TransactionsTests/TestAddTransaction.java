package TransactionsTests;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.Camp;
import persistence.Transaction;
import service.TransactionServiceRemote;
import service.CampService.CampServiceRemote;

public class TestAddTransaction {
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		TransactionServiceRemote TSR = (TransactionServiceRemote) context
				.lookup("ICRC-ear/ICRC-ejb/TransactionService!service.TransactionServiceRemote");
		Transaction t = new Transaction();
		t.setAmount(100);
		t.setType("zntry");
		Camp p = new Camp();
		//t.setDate(new java.util.Date());
		p.setCampId(1);
		t.setCamp(p);
		TSR.addTransaction(t);

		
			
	}

}
