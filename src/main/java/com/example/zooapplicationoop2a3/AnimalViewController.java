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

    public void setAnimal(Animal pAnimal) {
        this.currentAnimal = pAnimal;
        this.nameTextField.setText(pAnimal.getName());
        this.ageTextField.setText(String.valueOf(pAnimal.getAge()));
    }

    @FXML
    protected void onSaveButtonCLick(ActionEvent event) {
        currentAnimal.setName(nameTextField.getText());
        try{
            currentAnimal.setAge(Integer.parseInt(ageTextField.getText()));
        } catch (NumberFormatException e) {
            ageTextField.setText("Age is Invalid");
        }
        onCancelButtonClick(event);
    }
    @FXML
    protected void onCancelButtonClick(ActionEvent event) {
        Stage stage = (Stage) nameTextField.getScene().getWindow();
        stage.close();
    }
}
