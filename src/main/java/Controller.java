import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import org.example.Types;

import static org.example.Types.*;

public class Controller {

    @FXML
    private ComboBox<Types> comboOne;

    @FXML
    private TreeView<String> Tree1;

    @FXML
    private TitledPane Model;


    @FXML
    public void initialize() {
        setModels();
        setCombo();
    }

    public void setModels() {
        Model.setDisable(true);
        Model.setExpanded(false);
    }

    public void setCombo() {
        comboOne.getItems().add(CRONOS);
        comboOne.getItems().add(ARES);

        comboOne.valueProperty().addListener(new ChangeListener<Types>()
        {
            @Override
            public void changed(ObservableValue<? extends Types> observable, Types oldValue, Types newValue)
            {
                Model.setDisable(false);
                Model.setExpanded(true);

                Types meter = comboOne.getValue();
                TreeItem<String> root = new TreeItem<>(meter.getLabel());
                TreeItem<String> branch;
                TreeItem<String> leaf;
                for (Types child : meter.getChildren()) {
                    branch = new TreeItem<>(child.getLabel());
                    root.getChildren().add(branch);
                    for (Types grandchild : child.getChildren()) {
                        leaf = new TreeItem<>(grandchild.getLabel());
                        branch.getChildren().add(leaf);
                    }
                }


                root.setExpanded(true);

                Tree1.setRoot(root);

            }
        });
    }
}


