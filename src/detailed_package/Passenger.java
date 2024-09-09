package detailed_package;

import java.util.Scanner;

public class Passenger {
	
	Scanner sc = new Scanner(System.in);
	
	private String passengerName;
	private int passengerAge;
	private String passengerMob_No;
	private String passengerGender;
	private Ticket ticket;
	
	public Passenger()	{ }

	public Passenger(String passengerName, int passengerAge, String passengerMob_No, String passengerGender, Ticket ticket) {
		
		if(validateName(passengerName))
		{
			this.passengerName = passengerName;
		}
		else
		{
			setPassengerName(passengerName);
		}
		
		if(verifyAge(passengerAge))
		{
			this.passengerAge = passengerAge;
		}
		else
		{
			setPassengerAge(passengerAge);
		}
		
		if(checkNumber(passengerMob_No))
		{
			this.passengerMob_No = passengerMob_No;
		}
		else
		{
			setPassengerMob_No(passengerMob_No);
		}
		
		if(validateGender(passengerGender))
		{
			this.passengerGender = passengerGender;
		}
		else
		{
			setPassengerGender(passengerGender);
		}
		
		this.ticket = ticket;
	}
	
	// Validation Methods
	
	private boolean checkNumber(String passengerMob_No) {
		
		if(passengerMob_No == null)
		{
			return false;
		}
		
		
		char firstDigit = passengerMob_No.charAt(0);
		
		if(passengerMob_No.length() == 10 && firstDigit >= '7')
			return true;
		
		return false;
	}

	private boolean verifyAge(int passengerAge) {
		
		if(passengerAge >= 1 && passengerAge <= 100)
			return true;
		
		return false;
	}

	private boolean validateName(String passengerName) {
		
		if(passengerName == null)
		{
			return false;
		}
		
		if(passengerName.length() >= 4 && checkNameChars(passengerName))
		{
			return true;
		}
		return false;
	}

	private boolean checkNameChars(String passengerName) {
		
		int count = 0;
		
		for(int i = 0; i < passengerName.length(); i++)
		{
			char currChar = passengerName.charAt(i);
			if(Character.isAlphabetic(currChar))
			{
				count++;
			}
		}
		
		if(count == passengerName.length())
			return true;
		
		return false;
	}

	private boolean validateGender(String passengerGender) {
		
		if(passengerGender == null)
		{
			return false;
		}
		
		
		if(passengerGender.equalsIgnoreCase("male") || passengerGender.equalsIgnoreCase("female"))
			return true;
		
		return false;
	}
	
	
	// Getter Methods

	public String getPassengerName() {
		return this.passengerName;
	}
	
	public int getPassengerAge() {
		return this.passengerAge;
	}
	
	public String getPassengerMob_No() {
		return this.passengerMob_No;
	}
	
	public String getPassengerGender() {
		return this.passengerGender;
	}
	
	public Ticket getTicket()
	{
		return this.ticket;
	}

	// Setter Methods
	
	public void setPassengerName(String passengerName) {
		
		while(validateName(passengerName) == false)
		{
			System.err.println("Enter Valid Name: ");
			passengerName = sc.nextLine();
		}
		
		this.passengerName = passengerName;
		
	}

	public void setPassengerAge(int passengerAge) {
		
		while(verifyAge(passengerAge) == false)
		{
			System.err.println("Enter Valid Age: ");
			passengerAge = sc.nextInt();
		}
		
		this.passengerAge = passengerAge;
	}

	public void setPassengerMob_No(String passengerMob_No) {
		
		while(checkNumber(passengerMob_No) == false)
		{
			System.err.println("Enter Valid Mobile Number: ");
			passengerMob_No = sc.nextLine();
		}
		
		this.passengerMob_No = passengerMob_No;
	}
	
	private void setPassengerGender(String passengerGender)
	{
		while(validateGender(passengerGender) == false)
		{
			System.err.println("Enter Valid Gender: ");
			passengerGender = sc.nextLine();
		}
		
		this.passengerGender = passengerGender;
	}
	
	
	// Display Details Method
	
	public void passengerDetails()
	{
		System.out.println("Passenger Details:");
		System.out.println();
		System.out.println("Name:"+getPassengerName());
		System.out.println("Age:"+getPassengerAge());
		System.out.println("Mobile Number:"+getPassengerMob_No());
		System.out.println("Gender:"+getPassengerGender());
		ticket.ticketDetails();
	}
	
	public void ticketDetails()
	{
		ticket.ticketDetails();
	}
	
	
	
}
