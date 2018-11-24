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
    private FormatController formatController;
    @FXML
    ComboBox partOfSpeechComboBox;
    private ObservableList<DictionaryFull> data = FXCollections.observableArrayList();

    public Dictionary getDictionary() {
        return dictionary;
    }

    public void initialize() {
//        showTable();
        tableView.setItems(dictionary.getDataDic());
    }

//    public void showTable(){
//        data.clear();
//        for (String word : dictionary.vocabList()){
//            Vocabulary vocab = dictionary.show(word);
//            data.add(new DictionaryFull("",word, vocab.getPartOfSpeech(), vocab.getMeaning(), vocab.getExample()));
//        }
//    }
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
    @FXML
    public void editOnAction(ActionEvent actionEvent) throws IOException {
        Button button = (Button) actionEvent.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditView.fxml"));
        stage.setScene(new Scene((Parent) loader.load()));
        EditController editController = loader.getController();
        stage.show();
    }
    @FXML
    public void JSONOnAction() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FormatView.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load(), 1200, 600));
        stage.setTitle("Format JSON");
        formatController = loader.getController();
        formatController.setDictionaryController(this);
        formatController.formatJSON();
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    public void XMLOnAction() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FormatView.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load(), 1200, 600));
        stage.setTitle("Format XML");
        formatController = loader.getController();
        formatController.setDictionaryController(this);
        formatController.formatXML();
        stage.setResizable(false);
        stage.show();
    }



    public TableView<DictionaryFull> getTableView() {
        return tableView;
    }

    public void setTableView(TableView<DictionaryFull> tableView) {
        this.tableView = tableView;
    }
    public TableView<DictionaryFull> getDictionaryTableView() {
        return tableView;
    }

    public TableColumn<DictionaryFull, String> getWord() {
        return wordColumn;
    }

    public TableColumn<DictionaryFull, String> getPartOfSpeech() { return partOfSpeechColumn; }

    public TableColumn<DictionaryFull, String> getMeaning() {
        return meaningColumn;
    }

    public TableColumn<DictionaryFull, String> getExam() {
        return examColumn;
    }

}
