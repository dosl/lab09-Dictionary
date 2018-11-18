package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AddController {
    @FXML
    TextField wordField, meaningField, exampleField;
    @FXML
    ComboBox partOfSpeechComboBox;
    @FXML
    Button cancelButton;
    private DictionaryFull dictionaryFull;
    private HomeController homeController;
    private Dictionary dictionary = Dictionary.getInstance();

    private ObservableList<String> partOfSpeechList = FXCollections.observableArrayList("Noun", "Pronoun", "Verb", "Adverb", "Adjective", "Conjunction",
            "Preposition", "Interjection");

    public void initialize() {
        partOfSpeechComboBox.setItems(partOfSpeechList);
        partOfSpeechComboBox.setValue("Please Select");
    }

    @FXML
    public void cancelOnAction(ActionEvent actionEvent) throws IOException {
        Button button = (Button) actionEvent.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeView.fxml"));
        stage.setScene(new Scene((Parent) loader.load()));
        HomeController homeController = loader.getController();
        stage.show();
    }

    @FXML
    public void addWord(ActionEvent actionEvent) throws IOException {
        if (wordField.getText().equals("") || meaningField.getText().equals("") || exampleField.getText().equals("") || partOfSpeechComboBox.getSelectionModel().getSelectedItem().toString().equals("Please Select")) {
            System.out.println("there are nothing");
        } else {
            dictionary.addDic(wordField.getText(), new Vocabulary(partOfSpeechComboBox.getValue().toString(), meaningField.getText(), exampleField.getText()));
        }
        resetField();
        cancelOnAction(actionEvent);
    }

    public void resetField() {
        wordField.setText("");
        partOfSpeechComboBox.setValue("Please Select");
        meaningField.setText("");
        exampleField.setText("");
    }
    @FXML
    public void EditOnAction(ActionEvent actionEvent){

    }

}
