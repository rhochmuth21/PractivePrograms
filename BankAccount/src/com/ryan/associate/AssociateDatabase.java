package com.ryan.associate;

import java.util.ArrayList;
import java.util.List;

/**
 * A database that keeps all of the associate information.
 * 
 * @author Ryan Hochmuth
 *
 */
public class AssociateDatabase 
{
	// Contains all of the associates
	private List<Associate> associateList = new ArrayList<Associate>();
	
	// The value of the last created id
	private long lastId;
	
	/**
	 * Create a new associate database.
	 */
	public AssociateDatabase()
	{
		this.lastId = 111222332;
	}
	
	/**
	 * Generate an associate id number.
	 * @return long - the new id
	 */
	public long generateId()
	{
		return ++lastId;
	}
	
	/**
	 * Get the list of associates.
	 * @return associateList - the list of associates
	 */
	public List<Associate> getAssociateList()
	{
		return associateList;
	}
	
	/**
	 * Add a associate to the associate list.
	 * @precondition
	 * The associate must not be null
	 * @param associate - the associate to add to the list
	 */
	public void addNewAssociate(Associate associate)
	{
		if (associate != null)
			associateList.add(associate);
	}
}