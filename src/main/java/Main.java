import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import java.util.Objects;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/Projeto_Integracao-1.0-1.0.png")));
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/fxml/SBpage.fxml"));
            Scene scene = new Scene(loader.load());
            primaryStage.setTitle("Projeto de Integração");
            primaryStage.setScene(scene);
            primaryStage.getIcons().add(icon);
            primaryStage.setOnCloseRequest(e -> {
                System.exit(0);
            });
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        launch(args);
    }


}