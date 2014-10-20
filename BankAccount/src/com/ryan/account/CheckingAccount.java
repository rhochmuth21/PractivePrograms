package com.ryan.account;

/**
 * A checking account is a bank account that
 * allows purchases to be made from the
 * account.  Paired with a checking account
 * is a debit card that contains a card number
 * and pin number.
 * 
 * @author Ryan Hochmuth
 *
 */
public class CheckingAccount extends Account
{
	public CheckingAccount(long id, String name, String phoneNumber) 
	{
		super(id, name, phoneNumber);
	}
}