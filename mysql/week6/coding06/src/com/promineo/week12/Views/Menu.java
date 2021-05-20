package com.promineo.week12.Views;

import com.promineo.week12.Models.BankViewModel;
import com.promineo.week12.Models.CrudChoice;
import com.promineo.week12.Models.MainMenuChoice;
import com.promineo.week12.Services.AccountsService;
import com.promineo.week12.Services.BankService;
import com.promineo.week12.Services.LoanService;
import com.promineo.week12.Services.UserService;

import java.util.Scanner;

public class Menu {

    private static BankViewModel viewModel;
    private static Scanner scanner = new Scanner(System.in);

    public void start() {
        String selection = "";
        try {
            do {
                viewModel = new BankViewModel();
                displayMainMenu();
                if (viewModel.MainMenuChoice != MainMenuChoice.EXIT) {
                    displayCrudMenu();
                    displayDetailScreen();
                    BankService bankService = new BankService(viewModel);
                    bankService.StartBankService();
                }

            } while (viewModel.MainMenuChoice != MainMenuChoice.EXIT);
            System.out.println("Goodbye");
            scanner.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            scanner.close();
        }
    }

    private static void displayMainMenu() {
        System.out.println("-----------------------");
        System.out.println("Please Select an option");
        System.out.println("1) Edit Users");
        System.out.println("2) Edit Loans");
        System.out.println("3) Edit Accounts");
        System.out.println("4) Exit");
        System.out.println("-----------------------");

        if (scanner.hasNextInt()) {
            viewModel.MainMenuChoice = MainMenuChoice.values()[scanner.nextInt() - 1];
        }
    }

    private static void displayCrudMenu()
    {
        System.out.println("Please choose from the Crud Menu...");
        System.out.println("1. Create");
        System.out.println("2. Read");
        System.out.println("3. Update");
        System.out.println("4. Delete");

        if(scanner.hasNextInt())
        {
            viewModel.CrudChoice = CrudChoice.values()[scanner.nextInt() - 1];
        }
    }
    private static void displayDetailScreen()
    {
        switch (viewModel.MainMenuChoice)
        {
            case EXIT:

                break;
            case USER:
                switch (viewModel.CrudChoice)
                {
                    case CREATE:
                        System.out.println("Enter a username: ");
                        viewModel.UserName = scanner.next();
                        System.out.println("Enter a password: ");
                        viewModel.Password = scanner.next();
                        break;
                    case READ:
                        break;
                    case UPDATE:
                        System.out.println("Enter user Id: ");
                        viewModel.UserId = scanner.nextInt();
                        System.out.println("Enter username: ");
                        viewModel.UserName = scanner.next();
                        System.out.println("Enter password: ");
                        viewModel.Password = scanner.next();
                        break;
                    case DELETE:
                        System.out.println("Enter user Id: ");
                        viewModel.UserId = scanner.nextInt();
                        break;
                }
                break;
            case ACCOUNT:
                switch (viewModel.CrudChoice)
                {
                    case CREATE:
                        System.out.println("Enter account number: ");
                        viewModel.AccountNumber = scanner.nextInt();
                        System.out.println("Enter account amount: ");
                        viewModel.AccountAmount = scanner.nextDouble();
                        System.out.println("Enter user id of account owner");
                        viewModel.UserId = scanner.nextInt();
                        break;
                    case READ:
                        break;
                    case UPDATE:
                        System.out.println("Enter account number: ");
                        viewModel.AccountNumber = scanner.nextInt();
                        System.out.println("Enter account amount: ");
                        viewModel.AccountAmount = scanner.nextDouble();
                        System.out.println("Enter user's id number: ");
                        viewModel.UserId = scanner.nextInt();
                        break;
                    case DELETE:
                        System.out.println("Enter account number to delete: ");
                        viewModel.AccountNumber = scanner.nextInt();
                        break;
                }
                break;
            case LOAN:
                switch (viewModel.CrudChoice)
                {
                    case CREATE:
                        System.out.println("Enter loan amount: ");
                        viewModel.LoanAmount = scanner.nextDouble();
                        System.out.println("Enter the user id: ");
                        viewModel.UserId = scanner.nextInt();
                        break;
                    case READ:
                        break;
                    case UPDATE:
                        System.out.println("Enter loan Id: ");
                        viewModel.LoanId = scanner.nextInt();
                        System.out.println("Enter new loan amount: ");
                        viewModel.LoanAmount = scanner.nextDouble();
                        System.out.println("Enter user id; ");
                        viewModel.UserId = scanner.nextInt();
                        break;
                    case DELETE:
                        System.out.println("Enter loan id to delete: ");
                        viewModel.LoanId = scanner.nextInt();
                        break;
                }
                break;
        }
    }
}
