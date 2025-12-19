package micromaniac.micromaniac;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainView extends BorderPane {

    private final Magasin magasin;

    // Pages
    private final StackPane pages = new StackPane();
    private Node pageBoutique;
    private Node pageClient;
    private Node pageGestion;
    private Node pageAjoutJeu;

    // Bas
    private Label argentLabel;

    // Client
    private ListView<String> panierList;
    private Label totalLabel;
    private Label fideliteLabel;

    // Stock
    private TableView<InventaireStock> stockTable;

    public MainView(Magasin magasin) {
        this.magasin = magasin;

        setPadding(new Insets(10));
        setTop(createTopBar());

        pageBoutique = createBoutiquePage();
        pageClient = createClientPage();
        pageGestion = createGestionPage();
        pageAjoutJeu = createAjoutJeuPage();

        pages.getChildren().addAll(pageBoutique, pageClient, pageGestion, pageAjoutJeu);
        show(pageBoutique);

        setCenter(pages);
        setBottom(createBottomBar());

        refreshAll();
    }

    // BARRE DU HAUT
    private Node createTopBar() {
        Label title = new Label("Micromaniac");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Button btnBoutique = new Button("Boutique");
        Button btnClient = new Button("Client");
        Button btnGestion = new Button("Gestion");
        Button btnAjout = new Button("Ajouter un jeu");

        btnBoutique.setOnAction(e -> { show(pageBoutique); refreshAll(); });
        btnClient.setOnAction(e -> { show(pageClient); refreshAll(); });
        btnGestion.setOnAction(e -> { show(pageGestion); refreshAll(); });
        btnAjout.setOnAction(e -> show(pageAjoutJeu));

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        HBox top = new HBox(10, title, spacer,
                btnBoutique, btnClient, btnGestion, btnAjout);
        top.setAlignment(Pos.CENTER_LEFT);
        top.setPadding(new Insets(0, 0, 10, 0));

        return top;
    }

    private void show(Node page) {
        for (Node n : pages.getChildren()) {
            n.setVisible(false);
            n.setManaged(false);
        }
        page.setVisible(true);
        page.setManaged(true);
    }

    // BARRE DU BAS
    private Node createBottomBar() {
        argentLabel = new Label();
        HBox box = new HBox(argentLabel);
        box.setPadding(new Insets(10, 0, 0, 0));
        return box;
    }

    // PAGE BOUTIQUE
    private Node createBoutiquePage() {
        Label title = new Label("Inventaire du magasin");
        title.setStyle("-fx-font-weight: bold;");

        stockTable = new TableView<>();
        stockTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<InventaireStock, String> colNom = new TableColumn<>("Jeu");
        colNom.setCellValueFactory(d -> d.getValue().nomJeuProperty());

        TableColumn<InventaireStock, String> colType = new TableColumn<>("Type");
        colType.setCellValueFactory(d -> d.getValue().typeJeuProperty());

        TableColumn<InventaireStock, Number> colNeuf = new TableColumn<>("Neuf");
        colNeuf.setCellValueFactory(d -> d.getValue().stockNeufProperty());

        TableColumn<InventaireStock, Number> colOcc = new TableColumn<>("Occasion");
        colOcc.setCellValueFactory(d -> d.getValue().stockOccasionProperty());

        stockTable.getColumns().addAll(colNom, colType, colNeuf, colOcc);

        VBox box = new VBox(10, title, stockTable);
        VBox.setVgrow(stockTable, Priority.ALWAYS);

        return box;
    }

    // PAGE CLIENT
    private Node createClientPage() {

        fideliteLabel = new Label();
        panierList = new ListView<>();
        totalLabel = new Label();

        panierList.setMinWidth(400);

        Button accueil = new Button("Faire entrer un client");
        Button calculer = new Button("Calculer total");
        Button rachat = new Button("Rachat d'un jeu");
        Button paiement = new Button("Paiement");

        accueil.setOnAction(e -> {
            magasin.accueil();
            refreshClient();
        });

        calculer.setOnAction(e -> refreshClient());

        paiement.setOnAction(e -> {
            magasin.paiment();
            refreshAll();
        });

        rachat.setOnAction(e -> {
            String jeu = magasin.getClient().rendu(magasin.getDevanture());
            if (jeu == null || jeu.trim().isEmpty()) return;

            magasin.racheter(jeu);
            refreshAll();
        });

        VBox actions = new VBox(10,
                accueil,
                rachat,
                calculer,
                paiement,
                fideliteLabel
        );

        VBox panierBox = new VBox(10,
                new Label("Panier :"),
                panierList,
                totalLabel
        );

        HBox.setHgrow(panierBox, Priority.ALWAYS);
        HBox.setHgrow(panierList, Priority.ALWAYS);

        HBox root = new HBox(20, actions, panierBox);
        root.setPadding(new Insets(10));

        return root;
    }

    // PAGE GESTION
    private Node createGestionPage() {
        Label title = new Label("Gestion du magasin");
        title.setStyle("-fx-font-weight: bold;");

        Button restock = new Button("Restock général");
        Button embauche = new Button("Embaucher");

        restock.setOnAction(e -> {
            magasin.restockGeneral();
            refreshAll();
        });

        embauche.setOnAction(e -> {
            int argent = magasin.e.embauche(magasin.getArgent());
            magasin.setArgent(argent);
            magasin.n.setStokeLevel(magasin.e.getNbEmploie());
            refreshAll();
        });

        VBox box = new VBox(10, restock, embauche);
        box.setPadding(new Insets(10));

        return new VBox(10, title, box);
    }

    // PAGE AJOUT JEU
    private Node createAjoutJeuPage() {
        Label title = new Label("Ajouter un jeu");
        title.setStyle("-fx-font-weight: bold;");

        TextField nomJeuField = new TextField();
        nomJeuField.setPromptText("Nom du jeu");

        ComboBox<String> categorieBox = new ComboBox<>();
        categorieBox.getItems().addAll("Moderne", "Rétro");
        categorieBox.setValue("Moderne");

        Label message = new Label();

        Button ajouter = new Button("Ajouter");

        ajouter.setOnAction(e -> {
            String nom = nomJeuField.getText();
            String categorie = categorieBox.getValue();

            if (nom == null || nom.trim().isEmpty()) {
                message.setText("Nom invalide");
                return;
            }

            boolean retro = categorie.equals("Rétro");

            magasin.ajout(nom, retro);

            message.setText("Jeu ajouté : " + nom);
            nomJeuField.clear();

            refreshStockTable();
        });

        VBox form = new VBox(10,
                new Label("Nom du jeu"),
                nomJeuField,
                new Label("Catégorie"),
                categorieBox,
                ajouter,
                message
        );
        form.setPadding(new Insets(10));
        form.setMaxWidth(300);

        return new VBox(10, title, form);
    }

    // RAFRAÎCHISSEMENTS
    private void refreshAll() {
        argentLabel.setText("Argent : " + magasin.getArgent() + " €");
        refreshClient();
        refreshStockTable();
    }

    private void refreshClient() {
        Client c = magasin.getClient();
        fideliteLabel.setText("Fidélité : " + c.getFidelity());

        List<String> items = new ArrayList<>();
        for (String s : c.getPanier()) {
            if (s != null && !s.equals(" ")) {
                items.add(s);
            }
        }
        panierList.setItems(FXCollections.observableArrayList(items));
        totalLabel.setText("Total estimé : " + magasin.total() + " €");
    }

    private void refreshStockTable() {
        stockTable.setItems(buildInventaire());
    }

    private ObservableList<InventaireStock> buildInventaire() {
        ObservableList<InventaireStock> rows = FXCollections.observableArrayList();

        for (Map.Entry<String, Integer> e : magasin.n.getStockeJeuModerne().entrySet()) {
            String jeu = e.getKey();
            rows.add(new InventaireStock(
                    jeu,
                    "Moderne",
                    e.getValue(),
                    magasin.o.getStockeJeuModerneOccase().getOrDefault(jeu, 0)
            ));
        }

        for (Map.Entry<String, Integer> e : magasin.n.getStockeJeuRetro().entrySet()) {
            String jeu = e.getKey();
            rows.add(new InventaireStock(
                    jeu,
                    "Rétro",
                    e.getValue(),
                    magasin.o.getStockeJeuRetroOccase().getOrDefault(jeu, 0)
            ));
        }

        return rows;
    }
}
