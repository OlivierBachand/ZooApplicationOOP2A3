package com.example.zooapplicationoop2a3.Controllers;

import com.example.zooapplicationoop2a3.Model.CompositeEnclosureCollection;
import com.example.zooapplicationoop2a3.Model.ImportHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

/**
 * Controller for zoo-view.fxml
 * @author Olivier Bachand
 */
public class ZooController {
    CompositeEnclosureCollection bigCats = ImportHelper.createAnimals();

    @FXML
    protected void onViewButtonClick(ActionEvent pEvent) throws IOException {
        CompositeEnclosureCollectionController.newCompositeEnclosureCollectionView(pEvent, bigCats, bigCats.getName());
    }

}