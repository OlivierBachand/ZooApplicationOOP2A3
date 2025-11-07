package com.example.zooapplicationoop2a3.Controllers;

import com.example.zooapplicationoop2a3.Model.Animal;
import com.example.zooapplicationoop2a3.Model.Enclosure;
import com.example.zooapplicationoop2a3.ZooApplication;
import javafx.application.Platform;
import javafx.collections.FXCollections;
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

/**
 * Controller for the enclosure-view.fxml
 * @author Brody
 */
public class EnclosureController {

    /**
     * The current enclosure being viewed or modified.
     * */
    Enclosure enclosure;

    /**
     * Breadcrumb string used for navigation context.
     * */
    String aBreadCrumbs;

    /**
     * ListView displaying the animals in the enclosure.
     * */
    @FXML
    public ListView<String> enclosureListView;

    /**
     * Button used for editing a selected animal.
     * */
    @FXML
    public Button editButton;

    /**
     * Label showing the breadcrumb navigation path.
     * */
    @FXML
    public Label breadCrumbsLabel;

    /**
     * Initializes event handlers for the Enclosure view.
     * Sets up double-click functionality for editing animals directly.
     */
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

    /**
     * Sets the enclosure model and updates the view accordingly.
     *
     * @param pEnclosure the {@link Enclosure} instance to be displayed
     */
    public void setEnclosure(Enclosure pEnclosure) {
        this.enclosure = pEnclosure;
        this.breadCrumbsLabel.setText(aBreadCrumbs);
        this.enclosureListView.getItems().addAll(enclosure.getItems());
    }

    /**
     * Handles the Back button click event.
     * Closes the current enclosure window and returns to the previous screen.
     */
    @FXML
    public void onBackButtonClick() {
        Stage currentStage = (Stage) this.enclosureListView.getScene().getWindow();
        currentStage.close();
    }

    /**
     * Handles the Close button click event.
     * Exits the entire application.
     */
    @FXML
    public void onCloseButtonClick() {
        Platform.exit();
    }

    /**
     * Handles the Edit button click event.
     * Opens the selected animal in a detailed view for editing.
     *
     * @param pEvent the action event triggered by the button click
     * @throws IOException if the FXML file for the animal view cannot be loaded
     */
    @FXML
    public void onEditButtonClick(ActionEvent pEvent) throws IOException {
        try {
            int index = enclosureListView.getSelectionModel().getSelectedIndex();
            Animal selectedAnimal = enclosure.get(index);
            newAnimalView(pEvent, selectedAnimal);
        }
        catch (IndexOutOfBoundsException e) {
            new Alert(Alert.AlertType.ERROR, "Nothing Selected", ButtonType.OK).show();
        }
    }

    /**
     * Handles the Add button click event.
     * Opens the interface to add a new animal to the current enclosure.
     *
     * @param pEvent the action event triggered by the button click
     * @throws IOException if the FXML file for the add animal view cannot be loaded
     */
    @FXML
    public void onAddButtonClick(ActionEvent pEvent) throws IOException {
        newAddAnimalView(pEvent);
    }

    /**
     * Handles the Delete button click event.
     * Removes the selected animal from both the model and the list view.
     */
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

    /**
     * Opens the detailed view for a selected animal.
     *
     * @param pEvent the triggering action event
     * @param pSelectedAnimal the {@link Animal} to display
     * @throws IOException if the FXML file for the animal view cannot be loaded
     */
    public void newAnimalView(ActionEvent pEvent, Animal pSelectedAnimal) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ZooApplication.class.getResource("AnimalView.fxml"));
        Parent view = fxmlLoader.load();
        AnimalViewController newAnimalController = fxmlLoader.getController();
        Scene nextScene = new Scene(view);
        Stage nextStage = new Stage();
        nextStage.setScene(nextScene);
        newAnimalController.setAnimal(pSelectedAnimal);
        nextStage.setTitle(pSelectedAnimal.getName());
        nextStage.initModality(Modality.WINDOW_MODAL);
        nextStage.initOwner(((Node) pEvent.getSource()).getScene().getWindow());
        nextStage.setResizable(false);
        nextStage.showAndWait();
        this.enclosureListView.setItems(FXCollections.observableArrayList(enclosure.getItems()));
    }

    /**
     * Opens the interface to add a new animal to the enclosure.
     *
     * @param pEvent the triggering action event
     * @throws IOException if the FXML file for the add animal view cannot be loaded
     */
    public void newAddAnimalView(ActionEvent pEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ZooApplication.class.getResource("AddAnimalView.fxml"));
        Parent view = fxmlLoader.load();
        AddAnimalViewController newAddAnimalController = fxmlLoader.getController();
        Scene nextScene = new Scene(view);
        Stage nextStage = new Stage();
        nextStage.setScene(nextScene);
        newAddAnimalController.setEnclosure(this.enclosure);
        nextStage.setTitle("New Animal");
        nextStage.initModality(Modality.WINDOW_MODAL);
        nextStage.initOwner(((Node) pEvent.getSource()).getScene().getWindow());
        nextStage.setResizable(false);
        nextStage.showAndWait();
        this.enclosureListView.setItems(FXCollections.observableArrayList(enclosure.getItems()));
    }
}
