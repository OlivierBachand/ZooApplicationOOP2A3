package com.example.zooapplicationoop2a3;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class CompositeEnclosureCollectionController {
    CompositeEnclosureCollection aCEC;
    String aBreadCrumbs;
    @FXML
    public ListView<String> aCECListView;

    @FXML
    public Button aOpenButton;

    @FXML
    public Label aBreadCrumbsLabel;

    public void initialize() {
        aCECListView.setOnMouseClicked(pEvent -> {
            if (pEvent.getClickCount() == 2) {
                String selectedItem = aCECListView.getSelectionModel().getSelectedItem();
                if (selectedItem != null) {
                    this.aOpenButton.fire();
                }
            }
        });
    }

    public void setCEC(CompositeEnclosureCollection pCEC) {
        this.aCEC = pCEC;
        this.aBreadCrumbsLabel.setText(aBreadCrumbs);
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
                newCompositeEnclosureCollectionView(pEvent, selectedCEC, aBreadCrumbs + " > " + selectedCEC.getName());
            }
        }
        catch (IndexOutOfBoundsException e) {
            new Alert(Alert.AlertType.ERROR, "Nothing Selected", ButtonType.OK).show();
        }
    }

    public static void newCompositeEnclosureCollectionView(ActionEvent pEvent, CompositeEnclosureCollection selectedCEC, String pBreadCrumbs) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ZooApplication.class.getResource("cec-view.fxml"));
        Parent view = fxmlLoader.load();
        CompositeEnclosureCollectionController newCECController = fxmlLoader.getController();
        newCECController.aBreadCrumbs = pBreadCrumbs;
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
