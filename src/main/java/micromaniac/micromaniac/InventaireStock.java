package micromaniac.micromaniac;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class InventaireStock {

    private final SimpleStringProperty nomJeu;
    private final SimpleStringProperty typeJeu;
    private final SimpleIntegerProperty stockNeuf;
    private final SimpleIntegerProperty stockOccasion;

    public InventaireStock(String nomJeu, String typeJeu, int stockNeuf, int stockOccasion) {
        this.nomJeu = new SimpleStringProperty(nomJeu);
        this.typeJeu = new SimpleStringProperty(typeJeu);
        this.stockNeuf = new SimpleIntegerProperty(stockNeuf);
        this.stockOccasion = new SimpleIntegerProperty(stockOccasion);
    }

    public SimpleStringProperty nomJeuProperty() {
        return nomJeu;
    }

    public SimpleStringProperty typeJeuProperty() {
        return typeJeu;
    }

    public SimpleIntegerProperty stockNeufProperty() {
        return stockNeuf;
    }

    public SimpleIntegerProperty stockOccasionProperty() {
        return stockOccasion;
    }
}
