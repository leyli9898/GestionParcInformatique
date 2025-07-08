package repository;

import java.sql.*;
import java.util.List;

import entities.Equipement;




public class EquipementRepository {
    private Connection connection;
    private String sql;

    public EquipementRepository() {

    }

     // inserer un equipement
     public void insertEquipement(String nom_equipement, String type_equipement, String modele, String statut, String nom_utilisateur) throws SQLException {
         this.sql = "INSERT INTO Equipement(nom_equipement, type_equipement, modele, statut, nom_utilisateur) VALUES (?, ?, ?, ?, ?)";

         connection = DataBase.connectionBd();
         // methode pour retourner la valeur
         PreparedStatement preparedStatement = connection.prepareStatement(this.sql);
         // remplir les valeurs fournies
         preparedStatement.setString(1, nom_equipement);
         preparedStatement.setString(2, type_equipement);
         preparedStatement.setString(3, modele);
         preparedStatement.setString(4, statut);
         preparedStatement.setString(5, nom_utilisateur);
         // execution de la requette
         preparedStatement.executeUpdate();
         System.out.println("equipementE  ajouter");
     }

      // afficher tous les equipements
 public List<Equipement> allEquipement() throws SQLException {
     this.sql = "SELECT * FROM Equipement";
     this.connection = DataBase.connectionBd();

     Statement statement = this.connection.createStatement();
     ResultSet resultSet = statement.executeQuery(this.sql);

     System.out.println("Liste des équipements :");

     while (resultSet.next()) {
         int id = resultSet.getInt("id");
         String nomEquipement = resultSet.getString("nom_equipement");
         String typeEquipement = resultSet.getString("type_equipement");
         String modele = resultSet.getString("modele");
         String statut = resultSet.getString("statut");
         String nomUtilisateur = resultSet.getString("nom_utilisateur");

         System.out.println("ID: " + id +
                 ", Nom: " + nomEquipement +
                 ", Type: " + typeEquipement +
                 ", Modèle: " + modele +
                 ", Statut: " + statut +
                 ", Utilisateur: " + nomUtilisateur);
     }
 }

    // // //modifier un equipement
      public void updateEquipement(int id,String nom_equipement,String type_equipement, String modele, String statut,String nom_utilisateur) throws SQLException{
          this.sql= "UPDATE Equipement SET nom_equipement =?,type_equipement=?,modele=?,statut=?,nom_utilisateur=? Where id=?";
          this.connection=DataBase.connectionBd();
          PreparedStatement preparedStatement=this.connection.prepareStatement(this.sql);
          //mise a jour des colonnes

             preparedStatement.setString(1, nom_equipement);
             preparedStatement.setString(2, type_equipement);
             preparedStatement.setString(3, modele);
             preparedStatement.setString(4, statut);
             preparedStatement.setString(5, nom_utilisateur);
             preparedStatement.setInt(6, id);

          System.out.println("equipement modifier");

     int rows = preparedStatement.executeUpdate();
     if (rows > 0) {
         System.out.println("Équipement mis à jour avec succès !");
     } else {
         System.out.println("Aucun équipement trouvé avec cet ID.");
     }

     }

    //suprimer un equipement
       public void deleteEquipement(int id) throws SQLException {
    this.sql = "DELETE FROM Equipement WHERE id = ?";
    this.connection = DataBase.connectionBd();
    PreparedStatement preparedStatement = this.connection.prepareStatement(this.sql);
    preparedStatement.setInt(1, id);

    int rows = preparedStatement.executeUpdate();

    if (rows > 0) {
        System.out.println("Équipement supprimé avec succès !");
    } else {
        System.out.println("Aucun équipement trouvé avec cet ID.");
    }
}

}

