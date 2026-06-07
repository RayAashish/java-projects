
public class ATMSimulator {
    public static void main(String[] args) {
        
    }
}

class Account {
    private String name;
    private int balance;
    private String type;
    private int pin;

    public Account(String name, int balance, String type, int pin){
        this.name = name;
        this.balance = balance;
        this.type = type;
        if (pin > 9999)
            throw new RuntimeException("Please enter valid 4 digit pin");
        this.pin = pin;
    }
    @Override
    public String toString(){
        return name + "\n" + balance + "\n" + type;
    }
}