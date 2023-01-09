package dao;

import javax.swing.JOptionPane;
import model.Intrare;
import java.sql.*;

public class IntrareDao {
	 public static void save(Intrare intrare){
	        String query="insert into intrare(tip_intrare, data, suma) values('"+intrare.getTip_intrare()+"', '"+intrare.getData()+"', '"+intrare.getSuma()+"')"; 
	        BDOperations.setDataOrDelete(query, "Intrare adaugata cu succes!");
	    }
}
