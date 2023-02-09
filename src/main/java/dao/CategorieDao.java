package dao;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Categorie;
import java.sql.*;

public class CategorieDao {
	public static void save(Categorie categorie) {
        String query="insert into categorie(nume_categorie) values('"+categorie.getNume_categorie()+"')";
        BDOperations.setDataOrDelete(query, "");
    }
    public static ArrayList<Categorie> getAllRecords(){
        ArrayList<Categorie> arrayList=new ArrayList<Categorie>();
        try{
            ResultSet rs=BDOperations.getData("select * from categorie");
            while(rs.next()){
                Categorie categorie=new Categorie();
                categorie.setId_categorie(rs.getInt(1));
                categorie.setNume_categorie(rs.getString(2));
                arrayList.add(categorie);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    public static void delete(String id){
        String query="delete from categorie where id_categorie='"+id+"'";
        BDOperations.setDataOrDelete(query, "");
    }
    public static int idCategorie(String nume) {
    	int id=0;
    	try {
    		ResultSet rs=BDOperations.getData("select id_categorie from categorie where nume_categorie='"+nume+"'");
    		if(rs.next())
    			id=rs.getInt(1);
    	}
    	catch(Exception e) {
    		JOptionPane.showMessageDialog(null, e);
    	}
    	return id;
    }
}
