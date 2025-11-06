package com.example.zooapplicationoop2a3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * The {@code AnimalViewController} class serves as the controller for the Animal View in the
 * Zoo Management System. It manages user interactions for viewing and editing an {@link Animal}'s
 * details, such as name and age.
 * <p>
 * This controller follows the MVC (Model-View-Controller) pattern, where the view is defined
 * in the corresponding FXML file (animal-view.fxml), and the model is represented by the
 * {@code Animal} object.
 * </p>
 *
 * <p><strong>Responsibilities:</strong></p>
 * <ul>
 *     <li>Display the selected animal’s current name and age in text fields.</li>
 *     <li>Allow users to modify and save the animal’s information.</li>
 *     <li>Close the view window upon saving or cancelling.</li>
 * </ul>
 *
 * @author Max Gosselin
 * @version 1.0
 */
public class AnimalViewController {

    /** Text field for displaying and editing the animal's name. */
    @FXML
    private TextField nameTextField;

    /** Text field for displaying and editing the animal's age. */
    @FXML
    private TextField ageTextField;

    @FXML
    private TextField typeTextField;

    /** The currently selected {@link Animal} being viewed or edited. */
    private Animal currentAnimal;

    /**
     * Sets the {@link Animal} to be displayed in the view and populates
     * the text fields with its current information.
     *
     * @param pAnimal the {@code Animal} object whose data should be displayed
     */
    public void setAnimal(Animal pAnimal) {
        this.currentAnimal = pAnimal;
        this.nameTextField.setText(pAnimal.getName());
        this.ageTextField.setText(String.valueOf(pAnimal.getAge()));
    }

    /**
     * Handles the Save button click event.
     * <p>
     * Updates the {@link Animal}'s name and age based on user input.
     * If the age input is invalid, an error message is shown in the age text field.
     * Once saving is done, the view window is closed.
     * If there is a {@code typeTextField}, creates a new animal with the provided information instead
     * </p>
     *
     * @param event the {@link ActionEvent} triggered by clicking the Save button
     */
    @FXML
    protected void onSaveButtonCLick(ActionEvent event) {
        currentAnimal.setName(nameTextField.getText());
        try {
            currentAnimal.setAge(Integer.parseInt(ageTextField.getText()));
        } catch (NumberFormatException e) {
            ageTextField.setText("Age is Invalid");
        }
        if (typeTextField != null) {
            if (typeTextField.getText().equalsIgnoreCase("cougar")) {
            }
        }
        onCancelButtonClick(event);
    }

    /**
     * Handles the Cancel button click event.
     * <p>
     * Closes the current view window without saving any changes.
     * </p>
     *
     * @param event the {@link ActionEvent} triggered by clicking the Cancel button
     */
    @FXML
    protected void onCancelButtonClick(ActionEvent event) {
        Stage stage = (Stage) nameTextField.getScene().getWindow();
        stage.close();
    }
}
