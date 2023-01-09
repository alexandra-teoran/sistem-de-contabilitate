package dao;

import javax.swing.JOptionPane;

public class Tables {
	public static void main(String[] args) {
        try{
            String tabelCategorie="create table categorie(id_categorie int AUTO_INCREMENT primary key, nume_categorie varchar(200))";
            String tabelSursa="create table sursa(id_sursa int AUTO_INCREMENT primary key, nume_sursa varchar(200))";
            String tabelIntrare="create table intrare(id_intrare int AUTO_INCREMENT primary key, tip_intrare varchar(200), id_sursa int, data date, id_categorie int, suma int, foreign key id_sursa_fk (id_sursa) references sursa(id_sursa), foreign key id_categorie_fk (id_categorie) references categorie(id_categorie))";
            BDOperations.setDataOrDelete(tabelIntrare, "Tabelul Intrare A Fost Creat Cu Succes");
            BDOperations.setDataOrDelete(tabelCategorie, "Tabelul Categorie A Fost Creat Cu Succes");
            BDOperations.setDataOrDelete(tabelSursa, "Tabelul Sursa A Fost Creat Cu Succes");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
