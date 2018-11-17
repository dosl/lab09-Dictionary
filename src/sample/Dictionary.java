package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Dictionary{
    private Map<String, Vocabulary> dictionary = new HashMap<String, Vocabulary>() ;
    private ObservableList<DictionaryFull> vocabList;
    private DictionaryFull dictionaryFull;
    private static Dictionary instance = null;
    public static Dictionary getInstance(){
        if(instance == null){
            instance = new Dictionary();
        }
        return  instance;
    }

    private Dictionary(){
        vocabList = FXCollections.observableArrayList();
        addDic("Administer",new Vocabulary("Verb","จัดการ, ดำเนินงาน, บริหาร, ดูแล","As a president, I helped the principal administer the school."));
        addDic("Name",new Vocabulary("Noun","ชื่อ","My name is Min."));
        addDic("We",new Vocabulary("Pronoun","พวกเรา","We are students."));
        addDic("Sour",new Vocabulary("Adjective","เปรี้ยว","That fruit is always sour."));
        addDic("Hard",new Vocabulary("Adverb","ยาก, หนัก,ลำบาก","They studied English quite hard."));
    }

    public Map<String, Vocabulary> getDictionary() {
        return dictionary;
    }
    public String format(Format format) {
        return format.format(dictionary);
    }
    public Set<String> vocabList() {
        return dictionary.keySet();
    }

    public Vocabulary show(String word) {return dictionary.get(word); }

    public void addDic(String word, Vocabulary vocabulary) {
        System.out.println(word);
        dictionary.put(word,vocabulary);
        dictionaryFull = new DictionaryFull(word,vocabulary.getPartOfSpeech(),vocabulary.getMeaning(),vocabulary.getExample());
        System.out.println(dictionaryFull);
        vocabList.add(dictionaryFull);
//        dictionaryFull = new DictionaryFull(word,vocabulary.getPartOfSpeech(),vocabulary.getMeaning(),vocabulary.getExample());
//        dicList.add(dictionaryFull);
//        dictionary.put(word, vocabulary);
//        wordList.add(word);
        //vocabList.add(vocabulary);
//        dictionary.put(word,vocabulary);
    }

//    public String getDic(String vocab) {
//        String s = "";
//        for (Map.Entry<String, Vocabulary> entry : dictionary.entrySet()) {
//            s = (entry.getKey() + "=" + entry.getValue());
//        }
//        return s;
//    }

    public void removeWord(String word, DictionaryFull wordRemove){
        dictionary.remove(word);
        vocabList.remove(wordRemove);

    }
    public ObservableList getDataDic() {
        return  vocabList;
    }

}
