package micromaniac.micromaniac;

import java.util.HashMap;
import java.util.Map;


public class Occasion extends Stock{


    public Occasion(int stokelevel,
                    HashMap<String, Integer> stockejeuModerneOccase,
                    HashMap<String, Integer> stockejeuRetroOccase) {
        super(stokelevel, stockejeuModerneOccase, stockejeuRetroOccase);
    }

    //retire un jeu occase moderne pendant l'achat
    @Override
    public void selectionneOccase(String jeu, HashMap<String, Integer> stockejeu){
        stockejeu.put(jeu, stockejeu.get(jeu) - 1);
        setStockejeuModerne(stockejeu);
    }

    //retire un jeu occase retro lors de l'achat
    @Override
    public void selectionneOccaseRetro(String jeu, HashMap<String, Integer> stockejeu){
        stockejeu.put(jeu, stockejeu.get(jeu) - 1);
        setStockejeuRetro(stockejeu);
    }

    //augmente lors du rachat auprès du client
    @Override
    public void restockOccase(String jeu, HashMap<String, Integer> stockejeu) {
        stockejeu.put(jeu, stockejeu.get(jeu) + 1);
        setStockejeuModerne(stockejeu);
    }

    //augmente lors du rachat auprès du client
    @Override
    public void restockOccaseRetro(String jeu, HashMap<String, Integer> stockejeu) {
        stockejeu.put(jeu, stockejeu.get(jeu) + 1);
        setStockejeuRetro(stockejeu);
    }
}
