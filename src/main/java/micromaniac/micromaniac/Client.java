package micromaniac.micromaniac;

import java.util.Random;

public class Client { // simulation d'un client quelquonque
    private int fidelity;
    private String[] panier ;
    private String revend;

    public String getRevend() {
        return revend;
    }

    public void setRevend(String revend) {
        this.revend = revend;
    }

    public int getFidelity() {
        return fidelity;
    }

    public void setFidelity(int fidelity) {
        this.fidelity = fidelity;
    }

    public String[] getPanier() {
        return panier;
    }

    public void setPanier(String[] panier) {
        this.panier = panier;
    }

    public Client(String[] panier){
        this.panier = panier;
        this.fidelity = fidelityLevel();
        this.revend= "";
    }

    // créer un panier au hasard
    public void choixPanier(String[] liste, String[] panier) {
        System.out.print(" le panier du client est généré");
    }

    // défini son niveau de fidelité
    public static int fidelityLevel() {
        Random random = new Random();
        int x = random.nextInt(5);
        return x;
    }

    //choisi le jeu qu'il veux rendre
    public String rendu(String[] listejeu){
        Random random = new Random();
        int x = random.nextInt(10);
        setRevend(listejeu[x]);
        return this.revend;
    }
}