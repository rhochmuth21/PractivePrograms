package com.ryan.associate;

/**
 * An associate is an employee of the bank.
 * 
 * @author Ryan Hochmuth
 *
 */
public class Associate 
{
	private long ain;
	private String password;
	private String name;
	
	/**
	 * Create a new associate.
	 * @param ain - the id number of this associate.
	 * @param name -  the name of this associate
	 */
	public Associate(long ain, String name, String password)
	{
		this.ain = ain;
		this.name = name;
		this.password = password;
	}

	/**
	 * Get the ain of this associate.
	 * @return ain - the id number
	 */
	public long getAin() 
	{
		return ain;
	}

	/**
	 * Set the ain of this associate.
	 * @param ain - the id number
	 */
	public void setAin(long ain) 
	{
		this.ain = ain;
	}

	/**
	 * Get the name of this associate.
	 * @return name - the name
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * Set the name of this associate.
	 * @param name - the name
	 */
	public void setName(String name) 
	{
		this.name = name;
	}
	
	/**
	 * Get the password of this associate.
	 * @return password - the password
	 */
	public String getPassword() 
	{
		return password;
	}

	/**
	 * Set the password of this associate.
	 * @param password - the password
	 */
	public void setPassword(String password) 
	{
		this.password = password;
	}
}