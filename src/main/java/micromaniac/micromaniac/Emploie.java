package micromaniac.micromaniac;

public class Emploie {

    private int nbEmploie;

    public Emploie(int nbEmploie){
        this.nbEmploie= nbEmploie;
    }

    public int getNbEmploie() {
        return nbEmploie;
    }

    public void setNbEmploie(int nbEmploie) {
        this.nbEmploie = nbEmploie;
    }

    public int embauche(int argent) {
        if (this.nbEmploie <= 5) {
            setNbEmploie(this.nbEmploie + 1);
            argent=argent-500;
            System.out.print("vous avez un nouvel employé");

        } else {
            System.out.print("vous avez déja assez d'employé, acheter un nouveau magasin");
        }
        return argent;
    }
}
