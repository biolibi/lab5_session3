import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;





public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start (Stage primaryStage) {
        try {
            List<Données> listeDeDonnées = new ArrayList<>();
        ArrayList listeInformation = new ArrayList(10);
        primaryStage.setTitle("Logiciel espion");
        primaryStage.setWidth(600);
        primaryStage.setHeight(1000);
        primaryStage.setResizable(false);
        TextField nom = new TextField("");
        Button inscription = new Button("Inscription");
        Button connection = new Button("Connection");
        inscription.setTranslateX(280);
        connection.setTranslateX(275);
        inscription.setTranslateY(510);
        connection.setTranslateY(560);
        Button retour = new Button("Retour");
        retour.setTranslateX(100);
        Label utilisateur = new Label("Utilisateur");
        Label password = new Label("Mot de passe");
        Label échecDeConnection = new Label("Échec de connection");
        échecDeConnection.setTranslateX(280);
        échecDeConnection.setTranslateY(600);
        Button reset = new Button("Effacer");
        utilisateur.setTranslateX(280);
        utilisateur.setTranslateY(400);
        password.setTranslateX(280);
        password.setTranslateY(450);
        nom.setTranslateX(240);
        nom.setTranslateY(420);
        PasswordField passwordField = new PasswordField();
        passwordField.setTranslateX(240);
        passwordField.setTranslateY(480);
        ArrayList enregistrerPassword = new ArrayList();
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        TextField prenom = new TextField();
        TextField nomDeFamille = new TextField();
        PasswordField confMotDePasse = new PasswordField();
        Label labelconfMotDePasse = new Label("Confirmer le mot de passe");
        Label labelPrenom = new Label("Prénom");
        Label labelNomDeFamille = new Label("Nom de famille");
        Label labelGenre = new Label("Genre");
        Label labelÂge = new Label("Âge");
        Button buttonSinscrire = new Button("S'inscrire");
        Spinner spinnerÂge = new Spinner(18,200,18);
        RadioButton homme = new RadioButton("Homme");
        RadioButton femme = new RadioButton("Femme");
        RadioButton autres = new RadioButton("Autres");
        ToggleGroup groupe = new ToggleGroup();
        homme.setToggleGroup(groupe);
        femme.setToggleGroup(groupe);
        autres.setToggleGroup(groupe);
        RadioButton conditions = new RadioButton("J'accepte les conditions d'utilisation");
        HBox listeDeGenre = new HBox(homme,femme,autres);
        labelNomDeFamille.setTranslateX(270);
        labelNomDeFamille.setTranslateY(335);
        labelPrenom.setTranslateX(285);
        labelconfMotDePasse.setTranslateX(240);
        labelconfMotDePasse.setTranslateY(520);
        labelPrenom.setTranslateY(270);
        listeDeGenre.setTranslateX(240);
        confMotDePasse.setTranslateX(240);
        labelGenre.setTranslateX(300);
        labelGenre.setTranslateY(590);
        confMotDePasse.setTranslateY(550);
        labelÂge.setTranslateX(310);
        labelÂge.setTranslateY(650);
        listeDeGenre.setTranslateY(615);
        spinnerÂge.setTranslateX(240);
        spinnerÂge.setTranslateY(675);
        conditions.setTranslateX(240);
        conditions.setTranslateY(715);
        prenom.setTranslateX(240);
        prenom.setTranslateY(300);
        nomDeFamille.setTranslateX(240);
        nomDeFamille.setTranslateY(365);
        buttonSinscrire.setTranslateX(222);
        buttonSinscrire.setTranslateY(750);
        retour.setTranslateX(360);
        retour.setTranslateY(750);
        reset.setTranslateX(295);
        reset.setTranslateY(750);





        //sauvegarder & loader CSV files

            try {
                File file = new File("SavedData.csv.txt");
                Scanner sc = new Scanner(new FileReader(file));
                Scanner dataScanner;
                int index = 0;

                while (sc.hasNextLine()){
                    dataScanner = new Scanner(sc.nextLine());
                    dataScanner.useDelimiter(",");
                    Données donné = new Données();
                    while (dataScanner.hasNext()){
                        String data = dataScanner.next();
                        if (index == 0)
                            donné.setPrénom(data);
                        if (index == 1)
                            donné.setNom(data);
                        if (index == 2)
                            donné.setUtilisateur(data);
                        if (index == 3)
                            donné.setPassword(data);
                        if (index == 4)
                            donné.setGenre(data);
                        if (index == 5)
                            donné.setAge(data);

                        index++;
                    }
                    index =0;
                    listeDeDonnées.add(donné);
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }


                //récupérer les entrés de l'utilisateur
            nom.textProperty().addListener((observable, oldValue, newValue) -> {
            listeInformation.add(0,newValue);
        });

        passwordField.textProperty().addListener((observable, oldValue, newValue) -> {
            byte[] encodedhash = digest.digest(
                   newValue.getBytes(StandardCharsets.UTF_8));

            enregistrerPassword.add(0,bytesToHex(encodedhash));

        });

            //inscription
        inscription.setOnAction((event)->{
            prenom.setText("");
            nomDeFamille.setText("");
            passwordField.setText("");
            confMotDePasse.setText("");
            nom.setText("");
            utilisateur.setTranslateX(280);
            utilisateur.setTranslateY(400);
            password.setTranslateX(280);
            password.setTranslateY(450);
            nom.setTranslateX(240);
            nom.setTranslateY(420);
            passwordField.setTranslateX(240);
            passwordField.setTranslateY(480);

            Group root = new Group(retour,reset,prenom,nomDeFamille,labelconfMotDePasse,labelGenre,labelPrenom,labelNomDeFamille,labelÂge,spinnerÂge,utilisateur,password,nom,passwordField,conditions,listeDeGenre,confMotDePasse,buttonSinscrire);
            primaryStage.setScene(new Scene(root));
            primaryStage.show();

        });
            //s'inscrire
        buttonSinscrire.setOnAction((event)->{
            Label labelconditionsPourSinscrire = new Label("");
            labelconditionsPourSinscrire.setTranslateX(260);
            labelconditionsPourSinscrire.setTranslateY(800);
            ArrayList valide = new ArrayList();
            valide.clear();
            if (prenom.getText().trim().isEmpty()){
                labelconditionsPourSinscrire.setText("Prénom invalide");
                valide.add(true);
            }
            if (nomDeFamille.getText().trim().isEmpty()){
                labelconditionsPourSinscrire.setText("Nom invalide");
                valide.add(true);
            }
            if (nom.getText().trim().isEmpty()){
                labelconditionsPourSinscrire.setText("Nom d'utilisateur invalide");
                valide.add(true);
            }
            if (passwordField.getText().trim().isEmpty()){
                labelconditionsPourSinscrire.setText("Mot de passe invalide");
                valide.add(true);
            }
            if (confMotDePasse.getText().trim().isEmpty()){
                labelconditionsPourSinscrire.setText("Confirmation mot de passe invalide");
                valide.add(true);
            }
            if (groupe.getSelectedToggle() == null){
                labelconditionsPourSinscrire.setText("Genre invalide");
                valide.add(true);
            }
            if (conditions.isDisable()){
                labelconditionsPourSinscrire.setText("Accepte les conditions");
                valide.add(true);
            }

            if (passwordField.getText() == confMotDePasse.getText()){
                valide.add(true);
            }

            if (valide.size() != 0){
                Group root = new Group(retour,reset,prenom,nomDeFamille,labelconfMotDePasse,labelGenre,labelPrenom,labelNomDeFamille,labelÂge,spinnerÂge,utilisateur,password,nom,passwordField,conditions,listeDeGenre,confMotDePasse,buttonSinscrire,labelconditionsPourSinscrire);
                primaryStage.setScene(new Scene(root));
                primaryStage.show();
            }
            //enregistrer le fichier
            if (valide.size() == 0){
                byte[] encodedhash = digest.digest(
                        passwordField.getText().getBytes(StandardCharsets.UTF_8));

                StringBuilder stringBuilder = new StringBuilder(prenom.getText()+","+nomDeFamille.getText()+","+nom.getText()+","+bytesToHex(encodedhash)+","+groupe.getSelectedToggle()+","+spinnerÂge.getValue());

                try (FileWriter file = new FileWriter("SavedData.csv.txt",true);
                     BufferedWriter bufferedWriter = new BufferedWriter(file);
                    PrintWriter printWriter = new PrintWriter(bufferedWriter);
                ){
                   printWriter.println(stringBuilder);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Group root = new Group(nom,utilisateur,password,passwordField,inscription,connection);
                primaryStage.setScene(new Scene(root));
                primaryStage.show();
            }



        });

            //tentative de connection
        connection.setOnAction((event) -> {

           boolean connectionÉchouer = false;
           if (1 <=listeDeDonnées.size() && 1<=enregistrerPassword.size() && 1<= listeInformation.size()){


            for (int i = 0; i< listeDeDonnées.size();i++){
                ProgressIndicator progressIndicator = new ProgressIndicator();
                Label chargement = new Label("Chargement...");
                chargement.setTranslateX(250);
                VBox root = new VBox(progressIndicator,chargement);

                if (enregistrerPassword.get(0).equals(listeDeDonnées.get(i).getPassword()) && listeInformation.get(0).equals(listeDeDonnées.get(i).getUtilisateur())){

                    primaryStage.setScene(new Scene(root));
                    primaryStage.show();
                    connectionÉchouer = true;
                }
            }
            if (connectionÉchouer == false){
                Group root  =  new Group(nom,utilisateur,password,passwordField,inscription,connection,échecDeConnection);
                primaryStage.setScene(new Scene(root));
                primaryStage.show();
            }}
        });

            //retour au menu de connection
        retour.setOnAction((event)->{
            Group root = new Group(nom,utilisateur,password,passwordField,inscription,connection);
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        });
            //reset
        reset.setOnAction((event)->{
            ToggleGroup conditionsGroupe = new ToggleGroup();
            conditions.setToggleGroup(conditionsGroupe);
            prenom.setText("");
            nomDeFamille.setText("");
            passwordField.setText("");
            confMotDePasse.setText("");
            nom.setText("");
            groupe.selectToggle(null);
            conditionsGroupe.selectToggle(null);

            Group root = new Group(retour,reset,prenom,nomDeFamille,labelconfMotDePasse,labelGenre,labelPrenom,labelNomDeFamille,labelÂge,spinnerÂge,utilisateur,password,nom,passwordField,conditions,listeDeGenre,confMotDePasse,buttonSinscrire);
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        });

        Group root = new Group(nom,utilisateur,password,passwordField,inscription,connection);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    } catch (java.security.NoSuchAlgorithmException e){

        } }
            //hasher le mot de passe
    private static String bytesToHex(byte[] hash) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }







}
