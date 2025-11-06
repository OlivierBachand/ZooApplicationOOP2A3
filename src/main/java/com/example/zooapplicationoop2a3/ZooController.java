package com.example.zooapplicationoop2a3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class ZooController {
    CompositeEnclosureCollection bigCats = ImportHelper.createAnimals();

    @FXML
    protected void onViewButtonClick(ActionEvent pEvent) throws IOException {
        CompositeEnclosureCollectionController.newCompositeEnclosureCollectionView(pEvent, bigCats, bigCats.getName());
    }

}