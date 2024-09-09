
package detailed_package;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class ConfidentialLogics implements Operations
{
	
	static Scanner scan = new Scanner(System.in);
	private static LinkedList<Passenger> passengerList = new LinkedList<>();
	private static final ArrayList<String> locations = new ArrayList<>(Arrays.asList("Hyderabad","Bangalore","Chennai"));

	public void bookTicket() 
	{
		System.out.println("Enter Your Details Below");
		
		System.out.println("Enter Name: ");
		scan.nextLine();
		String passengerName = scan.nextLine();
		
		while(passengerName == null)
		{
			passengerName = scan.nextLine();
		}
		
		System.out.println("Enter Age: ");
		int passengerAge = scanNumber();
		
		
		System.out.println("Enter Mobile Number: ");
		String passengerMob_No = scanString();
		
		System.out.println("Enter Gender: ");
		String passengerGender = scanString();
		
		Passenger passenger = new Passenger(passengerName,passengerAge,passengerMob_No,passengerGender,createTicket());
		
		passengerList.add(passenger);
		
		System.out.println("Your Ticket is Booked Successfully.\n");
		
		passenger.ticketDetails();
		
		System.out.println("\n\n");
	}
	
	private static Ticket createTicket()
	{
		System.out.println("Ticket Booking: \n");
		
		String boardingPoint;
		String destinationPoint;
		String journeyDate;
		int ticketCost;
		
		ArrayList<String> loc = locations;
				
		System.out.println("For Boarding: \n");
		boardingPoint = setBoardingPoint(loc);
		loc.remove(boardingPoint);
		
		System.out.println("For Destination: \n");
		destinationPoint = setDestinationPoint(loc);
		
		journeyDate = setJourneyDate();
		ticketCost = setTicketCost(boardingPoint, destinationPoint);
		
		return new Ticket(boardingPoint, destinationPoint,journeyDate,ticketCost);
			
	}
	
	private static int setTicketCost(String boardingPoint,String destinationPoint) 
	{
		int ticketCost = 0;
		
		if(boardingPoint == "Hyderabad" && destinationPoint == "Bangalore"
				|| boardingPoint == "Bangalore" && destinationPoint == "Hyderabad")
		{
			ticketCost = 1500;
		}
		else if(boardingPoint == "Hyderabad" && destinationPoint == "Chennai"
				|| boardingPoint == "Chennai" && destinationPoint == "Hyderabad")
		{
			ticketCost = 1300;
		}
		else if(boardingPoint == "Bangalore" && destinationPoint == "Chennai"
				|| boardingPoint == "Chennai" && destinationPoint == "Bangalore")
		{
			ticketCost = 1100;
		}
		
		return ticketCost;
	}

	private static String setJourneyDate() 
	{
		System.out.print("Set the Journey Date: ");
		
		while(true)
		{
			String journeyDate = scanString();
			try
			{
				if(validate(journeyDate))
					return journeyDate;
			}
			catch(InvalidJourneyDate e1)
			{
				System.err.print("\nSet the Valid Date: ");
				journeyDate = scanString();
			}
			catch(NullPointerException e)
			{
				System.err.print("\nSet the Valid Date: ");
				journeyDate = scanString();
			}
		}
		
	}

	private static boolean validate(String journeyDate) throws InvalidJourneyDate 
	{
		
		if(journeyDate == null)
		{
			throw new NullPointerException();
		}
		
		if(journeyDate.length() == 8 && journeyDate.compareTo("08072024") > 0)
		{
			return true;
		}
		else
		{
			throw new InvalidJourneyDate();
		}
		
	}

	private static String setBoardingPoint(ArrayList<String> loc)
	{
		while(true)
		{
			System.out.println("Select Point");
			for(int i = 0; i < loc.size(); i++)
			{
				System.out.println((i+1)+". "+loc.get(i));
			}
			
			int option = scanNumber();
			switch(option)
			{
				case 1: return loc.get(option-1);
				
				case 2: return loc.get(option-1);
				
				case 3: return loc.get(option-1);
				
				default: System.out.println("Enter the valid option between 1 and "+loc.size()+" inclusive");
			}
		}
		
	}
	
	private static String setDestinationPoint(ArrayList<String> loc)
	{
		while(true)
		{
			System.out.println("Select Point");
			for(int i = 0; i < loc.size(); i++)
			{
				System.out.println((i+1)+". "+loc.get(i));
			}
			
			int option = scanNumber();
			switch(option)
			{
				case 1: return loc.get(option-1);
				
				case 2: return loc.get(option-1);
				
				default: System.out.println("Enter the valid option between 1 and "+loc.size()+" inclusive");
			}
		}
		
	}

	
	public void showTicket() 
	{
		
		System.out.println("\nTo Show Ticket Please Enter the details");
		System.out.print("Enter Your Mobile Number: ");
		String passengerMob_No = scanString();
		
		Passenger passenger = searchWithMob_No(passengerMob_No);
		
		if(passenger == null)
		{
			System.out.println("Ticket Not Found");
		}
		else
		{
			System.out.println();
			passenger.ticketDetails();
			System.out.println();
		}
		
	}
	
	private static Passenger searchWithMob_No(String passengerMob_No)
	{
		Passenger passenger = null;
		
		for(int i = 0; i < passengerList.size(); i++)
		{
			passenger = passengerList.get(i);
			if(passenger.getPassengerMob_No().equals(passengerMob_No))
			{
				return passenger;
			}
		}
		
		return null;
	}


	public void journeydetails() 
	{
		
		System.out.println("\nTo Show the Journey Details please enter Mobile Number");
		System.out.print("Enter Mobile Number: ");
		String passengerMob_No = scanString();
		
		Passenger passenger = searchWithMob_No(passengerMob_No);
		
		if(passenger == null)
		{
			System.out.println("Ticket Not Found");
		}
		else
		{
			System.out.println("\n"+passenger.getTicket().getBoardingPoint());
			System.out.println(passenger.getTicket().getDestinationPoint());
			System.out.println(passenger.getTicket().getJourneyDate()+"\n");
		}
	}
	
	private static Passenger searchWithTicketNo(int ticketNumber)
	{
		Iterator<Passenger> iterator = passengerList.iterator();
		
		while(iterator.hasNext())
		{
			Passenger passenger = iterator.next();
			int number = passenger.getTicket().getTicketNumber();
			if(ticketNumber == number)
			{
				return passenger;
			}
		}
		
		return null;
	}
	
	public void searchPassenger() 
	{
		
		System.out.println("\nTo Search Passenger Name Enter Ticket Number");
		
		int ticketNumber = scanNumber();
		
		Passenger passenger = searchWithTicketNo(ticketNumber);
		
		if(passenger == null)
		{
			System.out.println("Passenger Not Found");
		}
		else
		{
			System.out.println("\nThe Passenger Name: "+passenger.getPassengerName()+"\n");
		}
		
	}

	@Override
	public void searchTicket() 
	{
		
		System.out.println("\nTo Search the Ticket Please Enter Mobile Number");
		String passengerMob_No = scanString();
		
		Passenger passenger = searchWithMob_No(passengerMob_No);
		
		if(passenger == null)
		{
			System.out.println("Ticket Not Found");
		}
		else
		{
			System.out.println();
			passenger.ticketDetails();
			System.out.println();
		}
		
	}

	@Override
	public void changeBoardingPoint() 
	{
		
		System.out.println("\nTo Change Boarding Point Please Enter the Ticket Number and Mobile Number");
		System.out.println("Enter Mobile Number: ");
		String passengerMob_No = scanString();
		System.out.println("Enter Ticket Number: ");
		int ticketNumber = scanNumber();
		
		Passenger passenger = searchWithMob_No(passengerMob_No);
		if(passenger != null)
		{
			passenger = searchWithTicketNo(ticketNumber);
			
			if(passenger != null)
			{
				System.out.println("Your Previous Boarding Point was "+passenger.getTicket().getBoardingPoint());
				
				ArrayList<String> loc = locations;
				
				loc.remove(passenger.getTicket().getDestinationPoint());
				
				String newBoardingPoint = setDestinationPoint(loc);
				
				passenger.getTicket().setBoardingPoint(newBoardingPoint);
				
				System.out.println("Your Updated Boarding Point is "+passenger.getTicket().getBoardingPoint());
				
				int ticketCost = setTicketCost(passenger.getTicket().getBoardingPoint(),passenger.getTicket().getDestinationPoint());
				passenger.getTicket().setTicketCost(ticketCost);
				System.out.println();
				passenger.getTicket().ticketDetails();
				System.out.println();
			}
			else
			{
				System.out.println("Ticket Not Found");
			}
		}
		else
		{
			System.out.println("Passenger Not Found");
		}
		
	}

	@Override
	public void changeDestinationPoint() 
	{
		
		System.out.println("\nTo Change Destination Point Please Enter the Ticket Number and Mobile Number");
		System.out.println("Enter Mobile Number: ");
		String passengerMob_No = scanString();
		System.out.println("Enter Ticket Number: ");
		int ticketNumber = scanNumber();
		
		Passenger passenger = searchWithMob_No(passengerMob_No);
		if(passenger != null)
		{
			passenger = searchWithTicketNo(ticketNumber);
			
			if(passenger != null)
			{
				System.out.println("Your Previous Destination Point was "+passenger.getTicket().getDestinationPoint());
				
				ArrayList<String> loc = locations;
				
				loc.remove(passenger.getTicket().getBoardingPoint());
				
				String newDestinationPoint = setDestinationPoint(loc);
				
				passenger.getTicket().setDestinationPoint(newDestinationPoint);
				
				System.out.println("Your Updated Destination Point is "+passenger.getTicket().getDestinationPoint());
				
				int ticketCost = setTicketCost(passenger.getTicket().getBoardingPoint(),passenger.getTicket().getDestinationPoint());
				passenger.getTicket().setTicketCost(ticketCost);
				System.out.println();
				passenger.getTicket().ticketDetails();
				System.out.println();
			}
			else
			{
				System.out.println("Ticket Not Found");
			}
		}
		else
		{
			System.out.println("Passenger Not Found");
		}
		
	}
	

	public void cancelTicket() 
	{
		
		System.out.println("\nTo Cancel the Ticket Enter the Mobile Number and Ticket Number");
		
		System.out.println("Enter Mobile Number: ");
		String passengerMob_No = scanString();
		System.out.println("Enter Ticket Number: ");
		int ticketNumber = scanNumber();
		
		Passenger passenger = searchWithMob_No(passengerMob_No);
		if(passenger != null)
		{
			passenger = searchWithTicketNo(ticketNumber);
			
			if(passenger != null)
			{
				passengerList.remove(passenger);
			}
			else
			{
				System.out.println("Ticket Not Found");
			}
		}
		else
		{
			System.out.println("Passenger Not Found");
		}
		
	}
	
	private static String scanString()
	{
		while(true)
		{
			String newString = scan.next();
			
			if(newString != null || newString.length() > 0)
			{
				return newString;
			}
		}
	}
	
	private static int scanNumber()
	{
		int number = 0;
		
		while(true)
		{
			try
			{
				number = scan.nextInt();
				return number;
			}
			catch(InputMismatchException e)
			{
				System.err.println("Enter Valid Number");
				
			}
		}
	}

}
