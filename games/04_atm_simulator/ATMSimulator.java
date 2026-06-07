import java.util.Scanner;

public class ATMSimulator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account account = new Account("Aashish", 7000, "Saving", 1221);
        while (true) {
            System.out.println("Card read successful");
            System.out.print("Enter your pin: ");
            int pin = sc.nextInt();
            if (account.getPin() != pin) {
                System.out.println("Incorret pin");
                break;
            }
            System.out.println("1. Check Balance \n2. Deposit\n3. Withdraw");
            int option = sc.nextInt();
            if (option == 1){
                System.out.println(account.getBalance());
                break;
            } else {
                System.out.println("Enter deposit amount : ");
                int amount = sc.nextInt();
                if (option == 2){
                    account.depositAmount(amount);
                    System.out.println("Current balance : " + account.getBalance());
                    break;
                } else{
                    account.withdrawAmount(amount);
                    System.out.println("Current Balance : " + account.getBalance());
                }
            }
        }

        sc.close();
    }
}



class Account {
    private String name;
    private int balance;
    private String type;
    private int pin;

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public Account(){}

    public Account(String name, int balance, String type, int pin){
        this.name = name;
        this.balance = balance;
        this.type = type;
        if (pin > 9999)
            throw new RuntimeException("Please enter valid 4 digit pin");
        this.pin = pin;
    }

    public void depositAmount(int amount){
        if (amount < 100){
            System.out.println("Can't deposit less than 100");
            return;
        }
        this.balance += amount;
        System.out.println("Amount deposited sucessfully");
    }

    public void withdrawAmount(int amount){
        if (this.balance < amount){
            System.out.println("Insufficent balance");
            return;
        }
        if (amount < 100){
            System.out.println("Withdrawl amount must be more than 100");
            return;
        }
        this.balance += amount;
        System.out.println("Amount withdrawal successfull");
    }


    @Override
    public String toString(){
        return name + "\n" + balance + "\n" + type;
    }
}