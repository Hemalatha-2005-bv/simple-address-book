package org.sample.mavensample;
import java.sql.Connection;
import java.util.Scanner;

public class App
{
	 public static void main(String[] args) {
	        // Connect to database
	        Connection conn = DBConnection.getConnection();

	        // Create contact manager
	        ContactManager manager = new ContactManager();

	        // Scanner for input
	        Scanner sc = new Scanner(System.in);

	        while (true) {
	            System.out.println("\n==== CONTACT MANAGEMENT MENU ====");
	            System.out.println("1. Add Contact");
	            System.out.println("2. Show All Contacts");
	            System.out.println("3. Search Contact by Name");
	            System.out.println("4. Delete Contact by ID");
	            System.out.println("5. Exit");
	            System.out.print("Enter your choice: ");
	            int choice = sc.nextInt();
	            sc.nextLine(); 
	            switch (choice) {
	                case 1:
	                    System.out.print("Enter ID: ");
	                    int id = sc.nextInt();
	                    sc.nextLine();
	                    System.out.print("Enter Name: ");
	                    String name = sc.nextLine();
	                    System.out.print("Enter Phone: ");
	                    String phone = sc.nextLine();
	                    System.out.print("Enter Email: ");
	                    String email = sc.nextLine();
	                    System.out.print("Enter Address: ");
	                    String address = sc.nextLine();

	                    Contact contact = new Contact(id, name, phone, email, address);
	                    manager.addContact(contact);
	                    break;

	                case 2:
	                    manager.showAllContacts();
	                    break;

	                case 3:
	                    System.out.print("Enter Name to Search: ");
	                    String searchName = sc.nextLine();
	                    Contact found = manager.searchByName(searchName);
	                    if (found != null)
	                        System.out.println("Found: " + found);
	                    else
	                        System.out.println("❌ Contact not found!");
	                    break;

	                case 4:
	                    System.out.print("Enter ID to Delete: ");
	                    int deleteId = sc.nextInt();
	                    manager.deleteContactById(deleteId);
	                    break;

	                case 5:
	                    System.out.println("Exiting... Goodbye!");
	                    sc.close();
	                    return;

	                default:
	                    System.out.println("Invalid choice! Try again.");
	            }
	        }
	    }
}