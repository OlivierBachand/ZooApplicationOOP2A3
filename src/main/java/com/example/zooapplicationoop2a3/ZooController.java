package com.example.zooapplicationoop2a3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ZooController {
    CompositeEnclosureCollection bigCats = new CompositeEnclosureCollection("Big Cats");

    @FXML
    protected void onViewButtonClick(ActionEvent pEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ZooApplication.class.getResource("cec-view.fxml"));
        Parent view = fxmlLoader.load();
        CompositeEnclosureCollectionController newCECController = fxmlLoader.getController();
        newCECController.setCEC(bigCats);
        Scene nextScene = new Scene(view, 500, 500);
        Stage nextStage = new Stage();
        nextStage.setScene(nextScene);
        nextStage.setTitle(bigCats.getName());
        nextStage.initModality(Modality.WINDOW_MODAL);
        nextStage.initOwner(((Node) pEvent.getSource()).getScene().getWindow());
        nextStage.showAndWait();
    }

}