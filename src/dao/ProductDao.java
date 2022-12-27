/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Product;
import java.sql.*;

/**
 *
 * @author infec
 */
public class ProductDao {
    
    // Query to save Advert to database
    public static void save(Product product){
        String query = "insert into product(name,category,price) values('"+product.getName()+"','"+product.getCategory()+"','"+product.getPrice()+"')";
        DbOperations.setDataOrDelete(query, "Advert Added Successfully");
    }
    
     // Query to select Advert from database
    public static ArrayList<Product> getAllRecords(){
        ArrayList<Product> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("select *from product");
            while(rs.next()){
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setCategory(rs.getString("category"));
                product.setPrice(rs.getString("price"));
                arrayList.add(product);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    
    // Query to Update Advert
    public static void update(Product product){
        String query = "update product set name='"+product.getName()+"',category='"+product.getCategory()+"',price='"+product.getPrice()+"' where id ='"+product.getId()+"'";
        DbOperations.setDataOrDelete(query, "Advert Updated Successfully");
    }
    
    // Query to Delete Advert
    public static void delete(String id){
        String query = "delete from product where id = '"+id+"' ";
        DbOperations.setDataOrDelete(query, "Advert Deleted Successfully");
    }
    
    // Query to get the Category
    public static ArrayList<Product> getAllRecordsByCategory(String category){
        ArrayList<Product> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("select *from product where category='"+category+"'");
            while(rs.next()){
                Product product = new Product();
                product.setName(rs.getString("name"));
                arrayList.add(product);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    // Query to filter by name
    public static ArrayList<Product> filterAdvertsByName(String name, String category){
        ArrayList<Product> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("select *from product where name like '%"+name+"%' and category='"+category+"'");
            while(rs.next()){
                Product product = new Product();
                product.setName(rs.getString("name"));
                arrayList.add(product);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    
    // Query to filter advert by name
    public static Product getAdvertByName(String name){
        Product product = new Product();
        try {
            ResultSet rs = DbOperations.getData("select *from product where name='"+name+"'");
            while(rs.next()){
                product.setName(rs.getString(2));
                product.setCategory(rs.getString(3));
                product.setPrice(rs.getString(4));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, name);
        }
        return product;
    }
}
