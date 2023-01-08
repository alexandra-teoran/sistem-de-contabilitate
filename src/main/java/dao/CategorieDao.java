package dao;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Categorie;
import java.sql.*;

public class CategorieDao {
	public static void save(Categorie categorie) {
        String query="insert into categorie";
        BDOperations.setDataOrDelete(query, "Category Added Successfully");
    }
    public static ArrayList<Categorie> getAllRecords(){
        ArrayList<Categorie> arrayList=new ArrayList<Categorie>();
        try{
            ResultSet rs=BDOperations.getData("select * from categorie");
            while(rs.next()){
                Categorie categorie=new Categorie();
                categorie.setId_categorie(rs.getInt("id"));
                categorie.setNume_categorie(rs.getString("nume_categorie"));
                arrayList.add(categorie);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    public static void delete(String id){
        String query="delete from category where id='"+id+"'";
        BDOperations.setDataOrDelete(query, "Category Deleted Successfully");
    }
}
