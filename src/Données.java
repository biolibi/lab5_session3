public class Données {
    private String nom;
    private String password;
    private String age;
    private String prénom;
    private String utilisateur;
    private String genre;



    public Données (){
        this.prénom = prénom;
        this.age = age;
        this.password =password;
        this.nom = nom;
        this.utilisateur = utilisateur;
        this.genre = genre;
    }

    public String getNom() {
        return nom;
    }

    public String getPassword() {
        return password;
    }

    public String getAge() {
        return age;
    }

    public String getPrénom() {
        return prénom;
    }

    public String getUtilisateur() {
        return utilisateur;
    }

    public String getGenre() {
        return genre;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setPrénom(String prénom) {
        this.prénom = prénom;
    }

    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
