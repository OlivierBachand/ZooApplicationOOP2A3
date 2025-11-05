package com.example.zooapplicationoop2a3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AnimalViewController {

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField ageTextField;

    private Animal currentAnimal;

    public void setAnimal(Animal Animal) {
        this.currentAnimal = Animal;
        if(Animal != null)
        {
            nameTextField.setText(Animal.getName());
            ageTextField.setText(String.valueOf(Animal.getAge()));
        }
    }

    @FXML
    protected void onSaveButotnCLick(ActionEvent event) {
        if (currentAnimal != null) {
        currentAnimal.setName(nameTextField.getText());
        try{
            currentAnimal.setAge(Integer.parseInt(ageTextField.getText()));
        } catch (NumberFormatException e) {
            ageTextField.setText("Age is Invalid");
        }
        onCancelButtonClick(event);
        }

    }
    @FXML
    protected void onCancelButtonClick(ActionEvent event) {
        Stage stage = (Stage) nameTextField.getScene().getWindow();
        stage.close();
    }
}
