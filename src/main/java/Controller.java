import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import org.example.Types;

import static org.example.Types.*;

public class Controller {

    @FXML
    private ComboBox<Types> cbDevice;

    @FXML
    private TreeView<String> treeData;

    @FXML
    private TitledPane tpMeters;


    @FXML
    public void initialize() {
        setTp();
        setcbDevice();
    }

    public void setTp() {
        tpMeters.setDisable(true);
        tpMeters.setExpanded(false);
    }

    public void setcbDevice() {
        cbDevice.getItems().addAll(CRONOS, ARES);

        cbDevice.valueProperty().addListener(new ChangeListener<Types>()
        {
            @Override
            public void changed(ObservableValue<? extends Types> observable, Types oldValue, Types newValue)
            {
                tpMeters.setDisable(false);
                tpMeters.setExpanded(true);

                Types meter = cbDevice.getValue();
                TreeItem<String> root = new TreeItem<>(meter.getLabel());
                TreeItem<String> branch;
                TreeItem<String> leaf;
                for (Types child : meter.getChildren()) {
                    branch = new TreeItem<>(child.getLabel());
                    root.getChildren().add(branch);
                    for (Types grandChild : child.getChildren()) {
                        leaf = new TreeItem<>(grandChild.getLabel());
                        branch.getChildren().add(leaf);
                    }
                }


                root.setExpanded(true);

                treeData.setRoot(root);

            }
        });
    }
}


