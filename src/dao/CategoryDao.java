/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Category;
import java.sql.*;

/**
 *
 * @author infec
 */
public class CategoryDao {
    
    // Method to Insert into the Category Table
    public static void save(Category category){
        String query = "insert into category(name) values('"+category.getName()+"')";
        DbOperations.setDataOrDelete(query, "Category Added Successfully");
    }
    
    // Method to get all Records from the Category Table
    public static ArrayList<Category> getAllRecords(){
        ArrayList<Category> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("select *from category");
            while(rs.next()){
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                arrayList.add(category);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    
    // Method to Delete Records from the Category Table
    public static void delete(String id){
        String query = "delete from category where id='"+id+"'";
        DbOperations.setDataOrDelete(query, "Category Deleted Successfully");
    }
}
