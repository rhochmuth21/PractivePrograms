package com.ryan.main;

import java.util.ArrayList;
import java.util.List;

import com.ryan.account.Account;
import com.ryan.account.Customer;

public class BankDatabase 
{
	// Contains all of the bank customers
	private List<Customer> customerList = new ArrayList<Customer>();
	
	// The value of the last created id
	private long lastId;
	
	public BankDatabase()
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
	 * Get the list of customers.
	 * @return customerList - the list of customers
	 */
	public List<Customer> getCustomerList()
	{
		return customerList;
	}
	
	/**
	 * Add a new customer to the customer list.
	 * @precondition
	 * The customer must not be null
	 * @param customer - the customer to add to the list
	 */
	public void addNewCustomer(Customer customer)
	{
		if (customer != null)
			customerList.add(customer);
	}
}