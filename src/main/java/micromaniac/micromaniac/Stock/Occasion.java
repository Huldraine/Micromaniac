package micromaniac.micromaniac.Stock;

import java.util.HashMap;


public class Occasion extends Stock {


    public Occasion(int stokeLevel,
                    HashMap<String, Integer> stockeJeuModerneOccase,
                    HashMap<String, Integer> stockeJeuRetroOccase) {
        super(stokeLevel, stockeJeuModerneOccase, stockeJeuRetroOccase);
    }

    //retire un jeu occase moderne pendant l'achat
    @Override
    public void selectionneOccase(String jeu, HashMap<String, Integer> stockeJeu){
        stockeJeu.put(jeu, stockeJeu.get(jeu) - 1);
        setStockeJeuModerne(stockeJeu);
    }

    //retire un jeu occase retro lors de l'achat
    @Override
    public void selectionneOccaseRetro(String jeu, HashMap<String, Integer> stockeJeu){
        stockeJeu.put(jeu, stockeJeu.get(jeu) - 1);
        setStockeJeuRetro(stockeJeu);
    }

    //augmente lors du rachat auprès du client
    @Override
    public void restockOccase(String jeu, HashMap<String, Integer> stockeJeu) {
        stockeJeu.put(jeu, stockeJeu.get(jeu) + 1);
        setStockeJeuModerne(stockeJeu);
    }

    //augmente lors du rachat auprès du client
    @Override
    public void restockOccaseRetro(String jeu, HashMap<String, Integer> stockeJeu) {
        stockeJeu.put(jeu, stockeJeu.get(jeu) + 1);
        setStockeJeuRetro(stockeJeu);
    }
}
