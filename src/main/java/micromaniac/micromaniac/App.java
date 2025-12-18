package micromaniac.micromaniac;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {

        String[] devanture = {
                "super slap bros", "battleland 6", "elden cube",
                "surnautica", "zagreus", "Ghost of quimper",
                "Marius", "Zeldo", "cupper gear solid",
                "BLESS", "Alan sleep", "père lachaise rider"
        };

        Magasin magasin = new Magasin(
                2000,   // argent
                false,  // client présent
                70,     // prix neuf
                40,     // prix occasion
                30,     // rachat
                devanture,
                1
        );

        MainView root = new MainView(magasin);

        Scene scene = new Scene(root, 1000, 650);
        stage.setTitle("Micromaniac");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
