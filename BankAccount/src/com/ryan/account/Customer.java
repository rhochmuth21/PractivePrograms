package com.ryan.account;

import java.util.ArrayList;
import java.util.List;

/**
 * A customer represents a bank customer.
 * The purpose of this is so a single
 * customer can have multiple bank accounts.
 * 
 * @author Ryan Hochmuth
 *
 */
public class Customer 
{
	// This customer's accounts
	private List<Account> accounts = new ArrayList<Account>();
	
	private String name;
	private String phoneNum;
	
	public Customer(String name, String phoneNum)
	{
		this.name = name;
		this.phoneNum = phoneNum;
	}

	/**
	 * Get this customer's list of accounts.
	 * @return accounts - the list of accounts
	 */
	public List<Account> getAccounts() 
	{
		return accounts;
	}

	/**
	 * Set this customer's list of accounts.
	 * @param accounts - the list of accounts to set
	 */
	public void setAccounts(List<Account> accounts) 
	{
		this.accounts = accounts;
	}

	/**
	 * Get this customer's name.
	 * @return name - the name
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * Set this customer's name.
	 * @param name - the name to set
	 */
	public void setName(String name) 
	{
		this.name = name;
	}

	/**
	 * get this customer's phone number.
	 * @return phoneNum - the customer's phone number
	 */
	public String getPhoneNum() 
	{
		return phoneNum;
	}

	/**
	 * Set this customer's phone number.
	 * @param phoneNum -  the phone number to set
	 */
	public void setPhoneNum(String phoneNum) 
	{
		this.phoneNum = phoneNum;
	}
}