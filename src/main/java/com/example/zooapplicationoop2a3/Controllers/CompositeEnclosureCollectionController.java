package com.example.zooapplicationoop2a3.Controllers;

import com.example.zooapplicationoop2a3.Model.CompositeEnclosureCollection;
import com.example.zooapplicationoop2a3.Model.Enclosure;
import com.example.zooapplicationoop2a3.Model.EnclosureCollection;
import com.example.zooapplicationoop2a3.ZooApplication;
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

/**
 * Controller for cec-view.fxml
 * @author Olivier Bachand
 */
public class CompositeEnclosureCollectionController {
    /**
     * Current {@link CompositeEnclosureCollection}
     */
    CompositeEnclosureCollection aCEC;

    /**
     * {@link String} holding the current bread crumbs
     */
    String aBreadCrumbs;

    /**
     * {@link ListView} for holding {@link EnclosureCollection}
     */
    @FXML
    public ListView<String> aCECListView;

    /**
     * {@link Button} that has the text "Open"
     */
    @FXML
    public Button aOpenButton;

    /**
     * {@link Label} that displays the current location in the zoo structure.
     */
    @FXML
    public Label aBreadCrumbsLabel;

    /**
     * Adds a double click event handler on {@code aCECListView}
     */
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

    /**
     * Sets the {@code aCEC} and displays it.
     * @param pCEC {@link CompositeEnclosureCollection} to be displayed.
     */
    public void setCEC(CompositeEnclosureCollection pCEC) {
        this.aCEC = pCEC;
        this.aBreadCrumbsLabel.setText(aBreadCrumbs);
        this.aCECListView.getItems().addAll(aCEC.getItems());
    }

    /**
     * onAction that closes the current stage/view.
     */
    @FXML
    public void onBackButtonClick() {
        Stage currentStage = (Stage) this.aOpenButton.getScene().getWindow();
        currentStage.close();
    }

    /**
     * onAction that closes the entire application.
     */
    @FXML
    public void onCloseButtonClick() {
        Platform.exit();
    }

    /**
     * Opens either another CompositeEnclosureCollection view or an Enclosure view
     * @param pEvent event of the onAction
     * @throws IOException can happen when it loads a {@link FXMLLoader}
     */
    @FXML
    public void onOpenButtonClick(ActionEvent pEvent) throws IOException {
        try {
            int index = aCECListView.getSelectionModel().getSelectedIndex();
            EnclosureCollection selectedCollection = aCEC.get(index);
            if (selectedCollection instanceof CompositeEnclosureCollection selectedCEC) {
                newCompositeEnclosureCollectionView(pEvent, selectedCEC, aBreadCrumbs + " > " + selectedCEC.getName());
            } else if (selectedCollection instanceof Enclosure selectedEnclosure) {
                newEnclosureView(pEvent, selectedEnclosure, aBreadCrumbs + " > " + selectedEnclosure.getName());
            }
        }
        catch (IndexOutOfBoundsException e) {
            new Alert(Alert.AlertType.ERROR, "Nothing Selected", ButtonType.OK).show();
        }
    }

    /**
     * Shows a new CompositeEnclosureCollection view
     * @param pEvent onAction event
     * @param pSelectedCEC The {@link CompositeEnclosureCollection} that is currently selected in the listView
     * @param pBreadCrumbs The bread crumbs for the next view.
     * @throws IOException because of the load() method.
     */
    public static void newCompositeEnclosureCollectionView(ActionEvent pEvent, CompositeEnclosureCollection pSelectedCEC, String pBreadCrumbs) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ZooApplication.class.getResource("cec-view.fxml"));
        Parent view = fxmlLoader.load();
        CompositeEnclosureCollectionController newCECController = fxmlLoader.getController();
        newCECController.aBreadCrumbs = pBreadCrumbs;
        newCECController.setCEC(pSelectedCEC);
        getStage(pEvent, view, pSelectedCEC.getName());
    }

    /**
     * Sets the stage for the next view
     * @param pEvent onAction event
     * @param pView The view for the Scene.
     * @param pName Title of the stage
     */
    private static void getStage(ActionEvent pEvent, Parent pView, String pName) {
        Scene nextScene = new Scene(pView, 500, 500);
        Stage nextStage = new Stage();
        nextStage.setScene(nextScene);
        nextStage.setTitle(pName);
        nextStage.initModality(Modality.WINDOW_MODAL);
        nextStage.initOwner(((Node) pEvent.getSource()).getScene().getWindow());
        nextStage.setResizable(false);
        nextStage.showAndWait();
    }

    /**
     * Shows a new Enclosure view
     * @param pEvent onAction event
     * @param pSelectedEnclosure The {@link Enclosure} that is currently selected in the listView
     * @param pBreadCrumbs The bread crumbs for the next view.
     * @throws IOException because of the load() method.
     */
    public static void newEnclosureView(ActionEvent pEvent, Enclosure pSelectedEnclosure, String pBreadCrumbs) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ZooApplication.class.getResource("enclosure-view.fxml"));
        Parent view = fxmlLoader.load();
        EnclosureController newEnclosureController = fxmlLoader.getController();
        newEnclosureController.aBreadCrumbs = pBreadCrumbs;
        newEnclosureController.setEnclosure(pSelectedEnclosure);
        getStage(pEvent, view, pSelectedEnclosure.getName());
    }
}
