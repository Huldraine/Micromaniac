package micromaniac.micromaniac;

import java.util.HashMap;
import java.util.Map;


public class Neuf extends Stock{


    public Neuf(int stokelevel, HashMap<String, Integer> stockejeuModerne, HashMap<String, Integer> stockejeuRetro, String[] gameliste, String[] gamelisteRetro) {
        super(stokelevel, stockejeuModerne, stockejeuRetro, gameliste, gamelisteRetro);
    }



    @Override
    public void selectionne(String jeu, HashMap<String, Integer> stockejeu){
        stockejeu.put(jeu, stockejeu.get(jeu) - 1);
        setStockejeuModerne(stockejeu);

    }

    @Override
    public void restock(String[] listeExemplaire , float cout, HashMap<String, Integer> stockejeu) {
        for (int y = 0; y <= listeExemplaire.length - 1; y++) {
            cout = cout +(50*((5)-stockejeu.get(listeExemplaire[y])));
            stockejeu.put(listeExemplaire[y], (5));
        }
    }


    @Override
    public void selectionneRetro(String jeu, HashMap<String, Integer> stockejeu){
        stockejeu.put(jeu, stockejeu.get(jeu) - 1);
        setStockejeuRetro(stockejeu);

    }

    @Override
    public void restockRetro(String[] listeExemplaire , float cout, HashMap<String, Integer> stockejeu) {
        for (int y = 0; y <= listeExemplaire.length - 1; y++) {
            cout = cout +(50*((5)-stockejeu.get(listeExemplaire[y])));
            stockejeu.put(listeExemplaire[y], (5));
        }
    }
}
