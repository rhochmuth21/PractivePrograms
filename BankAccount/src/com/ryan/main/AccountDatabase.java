package com.ryan.main;

import java.util.ArrayList;
import java.util.List;

import com.ryan.account.Account;

public class AccountDatabase 
{
	// Contains all of the bank accounts
	private List<Account> accountList = new ArrayList<Account>();
	
	// The value of the last created id
	private long lastId;
	
	public AccountDatabase()
	{
		lastId = 11111110;
	}
	
	/**
	 * Generate an account id number.
	 * @return long - the new id
	 */
	public long generateId()
	{
		return ++lastId;
	}
	
	/**
	 * Get the list of bank accounts.
	 * @return accountList - the list of accounts
	 */
	public List<Account> getAccountList()
	{
		return accountList;
	}
	
	/**
	 * Add a new account to the account list.
	 * @precondition
	 * The account must not be null
	 * @param account - the account to add to the list
	 */
	public void addNewAccount(Account account)
	{
		if (account != null)
			accountList.add(account);
	}
}