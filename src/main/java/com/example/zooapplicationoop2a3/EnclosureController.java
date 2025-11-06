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

public class EnclosureController {
    Enclosure enclosure;
    String aBreadCrumbs;
    @FXML
    public ListView<String> enclosureListView;

    @FXML
    public Button editButton;

    @FXML
    public Label breadCrumbsLabel;

    public void initialize() {
        enclosureListView.setOnMouseClicked(pEvent -> {
            if (pEvent.getClickCount() == 2) {
                String selectedItem = enclosureListView.getSelectionModel().getSelectedItem();
                if (selectedItem != null) {
                    this.editButton.fire();
                }
            }
        });
    }

    public void setEnclosure(Enclosure pEnclosure) {
        this.enclosure = pEnclosure;
        this.breadCrumbsLabel.setText(aBreadCrumbs);
        this.enclosureListView.getItems().addAll(enclosure.getItems());
    }

    @FXML
    public void onBackButtonClick() {
        Stage currentStage = (Stage) this.enclosureListView.getScene().getWindow();
        currentStage.close();
    }

    @FXML
    public void onCloseButtonClick() {
        Platform.exit();
    }

    @FXML
    public void onEditButtonClick(ActionEvent pEvent) throws IOException {
        try {
            int index = enclosureListView.getSelectionModel().getSelectedIndex();
            Animal selectedAnimal = (Animal) enclosure.get(index);
            newAnimalView(pEvent, selectedAnimal, false);
        }
        catch (IndexOutOfBoundsException e) {
            new Alert(Alert.AlertType.ERROR, "Nothing Selected", ButtonType.OK).show();
        }
    }

    @FXML
    public void onAddButtonClick(ActionEvent pEvent) throws IOException {
        newAnimalView(pEvent,null, true);
    }

    @FXML
    public void onDeleteButtonClick() {
        try {
            int index = enclosureListView.getSelectionModel().getSelectedIndex();
            this.enclosure.removeAnimal(index);
            this.enclosureListView.getItems().remove(index);
        }
        catch (IndexOutOfBoundsException e) {
            new Alert(Alert.AlertType.ERROR, "Nothing Selected", ButtonType.OK).show();
        }
    }

    public static void newAnimalView(ActionEvent pEvent, Animal pSelectedAnimal, boolean pIsAddView) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ZooApplication.class.getResource(pIsAddView? "addAnimalView.fxml" : "AnimalView.fxml"));
        Parent view = fxmlLoader.load();
        AnimalViewController newAnimalController = fxmlLoader.getController();
        Scene nextScene = new Scene(view, 500, 500);
        Stage nextStage = new Stage();
        nextStage.setScene(nextScene);
        if (pSelectedAnimal != null) {
            newAnimalController.setAnimal(pSelectedAnimal);
            nextStage.setTitle(pSelectedAnimal.getName());
        }
        else {
            nextStage.setTitle("New Animal");
        }
        nextStage.initModality(Modality.WINDOW_MODAL);
        nextStage.initOwner(((Node) pEvent.getSource()).getScene().getWindow());
        nextStage.setResizable(false);
        nextStage.showAndWait();
    }
}
