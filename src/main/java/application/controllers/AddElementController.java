package application.controllers;

import commands.Command;
import commands.specific.InsertHumanBeing;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import utils.readers.ReaderFromConsole;
import validators.Errors;

import java.net.URL;
import java.util.ResourceBundle;

public class AddElementController implements Initializable {
    private Stage modalStage;

    private final ObservableList<String> BOOLEAN_TYPES = FXCollections
            .observableArrayList("false", "true");
    private final ObservableList<String> WEAPON_TYPES = FXCollections
            .observableArrayList("null", "hammer", "pistol", "shotgun");
    private final ObservableList<String> MOOD_TYPES = FXCollections
            .observableArrayList("null", "longing", "gloom", "apathy", "rage");

    @FXML private ChoiceBox<String> realHeroChoice;
    @FXML private ChoiceBox<String> hasToothPickChoice;
    @FXML private ChoiceBox<String> weaponTypeChoice;
    @FXML private ChoiceBox<String> moodChoice;
    @FXML private ChoiceBox<String> carChoice;
    @FXML private TextField nameField;
    @FXML private TextField impactSpeedField;
    @FXML private Button submitButton;
    @FXML private TextField coordinatesField;
    @FXML private Text errorText;
    @FXML private Button closeButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        errorText.setVisible(false);

        realHeroChoice.setValue(BOOLEAN_TYPES.get(0));
        realHeroChoice.setItems(BOOLEAN_TYPES);
        hasToothPickChoice.setValue(BOOLEAN_TYPES.get(0));
        hasToothPickChoice.setItems(BOOLEAN_TYPES);
        carChoice.setValue(BOOLEAN_TYPES.get(0));
        carChoice.setItems(BOOLEAN_TYPES);
        weaponTypeChoice.setValue(WEAPON_TYPES.get(0));
        weaponTypeChoice.setItems(WEAPON_TYPES);
        moodChoice.setValue(MOOD_TYPES.get(0));
        moodChoice.setItems(MOOD_TYPES);


        String name = nameField.getText();
        String coordinates = coordinatesField.getText();
        String impactSpeed = impactSpeedField.getText();
        String realHero = realHeroChoice.getValue();
        String hasToothPick = hasToothPickChoice.getValue();
        String weaponType = weaponTypeChoice.getValue();
        String mood = moodChoice.getValue();
        String carCool = carChoice.getValue();

        submitButton.setOnAction(event -> {
            InsertHumanBeing insertHumanBeing = new InsertHumanBeing(new ReaderFromConsole());
            Errors error = insertHumanBeing.execute(name, coordinates, impactSpeed, realHero, hasToothPick,
                    weaponType, mood, carCool);
            if(error == Errors.NOTHAVEERRORS){
                errorText.setText("Object was successfully added");
                errorText.setStyle("-fx-text-fill: green");

            }else errorText.setText(error.getError());
            errorText.setVisible(true);
        });

        closeButton.setOnAction(event -> modalStage.close());
    }

    public void setModalStage(Stage modalStage) {
        this.modalStage = modalStage;
    }
}
