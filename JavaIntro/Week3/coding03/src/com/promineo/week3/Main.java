package com.promineo.week3;

import javax.lang.model.type.NullType;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*
            Part 1
         */
        int[] ages = {3, 9, 23, 64, 2, 8, 28, 93};

        // Part A subtract first value from the last value
        System.out.println("Last value minus first: " + lastMinusFirst(ages));

        // Part B add a new age to the array and repeat part A
        // Have to expand the array to add another element to it
        ages = Arrays.copyOf(ages, ages.length + 1);
        ages[ages.length - 1] = 36;

        System.out.println("New last value minus first: " + lastMinusFirst(ages));

        // Part C Calculate average age
        int ageTotal = 0;
        for (int age : ages) {
            ageTotal += age;
        }

        double averageAge = (double) ageTotal / ages.length;

        System.out.println("Average Age: " + round(averageAge));

        /*
            Part 2
         */
        String[] names = {"Sam", "Tommy", "Tim", "Sally", "Buck", "Bob"};

        // Part A Loop through the array and find the average number of letters per name
        int lettersTotal = 0;

        for (String name : names) {
            lettersTotal += name.length();
        }

        double averageLetters = (double)lettersTotal / names.length;

        System.out.println("Average letters in Names: " + round(averageLetters));

        // Part B Concat the array into a single string separated by spaces
        StringBuilder namesToString = new StringBuilder();
        for (String name : names) {
            namesToString.append(name).append(" ");
        }
        System.out.println("Names array concatenated in a string: " + namesToString);

        /*
            Part 5 refer to assignment doc for part 3 and 4
         */
        int[] nameLengths = new int[6];

        if (names.length <= nameLengths.length){
            // Loop through names array
            for (int i = 0; i < names.length; i++) {
                nameLengths[i] = names[i].length();
            }
        } else {
            System.out.println("Allocate more space for nameLengths array");
        }

        /*
            Part 6
         */
        int charTotal = 0;
        for (int lengths : nameLengths) {
            charTotal += lengths;
        }
        System.out.println("Sum of elements: " + charTotal);

        /*
            Part 7
         */
        // Get Word to display
        Scanner wordIn = new Scanner(System.in);
        System.out.print("What word would you like to display: ");
        String word = wordIn.nextLine();

        // Get Number of iterations
        Scanner numberIn = new Scanner(System.in);
        System.out.print("How many times would you like to display: ");
        int number = numberIn.nextInt();

        // Function call
        displayWord(word, number);

        /*
            Part 8
         */
        Scanner first = new Scanner(System.in);
        System.out.print("What is your first name: ");
        String firstName = first.nextLine();

        Scanner last = new Scanner(System.in);
        System.out.print("What is your last name: ");
        String lastName = last.nextLine();

        displayName(firstName, lastName);

        /*
            Part 9
         */
        int [] numArray = {32, 25, 3, 6, 15};
        System.out.println("Numbers array is greater than 100 " + isGreaterThan100(numArray));

        /*
            Part 10
         */
        double average;
        double[] doubleArray = {2.5, 35.4, 21.67, 88.96};
        average = doubleAverage(doubleArray);
        System.out.println("The average of the array is: " + average);

        /*
            Part 11
         */
        double[] array1 = {3.4, 5.6, 66, 78};
        double[] array2 = {6.6, 94, 2, 1.3};
        System.out.println("The average of array 1 is greater" +
                           " than array 2: " + averageCompare(array1, array2));

        /*
            Part 12
         */
        boolean isHotOutside = true;
        double moneyInPocket = 54.60;
        System.out.println("I will buy a drink: " +
                            willBuyDrink(isHotOutside, moneyInPocket));

        /*
            Part 13
         */
        boolean bikeReady = true;
        // Truck gas will be on a 0 - 100 scale 0 being empty and 100 being full
        int gasInTruck = 75;
        // Using isHotOutside from previous part
        if (gasInTruck > 0 && gasInTruck < 100) {
            System.out.println("I will go biking: " + willGoBiking(isHotOutside, gasInTruck, bikeReady));
        } else {
            System.out.println("Please input a gas value between 0 and 100");
        }

    }
    // Will go biking
    // If it is hot outside and my truck has gas and my bike is ready
    // to go then return true
    private static boolean willGoBiking(boolean isHotOutside, int gasInTruck, boolean bikeReady) {
        return(isHotOutside && gasInTruck > 50 && bikeReady);
    }
    private static boolean willBuyDrink(boolean isHotOutside, double moneyInPocket) {
        return isHotOutside && moneyInPocket > 10.50;
    }
    // Compare two arrays averages
    private static boolean averageCompare(double[] array1, double[] array2) {
        double average1 = 0.00;
        double average2 = 0.00;

        for (double num : array1) {
            average1 += num;
        }
        average1 /= array1.length;

        for (double num : array2) {
            average2 += num;
        }
        average2 /= array2.length;

        return average1 > average2;
    }

    // Takes the average of an array of doubles
    private static double doubleAverage(double[] doubleArray) {
            double total = 0.00;

            for (double num : doubleArray) {
                total += num;
            }
            return total / doubleArray.length;
    }

    // Is greater than 100
    private static boolean isGreaterThan100(int[] numArray) {
        int total = 0;
        for(int num : numArray) {
            total += num;
        }
        return total > 100;
    }

    // Display full name
    private static void displayName(String firstName, String lastName) {
        System.out.println("Your Name is: " + firstName + " " +  lastName);
    }

    // Display word Part 7
    private static void displayWord(String word, int number) {
        for (int i = 0; i < number; i++) {
            System.out.println(word);
        }
    }

    // Round to two decimal places
    public static  double round(double input) {
        return Math.round(input * 100.0) / 100.0;
    }

    // Subtract first from last method
    public static int lastMinusFirst(int[] array) {
        return array[array.length - 1] - array[0];
    }
}
