package services;

import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Date;

import repository.EquipementRepository;



public class main {

  public static void main(String[] arg) throws SQLException {

     Scanner scanner = new Scanner(System.in);
     EquipementRepository equipement1 = new EquipementRepository();

     System.out.println("Entrer le nom de l'équipement :");
     String nom_equipement = scanner.nextLine();

     System.out.println("Entrer un type :");
     String type_equipement = scanner.nextLine();

     System.out.println("Entrer un modèle :");
     String modele = scanner.nextLine();

     System.out.println("Entrer un statut :");
     String statut = scanner.nextLine();

    System.out.println("Entrer le nom de l'utilisateur :");
    String nom_utilisateur = scanner.nextLine();

    // Insertion dans la base de données
    equipement1.insertEquipement(nom_equipement, type_equipement, modele, statut, nom_utilisateur);



    // Affichage de tous les équipements
   // equipementRepo.allEquipement();



  }
}
// System.out.println("Entrer l'ID de l'équipement suprimer :");
// int id = Integer.parseInt(scanner.nextLine());
// equipement1.deleteEquipement(id, nom_equipement, type_equipement, modele,
// nom_utilisateur);

// public static void main(String[] arg) throws SQLException {
// 
//

// panne1.insertPanne (description, statut, id_equipement, date_signalement);

// crud equipement
// Scanner scanner = new Scanner(System.in);
// EquipementRepository equipement1 = new EquipementRepository();

// System.out.println("Entrer l'ID de l'équipement à supprimer :");
// int id = Integer.parseInt(scanner.nextLine());

// equipement1.deleteEquipement(id);

// equipement1.updateEquipement(id, nom_equipement, type_equipement, modele,
// statut, nom_utilisateur);

// Insertion dans la base de données
// equipementRepo.insertEquipement(nom_equipement, type_equipement, modele,
// statut, nom_utilisateur);

// Affichage de tous les équipements
// equipementRepo.allEquipement();
