package com.ryan.main;

import javax.swing.JOptionPane;

import com.ryan.account.Account;
import com.ryan.account.CheckingAccount;
import com.ryan.account.SavingsAccount;
import com.ryan.associate.Associate;

/**
 * The bank is the control class used to
 * store and access account data.
 * 
 * @author Ryan hochmuth
 *
 */
public class Bank 
{
	// The database containing all of the bank accounts
	private BankDatabase database = new BankDatabase();
	
	// Current session data
	private Account currentAccount = null;
	
	/**
	 * Create a new Bank object.
	 */
	public Bank(Associate associate)
	{
		
	}
	
	/**
	 * Run a menu option.
	 * @return choice - the user's menu choice
	 */
	public void menu(int choice)
	{
		System.out.println("\n\nBank Accounts:");
		
		if (database.getAccountList().size() > 0)
		{
			for(int x = 0; x < database.getAccountList().size(); x++)
			{
				System.out.println("\nAccount #" + database.getAccountList().get(x).getId() + ":");
				System.out.println("\t-Name: " + database.getAccountList().get(x).getName());
				System.out.println("\t-Phone Number: " + database.getAccountList().get(x).getPhoneNumber());
				System.out.println("\t-Balance: " + database.getAccountList().get(x).getBalance());
			}
		}
		else
		{
			System.out.println("\n-No account data present");
		}
	}
	
	/**
	 * Create a new checking account.
	 */
	public void createCheckingAccount(String name, String phone)
	{
		// Create the new account
		if (name != null && phone != null && !name.equals("") && !phone.equals(""))
		{
			database.addNewAccount(new CheckingAccount(database.generateId(), name, phone));
			
			Account account = lookupName(name);
			
			JOptionPane.showMessageDialog(null, "Successfully created a new checking account." + 
					"\nAccount Holder's Name: " + account.getName() +
					"\nAccount #: " + account.getId());
		}
		else
			JOptionPane.showMessageDialog(null, "Invalid input.");
	}
	
	/**
	 * Create a new savings account.
	 */
	public void createSavingsAccount(String name, String phone)
	{
		// Create the new account
		if (name != null && phone != null && !name.equals("") && !phone.equals(""))
		{
			database.addNewAccount(new SavingsAccount(database.generateId(), name, phone));
			
			Account account = lookupName(name);
			
			JOptionPane.showMessageDialog(null, "Successfully created a new savings account." + 
					"\nAccount Holder's Name: " + account.getName() +
					"\nAccount #: " + account.getId());
		}
		else
			JOptionPane.showMessageDialog(null, "Invalid input.");
	}
	
	/**
	 * Lookup an account based on ID or name.
	 * @return Account -  the found account
	 */
	public Account lookup()
	{
		String idInput = "";
		String nameInput = "";
		
		long id = 0;
		
		int lookupMethod = -1;
		
		// Take input
		idInput = JOptionPane.showInputDialog(null, "Input the account ID:", 
				"Account ID", JOptionPane.OK_CANCEL_OPTION);
		
		// Parse the id
		if (idInput != null)
		{
			try
			{
				id = Long.parseLong(idInput);
				
				if (id < 11111111)
				{
					JOptionPane.showMessageDialog(null, "Invalid ID.");
					idInput = null;
				}
			}
			catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null, "Invalid ID.");
				idInput = null;
			}
		}
		
		if (idInput == null)
			nameInput = JOptionPane.showInputDialog(null, "Input the account holder's name:", 
					"Account Holder Name", JOptionPane.OK_CANCEL_OPTION);
		
		// Determine the lookup method
		if (idInput != null)
		{
			lookupMethod = 0;
		}
		else if (nameInput != null)
		{
			lookupMethod = 1;
		}
		else
		{
			JOptionPane.showMessageDialog(null, "An account ID number or name must be entered.");
			return null;
		}
		
		// Lookup the account
		switch(lookupMethod)
		{
			case 0: // Lookup by ID
				for(int x = 0; x < database.getAccountList().size(); x++)
				{
					if (id == database.getAccountList().get(x).getId())
					{	
						this.currentAccount = database.getAccountList().get(x);
						return database.getAccountList().get(x);
					}
				}
				JOptionPane.showMessageDialog(null, "The specified account could not be found.");
				
				break;
				
			case 1: // Lookup by name
				for(int x = 0; x < database.getAccountList().size(); x++)
				{
					if (nameInput.equals(database.getAccountList().get(x).getName()))
					{
						this.currentAccount = database.getAccountList().get(x);
						return database.getAccountList().get(x);
					}
				}
				JOptionPane.showMessageDialog(null, "The specified account could not be found.");
				
				break;
				
			default:
				break;	
		}
		
		return null;
	}
	
	/**
	 * Lookup an account automatically.
	 * @param id - the account id
	 * @param name - the account name
	 * @return Account -  the found account
	 */
	public Account automatedLookup(String idStr, String name)
	{
		int lookupMethod = -1;
		
		long id = 0;
		
		// Parse the id
		if (idStr != null && !idStr.equals(""))
		{
			try
			{
				id = Long.parseLong(idStr);
				
				if (id < 11111111)
				{
					JOptionPane.showMessageDialog(null, "Invalid ID.");
					idStr = null;
				}
			}
			catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null, "Invalid ID.");
				idStr = null;
			}
		}
		
		// Determine the lookup method
		if (idStr != null && !idStr.equals(""))
		{
			lookupMethod = 0;
		}
		else if (name != null)
		{
			lookupMethod = 1;
		}
		else
		{
			JOptionPane.showMessageDialog(null, "An account ID number or name must be entered.");
			return null;
		}
		
		// Lookup the account
		switch(lookupMethod)
		{
			case 0: // Lookup by ID
				for(int x = 0; x < database.getAccountList().size(); x++)
				{
					if (id == database.getAccountList().get(x).getId())
					{	
						this.currentAccount = database.getAccountList().get(x);
						return database.getAccountList().get(x);
					}
				}
				JOptionPane.showMessageDialog(null, "The specified account could not be found.");
				
				break;
				
			case 1: // Lookup by name
				for(int x = 0; x < database.getAccountList().size(); x++)
				{
					if (name.equals(database.getAccountList().get(x).getName()))
					{
						this.currentAccount = database.getAccountList().get(x);
						return database.getAccountList().get(x);
					}
				}
				JOptionPane.showMessageDialog(null, "The specified account could not be found.");
				
				break;
				
			default:
				break;	
		}
		
		return null;
	}
	
	/**
	 * Lookup an account based on a given name.
	 * @return Account -  the found account
	 */
	public Account lookupName(String name)
	{
		for(int x = 0; x < database.getAccountList().size(); x++)
		{
			if (name.equals(database.getAccountList().get(x).getName()))
			{
				return database.getAccountList().get(x);
			}
		}
		
		JOptionPane.showMessageDialog(null, "The specified account could not be found.");
		
		return null;
	}
	
	/**
	 * Check the balance of a bank account.
	 * @param account - the account to return the balance of
	 * @return double - the balance of the account
	 */
	public double checkBalance()
	{
		if (currentAccount == null)
		{
			JOptionPane.showMessageDialog(null, "Check balance failed, the given account was null.");
			return -1;
		}
		
		JOptionPane.showMessageDialog(null, "The balance of " + 
				currentAccount.getName() + "'s account with " + 
				"account # " + currentAccount.getId() +
				" is:\n $" + currentAccount.getBalance() + ".");
		
		return currentAccount.getBalance();
	}
	
	/**
	 * Deposit funds into a bank account.
	 * @param amountStr - the amount to deposit
	 */
	public void deposit(String amountStr)
	{
		if (currentAccount == null)
		{
			JOptionPane.showMessageDialog(null, "Deposit failed, the given account was null.");
			return;
		}
		
		double amount = 0.0;
		
		// Error checking
		if (amountStr == null)
		{
			JOptionPane.showMessageDialog(null, "Invalid deposit amount.");
			return;
		}
		
		try
		{
			amount = Double.parseDouble(amountStr);
		}
		catch(NumberFormatException e)
		{
			JOptionPane.showMessageDialog(null, "Invalid deposit amount input.");
			return;
		}
		
		if (amount <= 0)
		{
			JOptionPane.showMessageDialog(null, "Deposit amount must be greater than 0.");
			return;
		}
		
		currentAccount.deposit(amount);
		
		JOptionPane.showMessageDialog(null, "Successfully deposited $" + amount +
				" into " + currentAccount.getName() + "'s account." + 
				"\nBalance for account # " + currentAccount.getId() +
				" is $" + currentAccount.getBalance() + ".");
	}
	
	/**
	 * Withdraw funds into a bank account.
	 * @param amountStr - the amount to withdraw
	 */
	public void withdraw(String amountStr)
	{
		if (currentAccount == null)
		{
			JOptionPane.showMessageDialog(null, "Withdraw failed, the given account was null.");
			return;
		}
		
		double amount = 0.0;
		
		// Error checking
		if (amountStr == null)
		{
			JOptionPane.showMessageDialog(null, "Invalid withdraw amount.");
			return;
		}
		
		try
		{
			amount = Double.parseDouble(amountStr);
		}
		catch(NumberFormatException e)
		{
			JOptionPane.showMessageDialog(null, "Invalid withdraw amount input.");
			return;
		}
		
		if (amount <= 0)
		{
			JOptionPane.showMessageDialog(null, "Withdraw amount must be greater than 0.");
			return;
		}
		
		if (currentAccount.getBalance() >= amount)
		{
			currentAccount.withdraw(amount);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Withdraw failed:\n" + 
				"The balance of the account is less than " + amount + ".");
			return;
		}
		
		JOptionPane.showMessageDialog(null, "Successfully withdrew $" + amount +
				" from " + currentAccount.getName() + "'s account." + 
				"\nBalance for account # " + currentAccount.getId() +
				" is $" + currentAccount.getBalance() + ".");
	}
	
	/**
	 * Get the currentAccount
	 * @return currentAccount - the current account
	 */
	public Account getCurrentAccount()
	{
		return currentAccount;
	}
	
	/**
	 * Set the currentAccount
	 * @return currentAccount - the current account
	 */
	public void setCurrentAccount(Account currentAccount)
	{
		this.currentAccount = currentAccount;
	}
}