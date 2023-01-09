package dao;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Categorie;
import java.sql.*;

public class CategorieDao {
	public static void save(Categorie categorie) {
        String query="insert into categorie(nume_categorie) values('"+categorie.getNume_categorie()+"')";
        BDOperations.setDataOrDelete(query, "Categorie adaugata cu succes!");
    }
    public static ArrayList<Categorie> getAllRecords(){
        ArrayList<Categorie> arrayList=new ArrayList<Categorie>();
        try{
            ResultSet rs=BDOperations.getData("select * from categorie");
            while(rs.next()){
                Categorie categorie=new Categorie();
                categorie.setId_categorie(rs.getInt("id_categorie"));
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
        String query="delete from categorie where id_categorie='"+id+"'";
        BDOperations.setDataOrDelete(query, "Categorie adaugata cu succes!");
    }
}
