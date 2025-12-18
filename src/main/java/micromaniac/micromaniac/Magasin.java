package micromaniac.micromaniac;

import java.util.*;


public class Magasin implements Reduction{


    private int argent;
    private boolean clientPresent;
    private int prix;
    private int prixOcasse;
    private int rachat;
    private String[] devanture;
    private int employe;;

    Emploie e = new Emploie(1);
    Panier client = new Panier(new String[]{ " ", " ", " ", " ", " "});
    Neuf n = new Neuf(
            1,


            new HashMap<>(Map.of(
                    "super slap bros", 2,
                    "battleland 6", 2,
                    "elden cube", 2,
                    "surnautica", 2,
                    "zagreus", 2,
                    "Ghost of quimper", 2
            )),

            new HashMap<>(Map.of(
                    "Marius", 2,
                    "Zeldo", 2,
                    "cupper gear solid", 2,
                    "BLESS", 2,
                    "Alan sleep", 2,
                    "père lachaise rider", 2
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




    public Magasin(int argent, boolean clientPresent, int prix, int prixOccase, int rachat, String[] devanture, int employe) {
        this.argent = argent;
        this.clientPresent = clientPresent;
        this.prix = prix;
        this.prixOcasse = prixOccase;
        this.rachat = rachat;
        this.devanture = devanture;
        this.employe = employe;
    }


    public int getPrixOcasse() {
        return prixOcasse;
    }

    public void setPrixOcasse(int prixOcasse) {
        this.prixOcasse = prixOcasse;
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


    public void accueil() {
        if (clientPresent == false) {
            this.clientPresent = true;
            client.choixPanier(this.devanture, client.getPanier());
            System.out.println("bien le bonjour");
        } else {
            System.out.println("il y a déjà un client qui attend sont tour");
        }
    }


    public void paiment() {

        int save = getArgent();

        if (clientPresent == true) {

            int c = 0;
            int d=0;
            int total = 0;

            for (int i = 0; i <= client.getPanier().length - 1; i++) {

                if (!client.getPanier()[i].equals(" ")) {

                    boolean retro = Arrays.asList(n.getGamelisteRetro()).contains(client.getPanier()[i]);

                    if (retro) {

                        if (o.getStockejeuRetroOccase().get(client.getPanier()[i]) > 0) {
                            o.selectionneOccaseRetro(client.getPanier()[i], o.getStockejeuRetro());
                            d += 1;

                        } else if (n.getStockejeuRetro().get(client.getPanier()[i]) > 0){
                            n.selectionneRetro(client.getPanier()[i], n.getStockejeuRetro());
                            c += 1;

                        } else {
                            c += 0;

                        }
                    } else {

                        if (o.getStockejeuModerneOccase().get(client.getPanier()[i]) > 0) {

                            o.selectionneOccase(client.getPanier()[i], o.getStockejeuModerne());
                            d += 1;

                        } else if (n.getStockejeuModerne().get(client.getPanier()[i]) > 0){
                            n.selectionne(client.getPanier()[i], n.getStockejeuModerne());
                            c += 1;

                        } else {
                            c += 0;

                        }
                    }
                }

            }
            System.out.println(client.getFidelity());
            total =this.prix * c + this.prixOcasse * d;
            System.out.println(total);
            reduc(client.getFidelity(), total);
            System.out.println(total);
            this.argent += total;
            setClientPresent(false);
            if (getArgent() != save) {
                System.out.println("paiment accepté");
            } else {
                System.out.println("le client n'a rien acheté");
            }
        } else {
            System.out.println("il y a déjà un client qui attend sont tour");
        }
    }





    public int total() {

        int total = 0;
        int c = 0;
        int d = 0;

        for (int i = 0; i <= client.getPanier().length - 1; i++) {

            if (!client.getPanier()[i].equals(" ")) {

                boolean retro = Arrays.asList(n.getGamelisteRetro()).contains(client.getPanier()[i]);

                if (retro) {

                    if (o.getStockejeuRetroOccase().get(client.getPanier()[i]) > 0) {
                        d += 1;

                    } else if (n.getStockejeuRetro().get(client.getPanier()[i]) > 0) {
                        c += 1;

                    } else {
                        c += 0;
                        System.out.print("pas assez");
                    }
                } else {

                    if (o.getStockejeuModerneOccase().get(client.getPanier()[i]) > 0) {
                        d += 1;

                    } else if (n.getStockejeuModerne().get(client.getPanier()[i]) > 0) {
                        c += 1;

                    } else {
                        c += 0;
                        System.out.print("pas assez");
                    }
                }
            }

        }


        // Paiement
        total += this.prix * c + this.prixOcasse * d;
        return total;
    }



    public void racheter(String jeu) {
        if (this.argent >= this.rachat) {
            this.argent -= this.rachat;
            System.out.println(jeu);
            boolean retro = Arrays.asList(n.getGamelisteRetro()).contains(jeu);
            if (retro) {
                o.restockOccase(jeu, o.getStockejeuRetroOccase());
            } else {
                o.restockOccase(jeu, o.getStockejeuModerneOccase());
            }

        } else {
            System.out.println("argent insuffisant pour le rachat du jeu");
        }
    }


    public void day() {
        accueil();
        paiment();
        System.out.println(getArgent());
    }



    public void ajout(String jeu, boolean retro) {
        String[] ajoutJeu = new String[]{jeu};

        if (retro) {
            String[] ancienRetro = n.getGamelisteRetro();
            String[] concateneRetro = new String[ancienRetro.length + 1];

            System.arraycopy(ancienRetro, 0, concateneRetro, 0, ancienRetro.length);
            System.arraycopy(ajoutJeu, 0, concateneRetro, ancienRetro.length, 1);

            n.setGamelisteRetro(concateneRetro);

            HashMap<String, Integer> nouveauMap = new HashMap<>(n.getStockejeuRetro());
            nouveauMap.put(jeu,0);
            n.setStockejeuRetro(nouveauMap);


            HashMap<String, Integer> nouveauMap2 = new HashMap<>(o.getStockejeuRetroOccase());
            nouveauMap2.put(jeu,0);
            o.setStockejeuRetroOccase(nouveauMap2);
        } else {
            String[] ancienModerne = n.getGameliste();
            String[] concateneModerne = new String[ancienModerne.length + 1];

            System.arraycopy(ancienModerne, 0, concateneModerne, 0, ancienModerne.length);
            System.arraycopy(ajoutJeu, 0, concateneModerne, ancienModerne.length, 1);

            n.setGameliste(concateneModerne);

            HashMap<String, Integer> nouveauMap3 = new HashMap<>(n.getStockejeuModerne());
            nouveauMap3.put(jeu,0);
            n.setStockejeuModerne(nouveauMap3);


            HashMap<String, Integer> nouveauMap4 = new HashMap<>(o.getStockejeuModerneOccase());
            nouveauMap4.put(jeu,0);
            o.setStockejeuModerneOccase(nouveauMap4);


        }

        String[] ancienDevanture = getDevanture();
        String[] nouvelleDevanture = new String[ancienDevanture.length + 1];
        System.arraycopy(ancienDevanture, 0, nouvelleDevanture, 0, ancienDevanture.length);
        nouvelleDevanture[ancienDevanture.length] = jeu;
        setDevanture(nouvelleDevanture);
    }

    public void nouvelEmployer(){
        e.embauche(this.argent);
        n.setStokelevel(e.getNbEmploie());
    }

    @Override
    public int reduc(int level, int prix){
        prix = (prix * (100 - level*10))/100;
        return prix;
    }

}
