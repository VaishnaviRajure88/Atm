package atm;

import java.util.Scanner;

public class ATMInterface {
    static Scanner sc = new Scanner(System.in); // Single Scanner instance for the class

    public static int takenIntegerInput(int limit) {
        int input = 0;
        boolean flag = false;

        while (!flag) {
            try {
                input = sc.nextInt();
                flag = true;
                if (flag && (input > limit || input < 1)) {
                    System.out.println("Choose a number between 1 to " + limit);
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("Enter only integer value. ");
                sc.next(); // Clear invalid input
                flag = false;
            }
        }
        return input;
    }

    public static void main(String[] args) {
        System.out.println("\n*************WELCOME TO VR ATM INTERFACE*************");
        System.out.println("\n1.Register \n2.Exit");
        System.out.println("Choose one option: ");
        int choose = takenIntegerInput(2);

        if (choose == 1) {
            BankAccount b = new BankAccount();
            b.register();
            while (true) {
                System.out.println("\n1.Login \n2.Exit");
                System.out.println("Enter your choice: ");
                int ch = takenIntegerInput(2);
                if (ch == 1) {
                    if (b.login()) {
                        System.out.println("\n***************WELCOME BACK " + b.name + "***************");
                        boolean isFinished = false;
                        while (!isFinished) {
                            System.out.println("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Exit");
                            System.out.println("Enter your choice: ");
                            int c = takenIntegerInput(6);
                            switch (c) {
                                case 1:
                                    b.withdraw();
                                    break;
                                case 2:
                                    b.deposit();
                                    break;
                                case 3:
                                    b.transfer();
                                    break;
                                case 4:
                                    b.checkBalance();
                                    break;
                                case 5:
                                    b.transHistory();
                                    break;
                                case 6:
                                    isFinished = true;
                                    break;
                            }
                        }
                    }
                } else {
                    sc.close(); // Close scanner before exiting
                    System.exit(0);
                }
            }
        } else {
            sc.close(); // Close scanner before exiting
            System.exit(0);
        }
    }
}
