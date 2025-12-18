package micromaniac.micromaniac;

import java.util.HashMap;
import java.util.Map;


public class Neuf extends Stock{



    public Neuf(int stokelevel, HashMap<String, Integer> stockejeuModerne, HashMap<String, Integer> stockejeuRetro, String[] gameliste, String[] gamelisteRetro) {
        super(stokelevel, stockejeuModerne, stockejeuRetro, gameliste, gamelisteRetro);
    }


    // retire un jeu moderne du stock lors de l'achat
    @Override
    public void selectionne(String jeu, HashMap<String, Integer> stockejeu){
        stockejeu.put(jeu, stockejeu.get(jeu) - 1);
        setStockejeuModerne(stockejeu);

    }

    //remets le stock au maximum des jeu neuf
    @Override
    public void restock(String[] listeExemplaire, HashMap<String, Integer> stockejeu) {
        int total = 0;
        for (int y = 0; y <= listeExemplaire.length - 1; y++) {
            total = getCout()-(50*((5)-stockejeu.get(listeExemplaire[y])));
            setCout(total);
            stockejeu.put(listeExemplaire[y], (5*this.getStokelevel()));
        }
    }

    // retire un jeu moderne du stock lors de l'achat
    @Override
    public void selectionneRetro(String jeu, HashMap<String, Integer> stockejeu){
        stockejeu.put(jeu, stockejeu.get(jeu) - 1);
        setStockejeuRetro(stockejeu);

    }

    //remets le stock au maximum des jeux retro
    @Override
    public void restockRetro(String[] listeExemplaire , HashMap<String, Integer> stockejeu) {
        int total =0;
        for (int y = 0; y <= listeExemplaire.length - 1; y++) {
            total =  getCout()-(50*((5)-stockejeu.get(listeExemplaire[y])));
            setCout(total);
            stockejeu.put(listeExemplaire[y], (5*this.getStokelevel()));
        }
    }
}
