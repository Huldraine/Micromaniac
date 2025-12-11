package main.java.micromaniac.micromaniac;

import java.util.Random;

public class Client {
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

    public Client(){
        this.panier = new String[]{ " ", " ", " ", " ", " "};
        this.fidelity = fidelityLevel();
        this.revend= "";
    }

    public void choixPanier(String[] liste) {
        Random random = new Random();

        int x = random.nextInt(5);

        for (int i = 0; i <= x -1; i++) {
            int y = random.nextInt(10);

            for (int k = 0; k <= this.panier.length -1; k++) {

                if (this.panier[k] == liste[y]){

                    i -=1;
                    break;

                }else {

                    this.panier[i] = liste[y];

                }
            }
        }
    }

    public static int fidelityLevel() {
        Random random = new Random();
        int x = random.nextInt(10);
        return x;
    }

    public String rendu(String[] listejeu){
        Random random = new Random();
        int x = random.nextInt(10);
        setRevend(listejeu[x]);
        return this.revend;
    }
}