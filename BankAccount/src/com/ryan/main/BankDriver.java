package com.ryan.main;

import com.ryan.gui.BankGui;

/**
 * Used to start the program and control the bank.
 * 
 * @author Ryan Hochmuth
 *
 */
public class BankDriver 
{
	/**
	 * The main method to start the program.
	 * @param args
	 */
	public static void main(String[] args)
	{
		BankGui gui = new BankGui();
		
		gui.showStartScreen();
	}
}
