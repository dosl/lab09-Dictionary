package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    private Dictionary dictionary = Dictionary.getInstance();
    private Vocabulary vocabulary;
    @FXML
    TableView<DictionaryFull> tableView;
    @FXML
    TableColumn<DictionaryFull,String> wordColumn,partOfSpeechColumn,meaningColumn,examColumn;

    @FXML
    ComboBox partOfSpeechComboBox;
    private ObservableList<DictionaryFull> data = FXCollections.observableArrayList();
    private ObservableList<String> partOfSpeechList = FXCollections.observableArrayList("Noun", "Pronoun", "Verb", "Adverb", "Adjective", "Conjunction",
            "Preposition", "Interjection");

//    public HomeController() {
////        this.dictionary = new Dictionary();
//        // 5 คำศัพท์ตอนเริ่มโปรแกรม
//
//    }

    public void initialize() {
//        tableView.getColumns().add(col1);
//        tableView.setItems(dictionary.getDataDic2());
        //word.setCellValueFactory(new PropertyValueFactory<>("word"));


        showTable();
        partOfSpeechComboBox.setItems(partOfSpeechList);
        partOfSpeechComboBox.setValue("Please Select");
//        wordColumn.setCellValueFactory(new PropertyValueFactory<DictionaryFull, String>("word"));
//        partOfSpeechColumn.setCellValueFactory(new PropertyValueFactory<DictionaryFull, String>("partOfSpeech"));
//        meaningColumn.setCellValueFactory(new PropertyValueFactory<DictionaryFull, String>("meaning"));
//        examColumn.setCellValueFactory(new PropertyValueFactory<DictionaryFull, String>("example"));


//        wordColumn.setCellValueFactory(cellData->cellData.getValue().wordProperty());
//        partOfSpeechColumn.setCellValueFactory(cellData->cellData.getValue().partOfSpeechProperty());
//        meaningColumn.setCellValueFactory(cellData->cellData.getValue().meaningProperty());
//        examColumn.setCellValueFactory(cellData->cellData.getValue().exampleProperty());
        tableView.setItems(dictionary.getDataDic());

    }

//    public class TableData {
//        private final SimpleStringProperty word;
//        private final SimpleStringProperty partOfSpeech;
//        private final SimpleStringProperty meaning;
//        private final SimpleStringProperty example;
//
//        public TableData(String word, String partOfSpeech, String meaning, String example) {
//            this.word = new SimpleStringProperty(word);
//            this.partOfSpeech = new SimpleStringProperty(partOfSpeech);
//            this.meaning = new SimpleStringProperty(meaning);
//            this.example = new SimpleStringProperty(example);
//        }
//        public TableData(String word, Vocabulary vocabulary) {
//            this.word = new SimpleStringProperty(word);
//            partOfSpeech = new SimpleStringProperty(vocabulary.getPartOfSpeech());
//            meaning = new SimpleStringProperty(vocabulary.getMeaning());
//            example = new SimpleStringProperty(vocabulary.getExample());
//
//        }

    public void showTable(){
        data.clear();
        for (String word : dictionary.vocabList()){
            Vocabulary vocab = dictionary.show(word);
            data.add(new DictionaryFull(word, vocab.getPartOfSpeech(), vocab.getMeaning(), vocab.getExample()));
        }
    }
    @FXML
    public void addOnAction(ActionEvent actionEvent) throws IOException {
        Button button = (Button) actionEvent.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddView.fxml"));
        stage.setScene(new Scene((Parent) loader.load()));
        AddController addController = loader.getController();
        stage.show();
    }
    @FXML
    public void deleteOnAction(ActionEvent actionEvent) throws IOException {
        Button button = (Button) actionEvent.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DeleteView.fxml"));
        stage.setScene(new Scene((Parent) loader.load()));
        DeleteController deleteController = loader.getController();
        stage.show();
    }

    public TableView<DictionaryFull> getTableView() {
        return tableView;
    }

    public void setTableView(TableView<DictionaryFull> tableView) {
        this.tableView = tableView;
    }
}
