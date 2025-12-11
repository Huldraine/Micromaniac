package main.java.micromaniac.micromaniac;

public class Magasin {

    private int argent;
    private boolean clientPresent;
    private int prix;
    private  int rachat;
    private String[] devanture;
    private  int employe;

    Client client = new Client();

    public Magasin(int argent, boolean clientPresent,int prix,int rachat, String[] devanture){
        this.argent = argent;
        this.clientPresent = clientPresent;
        this.prix = prix;
        this.rachat = rachat;
        this.devanture = devanture;
    }



    public int getEmployé() {
        return employe;
    }

    public void setEmployé(int employé) {
        this.employe = employé;
    }

    public String[] getDevanture() {
        return devanture;
    }

    public void setDevanture(String[] devanture) {
        this.devanture = devanture;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getRachat() {
        return rachat;
    }

    public void setRachat(int rachat) {
        this.rachat = rachat;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getArgent() {
        return argent;
    }

    public void setArgent(int argent) {
        this.argent = argent;
    }

    public boolean isClientPresent() {
        return clientPresent;
    }

    public void setClientPresent(boolean clientPresent) {
        this.clientPresent = clientPresent;
    }



    public void accueil(){
        this.clientPresent=true;
        client.choixPanier(this.devanture);
        System.out.print("bien le bonjour");
    }

    public void paiment(){
        int c = 0;
        for (int i = 0; i <= client.getPanier().length-1; i++){
            if (client.getPanier()[i] != " "){
                c +=1;
            }
        }

        if (isClientPresent() == false) {
            this.argent += this.prix*c;
        } else {
            System.out.print("il y a déja un client qui attend son tour");
        }
    }

    public  String racheter(String jeu) {
        if (this.argent >= this.rachat) {
            this.argent -= this.rachat;
            return jeu;
        } else {
            return "argent insuffisant pour le rachat du jeu";
        }
    }

    public void day(){
        accueil();
        paiment();
        racheter(client.rendu(this.devanture));
    }

    public void embauche(){
        if (this.employe <= 5) {
            this.employe += 1;
        } else {
            System.out.print("vous avez déja assez d'employé, acheter un nouveau magasin");
        }
    }
}

