package com.example.zooapplicationoop2a3.Controllers;

import com.example.zooapplicationoop2a3.Model.*;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controller for addAnimalView.fxml
 * @author Olivier Bachand
 */
public class AddAnimalViewController {
    /**
     * To input the animal's name.
     */
    @FXML
    private TextField aNameTextField;

    /**
     * To input the animal's age.
     */
    @FXML
    private TextField aAgeTextField;

    /**
     * To input the animal's type.
     */
    @FXML
    private TextField aTypeTextField;

    /**
     * The enclosure of the {@link Animal}.
     */
    private Enclosure aCurrentEnclosure;

    /**
     * Sets the current {@link Enclosure} in {@code aCurrentEnclosure}.
     * @param pEnclosure the {@link Enclosure} from which the view was opened.
     */
    public void setEnclosure(Enclosure pEnclosure) {
        this.aCurrentEnclosure = pEnclosure;
    }

    /**
     * onAction that adds a new {@link Animal} in {@code aCurrentEnclosure}.
     */
    @FXML
    private void onAddButtonClick() {
        try {
            Animal newAnimal = createAnimal();
            if (newAnimal != null) {
                this.aCurrentEnclosure.addAnimal(newAnimal);
                onCancelButtonClick();
            }
            else
                new Alert(Alert.AlertType.ERROR, "This animal type is not available").showAndWait();
        }
        catch (NumberFormatException e) {
            aAgeTextField.setText("");
            new Alert(Alert.AlertType.ERROR, "Invalid Age").showAndWait();
        }
    }

    /**
     * Creates an {@link Animal} with the information in the Text Fields
     * @return the new {@link Animal}
     */
    private Animal createAnimal() {
        int age = Integer.parseInt(aAgeTextField.getText());
        if (age < 0)
            throw new NumberFormatException();
        String name = aNameTextField.getText();
        String type = aTypeTextField.getText();
        return switch (type.toLowerCase()) {
            case "tiger" -> new Tiger(name, age);
            case "lion" -> new Lion(name, age);
            case "cougar" -> new Cougar(name, age);
            default -> null;
        };
    }

    /**
     * onAction that closes the current stage.
     */
    @FXML
    private void onCancelButtonClick() {
        Stage stage = (Stage) aNameTextField.getScene().getWindow();
        stage.close();
    }
}
