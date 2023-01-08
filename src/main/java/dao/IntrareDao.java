package dao;

import javax.swing.JOptionPane;
import model.Intrare;
import java.sql.*;

public class IntrareDao {
	 public static void save(Intrare intrare){
	        String query="insert into intrare"; 
	        BDOperations.setDataOrDelete(query, "Registered Successfully! Wait for Admin Approval!");
	    }
}
