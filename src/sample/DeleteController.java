package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class DeleteController {
    @FXML
    TextField wordField, meaningField, exampleField;
    @FXML
    ComboBox partOfSpeechComboBox;
    @FXML
    Button cancelButton;
    @FXML
    TableView<DictionaryFull> tableView;
    @FXML
    TableColumn<DictionaryFull,String> wordColumn,partOfSpeechColumn,meaningColumn,examColumn;
    private DictionaryFull dictionaryFull;
    private HomeController homeController;
    private Dictionary dictionary = Dictionary.getInstance();

    private ObservableList<String> partOfSpeechList = FXCollections.observableArrayList("Noun", "Pronoun", "Verb", "Adverb", "Adjective", "Conjunction",
            "Preposition", "Interjection");
    @FXML
    public void clickTableView(MouseEvent mouseEvent){ }
    public void initialize() {
        partOfSpeechComboBox.setItems(partOfSpeechList);
        partOfSpeechComboBox.setValue("Please Select");

        //tableView.getColumns().setAll(wordColumn,partOfSpeechColumn,meaningColumn,examColumn);
        tableView.setItems(dictionary.getDataDic());
        tableView.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() > 1) {
                onEdit();
            }
        });


    }
    public void onEdit(){
        // check the table's selected item and get selected item
        if (tableView.getSelectionModel().getSelectedItem() != null) {
            DictionaryFull dictionaryFull = tableView.getSelectionModel().getSelectedItem();
            wordField.setText(dictionaryFull.getWord());
            meaningField.setText(dictionaryFull.getMeaning());
            exampleField.setText(dictionaryFull.getExample());
            partOfSpeechComboBox.setValue(dictionaryFull.getPartOfSpeech());
        }
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
    public void deleteOnAction(ActionEvent actionEvent) {
        DictionaryFull select = tableView.getSelectionModel().getSelectedItem();
        if(select != null){
            dictionary.removeWord(select.wordProperty().get(),select);
            tableView.refresh();
        }
    }
}
