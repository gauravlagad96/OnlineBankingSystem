package com.online.banking;

import com.online.banking.entities.Registration;
import com.online.banking.service.RegistrationService;
import com.online.banking.service.impl.RegistrationServiceImpl;
import java.util.*;

public class App {
	public static void main(String[] args) {

		RegistrationService registrationService = new RegistrationServiceImpl();
		System.out.println("------ WELCOME TO ONLINE BANKING SYSTEM -------");
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("1: Register\t 2:Bank Login\t3:User Login");
			System.out.println("Enter Your Choice : ");
			int choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {

			case 1:
				Registration reg = new Registration();
				System.out.println("Enter UserName : ");
				String name = sc.nextLine();
				reg.setUsername(name);

				System.out.println("Enter Email : ");
				String email = sc.nextLine();
				reg.setEmail(email);

				System.out.println("Enter Password");
				String password = sc.nextLine();
				reg.setPassword(password);

				System.out.println("Enter Mobile NO : ");
				String mob = sc.nextLine();
				reg.setPhoneNumber(mob);

				System.out.println("Enter User Type: bank, customer");
				String userType = sc.nextLine();
				reg.setType(userType);

				boolean newUser = registrationService.addNewUser(reg);

				System.out.println(newUser ? "Register successful" : "Not registered");

				break;

			case 2:
				System.out.println("Welcome to Bank Login Module : ");

				boolean isBankModuleActive = true; // Flag for the inner loop

				do {
					System.out.println("Enter 1: Get all users \t 2: Get all customers \t 3: Exit");
					int ch = sc.nextInt();

					switch (ch) {
					case 1:
						System.out.println("Fetching all users...");
						List<Registration> allUsers = registrationService.getAllUsers();
						if (allUsers.isEmpty()) {
							System.out.println("No users found.");
						} else {
							for (Registration user : allUsers) {
								System.out.println("ID: " + user.getUserId());
								System.out.println("Username: " + user.getUsername());
								System.out.println("Email: " + user.getEmail());
								System.out.println("Phone: " + user.getPhoneNumber());
								System.out.println("User Type: " + user.getType());
								System.out.println("--------------------------");
							}
						}

						break;

					case 2:
						System.out.println("get user by type");
						System.out.println("");
						break;
					case 9:
						isBankModuleActive = false;
						System.out.println("Exit successfully! ");
						break;
					default:
						System.out.println("Invalid Choice");
						break;
					}

				} while (isBankModuleActive);

				break;

			case 3:
				System.out.println("Welcome User !!!!!!!!!!!!!!!!!!!!!!!");
				break;
			case 9: {
				System.out.println("Log Out successfully !");
				System.exit(0);
			}
			default:
				System.out.println("Wrong Choice");
			}

		} while (true);

	}
}
