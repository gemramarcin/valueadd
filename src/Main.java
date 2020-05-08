import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) {


        SortedMap<String, List<Integer>> tmap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);


        try {
            Scanner scanner = new Scanner(new File("./zadanie.txt"));
            while (scanner.hasNextLine()) {
                String[] wordsInLine = scanner.nextLine().split("[, ?.:\"„”%()\\[\\]–-]");
                List<String> wordsAsList = new ArrayList<>(Arrays.asList(wordsInLine));
                wordsAsList.removeIf(word -> word.length() == 0);

                for (int i = 0; i < wordsAsList.size(); i++) {
                    String word = wordsAsList.get(i);

                    if (tmap.containsKey(word)) {
                        tmap.get(word).add(i);
                    } else {
                        List<Integer> newListOfInd = new ArrayList<>();
                        newListOfInd.add(i);
                        tmap.put(word, newListOfInd);
                    }
                }

            }
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        tmap.forEach((key, value) -> System.out.println(key + " - " + value.size() + " pozycje " + value));
    }


}

