package com.ryan.account;

/**
 * An account is the base for any type of
 * bank account that contains the following
 * data:
 * - double balance
 * - long id
 * - String name
 * - long phoneNumber
 * 
 * @author Ryan Hochmuth
 *
 */
public abstract class Account 
{
	// Account data
	protected double balance;
	protected long id;
	protected String name;
	protected String phoneNumber;
	
	/**
	 * Create a new account with the given
	 * name and phone number.
	 * @param name - the name of the account owner
	 * @param phoneNumber - the phone number of the account owner
	 */
	public Account(long id, String name, String phoneNumber)
	{
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		
		this.balance = 0.0;
	}
	
	/**
	 * Add funds to the balance of this account.
	 * @precondition
	 * The given amount must be greater than 0
	 * @param amount -  the amount of funds to add to the balance
	 */
	public void deposit(double amount)
	{
		if (amount > 0)
			this.balance += amount;
	}
	
	/**
	 * Get the balance of this account.
	 * @return balance - the balance
	 */
	public double getBalance()
	{
		return balance;
	}
	
	/**
	 * Set the balance of this account.
	 * @param balance - the balance to set
	 */
	public void setBalance(double balance)
	{
		this.balance = balance;
	}
	
	/**
	 * Get the id of this account.
	 * @return id -  the id number for this account
	 */
	public long getId()
	{
		return id;
	}
	
	/**
	 * Set the id of this account.
	 * @param id -  the id to set
	 */
	public void setId(long id)
	{
		this.id = id;
	}
	
	/**
	 * Get the name of this account holder.
	 * @return name - the name of the account holder
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Set the name of this account holder.
	 * @param name -  the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Get the phone number of this account holder.
	 * @return phoneNumber - the phone number of this account holder
	 */
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	
	/**
	 * Set the phone number of this account holder.
	 * @param phoneNumber - the number to set
	 */
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
}