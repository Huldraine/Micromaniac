package micromaniac.micromaniac;

public class Emploie extends Magasin {

    public Emploie(int argent, boolean clientPresent, int prix, int prixOccase, int rachat, String[] devanture, int employe) {
        super(argent, clientPresent, prix, prixOccase, rachat, devanture, employe);
    }


    @Override
    public void embauche() {
        if (getEmploye() <= 5) {
            setEmploye(getEmploye() + 1);
            setArgent(getArgent()-500);
            System.out.print("vous avez un nouvel employé");
        } else {
            System.out.print("vous avez déja assez d'employé, acheter un nouveau magasin");
        }
    }


    public void reduc() {

    }

    public void superPromo(){

    }
}
