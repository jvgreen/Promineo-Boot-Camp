package codingAssignment01;

public class Main {

    public static void main(String[] args) {
        // Create and assign each of the variables from the instruction
        double itemPrice = 50.48;
        double wallet = 350.99;
        int friendsPerYear = 3;
        int age = 28;
        String firstName = "Jonah";
        String lastName = "Green";
        char midInitial = 'V';

        double newWallet = wallet - itemPrice;
        int currentFriends = friendsPerYear * age;
        String fullName = firstName + " " + midInitial + " " + lastName;

        System.out.println("New wallet amount: " + newWallet);
        System.out.println("My current estimated number of friends: " + currentFriends);
        System.out.println("My full Name: " + fullName);
    }
}
