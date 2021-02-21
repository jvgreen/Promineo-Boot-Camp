package lab01;

public class Main {

    public static void main(String[] args) {
	    // Create a variable to hold the quantity of available plane seats left on a flight
        int seatsLeft = 34;

        // Create a variable to hold the cost of groceries at checkout
        double groceriesCost = 150.00;

        // Create a variable to hold a persons middle initial
        char midInitial = 'C';

        // Create a variable to hold true if its hot outside and false if its cold
        boolean isHot = false;

        // Create a variable to hold a customer's first name
        String firstName = "John";

        // Create a variable to hold a street address
        String streetAddress = "1234 E 800 W";

        // Print All variables
        System.out.println("Seats avialible on the plane: " + seatsLeft);
        System.out.println("Cost of groceries: " + groceriesCost);
        System.out.println("Middle Initial: " + midInitial);
        System.out.println("Is it hot outside: " + isHot);
        System.out.println("My first name: " + firstName);
        System.out.println("My street address: " + streetAddress + "\n");4

        // A customer booked 2 plane seats, remove two plane seats from the available seats
        seatsLeft -= 2;
        System.out.println("Updated seats avialible on the plane: " + seatsLeft);

        // Impulse candy bar purchase, add 2.25 to grocery total
        groceriesCost += 2.25;
        System.out.println("New cost of groceries: " + groceriesCost);

        // birth certificate was printer incorrectly, change the middle initial
        midInitial = 'D';
        // the season has changed update hot outside
        isHot = true;
        System.out.println("Is it hot outside now: " + isHot);

        // create new full name variable
        String lastName = "Doe";
        String fullName = firstName + " " + midInitial + " " + lastName;

        // print line that introduces customer and their address
        System.out.println("This is " + fullName + " their address is " + streetAddress);
    }
}
