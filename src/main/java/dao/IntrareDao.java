package dao;

import javax.swing.JOptionPane;
import model.Intrare;
import model.Sursa;

import java.sql.*;
import java.util.ArrayList;

public class IntrareDao {
	 public static void save(Intrare intrare){
	        String query="insert into intrare(tip_intrare, id_sursa, data, id_categorie, suma) values('"+intrare.getTip_intrare()+"', '"+intrare.getId_sursa()+"', '"+intrare.getData()+"', '"+intrare.getId_categorie()+"', '"+intrare.getSuma()+"')"; 
	        BDOperations.setDataOrDelete(query, "Intrare adaugata cu succes!");
	    }
	 
	 public static void delete(String id){
         String query="delete from intrare where id_intrare='"+id+"'";
         BDOperations.setDataOrDelete(query, "Product Deleted Successfully");
     }
	 
	 public static int getSold() {
		 int sold=0;
		 try {
			 ResultSet rs=BDOperations.getData("select sum(suma) from intrare group by tip_intrare order by tip_intrare desc");
			 if(rs.next())
				 sold=rs.getInt(1);
			 if(rs.next())
				 sold-=rs.getInt(1);
		 }
		 catch(Exception e) {
			 JOptionPane.showMessageDialog(null, e);
		 }
		 return sold;
	 }
	 
	 public static ArrayList<String[]>getAllRecords() {
		 ArrayList<String[]> object=new ArrayList<String[]>();
		 try {
			 ArrayList<Intrare> list=new ArrayList<Intrare>();
			 ResultSet rs=BDOperations.getData("select * from intrare");
			 while(rs.next()) {
				 Intrare intrare=new Intrare();
				 intrare.setData(rs.getString(4));
				 intrare.setId_categorie(rs.getInt(5));
				 intrare.setId_intrare(rs.getInt(1));
				 intrare.setId_sursa(rs.getInt(3));
				 intrare.setSuma(rs.getInt(6));
				 intrare.setTip_intrare(rs.getString(2));
				 list.add(intrare);
			 }
			 String sursa="", categorie="";
			 for(int i=0; i<list.size(); i++) {
				 ResultSet rs1=BDOperations.getData("select nume_sursa from sursa where id_sursa='"+list.get(i).getId_sursa()+"'");
				 if(rs1.next())
					 sursa=rs1.getString(1);
				 ResultSet rs2=BDOperations.getData("select nume_categorie from categorie where id_categorie='"+list.get(i).getId_categorie()+"'");
				 if(rs2.next())
					 categorie=rs2.getString(1);
				 object.add(new String[] {String.valueOf(list.get(i).getId_intrare()),list.get(i).getTip_intrare(), String.valueOf(list.get(i).getSuma()), sursa, categorie, list.get(i).getData()});
			 }
		 }
		 catch (Exception e) {
			// TODO: handle exception
			 JOptionPane.showMessageDialog(null, e);
		}
		return object;
	 }
	 
	 public static ArrayList<String[]> getIntrariByIntrare(String coloana, String valoare){
		 ArrayList<String[]> object=new ArrayList<String[]>();
		 try {
			 ResultSet rs=null;
			 ArrayList<Intrare> list=new ArrayList<Intrare>();
			 if(coloana.equals("tip_intrare"))
				 rs=BDOperations.getData("select * from intrare where tip_intrare='"+valoare+"'");
			 if(coloana.equals("data"))
				 rs=BDOperations.getData("select * from intrare where data='"+valoare+"'");
			 if(coloana.equals("suma"))
				 rs=BDOperations.getData("select * from intrare where suma='"+valoare+"'");
			 while(rs.next()) {
				 Intrare intrare=new Intrare();
				 intrare.setData(rs.getString(4));
				 intrare.setId_categorie(rs.getInt(5));
				 intrare.setId_intrare(rs.getInt(1));
				 intrare.setId_sursa(rs.getInt(3));
				 intrare.setSuma(rs.getInt(6));
				 intrare.setTip_intrare(rs.getString(2));
				 list.add(intrare);
			 }
			 String sursa="", categorie="";
			 for(Intrare i:list) {
				 ResultSet rs1=BDOperations.getData("select nume_sursa from sursa where id_sursa='"+i.getId_sursa()+"'");
				 if(rs1.next())
					 sursa=rs1.getString(1);
				 ResultSet rs2=BDOperations.getData("select nume_categorie from categorie where id_categorie='"+i.getId_categorie()+"'");
				 if(rs2.next())
					 categorie=rs2.getString(1);
				 object.add(new String[] {String.valueOf(i.getId_intrare()),i.getTip_intrare(), String.valueOf(i.getSuma()), sursa, categorie, i.getData().toString()});
			 }
		 }
		 catch (Exception e) {
			// TODO: handle exception
			 JOptionPane.showMessageDialog(null, e);
		}
		return object;
	 }
	 
	 public static ArrayList<String[]> getIntrariBySursa(String valoare) {
		 ArrayList<String[]> object=new ArrayList<String[]>();
		 try {
			 ResultSet rs1=BDOperations.getData("select id_sursa from sursa where nume_sursa='"+valoare+"'");
			 ArrayList<Intrare> list=new ArrayList<Intrare>();
			 int id_sursa=0;
			 if(rs1.next())
				 id_sursa=rs1.getInt(1);
			 ResultSet rs2=BDOperations.getData("select * from intrare where id_sursa='"+id_sursa+"'");
			 while(rs2.next()) {
				 Intrare intrare=new Intrare();
				 intrare.setData(rs2.getString(4));
				 intrare.setId_categorie(rs2.getInt(5));
				 intrare.setId_intrare(rs2.getInt(1));
				 intrare.setId_sursa(rs2.getInt(3));
				 intrare.setSuma(rs2.getInt(6));
				 intrare.setTip_intrare(rs2.getString(2));
				 list.add(intrare);
			}
			String categorie="";
			for(Intrare i:list) {
				ResultSet rs=BDOperations.getData("select nume_categorie from categorie where id_categorie='"+i.getId_categorie()+"'");
				if(rs.next())
					categorie=rs.getString(1);
				object.add(new String[] {String.valueOf(i.getId_intrare()), i.getTip_intrare(), String.valueOf(i.getSuma()), valoare, categorie, i.getData()});
			}
		 }
		 catch (Exception e) {
			// TODO: handle exception
			 JOptionPane.showMessageDialog(null, e);
		}
		 return object;
	 }
	 
	 public static ArrayList<String[]> getIntrariByCategorie(String valoare) {
		 ArrayList<String[]> object=new ArrayList<String[]>();
		 try {
			 ResultSet rs1=BDOperations.getData("select id_categorie from categorie where nume_categorie='"+valoare+"'");
			 ArrayList<Intrare> list=new ArrayList<Intrare>();
			 int id_categorie=0;
			 if(rs1.next())
				 id_categorie=rs1.getInt(1);
			 ResultSet rs2=BDOperations.getData("select * from intrare where id_categorie='"+id_categorie+"'");
			 while(rs2.next()) {
				 Intrare intrare=new Intrare();
				 intrare.setData(rs2.getString(4));
				 intrare.setId_categorie(rs2.getInt(5));
				 intrare.setId_intrare(rs2.getInt(1));
				 intrare.setId_sursa(rs2.getInt(3));
				 intrare.setSuma(rs2.getInt(6));
				 intrare.setTip_intrare(rs2.getString(2));
				 list.add(intrare);
			}
			String sursa="";
			for(Intrare i:list) {
				ResultSet rs=BDOperations.getData("select nume_sursa from sursa where id_sursa='"+i.getId_sursa()+"'");
				if(rs.next())
					sursa=rs.getString(1);
				object.add(new String[] {String.valueOf(i.getId_intrare()), i.getTip_intrare(), String.valueOf(i.getSuma()), sursa, valoare, i.getData()});
			}
		 }
		 catch (Exception e) {
			// TODO: handle exception
			 JOptionPane.showMessageDialog(null, e);
		}
		 return object;
	 }
	 
	 public static ArrayList<Integer> getChartData() {
		 ArrayList<Integer> list=new ArrayList<Integer>();
		 try {
			 ResultSet rs=BDOperations.getData("select sum(suma) from intrare group by tip_intrare order by tip_intrare desc");
			 while(rs.next()) {
				 list.add(rs.getInt(1));
			 }
		 }
		 catch(Exception e) {
			 JOptionPane.showMessageDialog(null, e);
		 }
		 return list;
	 }
}
