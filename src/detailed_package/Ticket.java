package detailed_package;

import java.util.Random;

public class Ticket {
	private int ticketNumber;
	private String boardingPoint;
	private String destinationPoint;
	private String journeyDate;
	private int ticketCost;
	
	Random randomNumber = new Random();
	
	public Ticket() { }

	public Ticket(String boardingPoint, String destinationPoint, String journeyDate, int ticketCost) {
		
		this.ticketNumber = randomNumber.nextInt(10000,99999);
		this.boardingPoint = boardingPoint;
		this.destinationPoint = destinationPoint;
		this.journeyDate = journeyDate;
		this.ticketCost = ticketCost;
	}

	public String getBoardingPoint() {
		return boardingPoint;
	}

	public void setBoardingPoint(String boardingPoint) {
		this.boardingPoint = boardingPoint;
	}

	public String getDestinationPoint() {
		return destinationPoint;
	}

	public void setDestinationPoint(String destinationPoint) {
		this.destinationPoint = destinationPoint;
	}

	public String getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}

	public int getTicketCost() {
		return ticketCost;
	}

	public void setTicketCost(int ticketCost) {
		this.ticketCost = ticketCost;
	}

	public int getTicketNumber() {
		return ticketNumber;
	}
	
	public void ticketDetails()
	{
		System.out.println("Ticket Details: ");
		System.out.println();
		System.out.println("Number: "+getTicketNumber());
		System.out.println("Boarding Point: "+getBoardingPoint());
		System.out.println("Destination Point: "+getDestinationPoint());
		System.out.println("Journey Date: "+getJourneyDate());
		System.out.println("Cost: "+getTicketCost());
		
	}
	
}
