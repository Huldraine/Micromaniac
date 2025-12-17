package micromaniac.micromaniac;

import java.util.*;


abstract class Magasin {


    private int argent;
    private boolean clientPresent;
    private int prix;
    private int rachat;
    private String[] devanture;
    private int employe;


    Client client = new Client();
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




    public Magasin(int argent, boolean clientPresent, int prix, int rachat, String[] devanture, int employe) {
        this.argent = argent;
        this.clientPresent = clientPresent;
        this.prix = prix;
        this.rachat = rachat;
        this.devanture = devanture;
        this.employe = employe;
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
        this.client = client;
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
            client.choixPanier(this.devanture);
            System.out.println("bien le bonjour");
        } else {
            System.out.println("il y a déjà un client qui attend sont tour");
        }
    }


    public void paiment() {
        int save = getArgent();

        if (!clientPresent) {
            System.out.println("Il n'y a pas de client pour le moment.");
            return;
        }

        int c = 0; // compteur de jeux achetés

        for (String jeu : client.getPanier()) {
            if (jeu.equals(" ")) continue; // panier vide à cet index

            boolean retro = Arrays.asList(n.getGamelisteRetro()).contains(jeu);

            if (retro) {
                // Jeu rétro
                if (o.getStockejeuRetroOccase().getOrDefault(jeu, 0) > 0) {
                    o.selectionneOccaseRetro(jeu, o.getStockejeuRetroOccase());
                    c++;
                } else if (n.getStockejeuRetro().getOrDefault(jeu, 0) > 0) {
                    n.selectionneRetro(jeu, n.getStockejeuRetro());
                    c++;
                } else {
                    System.out.println("Pas assez de stock rétro pour : " + jeu);
                }
            } else {
                // Jeu moderne
                if (o.getStockejeuModerneOccase().getOrDefault(jeu, 0) > 0) {
                    o.selectionneOccase(jeu, o.getStockejeuModerneOccase());
                    c++;
                } else if (n.getStockejeuModerne().getOrDefault(jeu, 0) > 0) {
                    n.selectionne(jeu, n.getStockejeuModerne());
                    c++;
                } else {
                    System.out.println("Pas assez de stock moderne pour : " + jeu);
                }
            }
        }

        // Paiement
        this.argent += this.prix * c;
        setClientPresent(false);

        if (c > 0) {
            System.out.println("Paiement accepté, " + c + " jeu(x) acheté(s).");
        } else {
            System.out.println("Le client n'a rien acheté.");
        }
    }



    public void racheter(String jeu) {
        if (this.argent >= this.rachat) {
            this.argent -= this.rachat;
            System.out.println(jeu);
        } else {
            System.out.println("argent insuffisant pour le rachat du jeu");
        }
    }


    public void day() {
        accueil();
        paiment();
        System.out.println(getArgent());
    }


    public void embauche() {
        System.out.print("vous avez recruté un employé");
    }
}
