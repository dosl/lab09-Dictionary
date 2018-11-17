package sample;


public class Vocabulary {
    private String partOfSpeech;
    private String meaning;
    private String example;

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    @Override
    public String toString() {
        return "Vocabulary{" +
                "partOfSpeech='" + partOfSpeech + '\'' +
                ", meaning='" + meaning + '\'' +
                ", example='" + example + '\'' +
                '}';
    }

    public String getMeaning() {
        return meaning;
    }

    public String getExample() {
        return example;
    }

    public Vocabulary(String partOfSpeech, String meaning, String example) {
        this.partOfSpeech = partOfSpeech;
        this.meaning = meaning;
        this.example = example;
    }
}
