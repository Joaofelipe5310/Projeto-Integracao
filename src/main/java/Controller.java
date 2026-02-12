import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class Controller {

    @FXML
    private ComboBox<String> comboOne;

    @FXML
    private TreeView<String> Tree1, Tree2;

    @FXML
    private TitledPane Model;

    @FXML
    public void initialize() {
        setComboBoxes();
        setTreeViews();
        setModels();

    }

    public void setModels() {
            Model.setDisable(true);
            Model.setExpanded(false);
        }


    public void setTreeViews(){
        TreeItem<String> root = new TreeItem<>("Ares");
        TreeItem<String> branch = new TreeItem<>("Ares TB");
        TreeItem<String> leaf = new TreeItem<>("Ares 7021");
        TreeItem<String> leaf2 = new TreeItem<>("Ares 7031");
        TreeItem<String> leaf3 = new TreeItem<>("Ares 7023");

        TreeItem<String> branch2 = new TreeItem<>("Ares THS");
        TreeItem<String> leaf4 = new TreeItem<>("Ares 8023 LS");
        TreeItem<String> leaf5 = new TreeItem<>("Ares 8023 200");
        TreeItem<String> leaf6 = new TreeItem<>("Ares 8023 2,5");

        root.getChildren().addAll(branch, branch2);
        branch.getChildren().addAll(leaf, leaf2, leaf3);
        branch2.getChildren().addAll(leaf4, leaf5, leaf6);
        Tree1.setRoot(root);
        Tree1.setDisable(true);
        Tree1.setVisible(false);


        TreeItem<String> rootTWO = new TreeItem<>("Cronos");
        TreeItem<String> branchTWO = new TreeItem<>("Cronos Old");
        TreeItem<String> leaf1TWO = new TreeItem<>("Cronos 6001-A");
        TreeItem<String> leaf2TWO = new TreeItem<>("Cronos 6003");
        TreeItem<String> leaf3TWO = new TreeItem<>("Cronos 7023");

        TreeItem<String> branch2TWO = new TreeItem<>("Cronos L");
        TreeItem<String> leaf4TWO = new TreeItem<>("Cronos 7023L");
        TreeItem<String> leaf5TWO = new TreeItem<>("Cronos 6021L");

        TreeItem<String> branch3TWO = new TreeItem<>("Cronos-NG");
        TreeItem<String> leaf6TWO = new TreeItem<>("Cronos 6001-NG");
        TreeItem<String> leaf7TWO = new TreeItem<>("Cronos 6003-NG");
        TreeItem<String> leaf8TWO = new TreeItem<>("Cronos 6021-NG");
        TreeItem<String> leaf9TWO = new TreeItem<>("Cronos 6031-NG");
        TreeItem<String> leaf10TWO = new TreeItem<>("Cronos 7021-NG");
        TreeItem<String> leaf11TWO = new TreeItem<>("Cronos 7023-NG");

        rootTWO.getChildren().addAll(branchTWO, branch2TWO, branch3TWO);
        branchTWO.getChildren().addAll(leaf1TWO, leaf2TWO, leaf3TWO);
        branch2TWO.getChildren().addAll(leaf4TWO, leaf5TWO);
        branch3TWO.getChildren().addAll(leaf6TWO, leaf7TWO, leaf8TWO, leaf9TWO, leaf10TWO, leaf11TWO);
        Tree2.setRoot(rootTWO);
        Tree2.setDisable(true);
        Tree2.setVisible(false);
    }
//oieeea
    public void setComboBoxes() {
        comboOne.getItems().addAll("Cronos", "Ares");
        comboOne.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.equals("Cronos")) {
                    Model.setDisable(false);
                    Model.setExpanded(true);
                    Tree1.setDisable(true);
                    Tree1.setVisible(false);
                    Tree2.setDisable(false);
                    Tree2.setVisible(true);

                } else if (newValue.equals("Ares")) {
                    Model.setDisable(false);
                    Model.setExpanded(true);
                    Tree1.setDisable(false);
                    Tree1.setVisible(true);
                    Tree2.setDisable(true);
                    Tree2.setVisible(false);
                } else {
                    Model.setDisable(true);
                    Model.setExpanded(false);
                }

            }
        });

    }

}


