package com.example.zooapplicationoop2a3;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddAnimalViewController {
    @FXML
    private TextField aNameTextField;

    @FXML
    private TextField aAgeTextField;

    @FXML
    private TextField aTypeTextField;
    
    private Enclosure aCurrentEnclosure;
    
    public void setEnclosure(Enclosure pEnclosure) {
        this.aCurrentEnclosure = pEnclosure;
    }

    @FXML
    private void onAddButtonClick() {

        try {
            int age = Integer.parseInt(aAgeTextField.getText());
            if (age < 0)
                throw new NumberFormatException();
            String name = aNameTextField.getText();
            String type = aTypeTextField.getText();
            Animal newAnimal = switch (type.toLowerCase()) {
                case "tiger" -> new Tiger(name, age);
                case "lion" -> new Lion(name, age);
                case "cougar" -> new Cougar(name, age);
                default -> null;
            };
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

    @FXML
    private void onCancelButtonClick() {
        Stage stage = (Stage) aNameTextField.getScene().getWindow();
        stage.close();
    }
}
