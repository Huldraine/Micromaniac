package micromaniac.micromaniac;

import java.util.HashMap;


public class Stock {


    private int stokelevel;
    private HashMap<String, Integer> stockejeuRetro;
    private HashMap<String, Integer> stockejeuModerne;
    private HashMap<String, Integer> stockejeuRetroOccase;
    private HashMap<String, Integer> stockejeuModerneOccase;
    private String[] gameliste;
    private String[] gamelisteRetro;


    public Stock(int stokelevel,  HashMap<String, Integer> stockejeuModerne, HashMap<String, Integer> stockejeuRetro, String[] gameliste, String[] gamelisteRetro) {
        this.stokelevel = stokelevel;
        this.stockejeuModerne = stockejeuModerne;
        this.stockejeuRetro = stockejeuRetro;
        this.gameliste = gameliste;
        this.gamelisteRetro = gamelisteRetro;
    }

    public Stock(int stokelevel, HashMap<String, Integer> stockejeuModerneOccase, HashMap<String, Integer> stockejeuRetroOccase) {
        this.stokelevel = stokelevel;
        this.stockejeuModerneOccase = stockejeuModerneOccase;
        this.stockejeuRetroOccase = stockejeuRetroOccase;
    }

    public HashMap<String, Integer> getStockejeuRetroOccase() {
        return stockejeuRetroOccase;
    }

    public void setStockejeuRetroOccase(HashMap<String, Integer> stockejeuRetroOccase) {
        this.stockejeuRetroOccase = stockejeuRetroOccase;
    }

    public HashMap<String, Integer> getStockejeuModerneOccase() {
        return stockejeuModerneOccase;
    }

    public void setStockejeuModerneOccase(HashMap<String, Integer> stockejeuModerneOccase) {
        this.stockejeuModerneOccase = stockejeuModerneOccase;
    }

    public String[] getGamelisteRetro() {
        return gamelisteRetro;
    }

    public void setGamelisteRetro(String[] gamelisteRetro) {
        this.gamelisteRetro = gamelisteRetro;
    }

    public String[] getGameliste() {
        return gameliste;
    }

    public void setGameliste(String[] gameliste) {
        this.gameliste = gameliste;
    }

    public int getStokelevel() {
        return stokelevel;
    }

    public void setStokelevel(int stokelevel) {
        this.stokelevel = stokelevel;
    }

    public HashMap<String, Integer> getStockejeuModerne() {
        return stockejeuModerne;
    }

    public void setStockejeuModerne(HashMap<String, Integer> stockejeuModerne) {
        this.stockejeuModerne = stockejeuModerne;
    }

    public HashMap<String, Integer> getStockejeuRetro() {
        return stockejeuRetro;
    }

    public void setStockejeuRetro(HashMap<String, Integer> stockejeuRetro) {
        this.stockejeuRetro = stockejeuRetro;
    }


    public void selectionne(String jeu, HashMap<String, Integer> stockejeu){
        System.out.println("selectionne");
    }

    public void selectionneRetro(String jeu, HashMap<String, Integer> stockejeu){
        System.out.println("selectionne");
    }

    public void restock(String[] listeExemplaire , int cout, HashMap<String, Integer> stockejeu) {
        System.out.println("restock moderne");
    }

    public void restockRetro(String[] listeExemplaire , int cout, HashMap<String, Integer> stockejeu) {
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

