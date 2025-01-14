package com.crud_oop.jdbc;
import com.crud_oop.Sepatu;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class PostgresQuery {
    public static void insertItem(String nama, String brand, String harga, String qty){
        String sql = "INSERT INTO warsneaks (nama, brand, harga, quantity) VALUES (?, ?, ?, ?)";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement psmt = conn.prepareStatement(sql)){
            System.out.println("Insert Item Succeed!");
            psmt.setString(1, nama);
            psmt.setString(2, brand);
            psmt.setInt(3, Integer.parseInt(harga));
            psmt.setInt(4, Integer.parseInt(qty));
            int rowsAffected = psmt.executeUpdate();
            System.out.println("Rows inserted: "+rowsAffected);

        }catch(SQLException e){
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }

    public static List<Sepatu> getAllSepatu(){
        List<Sepatu> sepatu = new ArrayList<>();
        String sql = "SELECT nama, brand, harga, quantity FROM warsneaks";

        try (Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){

            while(rs.next()){
                String nama = rs.getString("nama");
                String brand = rs.getString("brand");
                int harga = rs.getInt("harga");
                int qty = rs.getInt("quantity");

                sepatu.add(new Sepatu(nama, brand, harga, qty));
            }
        }catch(SQLException e){
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
        return sepatu;
    }

    public static void updateItem(String choose_index, String nama, String brand, String harga, String qty){
        String sql = "UPDATE warsneaks SET nama = ?, brand = ?, harga = ?, quantity = ? WHERE nama = ?";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement psmt = conn.prepareStatement(sql)){
            psmt.setString(1, nama);
            psmt.setString(2, brand);
            psmt.setInt(3, Integer.parseInt(harga));
            psmt.setInt(4, Integer.parseInt(qty));
            psmt.setString(5, choose_index);
            int rowsAffected = psmt.executeUpdate();
            System.out.println("Rows updated "+rowsAffected);
        }catch(SQLException e){
            System.out.println("Connection Failed");
            e.printStackTrace();
        }

    }
    public static void deleteItem(String nama){
        String sql = "DELETE FROM warsneaks WHERE nama = ?";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement psmt = conn.prepareStatement(sql)){
            psmt.setString(1, nama);

            int rowAffected = psmt.executeUpdate();
            System.out.println("Row deleted: "+rowAffected);
        }catch(SQLException e){
            System.out.println("Connection Failed!");
            e.printStackTrace();
        }
    }
}