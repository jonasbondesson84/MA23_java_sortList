import java.util.ArrayList;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> listOfNumbers = new ArrayList<>();
        listOfNumbers = createNumbers();

        for (int i : listOfNumbers) {
            System.out.println(i);
        }
        System.out.println();
        //checkForHighestUnique(listOfNumbers);
        int highestUnique = checkForHighestUnique(listOfNumbers);
        if(highestUnique!=0) {
            System.out.println("Det högst unika är " + highestUnique);
        } else {
            System.out.println("Det finns inga unika värden.");
        }

    }

    public static ArrayList<Integer> createNumbers() {

        ArrayList<Integer> listOfRandomNumbers = new ArrayList<>();
        int MAX_NUMBERS = 5;
        for (int i = 0; i < MAX_NUMBERS; i++) {
            listOfRandomNumbers.add((int) (Math.random() * 3) + 1);
        }
        return listOfRandomNumbers;
    }

    public static int checkForHighestUnique(ArrayList<Integer> listOfNumbers) {

        Collections.sort(listOfNumbers, Collections.reverseOrder());

        for(int i=0;i<listOfNumbers.size()-1;i++) {
            if(listOfNumbers.get(i)!=listOfNumbers.get(i+1)) {
                return listOfNumbers.get(i);
            } else {
                i= listOfNumbers.lastIndexOf(listOfNumbers.get(i));
            }
        }

        return 0;
    }
    
}

