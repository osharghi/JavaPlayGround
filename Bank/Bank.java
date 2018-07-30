import java.util.concurrent.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class Bank {
	
    BlockingQueue<Transaction> queue;
    public ArrayList<Account> accounts;
    private final Transaction nullTrans = new Transaction(-1,0,0);

    public Bank() {
    	
        queue = new LinkedBlockingQueue<Transaction>();
        accounts = new ArrayList<Account>();
        
    }

    // TODO: Add code for actually updating accounts. 
    // Should you make this synchronized? Why or why not?
    // If not, how do you avoid concurrency issues?
    public synchronized void processTransaction(Transaction t) {
    	
        System.out.println("Processing transaction");
        System.out.println(t.toString());
        
        if(t.fromAccount != t.toAccount)  //Transaction between two different accounts
        {
        		Account accountFrom = null;
        		Account accountTo = null;
        		for(int i = 0; i<accounts.size(); i++)
        		{
        			if(t.fromAccount == accounts.get(i).id)
        			{
        				accountFrom = accounts.get(i);
        			}
        		}
        		
        		for(int i = 0; i<accounts.size(); i++)
        		{
        			if(t.toAccount == accounts.get(i).id)
        			{
        				accountTo = accounts.get(i);
        			}
        		}
        		
        		accountFrom.balance = accountFrom.balance - t.amount;
        		accountFrom.transactionCount++;
        		accountTo.balance = accountTo.balance + t.amount;
        		accountTo.transactionCount++;
        }
        else if (t.fromAccount == t.toAccount)  //Transaction between 1 account
        {
        		Account account = null;
        		
        		for(int i = 0; i<accounts.size(); i++)
        		{
        			if(t.fromAccount == accounts.get(i).id)
        			{
        				account = accounts.get(i);
        			}
        		}
        		
        		account.transactionCount = account.transactionCount + 2;
        }        
    }
    
    private boolean doesAccountExist(int id)  //checks to make sure account object for id has not already been created
    {
    		if(accounts.size() != 0)
    		{
	    		for(int i = 0; i<accounts.size(); i++)
	    		{
	    			if(id == accounts.get(i).id)
	    			{
	    				return true;
	    			}
	    		}
    		}
    		
    		return false;
    }

    private class Worker extends Thread 
    {
        public void run() 
        {
            try 
            {
                Transaction t;
                do 
                {
                    t = queue.take();
                    if(t!=nullTrans)
                    {
                    		System.out.println("Queue done filling");
                    		System.out.println("Calling process");
                			processTransaction(t);
//                			System.out.println(this.getName() + t);
                    }
                } 
                while (t.fromAccount != -1);
            } 
            catch (InterruptedException e) 
            {
                System.out.println("interrupted");
            }
            System.out.println(this.getName()  + "exiting");
        }
    }

    public static void main(String[] args) {
        Bank bank = new Bank();
        
        ArrayList<Worker> workers = new ArrayList<Worker>();
        
        int threadCount = Integer.parseInt(args[1]);

        for(int i = 0; i<threadCount; i++)
        {
        		Worker worker = bank.new Worker();
        		workers.add(worker);
        }

        try{
        		
        		for(int i = 0; i<threadCount; i++)
			{
				Worker w = workers.get(i);
				w.start();
				System.out.println("Worker " + i + " started");
			}
        	
        		File file = new File(args[0]);
        		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        			
        		    String line;
        		    
        		    while ((line = br.readLine()) != null) {
        		    	
//        		       System.out.println(line);
        		       String[] splitStr = line.split("\\s+");
        		       int accountIDFrom = Integer.parseInt(splitStr[0]);
        		       int accountIDTo = Integer.parseInt(splitStr[1]);
        		       int amount = Integer.parseInt(splitStr[2]);
        		       Transaction t = new Transaction(accountIDFrom, accountIDTo, amount);
        		       if(accountIDFrom != accountIDTo)  //Transaction between 2 accounts
        		       {
        		    	   		if(!bank.doesAccountExist(accountIDFrom))
        		    	   		{
        		    	   			bank.accounts.add(new Account(accountIDFrom));
        		    	   		}
        		    	   		if(!bank.doesAccountExist(accountIDTo))
        		    	   		{
        		    	   			bank.accounts.add(new Account(accountIDTo));
        		    	   		}
        		       }
        		       else  //transaction between 1 account
        		       {
        		    	   		if(!bank.doesAccountExist(accountIDFrom))
        		    	   		{
        		    	   			bank.accounts.add(new Account(accountIDFrom));
        		    	   		}
        		       }
        		    	   
        		       bank.queue.put(t);
        		       
        		    }
        		    
        		    for(int i = 0; i<threadCount; i++)
                {
                		bank.queue.put(bank.nullTrans);
                }
        		    
        		    System.out.println("Queue done filling");
        		    
        		}	
        		catch(Exception e)
        		{
        			e.printStackTrace();
        		}
            
            System.out.println("Main finished adding all transactions");
            // TODO: Add code here to wait for ALL the workers to finish
            
            for(int i = 0; i<threadCount; i++)
			{
				Worker w = workers.get(i);
				w.join();
			}
            
            Collections.sort(bank.accounts, new Comparator<Account>() {
                @Override public int compare(Account a1, Account a2) {
                    return a1.id - a2.id; // Ascending
            }});

            for(int i=0; i<bank.accounts.size(); i++)
            {
            		Account account = bank.accounts.get(i);
            		System.out.println("ID: " + account.id + " balance: " + account.balance + " count: " + account.transactionCount);
            }
            
        } 
        catch (InterruptedException e) 
        {
            System.out.println("interrupted");
        }
        
        System.out.println("All threads done");   
    }
}

class Transaction {
    int fromAccount;
    int toAccount;
    int amount;

    public Transaction(int from, int to, int amt) {
        fromAccount = from;
        toAccount = to;
        amount = amt;
    }

    public String toString() {
    	
        return "Transaction: from = " + fromAccount + ", to = " + toAccount + " amount = " + amount;
        
    }
}

class Account {
	Integer id;
	int balance;
	int transactionCount;
	
	Account(int accountID)
	{
		this.id = new Integer(accountID);
		balance = 1000;
		transactionCount = 0;
	}
}

