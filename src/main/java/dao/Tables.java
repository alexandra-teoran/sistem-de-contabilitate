package dao;

import javax.swing.JOptionPane;

public class Tables {
	public static void main(String[] args) {
        try{
            String tabelIntrare="create table intrare(id int AUTO_INCREMENT primary key, nume varchar(200), email varchar(200), nrTelefon varchar(10), adresa varchar(200), parola varchar(200), intrebareDeSecuritate varchar(200), raspunsIntrebareSecuritate varchar(200), status varchar(20), UNIQUE (email))";
            String tabelCategorie="create table categorie(id int AUTO_INCREMENT primary key, name varchar(200))";
            String tabelSursa="create table sursa(id int AUTO_INCREMENT primary key, name varchar(200), category varchar(200), price varchar(200))";
            BDOperations.setDataOrDelete(tabelIntrare, "User Table Created Successfully");
            BDOperations.setDataOrDelete(tabelCategorie, "Category Table Created Successfully");
            BDOperations.setDataOrDelete(tabelSursa, "Product Table Created Successfully");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
