import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import org.example.Types;
import org.example.Line;
import org.example.Category;
import org.example.Model;
import org.hibernate.Hibernate;

import java.util.List;

public class Controller {

    @FXML
    private ComboBox<Line> cbDevice;

    @FXML
    private TreeView<String> treeData;

    @FXML
    private TitledPane tpMeters;

    @FXML
    public void initialize() {
        setTp();
        setCbDevice();
    }

    public void setTp() {
        tpMeters.setDisable(true);
        tpMeters.setExpanded(false);
    }



    public void setCbDevice() {
        List<Line> lines = Types.getLines();
        cbDevice.getItems().addAll(FXCollections.observableList(lines));

      cbDevice.valueProperty().addListener(new ChangeListener<Line>() {
          @Override
          public void changed(ObservableValue<? extends Line> observable, Line oldValue, Line newValue) {
              tpMeters.setDisable(false);
              tpMeters.setExpanded(true);

              Line meter = cbDevice.getValue();
              TreeItem<String> root = new TreeItem<>(meter.getName());
              TreeItem<String> branch;
              for (Category cat : meter.getCat()) {
                  branch = new TreeItem<>(cat.getName());
                  root.getChildren().add(branch);
                  for (Model model : cat.getModel()) {
                      branch.getChildren().add(new TreeItem<>(model.getName()));
                  }
              }
              treeData.setRoot(root);
              root.setExpanded(true);
          }
      });

    }

}


