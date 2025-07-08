package repository;

    import java.sql.*;

public class UtilisateurRepository {
    private Connection connection;
    private String sql;

     public UtilisateurRepository(){

     }
    //ajouter un users
    public void insertUtilisateur(String nom,String prenom,String email)throws SQLException{
        this.sql= "INSERT INTO Utilisateur(nom,prenom,email) values(?,?,?)";
        this.connection= DataBase.connectionBd();
        PreparedStatement preparedStatement = this.connection.prepareStatement(this.sql);
        preparedStatement.setString(1, nom);
        preparedStatement.setString(1, prenom);
        preparedStatement.setString(2, email);

        preparedStatement.executeUpdate();
        System.out.println("utilisateur ajouter");
    }
    //afficher tous les utilisateurs
    public void allUtilisateurs()throws SQLException{
        this.sql= "SELECT* FROM Utilisateur";
        this.connection = DataBase.connectionBd();
        Statement statement= this.connection.createStatement();
        ResultSet resultSet= statement.executeQuery(this.sql);
        System.out.println("liste des utilisateurs");
        while (resultSet.next()) {
            int id=resultSet.getInt("id");
        String nom = resultSet.getString("nom");
        String prenom = resultSet.getString("prenom");
        String email = resultSet.getString("email");

        System.out.println("ID:" + id + ",Nom:" + nom + ",Prenom:" + prenom + ",Email" + email);
            
        }
    }
    //mosifier des users
    public void UpdateUtilisateur(int id,String nom, String prenom,String email)throws SQLException{
        this.sql = "UPDATE Utilisateur SET nom=?,prenom=?,email=? WHERE id=?";
        this.connection = DataBase.connectionBd();
        PreparedStatement preparedStatement = this.connection.prepareStatement(this.sql);

        preparedStatement.setInt(1,id);
        preparedStatement.setString(2, nom);
        preparedStatement.setString(3, prenom);
        preparedStatement.setString(4, email);
        preparedStatement.executeUpdate();
        System.out.println("utilisateur mis a jour");
    }
    //suprimer un users
    public void deleteUtilisateur(int id) throws SQLException{

    this.sql = "DELETE FROM Utilisateur WHERE id = ?";
    this.connection = DataBase.connectionBd();
    PreparedStatement preparedStatement = this.connection.prepareStatement(this.sql);
    preparedStatement.setInt(1,id);
    preparedStatement.executeUpdate();
    System.out.println("users supprimer");
    }
}
