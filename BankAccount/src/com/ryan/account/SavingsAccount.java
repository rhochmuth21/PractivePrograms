package com.ryan.account;

/**
 * A savings account is an account used
 * solely for saving money.  Money can be
 * deposited and withdrawn but purchases
 * cannot be made from this account.
 * 
 * @author Ryan Hochmuth
 *
 */
public class SavingsAccount extends Account
{
	public SavingsAccount(long id, String name, String phoneNumber) 
	{
		super(id, name, phoneNumber);
	}
}