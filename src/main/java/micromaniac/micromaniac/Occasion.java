package micromaniac.micromaniac;

import java.util.HashMap;
import java.util.Map;


public class Occasion extends Stock{


    public Occasion(int stokelevel,
                    HashMap<String, Integer> stockejeuModerneOccase,
                    HashMap<String, Integer> stockejeuRetroOccase) {
        super(stokelevel, stockejeuModerneOccase, stockejeuRetroOccase);
    }


    @Override
    public void selectionneOccase(String jeu, HashMap<String, Integer> stockejeu){
        stockejeu.put(jeu, stockejeu.get(jeu) - 1);
        setStockejeuModerne(stockejeu);
    }


    @Override
    public void selectionneOccaseRetro(String jeu, HashMap<String, Integer> stockejeu){
        stockejeu.put(jeu, stockejeu.get(jeu) - 1);
        setStockejeuRetro(stockejeu);
    }

    @Override
    public void restockOccase(String jeu, HashMap<String, Integer> stockejeu) {
        stockejeu.put(jeu, stockejeu.get(jeu) + 1);
        setStockejeuModerne(stockejeu);
    }

    @Override
    public void restockOccaseRetro(String jeu, HashMap<String, Integer> stockejeu) {
        stockejeu.put(jeu, stockejeu.get(jeu) + 1);
        setStockejeuRetro(stockejeu);
    }
}
