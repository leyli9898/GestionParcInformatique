package services;
import java .sql.SQLException;
import java.util.List;
import java.util.Scanner;

import entities.Pannes;

import java.sql.Date;
import repository.PanneRepository;

public class mainPanne {
    public static <Panne> void main(String[] arg) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        PanneRepository panne1= new PanneRepository();
       while(true){
            System.out.println("\n=== Menu Panne ===");
            System.out.println("1.ajouter une panne");
            System.out.println("2.modifierles pannes");
            System.out.println("3;supprimer une panne");
            System.out.println("4.afficher les pannes");
            System.out.println("0.Quitter");
            System.out.println("choix :");
            int choix;
            try{
                
            choix =Integer.parseInt(scanner.nextLine());
            }catch (Exception e){
                System.out.println("veuiller entrer valide");
                continue;
            }
            try{
                switch (choix){
                    case 1:
                        System.out.println("Description:");
                        String description =scanner.nextLine();
                        System.out.println("statut:");
                        String statut= scanner.nextLine();
                        System.out.println("id_equipement:");
                        int id_equipement = Integer.parseInt(scanner.nextLine());
                        System.out.println("date_signalement (yyyy-mm-dd):");
                        Date date_signalement= Date.valueOf(scanner.nextLine());
                        panne1.insertPanne(description, statut, id_equipement, date_signalement);
                        System.out.println("panne ajoutée avec succes");
                        break;
                    case 2:
                       
                        System.out.println("Description de la panne a modifier: ");
                        String anciennedescription =scanner.nextLine();
                        System.out.println(" nouveau statut:");
                        String ancienstatut= scanner.nextLine();
                        System.out.println(" nouvel id_equipement:");
                        int ancienid_equipement = Integer.parseInt(scanner.nextLine());
                        System.out.println(" nouvelle date_signalement (yyyy-mm-dd):");
                        Date anciennedate_signalement= Date.valueOf(scanner.nextLine());
                        panne1.updatePanne(anciennedescription, ancienstatut, ancienid_equipement, anciennedate_signalement);
                        System.out.println("panne ajoutée avec succes");
                        break;
                    case 3:
                        System.out.println("Entrer l'id de la panne a supprimer:");
                        int id = Integer.parseInt(scanner.nextLine());
                        panne1.deletePanne(id);
                        System.out.println("panne suprimer avec succes");
                        break;
                        case 4:
                        List<Panne> pannes = panne1.allPannes();
                        System.out.println("Liste des pannes :");
                        for (Pannes panne : pannes){
                            System.out.println("id: "+ panne.getId_equipement()+
                                    ",Description" + panne.getDescription() +
                                    ",statut: " + panne.getStatut() +
                                    ",id_equipement: "+ panne.getId_equipement() +
                                    ",date_signalement:" + panne.getDate_signalement());
                        }
                        break;
                        case 0:
                        System.out.println("Au revevoir!");
                        scanner.close();
                        return;
                           default:
                           System.out.println("choix invalide, veuller reessayer");
                           
                }
            }catch (SQLException e){
                System.out.println("Erreur lors de l' operation:"+e.getMessage());
            }
        }
        scanner.close();
    }
}


