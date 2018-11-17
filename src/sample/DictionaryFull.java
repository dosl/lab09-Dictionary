package sample;

import javafx.beans.property.SimpleStringProperty;

public class DictionaryFull {
    private SimpleStringProperty word;
    private SimpleStringProperty partOfSpeech;
    private SimpleStringProperty meaning;
    private SimpleStringProperty example;

    public DictionaryFull(String word, String partOfSpeech, String meaning, String example) {
        this.word = new SimpleStringProperty(word);
        this.partOfSpeech = new SimpleStringProperty(partOfSpeech);
        this.meaning = new SimpleStringProperty(meaning);
        this.example = new SimpleStringProperty(example);
    }

    public String getWord() {
        return word.get();
    }

    public SimpleStringProperty wordProperty() {
        return word;
    }

    public void setWord(String word) {
        this.word.set(word);
    }

    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech.set(partOfSpeech);
    }

    public void setMeaning(String meaning) {
        this.meaning.set(meaning);
    }

    public void setExample(String example) {
        this.example.set(example);
    }

    public String getPartOfSpeech() {
        return partOfSpeech.get();
    }

    public SimpleStringProperty partOfSpeechProperty() {
        return partOfSpeech;
    }

    public String getMeaning() {
        return meaning.get();
    }

    public SimpleStringProperty meaningProperty() {
        return meaning;
    }

    public String getExample() {
        return example.get();
    }

    public SimpleStringProperty exampleProperty() {
        return example;
    }
}
