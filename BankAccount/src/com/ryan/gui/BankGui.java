package com.ryan.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.imgscalr.Scalr;
import org.imgscalr.Scalr.Method;

import com.ryan.associate.Associate;
import com.ryan.associate.AssociateDatabase;
import com.ryan.main.Bank;

/**
 * BankGui handles the gui elements of the bank.
 * 
 * @author Ryan Hochmuth
 *
 */
public class BankGui implements ActionListener
{
	// Associate info
	private AssociateDatabase associateDb = new AssociateDatabase(); 
	private Associate currentAssociate = null;
	
	// Bank info
	private Bank bank = new Bank(currentAssociate);
	
	// Gui Components
	private JFrame frame = new JFrame();
	private JLabel bgLbl = new JLabel();
	private JButton exitBtn = new JButton();
	private JButton minimizeBtn = new JButton();
	
	// Start Components
	private JLabel ainLbl = new JLabel();
	private JTextField ainText = new JTextField();
	private JLabel passLbl = new JLabel();
	private JTextField passText = new JTextField();
	private JButton startOkBtn = new JButton();
	
	// Main Components
	private JLabel associateLbl = new JLabel();
	private JLabel vertBar = new JLabel();
	private JButton customerTab = new JButton();
	private JButton bankTab = new JButton();
	private JButton logoutTab = new JButton();
	
	// Customer Tab
	private JLabel idLbl = new JLabel();
	private JTextField idText = new JTextField();
	private JLabel nameLbl = new JLabel();
	private JTextField nameText = new JTextField();
	private JButton lookupBtn = new JButton();
	private JButton newCusBtn = new JButton();
	private JLabel newCusLbl = new JLabel();
	
	// Bank Tab
	private JLabel customerLbl = new JLabel();
	private JButton option1Btn = new JButton();
	private JLabel option1Lbl = new JLabel();
	private JButton option2Btn = new JButton();
	private JLabel option2Lbl = new JLabel();
	private JButton option3Btn = new JButton();
	private JLabel option3Lbl = new JLabel();
	
	// Side Content
	private int sideChoice = 0;
	private JLabel firstLbl = new JLabel();
	private JTextField firstText = new JTextField();
	private JLabel secondLbl = new JLabel();
	private JTextField secondText = new JTextField();
	private JButton sideOkBtn = new JButton();
	
	// Fonts
	private Font lintel = registerFont("src/res/Lintel-Regular.ttf", "Lintel", 24, false);
	private Font lintelSmall = registerFont("src/res/Lintel-Regular.ttf", "Lintel", 18, false);
	private Font password = registerFont("src/res/password.ttf", "Password", 24, false);
	
	// Other
	DecimalFormat decForm = new DecimalFormat("###,###,###,###,###.00");
	
	/**
	 * Create a new BankGui.
	 */
	public BankGui()
	{
		startOkBtn.addActionListener(this);
		exitBtn.addActionListener(this);
		minimizeBtn.addActionListener(this);
		customerTab.addActionListener(this);
		bankTab.addActionListener(this);
		logoutTab.addActionListener(this);
		option1Btn.addActionListener(this);
		option2Btn.addActionListener(this);
		option3Btn.addActionListener(this);
		lookupBtn.addActionListener(this);
		newCusBtn.addActionListener(this);
		sideOkBtn.addActionListener(this);
		
		// frame setup
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1280, 720);
		frame.setLocationRelativeTo(null);
		frame.setFocusable(true);
		frame.setLayout(null);
		frame.setUndecorated(true);
		frame.setIconImage(new ImageIcon("src/res/icon.png").getImage());
		
		// Add test associates
		Associate ryan = new Associate(993094868, "Ryan Hochmuth", "Fmlrocks21");
		associateDb.addNewAssociate(ryan);
		
		Associate jason = new Associate(123456789, "Jason Griffith", "iSuckA55");
		associateDb.addNewAssociate(jason);
		
		Associate melissa = new Associate(216821682, "Melissa Santonocito", "Sheeba68");
		associateDb.addNewAssociate(melissa);
	}
	
	/**
	 * Constructs and show to the bank startup screen.
	 */
	public void showStartScreen()
	{
		frame.add(bgLbl);
		bgLbl.removeAll();
		
		// bgLbl setup
		bgLbl.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		bgLbl.setLayout(null);
		bgLbl.setIcon(new ImageIcon("src/res/background.png"));
		bgLbl.setVisible(true);
		
		bgLbl.add(exitBtn);
		
		// exitBtn setup
		exitBtn.setBorderPainted(false);
		exitBtn.setOpaque(false);
		exitBtn.setContentAreaFilled(false);
		exitBtn.setFocusPainted(false);
		exitBtn.setIcon(new ImageIcon("src/res/exitBtnNew.png"));
		exitBtn.setRolloverIcon(new ImageIcon("src/res/exitBtnHoverNew.png"));
		exitBtn.setBounds(1227, 13, 45, 45);
		exitBtn.setVisible(true);
		
		bgLbl.add(minimizeBtn);
		
		// minimizeBtn setup
		minimizeBtn.setBorderPainted(false);
		minimizeBtn.setOpaque(false);
		minimizeBtn.setContentAreaFilled(false);
		minimizeBtn.setFocusPainted(false);
		minimizeBtn.setIcon(new ImageIcon("src/res/minimizeBtnNew.png"));
		minimizeBtn.setRolloverIcon(new ImageIcon("src/res/minimizeBtnHoverNew.png"));
		minimizeBtn.setBounds(1166, 13, 45, 45);
		minimizeBtn.setVisible(true);
		
		bgLbl.add(ainLbl);
		
		// ainLbl setup
		ainLbl.setBounds(520, 260, 240, 40);
		ainLbl.setFont(lintel);
		ainLbl.setText("Enter Your AIN:");
		ainLbl.setVisible(true);
		
		bgLbl.add(ainText);
		
		// ainText setup
		ainText.setBounds(520, 300, 240, 40);
		ainText.setFont(lintel);
		ainText.setVisible(true);
		
		bgLbl.add(passLbl);
		
		// passLbl setup
		passLbl.setBounds(520, 360, 240, 40);
		passLbl.setFont(lintel);
		passLbl.setText("Enter Your Password:");
		passLbl.setVisible(true);
		
		bgLbl.add(passText);
		
		// passText setup
		passText.setBounds(520, 400, 240, 40);
		passText.setFont(password);
		passText.setVisible(true);
		
		bgLbl.add(startOkBtn);
		
		// startOkBtn setup
		startOkBtn.setBorderPainted(false);
		startOkBtn.setOpaque(false);
		startOkBtn.setContentAreaFilled(false);
		startOkBtn.setFocusPainted(false);
		startOkBtn.setIcon(new ImageIcon(scaleImage(new ImageIcon("src/res/button2.png").getImage(), 160, 50)));
		startOkBtn.setRolloverIcon(new ImageIcon(scaleImage(new ImageIcon("src/res/button2Hover.png").getImage(), 160, 50)));
		startOkBtn.setText("Ok");
		startOkBtn.setHorizontalTextPosition(JButton.CENTER);
		startOkBtn.setVerticalTextPosition(JButton.CENTER);
		startOkBtn.setFont(lintel);
		startOkBtn.setForeground(Color.black);
		startOkBtn.setBounds(560, 537, 160, 50);
		startOkBtn.setVisible(true);
		
		frame.setVisible(true);
		
		//ainText.setText("993094868");
		//passText.setText("Fmlrocks21");
		
		frame.repaint();
	}
	
	/**
	 * Show the main bank screen.
	 */
	public void showMainScreen()
	{
		frame.add(bgLbl);
		bgLbl.removeAll();
		
		// bgLbl setup
		bgLbl.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		bgLbl.setLayout(null);
		bgLbl.setIcon(new ImageIcon("src/res/mainBg.png"));
		bgLbl.setVisible(true);
		
		if (currentAssociate != null)
		{
			bgLbl.add(associateLbl);
			
			// associateLbl setup
			associateLbl.setBounds(400, 15, 700, 40);
			associateLbl.setFont(lintel);
			associateLbl.setText("Hello " + currentAssociate.getName() + ", your AIN is: " + currentAssociate.getAin());
			associateLbl.setVisible(true);
		}
		
		bgLbl.add(exitBtn);
		
		// exitBtn setup
		exitBtn.setBorderPainted(false);
		exitBtn.setOpaque(false);
		exitBtn.setContentAreaFilled(false);
		exitBtn.setFocusPainted(false);
		exitBtn.setIcon(new ImageIcon("src/res/exitBtnNew.png"));
		exitBtn.setRolloverIcon(new ImageIcon("src/res/exitBtnHoverNew.png"));
		exitBtn.setBounds(1227, 13, 45, 45);
		exitBtn.setVisible(true);
		
		bgLbl.add(minimizeBtn);
		
		// minimizeBtn setup
		minimizeBtn.setBorderPainted(false);
		minimizeBtn.setOpaque(false);
		minimizeBtn.setContentAreaFilled(false);
		minimizeBtn.setFocusPainted(false);
		minimizeBtn.setIcon(new ImageIcon("src/res/minimizeBtnNew.png"));
		minimizeBtn.setRolloverIcon(new ImageIcon("src/res/minimizeBtnHoverNew.png"));
		minimizeBtn.setBounds(1166, 13, 45, 45);
		minimizeBtn.setVisible(true);
		
		bgLbl.add(vertBar);
		
		// vertBar setup
		vertBar.setBounds(850, 120, 22, 515);
		vertBar.setIcon(new ImageIcon("src/res/verticalCrossbar.png"));
		vertBar.setVisible(true);
		
		bgLbl.add(customerTab);
		
		// customerTab setup
		customerTab.setBorderPainted(false);
		customerTab.setOpaque(false);
		customerTab.setContentAreaFilled(false);
		customerTab.setFocusPainted(false);
		customerTab.setIcon(new ImageIcon("src/res/tab.png"));
		customerTab.setRolloverIcon(new ImageIcon("src/res/tabHover.png"));
		customerTab.setText("Customer");
		customerTab.setHorizontalTextPosition(JButton.CENTER);
		customerTab.setVerticalTextPosition(JButton.CENTER);
		customerTab.setFont(lintel);
		customerTab.setForeground(Color.black);
		customerTab.setBounds(376, 49, 195, 58);
		customerTab.setVisible(true);
		
		bgLbl.add(bankTab);
		
		// bankTab setup
		bankTab.setBorderPainted(false);
		bankTab.setOpaque(false);
		bankTab.setContentAreaFilled(false);
		bankTab.setFocusPainted(false);
		bankTab.setIcon(new ImageIcon("src/res/tab.png"));
		bankTab.setRolloverIcon(new ImageIcon("src/res/tabHover.png"));
		bankTab.setText("Bank");
		bankTab.setHorizontalTextPosition(JButton.CENTER);
		bankTab.setVerticalTextPosition(JButton.CENTER);
		bankTab.setFont(lintel);
		bankTab.setForeground(Color.black);
		bankTab.setBounds(581, 49, 195, 58);
		bankTab.setVisible(true);
		
		bgLbl.add(logoutTab);
		
		// logoutTab setup
		logoutTab.setBorderPainted(false);
		logoutTab.setOpaque(false);
		logoutTab.setContentAreaFilled(false);
		logoutTab.setFocusPainted(false);
		logoutTab.setIcon(new ImageIcon("src/res/tab.png"));
		logoutTab.setRolloverIcon(new ImageIcon("src/res/tabHover.png"));
		logoutTab.setText("Logout");
		logoutTab.setHorizontalTextPosition(JButton.CENTER);
		logoutTab.setVerticalTextPosition(JButton.CENTER);
		logoutTab.setFont(lintel);
		logoutTab.setForeground(Color.black);
		logoutTab.setBounds(786, 49, 195, 58);
		logoutTab.setVisible(true);
		
		showCustomerTab();
	}
	
	/**
	 * Show the customer tab info on the screen.
	 */
	public void showCustomerTab()
	{
		bgLbl.remove(option1Btn);
		bgLbl.remove(option1Lbl);
		bgLbl.remove(option2Btn);
		bgLbl.remove(option2Lbl);
		bgLbl.remove(option3Btn);
		bgLbl.remove(option3Lbl);
		
		bgLbl.add(customerLbl);
		
		// customerLbl setup
		customerLbl.setBounds(90, 100, 600, 58);
		customerLbl.setFont(lintelSmall);
		
		if (bank.getCurrentAccount() != null)
			customerLbl.setText("Customer: Name: " + bank.getCurrentAccount().getName() + ", Phone #: " + 
								bank.getCurrentAccount().getPhoneNumber() + ", Balance: $ " + 
								decForm.format(bank.getCurrentAccount().getBalance()));
		else
			customerLbl.setText("Customer: No current customer");
			
		customerLbl.setVisible(true);
		
		bgLbl.add(idLbl);
		
		// idLbl setup
		idLbl.setBounds(90, 156, 400, 40);
		idLbl.setFont(lintel);
		idLbl.setText("Enter the Customer's Account ID:");
		idLbl.setVisible(true);
		
		bgLbl.add(idText);
		
		// idText setup
		idText.setBounds(90, 196, 240, 40);
		idText.setFont(lintel);
		idText.setVisible(true);
		
		bgLbl.add(nameLbl);
		
		// nameLbl setup
		nameLbl.setBounds(90, 256, 400, 40);
		nameLbl.setFont(lintel);
		nameLbl.setText("Enter the Customer's Full Name:");
		nameLbl.setVisible(true);
		
		bgLbl.add(nameText);
		
		// nameText setup
		nameText.setBounds(90, 296, 240, 40);
		nameText.setFont(lintel);
		nameText.setVisible(true);
		
		bgLbl.add(lookupBtn);
		
		// startOkBtn setup
		lookupBtn.setBorderPainted(false);
		lookupBtn.setOpaque(false);
		lookupBtn.setContentAreaFilled(false);
		lookupBtn.setFocusPainted(false);
		lookupBtn.setIcon(new ImageIcon(scaleImage(new ImageIcon("src/res/button.png").getImage(), 160, 50)));
		lookupBtn.setRolloverIcon(new ImageIcon(scaleImage(new ImageIcon("src/res/buttonHover.png").getImage(), 160, 50)));
		lookupBtn.setText("Lookup");
		lookupBtn.setHorizontalTextPosition(JButton.CENTER);
		lookupBtn.setVerticalTextPosition(JButton.CENTER);
		lookupBtn.setFont(lintel);
		lookupBtn.setForeground(Color.black);
		lookupBtn.setBounds(130, 356, 160, 50);
		lookupBtn.setVisible(true);
		
		bgLbl.add(newCusBtn);
		
		// newCusBtn setup
		newCusBtn.setBorderPainted(false);
		newCusBtn.setOpaque(false);
		newCusBtn.setContentAreaFilled(false);
		newCusBtn.setFocusPainted(false);
		newCusBtn.setIcon(new ImageIcon("src/res/smallBtn.png"));
		newCusBtn.setRolloverIcon(new ImageIcon("src/res/smallBtnHover.png"));
		newCusBtn.setText("");
		newCusBtn.setHorizontalTextPosition(JButton.CENTER);
		newCusBtn.setVerticalTextPosition(JButton.CENTER);
		newCusBtn.setFont(lintel);
		newCusBtn.setForeground(Color.black);
		newCusBtn.setBounds(90, 590, 58, 58);
		newCusBtn.setVisible(true);
		
		bgLbl.add(newCusLbl);
		
		// newCusLbl setup
		newCusLbl.setBounds(154, 592, 350, 58);
		newCusLbl.setFont(lintel);
		newCusLbl.setText("Create a new checking account");
		newCusLbl.setVisible(true);
		
		frame.repaint();
	}
	
	/**
	 * Show the bank tab info on the screen.
	 */
	public void showBankTab()
	{
		bgLbl.remove(idLbl);
		bgLbl.remove(idText);
		bgLbl.remove(nameLbl);
		bgLbl.remove(nameText);
		bgLbl.remove(lookupBtn);
		bgLbl.remove(newCusBtn);
		bgLbl.remove(newCusLbl);
		
		bgLbl.add(customerLbl);
		
		// customerLbl setup
		customerLbl.setBounds(90, 100, 600, 58);
		customerLbl.setFont(lintelSmall);
		
		if (bank.getCurrentAccount() != null)
			customerLbl.setText("Customer: Name: " + bank.getCurrentAccount().getName() + ", Phone #: " + 
								bank.getCurrentAccount().getPhoneNumber() + ", Balance: $ " + 
								decForm.format(bank.getCurrentAccount().getBalance()));
		else
			customerLbl.setText("Customer: No current customer");
			
		customerLbl.setVisible(true);
		
		bgLbl.add(option1Btn);
		
		// option1Btn setup
		option1Btn.setBorderPainted(false);
		option1Btn.setOpaque(false);
		option1Btn.setContentAreaFilled(false);
		option1Btn.setFocusPainted(false);
		option1Btn.setIcon(new ImageIcon("src/res/smallBtn.png"));
		option1Btn.setRolloverIcon(new ImageIcon("src/res/smallBtnHover.png"));
		option1Btn.setText("1");
		option1Btn.setHorizontalTextPosition(JButton.CENTER);
		option1Btn.setVerticalTextPosition(JButton.CENTER);
		option1Btn.setFont(lintel);
		option1Btn.setForeground(Color.black);
		option1Btn.setBounds(90, 156, 58, 58);
		option1Btn.setVisible(true);
		
		bgLbl.add(option1Lbl);
		
		// option1Lbl setup
		option1Lbl.setBounds(154, 158, 350, 58);
		option1Lbl.setFont(lintel);
		option1Lbl.setText("Check balance");
		option1Lbl.setVisible(true);
		
		bgLbl.add(option2Btn);
		
		// option2Btn setup
		option2Btn.setBorderPainted(false);
		option2Btn.setOpaque(false);
		option2Btn.setContentAreaFilled(false);
		option2Btn.setFocusPainted(false);
		option2Btn.setIcon(new ImageIcon("src/res/smallBtn.png"));
		option2Btn.setRolloverIcon(new ImageIcon("src/res/smallBtnHover.png"));
		option2Btn.setText("2");
		option2Btn.setHorizontalTextPosition(JButton.CENTER);
		option2Btn.setVerticalTextPosition(JButton.CENTER);
		option2Btn.setFont(lintel);
		option2Btn.setForeground(Color.black);
		option2Btn.setBounds(90, 224, 58, 58);
		option2Btn.setVisible(true);
		
		bgLbl.add(option2Lbl);
		
		// option2Lbl setup
		option2Lbl.setBounds(154, 226, 350, 58);
		option2Lbl.setFont(lintel);
		option2Lbl.setText("Deposit");
		option2Lbl.setVisible(true);
		
		bgLbl.add(option3Btn);
		
		// option3Btn setup
		option3Btn.setBorderPainted(false);
		option3Btn.setOpaque(false);
		option3Btn.setContentAreaFilled(false);
		option3Btn.setFocusPainted(false);
		option3Btn.setIcon(new ImageIcon("src/res/smallBtn.png"));
		option3Btn.setRolloverIcon(new ImageIcon("src/res/smallBtnHover.png"));
		option3Btn.setText("3");
		option3Btn.setHorizontalTextPosition(JButton.CENTER);
		option3Btn.setVerticalTextPosition(JButton.CENTER);
		option3Btn.setFont(lintel);
		option3Btn.setForeground(Color.black);
		option3Btn.setBounds(90, 292, 58, 58);
		option3Btn.setVisible(true);
		
		bgLbl.add(option3Lbl);
		
		// option3Lbl setup
		option3Lbl.setBounds(154, 294, 350, 58);
		option3Lbl.setFont(lintel);
		option3Lbl.setText("Withdraw");
		option3Lbl.setVisible(true);
		
		frame.repaint();
	}
	
	/**
	 * Reset the GUI components in the
	 * side panel.
	 */
	public void resetSideContent()
	{
		// Create a new account
		bgLbl.remove(firstLbl);
		bgLbl.remove(firstText);
		bgLbl.remove(secondLbl);
		bgLbl.remove(secondText);
		bgLbl.remove(sideOkBtn);
		
		frame.repaint();
	}
	
	/**
	 * Show the GUI for creating a new account.
	 */
	public void createCheckingAccount()
	{
		bgLbl.add(firstLbl);
		
		// firstLbl setup
		firstLbl.setBounds(800 + 90, 116, 400, 40);
		firstLbl.setFont(lintel);
		firstLbl.setText("Enter the Customer's Name:");
		firstLbl.setVisible(true);
		
		bgLbl.add(firstText);
		
		// firstText setup
		firstText.setBounds(800 + 90, 156, 240, 40);
		firstText.setFont(lintel);
		firstText.setVisible(true);
		
		bgLbl.add(secondLbl);
		
		// secondLbl setup
		secondLbl.setBounds(800 + 90, 216, 400, 40);
		secondLbl.setFont(lintel);
		secondLbl.setText("Enter the Customer's Phone #:");
		secondLbl.setVisible(true);
		
		bgLbl.add(secondText);
		
		// secondText setup
		secondText.setBounds(800 + 90, 256, 240, 40);
		secondText.setFont(lintel);
		secondText.setVisible(true);
		
		bgLbl.add(sideOkBtn);
		
		// sideOkBtn setup
		sideOkBtn.setBorderPainted(false);
		sideOkBtn.setOpaque(false);
		sideOkBtn.setContentAreaFilled(false);
		sideOkBtn.setFocusPainted(false);
		sideOkBtn.setIcon(new ImageIcon(scaleImage(new ImageIcon("src/res/button2.png").getImage(), 160, 50)));
		sideOkBtn.setRolloverIcon(new ImageIcon(scaleImage(new ImageIcon("src/res/button2Hover.png").getImage(), 160, 50)));
		sideOkBtn.setText("Ok");
		sideOkBtn.setHorizontalTextPosition(JButton.CENTER);
		sideOkBtn.setVerticalTextPosition(JButton.CENTER);
		sideOkBtn.setFont(lintel);
		sideOkBtn.setForeground(Color.black);
		sideOkBtn.setBounds(800 + 130, 316, 160, 50);
		sideOkBtn.setVisible(true);
		
		frame.repaint();
	}
	
	/**
	 * Show the GUI for a deposit.
	 */
	public void deposit()
	{
		bgLbl.add(firstLbl);
		
		// firstLbl setup
		firstLbl.setBounds(800 + 90, 116, 400, 40);
		firstLbl.setFont(lintel);
		firstLbl.setText("Enter the Deposit amount:");
		firstLbl.setVisible(true);
		
		bgLbl.add(firstText);
		
		// firstText setup
		firstText.setBounds(800 + 90, 156, 240, 40);
		firstText.setFont(lintel);
		firstText.setVisible(true);
		
		bgLbl.add(sideOkBtn);
		
		// sideOkBtn setup
		sideOkBtn.setBorderPainted(false);
		sideOkBtn.setOpaque(false);
		sideOkBtn.setContentAreaFilled(false);
		sideOkBtn.setFocusPainted(false);
		sideOkBtn.setIcon(new ImageIcon(scaleImage(new ImageIcon("src/res/button2.png").getImage(), 160, 50)));
		sideOkBtn.setRolloverIcon(new ImageIcon(scaleImage(new ImageIcon("src/res/button2Hover.png").getImage(), 160, 50)));
		sideOkBtn.setText("Ok");
		sideOkBtn.setHorizontalTextPosition(JButton.CENTER);
		sideOkBtn.setVerticalTextPosition(JButton.CENTER);
		sideOkBtn.setFont(lintel);
		sideOkBtn.setForeground(Color.black);
		sideOkBtn.setBounds(800 + 130, 216, 160, 50);
		sideOkBtn.setVisible(true);
		
		frame.repaint();
	}
	
	/**
	 * Scales an image to the proper size.
	 * @param image
	 */
	private Image scaleImage(Image image, float width, float height)
	{
		if (image instanceof BufferedImage)
	    {
	        return (BufferedImage) image;
	    }

	    // Create a buffered image with transparency
	    BufferedImage bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);

	    // Draw the image on to the buffered image
	    Graphics2D g2d = bimage.createGraphics();
	    g2d.drawImage(image, 0, 0, null);
	    g2d.dispose();
		
		return Scalr.resize(bimage, Method.BALANCED, (int)width, (int)height);
	}
	
	/**
	 * Registers a new Font using the given fontPath.
	 * @param fontPath
	 */
	private Font registerFont(String fontPath, String fontName, int fontSize, boolean isBold)
	{
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		
		try
		{
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		if (isBold)
			return new Font(fontName, Font.BOLD, fontSize);
		else
			return new Font(fontName, Font.PLAIN, fontSize);	
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		/****************************************
		 * Start Screen
		 ***************************************/
		// Ok: Start a bank session if the information is correct
		if (e.getSource() == startOkBtn)
		{
			long ain = 0;
			String password = passText.getText();
			
			try // Check if the ain is valid
			{
				if (ainText.getText().length() == 9)
					ain = Long.parseLong(ainText.getText());
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid AIN (Must be 9-characters).", "Invalid AIN", JOptionPane.ERROR_MESSAGE);
					ainText.setText("");
					passText.setText("");
					return;
				}
			}
			catch(NumberFormatException ne)
			{
				JOptionPane.showMessageDialog(null, "Invalid AIN (Type numbers only).", "Invalid AIN", JOptionPane.ERROR_MESSAGE);
				ainText.setText("");
				passText.setText("");
				return;
			}
			
			// Look for the associate
			for (int x = 0; x < associateDb.getAssociateList().size(); x++)
			{
				if (ain == associateDb.getAssociateList().get(x).getAin())
				{
					currentAssociate = associateDb.getAssociateList().get(x);
				}
			}
			
			if (currentAssociate == null)
			{
				JOptionPane.showMessageDialog(null, "The specified AIN could not be found.", "AIN Not Found", JOptionPane.ERROR_MESSAGE);
				ainText.setText("");
				passText.setText("");
				return;
			}
			
			if (!password.equals(currentAssociate.getPassword()))
			{
				JOptionPane.showMessageDialog(null, "The specified password is incorrect.", "Incorrect Password", JOptionPane.ERROR_MESSAGE);
				ainText.setText("");
				passText.setText("");
				currentAssociate = null;
				return;
			}
			
			ainText.setText("");
			passText.setText("");
			
			showMainScreen();
		}
		
		/****************************************
		 * Exit/Minimize
		 ***************************************/
		// Exit: Exit the program
		if (e.getSource() == exitBtn)
		{
			System.exit(0);
		}
		// Minimize: Minimize the screen
		if (e.getSource() == minimizeBtn)
		{
			frame.setState(Frame.ICONIFIED);
		}
		
		/****************************************
		 * Tabs
		 ***************************************/
		// Customer Tab: Show the customer screen
		if (e.getSource() == customerTab)
		{
			resetSideContent();
			showCustomerTab();
		}
		// Bank Tab: Show the bank screen
		if (e.getSource() == bankTab)
		{
			resetSideContent();
			showBankTab();
		}
		// Logout Tab: Logout the current associate
		if (e.getSource() == logoutTab)
		{
			resetSideContent();
			currentAssociate = null;
			bank.setCurrentAccount(null);
			showStartScreen();
		}
		
		/****************************************
		 * Bank Options
		 ***************************************/
		// Bank Option 1: Perform the first option
		if (e.getSource() == option1Btn)
		{
			sideChoice = 1;
			showBankTab();
		}
		// Bank Option 2: Perform the second option
		if (e.getSource() == option2Btn)
		{
			sideChoice = 2;
			deposit();
			showBankTab();
		}
		// Bank Option 3: Perform the third option
		if (e.getSource() == option3Btn)
		{
			sideChoice = 3;
			showBankTab();
		}
		
		/****************************************
		 * Customer Options
		 ***************************************/
		// Lookup: lookup a customer account
		if (e.getSource() == lookupBtn)
		{
			if (bank.automatedLookup(idText.getText(), nameText.getText()) != null)
			{
				showCustomerTab();
			}
			
			idText.setText("");
			nameText.setText("");
		}
		
		// Create Checking Account:
		if (e.getSource() == newCusBtn)
		{
			sideChoice = 100;
			resetSideContent();
			createCheckingAccount();
		}
		if (e.getSource() == sideOkBtn)
		{
			switch (sideChoice)
			{
				case 1:
					resetSideContent();
					showBankTab();
					break;
			
				case 2:
					bank.deposit(firstText.getText());
					resetSideContent();
					showBankTab();
					break;
					
				case 3:
					resetSideContent();
					showBankTab();
					break;
			
				case 100:
					bank.createCheckingAccount(firstText.getText(), secondText.getText());
					resetSideContent();
					showCustomerTab();
					break;
			}
			
			firstText.setText("");
			secondText.setText("");
			sideChoice = 0;
		}
	}
}