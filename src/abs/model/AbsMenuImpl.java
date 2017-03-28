package abs.model;

import java.util.HashMap;
import java.util.Scanner;

import abs.model.users.Customer;

public class AbsMenuImpl {
	
	AbsDisplayMenus dm = new AbsDisplayMenus();
	
	public void initializeMenu(AbsMaps absMaps, AbsClientSystemImpl cs, HashMap<String, Customer> map, AbsFileOperationImpl fo, String writePath) {
		
		Scanner scan = new Scanner(System.in);
		int selected;
		boolean exit = false;
		do {
			dm.printMainMenu();
			dm.printChoice();
			selected = scan.nextInt();
			switch(selected) {
			case 1:
				loginMenu(absMaps, cs, map, fo, writePath);
				break;
			case 2:
				dm.printRegisterMenu();
				registerMenu(absMaps, cs, map, fo, writePath);
				break;
			case 3:
				dm.printExit();
				exit = true;
				break;
			}
		} while (!exit);
	}
	
	public void loginMenu(AbsMaps absMaps, AbsClientSystemImpl cs, HashMap<String, Customer> map, AbsFileOperationImpl fo, String writePath) {
		System.out.println();
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter username: ");
		String username = scan.nextLine();
		System.out.print("Enter password: ");
		String password = scan.nextLine();
		if(absMaps.ownerValidation(username, password) == true) {
			ownerMenu(username, absMaps, cs, map);
		}
		else if(absMaps.customerValidation(username, password) == true) {
			customerMenu(username, absMaps, cs, map, fo, writePath);
		}
		else {
			System.out.println("Sorry, those credentials are invalid.");
		}
		System.out.println();

	}

	public void registerMenu(AbsMaps absMaps, AbsClientSystemImpl cs, HashMap<String, Customer> map, AbsFileOperationImpl fo, String writePath) {
		Scanner scan = new Scanner(System.in);
		int selected;
		selected = scan.nextInt();
		switch(selected) {
			case 1:
				initializeMenu(absMaps, cs, map, fo, writePath);
				break;
			case 2:
				cs.registerCustomer(map);
				fo.compileCustomerMapStrings(writePath, map);
				break;
			case 3:
				System.out.println();
				break;
		}
	}
	
	public void customerMenu(String username, AbsMaps absMaps, AbsClientSystemImpl cs, HashMap<String, Customer> map, AbsFileOperationImpl fo, String writePath) {
		Scanner scan = new Scanner(System.in);
		int selected;
		boolean logout = false;
		do {
			dm.printVerifiedCustomerMenu();
			selected = scan.nextInt();
			switch(selected) {
				case 1:
					System.out.println();
					System.out.println(absMaps.getCustomerMap().get(username).toString());
					break;
				case 2:
					//change password
					cs.changeCustomerPassword(username, map);
					fo.compileCustomerMapStrings(writePath, map);
					break;
				case 3:
					dm.printEditCustomer();
					dm.printChoice();
					cs.editCustomerInformation(username, map);
					fo.compileCustomerMapStrings(writePath, map);
					break;
				case 4:
					System.out.println();
					logout = true;
					break;
			} 
		} while (logout == false);
	}
	
	public void ownerMenu(String username, AbsMaps absMaps, AbsClientSystemImpl cs, HashMap<String, Customer> map) {
		Scanner scan = new Scanner(System.in);
		int selected;
		boolean logout = false;
		do {
			dm.printVerifiedOwnerMenu();
			selected = scan.nextInt();
			switch(selected) {
				case 1:
					System.out.println(absMaps.getOwnerMap().get(username).toString());
					break;
				case 2:
					cs.printCustomerMap(map);
					break;
				case 3:
					logout = true;
					break;
			} 
		} while (logout == false);
	}
	
	
}
