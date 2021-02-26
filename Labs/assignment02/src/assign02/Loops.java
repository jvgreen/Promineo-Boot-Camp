package assign02;

public class Loops {
    int count;

    // Constructor will set all count variables and display
    public Loops() {
        count = 0;
    }

    // Display even numbers from 0 - 100
    public void evenTo100() {
        while (count < 101) {
            System.out.print(count + " ");
            count += 2;
        }
    }

    // Display every 3rd number goint backwards from 100 - 0
    public void every3rd() {
        count = 100;
        while (count > -1) {
            System.out.print(count + " ");
            count -= 3;
        }
    }

    // Prints out 1-100
    public void oneTo100() {
        for(int i = 1; i < 101; i++) {
            System.out.print(i + " ");
        }
    }

    // Prints out 1 - 100 but every third number it says Hello
    // If the number is divisible by 5 it prints world
    // and if its divisible by 3 and 5 print hello world
    public void oneTo100HelloWorld() {
        for (int i = 1; i < 101; i++) {
            if (i % 3 == 0 && i % 5 == 0)
                System.out.print("HelloWorld ");
            else if (i % 3 == 0)
                System.out.print("Hello ");
            else if (i % 5 == 0)
                System.out.print(("World "));
            else
                System.out.print(i + " ");
        }
    }
}
