package micromaniac.micromaniac;

import java.util.Random;

public class Panier extends Client{


    public Panier(String[] panier) {
        super(panier);
    }

    @Override
    public void choixPanier(String[] liste, String[]panier ) {
        Random random = new Random();

        int x = random.nextInt(5);

        for (int i = 0; i <= x -1; i++) {
            int y = random.nextInt(liste.length);
            for (int k = 0; k <= panier.length -1; k++) {
                panier[i] = liste[y];
            }
        }
    }
}
