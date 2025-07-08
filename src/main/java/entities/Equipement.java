package entities;

public class Equipement {
    private int id;
    private String nom_equipement;
    private String type_equipement;
    private String modele;
    private String statut;
    private String nom_utilisateur;
    
    public Equipement(){

    }

    public Equipement(int id,String nom_equipement,String type_equipement,String modele,String statut,String nom_utilisateur){

        this.id=id;
        this.nom_equipement=nom_equipement;
        this.type_equipement=type_equipement;
        this.modele=modele;
        this.statut=statut;
        this.nom_utilisateur=nom_utilisateur;
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_equipement() {
        return nom_equipement;
    }

    public void setNom_equipement(String nom_equipement) {
        this.nom_equipement = nom_equipement;
    }

    public String getType_equipement() {
        return type_equipement;
    }

    public void setType_equipement(String type_equipement) {
        this.type_equipement = type_equipement;
    }

    public String getModee() {
        return modele;
    }

    public void setModee(String modee) {
        this.modele = modee;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getNom_utlilisateur() {
        return nom_utilisateur;
    }

    public void setNom_utlilisateur(String nom_utlilisateur) {
        this.nom_utilisateur = nom_utlilisateur;
    }


}