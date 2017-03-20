package abs.model;

public class AbsDisplayMenuImpl {
	
	public void printMainMenu() {
		System.out.println("Application Booking System");
		System.out.println("==========================");
		System.out.println("1. Login");
		System.out.println("2. Register");
		System.out.println("3. Exit");
		System.out.println("==========================");
	}
	
	public void printLoginMenu() {
		System.out.println();
		System.out.println("Login Menu");
		System.out.println("==========================");
		System.out.println("Enter Username and Password");
		System.out.println("==========================");
	}
	
	public void printRegisterMenu() {
		System.out.println();
		System.out.println("Register Menu");
		System.out.println("==========================");
		System.out.println("1. Back");
		System.out.println("2. Register new Customer");
		System.out.println("3. Exit");
		System.out.println("==========================");
		printChoice();
	}
	
	public void printCustomerMenu() {
		System.out.println();
		System.out.println("Client Menu");
		System.out.println("==========================");
		System.out.println("1. Back");
		System.out.println("2. Exit");
		System.out.println("==========================");
		printChoice();
	}
	
	public void printOwnerMenu() {
		System.out.println();
		System.out.println("Owner Menu");
		System.out.println("==========================");
		System.out.println("1. Display owner details");
		System.out.println("2. Back");
		System.out.println("3. Exit");
		System.out.println("==========================");
		printChoice();
	}
	
	public void printChoice() {
		System.out.print("Press a number: ");
	}
	
	public void printExit() {
		System.out.println("Session closed");
	}
}
