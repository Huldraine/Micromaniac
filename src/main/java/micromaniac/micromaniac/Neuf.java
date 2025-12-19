package micromaniac.micromaniac;

import java.util.HashMap;
import java.util.Map;


public class Neuf extends Stock{



    public Neuf(int stokeLevel, HashMap<String, Integer> stockeJeuModerne, HashMap<String, Integer> stockeJeuRetro, String[] gameListe, String[] gameListeRetro) {
        super(stokeLevel, stockeJeuModerne, stockeJeuRetro, gameListe, gameListeRetro);
    }


    // retire un jeu moderne du stock lors de l'achat
    @Override
    public void selectionne(String jeu, HashMap<String, Integer> stockeJeu){
        stockeJeu.put(jeu, stockeJeu.get(jeu) - 1);
        setStockeJeuModerne(stockeJeu);

    }

    //remets le stock au maximum des jeu neuf
    @Override
    public void restock(String[] listeExemplaire, HashMap<String, Integer> stockeJeu) {
        for (String jeu : listeExemplaire) {
            int manque = 30*((5 * getStokeLevel()) - stockeJeu.get(jeu));
            setCout(getCout()+ manque);
            stockeJeu.put(jeu, 5 * getStokeLevel());
        }
    }

    // retire un jeu moderne du stock lors de l'achat
    @Override
    public void selectionneRetro(String jeu, HashMap<String, Integer> stockeJeu){
        stockeJeu.put(jeu, stockeJeu.get(jeu) - 1);
        setStockeJeuRetro(stockeJeu);

    }

    //remets le stock au maximum des jeux retro
    @Override
    public void restockRetro(String[] listeExemplaire, HashMap<String, Integer> stockeJeu) {

        for (String jeu : listeExemplaire) {
            int manque = 20*((5 * getStokeLevel()) - stockeJeu.get(jeu));
            setCout(getCout()+ manque);
            stockeJeu.put(jeu, 5 * getStokeLevel());
        }
    }
}