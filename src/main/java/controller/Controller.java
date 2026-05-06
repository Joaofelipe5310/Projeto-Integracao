package controller;

import dto.CategoryDTO;
import dto.LineDTO;
import dto.ModelDTO;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import service.apiService;
import java.util.List;

public class Controller {

    @FXML
    private ComboBox<LineDTO> cbDevice;

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
        List<LineDTO> lines = service.connection();
        cbDevice.getItems().addAll(FXCollections.observableList(lines));

        cbDevice.valueProperty().addListener(new ChangeListener<LineDTO>() {
            @Override
            public void changed(ObservableValue<? extends LineDTO> observable, LineDTO oldValue, LineDTO newValue) {
                tpMeters.setDisable(false);
                tpMeters.setExpanded(true);

              LineDTO meter = cbDevice.getValue();
              TreeItem<String> root = new TreeItem<>(meter .getName());
              TreeItem<String> branch;
              for (CategoryDTO cat : meter.getCategories()) {
                  branch = new TreeItem<>(cat.getName());
                  root.getChildren().add(branch);
                  for (ModelDTO model : cat.getModels()) {
                      branch.getChildren().add(new TreeItem<>(model.getName()));
                  }
              }
              treeData.setRoot(root);
              root.setExpanded(true);
            }
         }
      );

    }

}