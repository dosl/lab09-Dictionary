package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Dictionary {
    private Map<String, Vocabulary> dictionary = new HashMap<String, Vocabulary>();
    private ObservableList<DictionaryFull> vocabList;
    private DictionaryFull dictionaryFull;
    private static Dictionary instance = null;

    public static Dictionary getInstance() {
        if (instance == null) {
            instance = new Dictionary();
        }
        return instance;
    }

    private Dictionary() {
        vocabList = FXCollections.observableArrayList();
        addDic("Security", new Vocabulary("Noun", " protection of a person, building, organization, or country against threats such as crime or attacks by foreign countries", "You'll need to notify security if you want to work late in the office."));
        addDic("Game", new Vocabulary("Noun", "an entertaining activity or sport, especially one played by children, or the equipment needed for such an activity", "The children played a game of cops and robbers."));
        addDic("Sleep", new Vocabulary("Verb", "to be in the state of rest when your eyes are closed, your body is not active, and your mind is unconscious", "I slept late on Sunday morning."));
        addDic("Fantastic", new Vocabulary("Adjective", "extremely good", "We had a fantastic time."));
        addDic("And", new Vocabulary("Conjunction", "used to join two words, phrases, parts of sentences, or related statements together", "We were wet and tired."));
    }

    public Map<String, Vocabulary> getDictionary() {
        return dictionary;
    }

    public String format(MyFormatter format) {
        return format.format(dictionary);
    }

    public Set<String> vocabList() {
        return dictionary.keySet();
    }

    public Vocabulary show(String word) {
        return dictionary.get(word);
    }

    public void addDic(String word, Vocabulary vocabulary) {
        dictionary.put(word, vocabulary);
        dictionaryFull = new DictionaryFull(word, vocabulary.getPartOfSpeech(), vocabulary.getMeaning(), vocabulary.getExample());
        vocabList.add(dictionaryFull);

    }


    public void removeWord(String word, DictionaryFull wordRemove) {
        dictionary.remove(word);
        vocabList.remove(wordRemove);

    }

    public ObservableList getDataDic() {
        return vocabList;
    }
    public Map<String, Vocabulary> getDictionaryMap() {
        return dictionary;
    }

}
