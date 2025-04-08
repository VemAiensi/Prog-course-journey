import exceptions.*;

import java.util.*;

public class Main {
  static List<Account> accountList;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    accountList = new ArrayList<>();
    int loopback = 1;
    String logSuccesful = "==================================================\n " +
        "You are now Logged in. Please choose an operation\n[1] Log out   [2] Exit Program";

    System.out.println("Login Trials {OOP Laboratory Assignment 3}\n" +
        "-Vem Aiensi A. Marasigan [2 BSCS 1]\n" +
        "==================================================");

    while (true) {
      System.out.print("\n[1] Create an Account\n[2] Login to an Existing Account\n" +
          "[3] Exit\nCHOOSE: ");
      int choice = scan.nextInt();

      switch (choice) {
        case 1:
          System.out.print("\nPlease enter your desired User Name: ");
          String userID = scan.next();
          System.out.print("Please enter your password: ");
          String password = scan.next();

          Account acc = new Account(userID, password);
          acc.setUserID(userID);
          acc.setPassword(password);
          accountList.add(acc);
          System.out.println("\n\t\t\t  Account Created!\nPlease be informed that you only have 3 attempts" +
              "\n to log to your account. Failure to do so will" +
              " \n\t\t  deactivate your account.\n\t\t\t\tThank you!\n\n" +
              logSuccesful);

          if (scan.nextInt() == 2) {
            System.out.print("The System Terminated.");
            System.exit(0);
          }
          break; // This account creation is just an extra mechanic

        case 2:
          System.out.print("\nPlease indicate your User Name: ");
          String userIDInput = scan.next();
          System.out.print("Please enter your password: ");
          String passwordInput = scan.next();

          Account account = findAccount(userIDInput);

          try {
            if (account == null) {
              throw new NotExistingAccountException("Account does not exist.");
            }

            if (account.getAttempts() == 0) {
              throw new NoMoreAttemptsException("Account is was already terminated.");
            } else {
              if (account.getPassword().equals(passwordInput)) {
                account.attemptReset();
                System.out.println(logSuccesful);

                if (scan.nextInt() == 2) {
                  System.out.print("The System Terminated.");
                  System.exit(0);
                }
              }

              else {
                account.setAttempts(account.getAttempts() - 1);
                if (account.getAttempts() == 0) {
                  throw new NoMoreAttemptsException("There are no more attempts left.");
                } else {
                  throw new PasswordMismatchException(account.getAttempts() + " attempt/s remaining.");
                }
              }
            }
          } catch (PasswordMismatchException e) {
            System.out.println("***************************************" +
                "\nInvalid Password. " + e.getMessage());
          } catch (NoMoreAttemptsException e) {
            System.out.println("*********************************************" +
                "\nLogin Failed. " + e.getMessage());
          } catch (NotExistingAccountException e) {
            System.out.println("***************************************\n" +
                e.getMessage() + " Please try again.");
          }
          break;

        case 3:
          System.out.print("The System Terminated.");
          System.exit(0);
      }
    }
  }

  static Account findAccount(String userID) {
    Account acc = null;
    for (int count = 0; count < accountList.size(); count++) {
      if (accountList.get(count).getUserID().equals(userID)) {
        acc = accountList.get(count);
      }
    }
    return acc;
  }
}
