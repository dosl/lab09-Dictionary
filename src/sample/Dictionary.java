package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Dictionary {
    private Map<String, Vocabulary> dictionary = new HashMap<String, Vocabulary>();
    private ObservableList<DictionaryFull> vocabList;
    private DictionaryFull dictionaryFull;
    private static Dictionary instance = null;
    private PrintWriter printWriter;
//    private String[] listId;
    ArrayList<String> listId = new ArrayList<String>();
    File file = new File("src/sample/dictionary.txt");


    public static Dictionary getInstance() {
        if (instance == null) {
            instance = new Dictionary();
        }
        return instance;
    }

    private Dictionary() {
        vocabList = FXCollections.observableArrayList();
//        showTable("Security", new Vocabulary("Noun", " protection of a person, building, organization, or country against threats such as crime or attacks by foreign countries", "You'll need to notify security if you want to work late in the office."));
//        showTable("Game", new Vocabulary("Noun", "an entertaining activity or sport, especially one played by children, or the equipment needed for such an activity", "The children played a game of cops and robbers."));
//        showTable("Sleep", new Vocabulary("Verb", "to be in the state of rest when your eyes are closed, your body is not active, and your mind is unconscious", "I slept late on Sunday morning."));
//        showTable("Fantastic", new Vocabulary("Adjective", "extremely good", "We had a fantastic time."));
//        showTable("And", new Vocabulary("Conjunction", "used to join two words, phrases, parts of sentences, or related statements together", "We were wet and tired."));
        try {

            String line = "";
            printWriter = new PrintWriter(new FileWriter(file, true));
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while ((line = bufferedReader.readLine()) != null) {
                    String[] arr =line.split("#");
                    System.out.println(arr[0]);
                    showTable(arr[0],arr[1],new Vocabulary(arr[2], arr[3], arr[4]));
                    listId.add(arr[0]);
                    //
//  printWriter.printf((dictionaryFull) + "\n");
//                }
            }
            System.out.println(listId);

//

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        printWriter.close();

    }

    public void readMsg() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public void showTable(String id,String word, Vocabulary vocabulary) {
        dictionary.put(word, vocabulary);
        dictionaryFull = new DictionaryFull(id,word, vocabulary.getPartOfSpeech(), vocabulary.getMeaning(), vocabulary.getExample());
        vocabList.add(dictionaryFull);


//        printWriter.printf(dictionaryFull.toString2() + "\n");
//        try {
////            printWriter = new PrintWriter(new FileWriter(file, true));
////            printWriter.printf(dictionaryFull.toString()+"\n");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        readMsg();

    }
    public void addFile(String word,Vocabulary vocabulary){
        dictionary.put(word, vocabulary);
        String id = genId();
        System.out.println("gen: "+id);
        listId.add(id);
        dictionaryFull = new DictionaryFull(id,word, vocabulary.getPartOfSpeech(), vocabulary.getMeaning(), vocabulary.getExample());
        vocabList.add(dictionaryFull);
//        printWriter.printf(dictionaryFull.toString2()+"\n");
        try {
            File file = new File("src/sample/dictionary.txt");
            printWriter = new PrintWriter(new FileWriter(file, true));

//            printWriter.printf("SSSS" + "\n");
            printWriter.printf(dictionaryFull.toString2()+"\n");
            printWriter.close();
//            System.out.println("pL");
//            System.out.println(dictionaryFull.toString2());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String genId(){
        System.out.println(listId);
        int newId=0;
        for (newId = 0; newId < 100000000 ; newId++) {
            if(!listId.contains(newId+"")){
                return newId+"" ;
            }else{

            }
        }
        System.out.println("no Id");
        return newId+"";
    }
    public void removeWord(String word, DictionaryFull wordRemove) {
        dictionary.remove(word);
        vocabList.remove(wordRemove);

    }
    public void removeWord(String id,String word, DictionaryFull wordRemove) {


        File myFoo = new File("src/sample/dictionary.txt");
        FileWriter fooWriter = null; // true to append
        BufferedReader bufferedReader = null;
        String text_new="";
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            printWriter = new PrintWriter(new FileWriter(myFoo, true));
            while ((line = bufferedReader.readLine()) != null) {
                String[] arr =line.split("#");
//                System.out.println(arr[0]);
                if (!arr[0].equals(id)){
//                    System.out.println("Go !!"+id);
                    text_new = text_new+line+"\n";
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (text_new!=null && text_new!="") {
//            System.out.println("text: "+text_new);
            try {
                fooWriter = new FileWriter(myFoo, false);
                fooWriter.write(text_new);
                fooWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        dictionary.remove(word);
        vocabList.remove(wordRemove);
    }
//    public ObservableList getDataDic() throws IOException {
//        try {
//            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
//            String line = "";
//            while ((line = bufferedReader.readLine())!=null){
//                vocabList.add(vocabList);
//            }
//
//            bufferedReader.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return vocabList;
//    }

    public ObservableList getDataDic() {
        return vocabList;
    }

    public Map<String, Vocabulary> getDictionaryMap() {
        return dictionary;
    }

}
