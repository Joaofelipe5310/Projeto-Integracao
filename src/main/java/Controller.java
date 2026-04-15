import API.DatabaseConnection;
import API.service.LineService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import API.DTO.LineDTO;
import API.DTO.CategoryDTO;
import API.DTO.ModelDTO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
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


    public List<LineDTO> con() {
        try {
            URL url = new URL("http://localhost:8080/lines");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
            );

            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

            ObjectMapper mapper = new ObjectMapper();

            return mapper.readValue(response.toString(), new TypeReference<List<LineDTO>>() {}
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    public void setCbDevice() {

        List<LineDTO> lines = con();
        cbDevice.getItems().addAll(FXCollections.observableList(lines));

        cbDevice.valueProperty().addListener(new ChangeListener<LineDTO>() {
            @Override
            public void changed(ObservableValue<? extends LineDTO> observable, LineDTO oldValue, LineDTO newValue) {
                tpMeters.setDisable(false);
                tpMeters.setExpanded(true);

              LineDTO meter = cbDevice.getValue();
              TreeItem<String> root = new TreeItem<>(meter.getName());
              TreeItem<String> branch;
              for (CategoryDTO cat : meter.getCat()) {
                  branch = new TreeItem<>(cat.getName());
                  root.getChildren().add(branch);
                  for (ModelDTO model : cat.getModels()) {
                      branch.getChildren().add(new TreeItem<>(model.getName()));
                  }
              }
              treeData.setRoot(root);
              root.setExpanded(true);
            }
        });

    }

}