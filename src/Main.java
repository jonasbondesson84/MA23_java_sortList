import java.util.ArrayList;

import java.util.Collections;
import java.util.HashMap;


public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> listOfNumbers = createNumbers();



        for (int i : listOfNumbers) {
            System.out.println(i);
        }
        System.out.println();

        int highestUnique = checkWithHashTag(listOfNumbers);//checkForHighestUnique(listOfNumbers);
        if (highestUnique != 0) {
            System.out.println("Det högst unika är " + highestUnique);
        } else {
            System.out.println("Det finns inga unika värden.");
        }

    }

    public static ArrayList<Integer> createNumbers() {

        ArrayList<Integer> listOfRandomNumbers = new ArrayList<>();
        int MAX_NUMBERS = 100;
        for (int i = 0; i < MAX_NUMBERS; i++) {
            listOfRandomNumbers.add((int) (Math.random() * 100) + 1);
        }
        return listOfRandomNumbers;
    }


    public static int checkForHighestUnique(ArrayList<Integer> listOfNumbers) {

        Collections.sort(listOfNumbers, Collections.reverseOrder()); //Sorterar listan i omvänd ordning

        for (int i = 0; i < listOfNumbers.size(); ) {
            if (i + 1 < listOfNumbers.size()) { //För att kunna jämföra med nästa tal i listan behöver det finnas plats kvar i listan
                if (!listOfNumbers.get(i).equals(listOfNumbers.get(i + 1))) { //om talet på plats i inte är samma som på plats i+1 är det högsta unika talet.
                    return listOfNumbers.get(i);
                }
                int currentNumber = listOfNumbers.get(i);
                while (i < listOfNumbers.size() - 1 && listOfNumbers.get(i).equals(currentNumber)) {
                    i++; //Om talet på plats i är samma som nästa tal ökar i med ett, fram tills talen inte är samma.
                }
            } else { //Om det är sista positionen i listan jämförs den med föregående tal för att kontrollera om det är unikt.
                if (!listOfNumbers.get(i).equals(listOfNumbers.get(i - 1))) {
                    return listOfNumbers.get(i);
                }
            }
        }
        //Finns det inga unika returneras 0
        return 0;
    }

    static int checkWithHashTag(ArrayList<Integer> listOfNumbers) {
        HashMap<Integer, Integer> hashList = new HashMap<>();
        ArrayList<Integer> filteredList = new ArrayList<>();

        for (int i : listOfNumbers) {
            if (!hashList.containsKey(i)) { //Om talet inte finns i hashmapen läggs det till
                hashList.put(i, 1);
            } else {
                hashList.put(i, hashList.get(i) + 1); //om det redan finns ökar value med 1
            }
        }
        for (int i : hashList.keySet()) {
            if (hashList.get(i) == 1) { //skapar en ny lista där enbart tal med value 1 läggs till
                filteredList.add(i);
            }
        }

        if (!filteredList.isEmpty()) { //om listan inte är tom returneras det högsta talet.
            return Collections.max(filteredList);
        }
        return 0;
    }
}

