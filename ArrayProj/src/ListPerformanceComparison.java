import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListPerformanceComparison {

    public static void main(String[] args) {

        // Declare and initialize the variable to store the number of elements
        int N = 20000;
        int tInM = 10;

        // Declare variable to store start, end and performance time
        long start = 0, end = 0, aListTime, lListTime, aTime, sum = 0;

        // Declare an ArrayList
        List<Character> arrayList = new ArrayList<>();

        // If takes less than 1 second to fill the ArrayList
        while (end - start < tInM) {



            // store start time
            start = System.currentTimeMillis();

            // Fill the array list using random chars between 'a' to 'z'
            for (int i = 0; i < N; i++) {
                arrayList.add((char) ((int) (Math.random() * 26) + 97));
            }

            // store the end time
            end = System.currentTimeMillis();



            // if filling time is 1 seconds then increase the value of N
            if (end - start < tInM)
                N += 10000;

        }

        // Declare a LinkedList
        List<Character> linkedList = new LinkedList<Character>();

        // Declare an array of size N
        char[] array = new char[N];

        // Fill LinkedList
        for (int i = 0; i < N; i++) {

            linkedList.add((char) ((int) (Math.random() * 26) + 97));

        }

        // Fill Array
        for (int i = 0; i < N; i++) {

            array[i] = (char) ((int) (Math.random() * 26) + 97);

        }


        // Set start and end time to 0
        start = end = 0;


        // Calculate the time taken by ArrayList in performing sum of elements.
        start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {

            sum += arrayList.get(i);

        }
        end = System.currentTimeMillis();

        aListTime  = end - start;



        // Calculate the time taken by LinkedList in performing sum of elements.
        start = end = 0;
        start = System.currentTimeMillis();

        for (int i = 0; i < N; i++) {

            sum += linkedList.get(i);

        }

        end = System.currentTimeMillis();


        lListTime  = end - start;

        // Calculate the time taken by Array in performing sum of elements.
        start = end = 0;
        start = System.currentTimeMillis();

        for (int i = 0; i < N; i++) {

            sum += array[i];

        }

        end = System.currentTimeMillis();
        aTime = end - start;


        // print result
        System.out.printf("%-10s%-20s%-20s%-20s\n", "N","ArrayList Time", "LinkedList Time", "Array Time");

        System.out.printf("%-10d%-20s%-20s%-20s", N, aListTime+" ms", lListTime+" ms", aTime+" ms");



    }

}
 