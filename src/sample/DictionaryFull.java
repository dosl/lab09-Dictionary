package sample;

import javafx.beans.property.SimpleStringProperty;

public class DictionaryFull {
    private SimpleStringProperty word;
    private SimpleStringProperty partOfSpeech;
    private SimpleStringProperty meaning;
    private SimpleStringProperty example;
    private String wordString;
    private String partOfSpeechString;
    private String meaningString;
    private String exampleString;
    private String id;
    public DictionaryFull(String id,String word, String partOfSpeech, String meaning, String example) {
        this.id=id;
        this.word = new SimpleStringProperty(word);
        this.partOfSpeech = new SimpleStringProperty(partOfSpeech);
        this.meaning = new SimpleStringProperty(meaning);
        this.example = new SimpleStringProperty(example);
        this.wordString = word;
        this.partOfSpeechString = partOfSpeech;
        this.meaningString = meaning;
        this.exampleString = example;
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

    @Override
    public String toString() {
        return word + " " + partOfSpeech + " " + meaning + " " + example;
    }

    public String toString2() {
        return id+"#"+wordString + "#" + partOfSpeechString + "#" + meaningString + "#" + exampleString;
    }
    public String get_id() {
        return id;
    }
}
