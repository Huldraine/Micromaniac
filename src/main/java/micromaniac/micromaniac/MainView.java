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

    private final StackPane pages = new StackPane();
    private Node pageBoutique;
    private Node pageClient;
    private Node pageGestion;

    private Label moneyLabel;

    // Client
    private ListView<String> clientCartList;
    private Label clientTotalLabel;
    private Label clientFidelityLabel;

    // Stock
    private TableView<InventaireStock> stockTable;

    public MainView(Magasin magasin) {
        this.magasin = magasin;

        setPadding(new Insets(10));
        setTop(createTopBar());

        pageBoutique = createBoutiquePage();
        pageClient = createClientPage();
        pageGestion = createGestionPage();

        pages.getChildren().addAll(pageBoutique, pageClient, pageGestion);
        show(pageBoutique);

        setCenter(pages);
        setBottom(createBottomBar());

        refreshAll();
    }

    // TOP BAR
    private Region createTopBar() {
        Label title = new Label("Micromaniac - Gestion du magasin");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        Button btnBoutique = new Button("Boutique");
        Button btnClient = new Button("Client actuel");
        Button btnGestion = new Button("Gestion");

        btnBoutique.setOnAction(e -> { show(pageBoutique); refreshAll(); });
        btnClient.setOnAction(e -> { show(pageClient); refreshAll(); });
        btnGestion.setOnAction(e -> { show(pageGestion); refreshAll(); });

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        HBox top = new HBox(10, title, spacer, btnBoutique, btnClient, btnGestion);
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

    // BOTTOM BAR
    private Region createBottomBar() {
        moneyLabel = new Label();
        HBox bar = new HBox(moneyLabel);
        bar.setPadding(new Insets(10, 0, 0, 0));
        return bar;
    }

    // PAGE BOUTIQUE
    private Node createBoutiquePage() {
        Label title = new Label("Inventaire du magasin");
        title.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        stockTable = new TableView<>();
        stockTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<InventaireStock, String> colNom =
                new TableColumn<>("Jeu");
        colNom.setCellValueFactory(d -> d.getValue().nomJeuProperty());

        TableColumn<InventaireStock, String> colType =
                new TableColumn<>("Type");
        colType.setCellValueFactory(d -> d.getValue().typeJeuProperty());

        TableColumn<InventaireStock, Number> colNeuf =
                new TableColumn<>("Stock neuf");
        colNeuf.setCellValueFactory(d -> d.getValue().stockNeufProperty());

        TableColumn<InventaireStock, Number> colOcc =
                new TableColumn<>("Stock occasion");
        colOcc.setCellValueFactory(d -> d.getValue().stockOccasionProperty());

        stockTable.getColumns().addAll(colNom, colType, colNeuf, colOcc);

        Button refresh = new Button("Rafraîchir");
        refresh.setOnAction(e -> refreshStockTable());

        VBox page = new VBox(10, title, stockTable, refresh);
        VBox.setVgrow(stockTable, Priority.ALWAYS);

        return page;
    }

    // PAGE CLIENT
    private Node createClientPage() {
        Label title = new Label("Client actuel");
        title.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        clientFidelityLabel = new Label();
        clientCartList = new ListView<>();
        clientTotalLabel = new Label();

        Button btnAccueil = new Button("Faire entrer un client");
        Button btnCalcul = new Button("Calculer total");
        Button btnPaiement = new Button("Paiement");
        Button btnRachat = new Button("Rachat d'un jeu");

        btnAccueil.setOnAction(e -> {
            magasin.accueil();
            refreshClient();
        });

        btnCalcul.setOnAction(e -> {
            clientTotalLabel.setText("Total : " + magasin.total() + " €");
        });

        btnPaiement.setOnAction(e -> {
            magasin.paiment();
            refreshAll();
        });

        btnRachat.setOnAction(e -> {
            String jeu = magasin.getClient().rendu(magasin.getDevanture());
            magasin.racheter(jeu);
            refreshAll();
        });

        VBox left = new VBox(10,
                btnAccueil,
                btnRachat,
                new Separator(),
                clientFidelityLabel,
                new Label("Panier du client"),
                clientCartList,
                clientTotalLabel
        );
        VBox.setVgrow(clientCartList, Priority.ALWAYS);

        VBox right = new VBox(10, btnCalcul, btnPaiement);

        HBox content = new HBox(15, left, right);
        content.setPadding(new Insets(10));
        HBox.setHgrow(left, Priority.ALWAYS);

        return new VBox(10, title, content);
    }

    // PAGE GESTION
    private Node createGestionPage() {
        Label title = new Label("Gestion du magasin");
        title.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        Button restock = new Button("Restock général");
        restock.setOnAction(e -> {
            magasin.restockGeneral();
            refreshAll();
        });

        Button embauche = new Button("Embaucher");
        embauche.setOnAction(e -> {
            int newArgent = magasin.e.embauche(magasin.getArgent());
            magasin.setArgent(newArgent);
            magasin.n.setStokelevel(magasin.e.getNbEmploie());
            refreshAll();
        });

        VBox box = new VBox(10, restock, embauche);
        box.setPadding(new Insets(10));
        box.setStyle("-fx-border-color: #cccccc; -fx-border-radius: 6px;");

        return new VBox(10, title, box);
    }

    // REFRESH
    private void refreshAll() {
        moneyLabel.setText("Argent du magasin : " + magasin.getArgent() + " €");
        refreshClient();
        refreshStockTable();
    }

    private void refreshClient() {
        Client c = magasin.getClient();
        clientFidelityLabel.setText("Fidélité du client : " + c.getFidelity());

        List<String> items = new ArrayList<>();
        for (String s : c.getPanier()) {
            if (s != null && !s.equals(" ")) {
                items.add(s);
            }
        }
        clientCartList.setItems(FXCollections.observableArrayList(items));
        clientTotalLabel.setText("Total estimé : " + magasin.total() + " €");
    }

    private void refreshStockTable() {
        stockTable.setItems(buildInventaire());
    }

    private ObservableList<InventaireStock> buildInventaire() {
        ObservableList<InventaireStock> rows = FXCollections.observableArrayList();

        for (Map.Entry<String, Integer> e : magasin.n.getStockejeuModerne().entrySet()) {
            String jeu = e.getKey();
            int neuf = e.getValue();
            int occ = magasin.o.getStockejeuModerneOccase().getOrDefault(jeu, 0);
            rows.add(new InventaireStock(jeu, "Moderne", neuf, occ));
        }

        for (Map.Entry<String, Integer> e : magasin.n.getStockejeuRetro().entrySet()) {
            String jeu = e.getKey();
            int neuf = e.getValue();
            int occ = magasin.o.getStockejeuRetroOccase().getOrDefault(jeu, 0);
            rows.add(new InventaireStock(jeu, "Rétro", neuf, occ));
        }

        return rows;
    }
}
