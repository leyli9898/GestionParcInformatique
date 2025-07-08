package entities;

public class Pannes {
    private String description;
    private String statut;
    private int id_equipement;
    private java.util.Date date_signalement;


    public Pannes(){

    }
    public Pannes(String description,String statut,int id_equipement,java.util.Date date_signalement){
        this.description=description;
        this.statut=statut;
        this.id_equipement=id_equipement;
        this.date_signalement=date_signalement;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getStatut() {
        return statut;
    }
    public void setStatut(String statut) {
        this.statut = statut;
    }
    public int getId_equipement() {
        return id_equipement;
    }
    public void setId_equipement(int id_equipement) {
        this.id_equipement = id_equipement;
    }
    public java.util.Date getDate_signalement() {
        return date_signalement;
    }
    public void setDate_signalement(java.util.Date date_signalement) {
        this.date_signalement = date_signalement;
    }
    
}
