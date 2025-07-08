package repository;

import java.sql.*;

public class PanneRepository {

    private Connection connection;
    private String sql;

    public void insertPanne(String description, String statut, int id_equipement, Date date_signalement)
            throws SQLException {
        this.connection = DataBase.connectionBd();
        this.sql = "INSERT INTO Panne (description, statut, id_equipement, date_signalement) VALUES (?, ?, ?, ?)";

        PreparedStatement preparedStatement = this.connection.prepareStatement(this.sql);
        preparedStatement.setString(1, description);
        preparedStatement.setString(2, statut);
        preparedStatement.setInt(3, id_equipement);
        preparedStatement.setDate(4, date_signalement);

        int rows = preparedStatement.executeUpdate();
        if (rows > 0) {
            System.out.println(" Panne insérée avec succès !");
        } else {
            System.out.println("Aucune panne insérée.");
        }
    }

    // //modifier pannes
    public void updatePanne(int id, String description, String statut, int id_equipement, Date date_signalement)
            throws SQLException {
        this.sql = "UPDATE Panne SET description = ?, statut = ?, id_equipement = ?, date_signalement = ? WHERE id = ?";
        this.connection = DataBase.connectionBd();

        PreparedStatement preparedStatement = this.connection.prepareStatement(this.sql);

        preparedStatement.setString(1, description);
        preparedStatement.setString(2, statut);
        preparedStatement.setInt(3, id_equipement);
        preparedStatement.setDate(4, new java.sql.Date(date_signalement.getTime()));
        preparedStatement.setInt(5, id);

        preparedStatement.executeUpdate();

        System.out.println("Panne modifiée");
    }
    
    // //supprimer des pannes
    public void deletePanne(int id) throws SQLException {
        this.sql = "DELETE FROM Panne WHERE id=?";
        this.connection = DataBase.connectionBd();
        PreparedStatement preparedStatement = this.connection.prepareStatement(this.sql);

        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        System.out.println("panne suprimer");
    }


    // afficher toutes les pannes
    public void allPanne() throws SQLException {
        this.sql = "SELECT * FROM Panne";
        this.connection = DataBase.connectionBd();
        Statement statement = this.connection.createStatement();
        ResultSet resultSet = statement.executeQuery(this.sql);
        System.out.println("Pannes affichees");

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String description = resultSet.getString("description");
            String statut = resultSet.getString("statut");
            int id_equipement = resultSet.getInt("id_equipement");
            Date date_signalement = resultSet.getDate("date_signalement");
            System.out.println("ID:" + id + ",Description:" + description + ",Statut:" + statut + ",ID_equipement:"
                    + id_equipement + "Date_signalement:" + date_signalement);

        }

    }

}
