package micromaniac.micromaniac.Stock;

import java.util.HashMap;


public class Stock {


    private int stokeLevel;
    private int cout;
    private HashMap<String, Integer> stockeJeuRetro;
    private HashMap<String, Integer> stockeJeuModerne;
    private HashMap<String, Integer> stockeJeuRetroOccase;
    private HashMap<String, Integer> stockeJeuModerneOccase;
    private String[] gameListe;
    private String[] gameListeRetro;


    public Stock(int stokeLevel,  HashMap<String, Integer> stockeJeuModerne, HashMap<String, Integer> stockeJeuRetro, String[] gameListe, String[] gameListeRetro) {
        this.stokeLevel = stokeLevel;
        this.stockeJeuModerne = stockeJeuModerne;
        this.stockeJeuRetro = stockeJeuRetro;
        this.gameListe = gameListe;
        this.gameListeRetro = gameListeRetro;
        this.cout = 0;
    }

    public Stock(int stokeLevel, HashMap<String, Integer> stockeJeuModerneOccase, HashMap<String, Integer> stockeJeuRetroOccase) {
        this.stokeLevel = stokeLevel;
        this.stockeJeuModerneOccase = stockeJeuModerneOccase;
        this.stockeJeuRetroOccase = stockeJeuRetroOccase;
    }


    public int getCout() {
        return cout;
    }

    public void setCout(int cout) {
        this.cout = cout;
    }

    public int getStokeLevel() {
        return stokeLevel;
    }

    public void setStokeLevel(int stokeLevel) {
        this.stokeLevel = stokeLevel;
    }

    public HashMap<String, Integer> getStockeJeuRetro() {
        return stockeJeuRetro;
    }

    public void setStockeJeuRetro(HashMap<String, Integer> stockeJeuRetro) {
        this.stockeJeuRetro = stockeJeuRetro;
    }

    public HashMap<String, Integer> getStockeJeuModerne() {
        return stockeJeuModerne;
    }

    public void setStockeJeuModerne(HashMap<String, Integer> stockeJeuModerne) {
        this.stockeJeuModerne = stockeJeuModerne;
    }

    public HashMap<String, Integer> getStockeJeuRetroOccase() {
        return stockeJeuRetroOccase;
    }

    public void setStockeJeuRetroOccase(HashMap<String, Integer> stockeJeuRetroOccase) {
        this.stockeJeuRetroOccase = stockeJeuRetroOccase;
    }

    public HashMap<String, Integer> getStockeJeuModerneOccase() {
        return stockeJeuModerneOccase;
    }

    public void setStockeJeuModerneOccase(HashMap<String, Integer> stockeJeuModerneOccase) {
        this.stockeJeuModerneOccase = stockeJeuModerneOccase;
    }

    public String[] getGameListe() {
        return gameListe;
    }

    public void setGameListe(String[] gameListe) {
        this.gameListe = gameListe;
    }

    public String[] getGameListeRetro() {
        return gameListeRetro;
    }

    public void setGameListeRetro(String[] gameListeRetro) {
        this.gameListeRetro = gameListeRetro;
    }

    public void selectionne(String jeu, HashMap<String, Integer> stockejeu){
        System.out.println("selectionne");
    }

    public void selectionneRetro(String jeu, HashMap<String, Integer> stockejeu){
        System.out.println("selectionne");
    }

    public void restock(String[] listeExemplaire, HashMap<String, Integer> stockejeu) {
        System.out.println("restock moderne");
    }

    public void restockRetro(String[] listeExemplaire, HashMap<String, Integer> stockejeu) {
        System.out.println("restock Retro");
    }


    public void restockOccase(String jeu, HashMap<String, Integer> stockejeuOccasion) {
        System.out.println("restock Occasion");
    }

    public void restockOccaseRetro(String jeu, HashMap<String, Integer> stockejeuOccasion) {
        System.out.println("restock Occasion");
    }

    public void selectionneOccaseRetro(String jeu, HashMap<String, Integer> stockejeu){
        System.out.println("selectionne");
    }

    public void selectionneOccase(String jeu, HashMap<String, Integer> stockejeu){
        System.out.println("selectionne");
    }
}

