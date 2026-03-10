import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            System.out.println(getClass().getResource("/fxml/SBpage.fxml"));

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/fxml/SBpage.fxml")
            );

            Scene scene = new Scene(loader.load());
            primaryStage.setTitle("Projeto de Integração");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
