package org.sample.mavensample;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactManager {

    // ✅ Add contact to MySQL database
    public void addContact(Contact contact) {
        String sql = "INSERT INTO contacts (name, phone, email, address) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, contact.getName());
            stmt.setString(2, contact.getPhone());
            stmt.setString(3, contact.getEmail());
            stmt.setString(4, contact.getAddress());
            stmt.executeUpdate();

            System.out.println("✅ Contact added successfully to database!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ✅ Show all contacts from MySQL
    public void showAllContacts() {
        String sql = "SELECT * FROM contacts";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Contact List ---");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("phone") + " | " +
                        rs.getString("email") + " | " +
                        rs.getString("address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ✅ Delete contact by ID
    public void deleteContactById(int id) {
        String sql = "DELETE FROM contacts WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();

            if (rows > 0) {
                System.out.println("✅ Contact deleted successfully!");
            } else {
                System.out.println("❌ Contact not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ✅ Search by name
    public Contact searchByName(String name) {
        String sql = "SELECT * FROM contacts WHERE name = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Contact(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("address"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}