package com.example.zooapplicationoop2a3;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class CompositeEnclosureCollectionController {
    CompositeEnclosureCollection aCEC;
    @FXML
    public ListView<String> cecListView;

    public void initialize() {
        this.aCEC.addCollection(new CompositeEnclosureCollection("Tiger"));
        this.aCEC.addCollection(new CompositeEnclosureCollection("Cougar"));
        this.aCEC.addCollection(new CompositeEnclosureCollection("Lion"));
        this.cecListView.setItems(FXCollections.observableArrayList(aCEC.getItems()));
    }

    public void setCEC(CompositeEnclosureCollection pCEC) {
        this.aCEC = pCEC;
    }
}
