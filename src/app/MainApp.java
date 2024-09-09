package app;

import java.util.Scanner;

import detailed_package.Driver;
import detailed_package.Operations;

public class MainApp {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		
		Operations operation = Driver.helperMethod();
		

		
		System.out.println("Welcome to Qureshi's Travel Ticket Booking Application");
		System.out.println("\nHere are the Modules to perform.\n");
		
		outer: while(true)
		{
			System.out.println("1. Book Ticket");
			System.out.println("2. Show Ticket");
			System.out.println("3. Journey Details");
			System.out.println("4. Search Passenger");
			System.out.println("5. Search Ticket");
			System.out.println("6. Change Boarding Point");
			System.out.println("7. Change Destination Point");
			System.out.println("8. Cancel Ticket");
			System.out.println("9. Exit");
			System.out.println();
			System.out.println("Choose the Option Number to perform Specific Operations");
			
			int option = scan.nextInt();
			
			switch(option)
			{
				case 1: operation.bookTicket();
				break;
				
				case 2: operation.showTicket();
				break;
				
				case 3: operation.journeydetails();
				break;
				
				case 4: operation.searchPassenger();
				break;
				
				case 5: operation.searchTicket();
				break;
				
				case 6: operation.changeBoardingPoint();
				break;
				
				case 7: operation.changeDestinationPoint();
				break;
				
				case 8: operation.cancelTicket();
				break;
				
				case 9: break outer;
				
				default: System.out.println("Enter the Valid Option Number between 1 and 9 inclusive");
			}
		}
		
		System.out.println("You Have Successfully Exited.");
		
	}

}
