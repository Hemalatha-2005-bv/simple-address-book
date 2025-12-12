Project Summary: Simple Address Book
 
It is a simple Java-based desktop application developed using Eclipse IDE, MySQL Database, and JDBC (MySQL Connector/J).
It allows users to add, view, search, update, and delete contact information efficiently through a console-based interface.


🔧 Tech Stack

Language: Java (Core Java, JDBC)

IDE: Eclipse (Maven Project)

Database: MySQL

Driver: MySQL Connector/J

Architecture: MVC-inspired structure with a Database connection utility


Features:

Add new contacts with name, phone, email, and address.

View all stored contacts from the database.

Search for a contact by name.

Update or delete contact records using their ID.

Persistent data storage using MySQL.


▶️ How to Run

Open Eclipse → File → New → Maven Project.

Add the provided Java files in src/main/java/simpleaddressbook/.

Add MySQL Connector dependency to pom.xml.

Create the database using the SQL script.

Update your database credentials in DBConnection.java.

Run AddressBookApp.java → choose menu options.


🧠 Sample Menu Output

==== CONTACT MANAGEMENT MENU ====
1. Add Contact
2. Show All Contacts
3. Search Contact by Name
4. Delete Contact by ID
5. Exit
Enter your choice:


🚀 Future Enhancements

GUI integration using JavaFX or Swing

Export contacts to CSV/PDF

User authentication system
