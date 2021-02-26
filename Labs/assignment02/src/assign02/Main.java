package assign02;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    	/*
    		Part 1
    		Display boolean expressions
    	 */

	    System.out.println(true && false);
	    System.out.println(true || false);
	    System.out.println(false && false);
	    System.out.println(true && (false || true));
	    System.out.println(false || (true && false));
	    System.out.println(false || 1 < 5);
	    System.out.println(5 >= 4 && 1 > 3);
	    System.out.println(10 < 4 || 1 > 4);
	    System.out.println(12 >= 2 && 1 < 24);
	    System.out.println("Hello".charAt(0) == 'h');

	    /*
	    	Part 2
	    	Create Boolean variables and values
	     */

		// Is it hot outside
		int temp = 37;
		boolean isHotOutside = false;

		if (temp > 80)
			isHotOutside = true;

		System.out.println("isHotOutside: " + isHotOutside);

		// Is it a weekend
		String day = "Monday";
		boolean isWeekDay = false;

		if (day != "Saturday" || day != "Sunday")
			isWeekDay = true;

		System.out.println("Is it a week day: " + isWeekDay);

		// Is there money in my wallet
		double amountOfMoney = 999999999;
		boolean moneyInWallet = false;

		if (amountOfMoney > 0)
			moneyInWallet = true;

		System.out.println("There money in my pocket: " + moneyInWallet);

		/*
			Part 3
			Variables Cont.
		 */

		double costOfMilk = 2.69;
		// Im going to use money in wallet from part 2
		int thirstLevel = 6;

		/*
			Part 4
			Using variables
		 */

		// Should I Buy Ice Cream
		boolean shouldBuyIceCream = false;

		if (isHotOutside && moneyInWallet)
			shouldBuyIceCream = true;

		System.out.println("I should buy ice cream: " + shouldBuyIceCream);

		// Should I Swim
		boolean willGoSwimming = false;

		if (isHotOutside && !isWeekDay)
			willGoSwimming = true;

		System.out.println("I am going to swim: " + willGoSwimming);

		// It is a good day
		boolean isAGoodDay = false;

		if (isHotOutside && moneyInWallet && !isWeekDay)
			isAGoodDay = true;

		System.out.println("It is a good day: " + isAGoodDay);

		// I should buy milk
		boolean willBuyMilk = false;

		if (isHotOutside && thirstLevel >= 3 && amountOfMoney >= (costOfMilk * 2))
			willBuyMilk = true;

		System.out.println("I am going to buy milk: " + willBuyMilk);

		/*
			Create a new instance of loops object
			and call its constructor
		 */
		Loops myLoop = new Loops();
		System.out.println("Print every even number between 0 - 100:");
		myLoop.evenTo100();
		System.out.println("\nPrint every 3rd number counting back from 100 - 0:");
		myLoop.every3rd();
		System.out.println("\nPrint every number between 1-100");
		myLoop.oneTo100();
		System.out.println("\nPrint every number between 1 - 100 but every number " +
							"divisible by 3 and 5 have a surprise:");
		myLoop.oneTo100HelloWorld();
    }
}
