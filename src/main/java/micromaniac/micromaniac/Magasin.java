package micromaniac.micromaniac;

import micromaniac.micromaniac.Client.Client;
import micromaniac.micromaniac.Client.Panier;
import micromaniac.micromaniac.Emploie.Emploie;
import micromaniac.micromaniac.Stock.Neuf;
import micromaniac.micromaniac.Stock.Occasion;


import java.util.*;


public class Magasin implements Reduction{


    private int argent;
    private boolean clientPresent;
    private boolean rachatPossible;
    private int prix;
    private int prixOccase;
    private int rachat;
    private String[] devanture;
    private int employe;

    Emploie e = new Emploie(1);
    Panier client = new Panier(new String[]{ " ", " ", " ", " ", " "});
    Neuf n = new Neuf(
            1,


            new HashMap<>(Map.of(
                    "super slap bros", 5,
                    "battleland 6", 5,
                    "elden cube", 5,
                    "surnautica", 5,
                    "zagreus", 5,
                    "Ghost of quimper", 5
            )),

            new HashMap<>(Map.of(
                    "Marius", 5,
                    "Zeldo", 5,
                    "cupper gear solid", 5,
                    "BLESS", 5,
                    "Alan sleep", 5,
                    "père lachaise rider", 5
            )),



            new String[]{"super slap bros", "battleland 6", "elden cube", "surnautica", "zagreus", "Ghost of quimper"},

            new String[]{"Marius", "Zeldo", "cupper gear solid", "BLESS", "Alan sleep", "père lachaise rider"}

    );

    Occasion o = new Occasion(
            1,



            new HashMap<>(Map.of(
                    "super slap bros", 0,
                    "battleland 6", 0,
                    "elden cube", 0,
                    "surnautica", 0,
                    "zagreus", 0,
                    "Ghost of quimper", 0
            )),



            new HashMap<>(Map.of(
                    "Marius", 0,
                    "Zeldo", 0,
                    "cupper gear solid", 0,
                    "BLESS", 0,
                    "Alan sleep", 0,
                    "père lachaise rider", 0
            ))

    );



    //constructeur de magasin
    public Magasin(int argent, boolean clientPresent, int prix, int prixOccase, int rachat, String[] devanture, int employe) {
        this.argent = argent;
        this.clientPresent = clientPresent;
        this.rachatPossible = false;
        this.prix = prix;
        this.prixOccase = prixOccase;
        this.rachat = rachat;
        this.devanture = devanture;
        this.employe = employe;
    }




    public boolean isRachatPossible() {
        return rachatPossible;
    }

    public void setRachatPossible(boolean rachatPossible) {
        this.rachatPossible = rachatPossible;
    }

    public int getPrixOcasse() {
        return prixOccase;
    }

    public void setPrixOcasse(int prixOcasse) {
        this.prixOccase = prixOcasse;
    }

    public int getEmploye() {
        return employe;
    }

    public void setEmploye(int employe) {
        this.employe = employe;
    }

    public String[] getDevanture() {
        return devanture;
    }

    public void setDevanture(String[] devanture) {
        this.devanture = devanture;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = (Panier) client;
    }

    public int getRachat() {
        return rachat;
    }

    public void setRachat(int rachat) {
        this.rachat = rachat;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getArgent() {
        return argent;
    }

    public void setArgent(int argent) {
        this.argent = argent;
    }

    public boolean isClientPresent() {
        return clientPresent;
    }

    public void setClientPresent(boolean clientPresent) {
        this.clientPresent = clientPresent;
    }



    // accueil un client, un par un dans le magasin
    public void accueil() {
        if (clientPresent == false) {
            client.setPanier(new String[]{ " ", " ", " ", " ", " "});
            this.clientPresent = true;
            this.rachatPossible = true;
            client.choixPanier(this.devanture, client.getPanier());
            System.out.println("Bien le bonjour");
        } else {
            System.out.println("Il y a déjà un client qui attend son tour");
        }
    }



    // procède au paiment, si le client est présent
    public void paiment() {

        int save = getArgent();

        if (clientPresent == true) {

            int c = 0;
            int d=0;
            int total = 0;

            for (int i = 0; i <= client.getPanier().length - 1; i++) {

                if (!client.getPanier()[i].equals(" ")) {

                    boolean retro = Arrays.asList(n.getGameListeRetro()).contains(client.getPanier()[i]);

                    if (retro) {

                        if (o.getStockeJeuRetroOccase().get(client.getPanier()[i]) > 0) {
                            o.selectionneOccaseRetro(client.getPanier()[i], o.getStockeJeuRetro());
                            d += 1;

                        } else if (n.getStockeJeuRetro().get(client.getPanier()[i]) > 0){
                            n.selectionneRetro(client.getPanier()[i], n.getStockeJeuRetro());
                            c += 1;

                        } else {
                            c += 0;

                        }
                    } else {

                        if (o.getStockeJeuModerneOccase().get(client.getPanier()[i]) > 0) {

                            o.selectionneOccase(client.getPanier()[i], o.getStockeJeuModerne());
                            d += 1;

                        } else if (n.getStockeJeuModerne().get(client.getPanier()[i]) > 0){
                            n.selectionne(client.getPanier()[i], n.getStockeJeuModerne());
                            c += 1;

                        } else {
                            c += 0;

                        }
                    }
                }

            }
            System.out.println(client.getFidelity());
            total =this.prix * c + this.prixOccase * d;
            System.out.println(total);
            int fin =reduc(client.getFidelity(), total);
            System.out.println(fin);
            this.argent += fin;
            setClientPresent(false);
            if (getArgent() != save) {
                System.out.println("Paiment accepté");
            } else {
                System.out.println("Le client n'a rien acheté");
            }
        } else {
            System.out.println("Il y a déjà un client qui attend sont tour");
        }
    }




    // calcule le prix total du panier du client
    public int total() {

        int total = 0;
        int c = 0;
        int d = 0;

        for (int i = 0; i <= client.getPanier().length - 1; i++) {

            if (!client.getPanier()[i].equals(" ")) {

                boolean retro = Arrays.asList(n.getGameListeRetro()).contains(client.getPanier()[i]);

                if (retro) {

                    if (o.getStockeJeuRetroOccase().get(client.getPanier()[i]) > 0) {
                        d += 1;

                    } else if (n.getStockeJeuRetro().get(client.getPanier()[i]) > 0) {
                        c += 1;

                    } else {
                        c += 0;
                        System.out.print("Pas assez");
                    }
                } else {

                    if (o.getStockeJeuModerneOccase().get(client.getPanier()[i]) > 0) {
                        d += 1;

                    } else if (n.getStockeJeuModerne().get(client.getPanier()[i]) > 0) {
                        c += 1;

                    } else {
                        c += 0;
                        System.out.print("Pas assez");
                    }
                }
            }

        }


        // Paiement
        total += this.prix * c + this.prixOccase * d;
        int fin =reduc(client.getFidelity(), total);
        return fin;
    }


    //rachète le jeu que le client ramène
    public void racheter(String jeu) {
        if (this.rachatPossible) {
            if (this.argent >= this.rachat) {
                this.argent -= this.rachat;
                System.out.println(jeu);
                boolean retro = Arrays.asList(n.getGameListeRetro()).contains(jeu);
                if (retro) {
                    o.restockOccase(jeu, o.getStockeJeuRetroOccase());
                } else {
                    o.restockOccase(jeu, o.getStockeJeuModerneOccase());
                }

            } else {
                System.out.println("Argent insuffisant pour le rachat du jeu");
            }

        }
        setRachatPossible(false);
    }


    // simule une journée pour les crash test
    public void day() {
        accueil();
        paiment();
        System.out.println(getArgent());
    }


    // ajoute un jeu dans le jeu vendu
    public void ajout(String jeu, boolean retro) {
        String[] ajoutJeu = new String[]{jeu};

        //ajoute le jeu dans le gameliste retro et dans les dictionnaire de jeu d'occasion et de jeu neuf retro
        if (retro) {
            String[] ancienRetro = n.getGameListeRetro();
            String[] concateneRetro = new String[ancienRetro.length + 1];

            System.arraycopy(ancienRetro, 0, concateneRetro, 0, ancienRetro.length);
            System.arraycopy(ajoutJeu, 0, concateneRetro, ancienRetro.length, 1);

            n.setGameListeRetro(concateneRetro);

            HashMap<String, Integer> nouveauMap = new HashMap<>(n.getStockeJeuRetro());
            nouveauMap.put(jeu,0);
            n.setStockeJeuRetro(nouveauMap);


            HashMap<String, Integer> nouveauMap2 = new HashMap<>(o.getStockeJeuRetroOccase());
            nouveauMap2.put(jeu,0);
            o.setStockeJeuRetroOccase(nouveauMap2);

            //ajoute le jeu dans le gameliste moderne et dans les dictionnaire de jeu d'occasion et de jeu neuf moderne
        } else {
            String[] ancienModerne = n.getGameListe();
            String[] concateneModerne = new String[ancienModerne.length + 1];

            System.arraycopy(ancienModerne, 0, concateneModerne, 0, ancienModerne.length);
            System.arraycopy(ajoutJeu, 0, concateneModerne, ancienModerne.length, 1);

            n.setGameListe(concateneModerne);

            HashMap<String, Integer> nouveauMap3 = new HashMap<>(n.getStockeJeuModerne());
            nouveauMap3.put(jeu,0);
            n.setStockeJeuModerne(nouveauMap3);


            HashMap<String, Integer> nouveauMap4 = new HashMap<>(o.getStockeJeuModerneOccase());
            nouveauMap4.put(jeu,0);
            o.setStockeJeuModerneOccase(nouveauMap4);


        }

        // mets a jour la vitrine du magasin
        String[] ancienDevanture = getDevanture();
        String[] nouvelleDevanture = new String[ancienDevanture.length + 1];
        System.arraycopy(ancienDevanture, 0, nouvelleDevanture, 0, ancienDevanture.length);
        nouvelleDevanture[ancienDevanture.length] = jeu;
        setDevanture(nouvelleDevanture);
    }



    //permet d'ajouté un employer et donc de gerer plus de stock
    public void nouvelEmployer(){
        e.embauche(this.argent);
        n.setStokeLevel(e.getNbEmploie());
    }



    @Override
    public int reduc(int level, int prix){
        prix = (prix * (100 - level*10))/100;
        return prix;
    }



    // fais appelle au fonction de restock des jeu neuf
    public void restockGeneral(){

        n.restock(n.getGameListe(), n.getStockeJeuModerne());
        n.restockRetro(n.getGameListeRetro(), n.getStockeJeuRetro());
        setArgent(this.argent - n.getCout());
    }

}
