package dao;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Sursa;
import java.sql.*;

public class SursaDao {
	 public static void save(Sursa sursa){
	        String query="insert into sursa(nume_sursa) values('"+sursa.getNume_sursa()+"')";
	        BDOperations.setDataOrDelete(query, "Sursa adaugata cu succes!");
	    }
	    
	    public static ArrayList<Sursa> getAllRecords(){
	        ArrayList<Sursa> arrayList=new ArrayList<Sursa>();
	        try{
	            ResultSet rs=BDOperations.getData("select * from sursa");
	            while(rs.next()){
	                Sursa sursa=new Sursa();
	                sursa.setId_sursa(rs.getInt(1));;
	                sursa.setNume_sursa(rs.getString(2));
	                arrayList.add(sursa);
	            }
	        }
	        catch(Exception e){
	               JOptionPane.showMessageDialog(null, e);
	        }
	        return arrayList;
	    }
	    
	    public static void delete(String id){
	         String query="delete from product where id_sursa='"+id+"'";
	         BDOperations.setDataOrDelete(query, "");
	    }
	    
	    public static int idSursa(String nume) {
	    	int id=0;
	    	try {
	    		ResultSet rs=BDOperations.getData("select id_sursa from sursa where nume_sursa='"+nume+"'");
	    		if(rs.next())
	    			id=rs.getInt(1);
	    	}
	    	catch(Exception e) {
	    		JOptionPane.showMessageDialog(null, e);
	    	}
	    	return id;
	    }
}
