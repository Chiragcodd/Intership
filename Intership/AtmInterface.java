import java.util.Scanner;

class BankAccount
{
    private double balance;
    private int pin;

    public BankAccount(double initialBalance, int pin){
        this.balance = initialBalance;
        this.pin=pin;
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double amount){
        if (amount > 0){
            balance += amount;
        }
    }

    public boolean withdraw(double amount){
        if (amount > 0 && amount <= balance){
            balance -= amount;
            return true;
        }
        return false;
    }
    public boolean validatePin(int enteredPin){
        return this.pin == enteredPin;
    }
}

class ATM{
    private BankAccount account;
    
    public ATM(BankAccount account){
        this.account = account;
    }

    public void displayMenu(){
        System.out.println("ATM Menu");
        System.out.println("1 : Withdraw");
        System.out.println("2 : Deposit");
        System.out.println("3 : Check Balance");
        System.out.println("4 : Exit");
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Please enter your PIN: ");
        int enteredPin = sc.nextInt();

        if(!account.validatePin(enteredPin)){
            System.out.println("Invalid PIN. Access Denied ");
            System.out.print("Try Again ");
            sc.close();
            return;
        }


        while (true){
            displayMenu();
            System.out.println("Enter your Choice: ");
            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.println("Enter the amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    if (account.withdraw(withdrawAmount)){
                        System.out.println("Withdraw Successful.");
                    } else {
                        System.out.println("Insufficients balance.");
                    }
                    break;
                case 2:
                    System.out.println("Enter the amount to deposite: ");
                    double depositAmount  =  sc.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("Deposit Successful.");
                    break;
                case 3:
                    System.out.println("Your account balance is: "+account.getBalance());
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM.");
                    return;
                default:
                    System.out.println("Invalid choice .please try again.");
                    break;
            }
        }
    }    
}

public class AtmInterface {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(100000,2003);
        ATM atm = new ATM(userAccount);
        atm.run();

    }   
}
