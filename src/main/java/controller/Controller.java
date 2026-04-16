package controller;

import dto.CategoryDTOF;
import dto.LineDTOF;
import dto.ModelDTOF;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import service.apiService;
import java.util.List;

public class Controller {

    @FXML
    private ComboBox<LineDTOF> cbDevice;

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

        apiService service = new apiService();
        List<LineDTOF> lines = service.con();
        cbDevice.getItems().addAll(FXCollections.observableList(lines));

        cbDevice.valueProperty().addListener(new ChangeListener<LineDTOF>() {
            @Override
            public void changed(ObservableValue<? extends LineDTOF> observable, LineDTOF oldValue, LineDTOF newValue) {
                tpMeters.setDisable(false);
                tpMeters.setExpanded(true);

              LineDTOF meter = cbDevice.getValue();
              TreeItem<String> root = new TreeItem<>(meter.getName());
              TreeItem<String> branch;
              for (CategoryDTOF cat : meter.getCategories()) {
                  branch = new TreeItem<>(cat.getName());
                  root.getChildren().add(branch);
                  for (ModelDTOF model : cat.getModels()) {
                      branch.getChildren().add(new TreeItem<>(model.getName()));
                  }
              }
              treeData.setRoot(root);
              root.setExpanded(true);
            }
        });

    }

}