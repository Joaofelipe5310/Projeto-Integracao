import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            System.out.println(getClass().getResource("/fxml/SBpage.fxml"));
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/fxml/SBpage.fxml"));
            Scene scene = new Scene(loader.load());
            primaryStage.setTitle("Projeto de Integração");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
        primaryStage.setOnCloseRequest(e -> {
            System.exit(0);
        });
    }
    public static void main(String[] args) {
        launch(args);
    }
}
