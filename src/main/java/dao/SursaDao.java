package dao;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Sursa;
import java.sql.*;

public class SursaDao {
	 public static void save(Sursa sursa){
	        String query="insert into sursa";
	        BDOperations.setDataOrDelete(query, "Product Added Successfully");
	    }
	    
	    public static ArrayList<Sursa> getAllRecords(){
	        ArrayList<Sursa> arrayList=new ArrayList<Sursa>();
	        try{
	            ResultSet rs=BDOperations.getData("select * from sursa");
	            while(rs.next()){
	                Sursa sursa=new Sursa();
	                /*sursa.setId(rs.getInt("id"));
	                sursa.setName(rs.getString("category"));
	                sursa.setPrice(rs.getString("price"));*/
	                arrayList.add(sursa);
	            }
	        }
	        catch(Exception e){
	               JOptionPane.showMessageDialog(null, e);
	        }
	        return arrayList;
	    }
	    
	    
	    public static void delete(String id){
	         String query="delete from product where id=";
	         BDOperations.setDataOrDelete(query, "Product Deleted Successfully");
	    }
}
