/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Bill;

/**
 *
 * @author infec
 */
public class BillDao {

    // Method to add quuery to select max(id) from Bill table
    public static String getId() {
        int id = 1;
        try {
            ResultSet rs = DbOperations.getData("select max(id) from bill");
            if (rs.next()) {
                id = rs.getInt(1);
                id = id + 1;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return String.valueOf(id);
    }

    // Method to add Query to Insert values into the Bill Table
    public static void save(Bill bill) {
        String query = "insert into bill values('" + bill.getId() + "','" + bill.getName() + "','" + bill.getMobileNumber() + "','" + bill.getEmail() + "','" + bill.getDate() + "','" + bill.getTotal() + "','" + bill.getCreatedBy() + "')";
        DbOperations.setDataOrDelete(query, "Bill Details Added Successfully");
    }

    // Sorting the Bill Details By ascending order
    public static ArrayList<Bill> getAllRecordsByInc(String date) {
        ArrayList<Bill> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("select *from bill where date like'%" + date + "%'");
            while (rs.next()) {
                Bill bill = new Bill();
                bill.setId(rs.getInt("id"));
                bill.setName(rs.getString("name"));
                bill.setMobileNumber(rs.getString("mobileNumber"));
                bill.setEmail(rs.getString("email"));
                bill.setDate(rs.getString("date"));
                bill.setTotal(rs.getString("total"));
                bill.setCreatedBy(rs.getString("createdBy"));
                arrayList.add(bill);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }

    // Sorting Bill Details by Descending Order
    public static ArrayList<Bill> getAllRecordsByDesc(String date) {
        ArrayList<Bill> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("select *from bill where date like'%" + date + "%' order By id DESC");
            while (rs.next()) {
                Bill bill = new Bill();
                bill.setId(rs.getInt("id"));
                bill.setName(rs.getString("name"));
                bill.setMobileNumber(rs.getString("mobileNumber"));
                bill.setEmail(rs.getString("email"));
                bill.setDate(rs.getString("date"));
                bill.setTotal(rs.getString("total"));
                bill.setCreatedBy(rs.getString("createdBy"));
                arrayList.add(bill);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
}
