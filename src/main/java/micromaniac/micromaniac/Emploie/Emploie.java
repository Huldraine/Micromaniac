package micromaniac.micromaniac.Emploie;

import java.util.HashMap;
import java.util.Map;

public class Emploie {

    private int nbEmploie;
    private int charge;
    private HashMap<String, Integer> tabEmploie;

    public Emploie(int nbEmploie, int charge, HashMap<String, Integer> tabEmploie){

        this.nbEmploie= nbEmploie;
        this.charge= charge;
        this.tabEmploie= tabEmploie;
    }

    public int getNbEmploie() {
        return nbEmploie;
    }

    public void setNbEmploie(int nbEmploie) {
        this.nbEmploie = nbEmploie;
    }

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    public HashMap<String, Integer> getTabEmploie() {
        return tabEmploie;
    }

    public void setTabEmploie(HashMap<String, Integer> tabEmploie) {
        this.tabEmploie = tabEmploie;
    }

    // embauche un employer et on paye des charges
    public int embauche() {
        if (this.nbEmploie <= 5) {
            setNbEmploie(this.nbEmploie + 1);
            this.charge+=500;
            System.out.print("vous avez un nouvel employé");
            HashMap<String, Integer> nouveauMap = new HashMap<>(getTabEmploie());
            nouveauMap.put("E"+ String.valueOf(this.nbEmploie),0);
            setTabEmploie(nouveauMap);
        } else {
            System.out.print("vous avez déja assez d'employé, acheter un nouveau magasin");
        }
        return this.charge;
    }
}
