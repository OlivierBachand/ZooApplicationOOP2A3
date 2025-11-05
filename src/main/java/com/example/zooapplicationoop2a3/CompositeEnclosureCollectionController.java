package com.example.zooapplicationoop2a3;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class CompositeEnclosureCollectionController {
    CompositeEnclosureCollection aCEC;
    @FXML
    public ListView<String> aCECListView;

    @FXML
    public Button aOpenButton;

    public void setCEC(CompositeEnclosureCollection pCEC) {
        this.aCEC = pCEC;
        this.aCEC.addCollection(new CompositeEnclosureCollection("1"));
        this.aCEC.addCollection(new CompositeEnclosureCollection("2"));
        this.aCEC.addCollection(new CompositeEnclosureCollection("3"));
        this.aCECListView.getItems().addAll(aCEC.getItems());
    }

    @FXML
    public void onBackButtonClick() {
        Stage currentStage = (Stage) this.aOpenButton.getScene().getWindow();
        currentStage.close();
    }

    @FXML
    public void onCloseButtonClick() {
        Platform.exit();
    }

    @FXML
    public void onOpenButtonClick(ActionEvent pEvent) throws IOException {
        try {
            int index = aCECListView.getSelectionModel().getSelectedIndex();
            EnclosureCollection selectedCollection = aCEC.getEnclosureCollection(index);
            if (selectedCollection instanceof CompositeEnclosureCollection selectedCEC) {
                newCompositeEnclosureCollectionView(pEvent, selectedCEC);
            }
        }
        catch (IndexOutOfBoundsException e) {
            new Alert(Alert.AlertType.ERROR, "Nothing Selected", ButtonType.OK).show();
        }
    }

    public static void newCompositeEnclosureCollectionView(ActionEvent pEvent, CompositeEnclosureCollection selectedCEC) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ZooApplication.class.getResource("cec-view.fxml"));
        Parent view = fxmlLoader.load();
        CompositeEnclosureCollectionController newCECController = fxmlLoader.getController();
        newCECController.setCEC(selectedCEC);
        Scene nextScene = new Scene(view, 500, 500);
        Stage nextStage = new Stage();
        nextStage.setScene(nextScene);
        nextStage.setTitle(selectedCEC.getName());
        nextStage.initModality(Modality.WINDOW_MODAL);
        nextStage.initOwner(((Node) pEvent.getSource()).getScene().getWindow());
        nextStage.setResizable(false);
        nextStage.showAndWait();
    }
}
