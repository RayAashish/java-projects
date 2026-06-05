import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int randomNumber = (int) Math.floor(Math.random() * 10);
        int chances = 3;
        while (true) {
            if (chances == 0){
                System.out.println("The number was : " + randomNumber);
                System.out.println("You lost the game!");
                break;
            }
            System.out.println("Guess the number between 0-9 : ");
            int n = sc.nextInt();
            if (n == randomNumber){
                System.out.println("Correct Guess, You won the game!");
                break;
            } else {
                chances--;
                System.out.println("Wrong Guess !\nChances left : " + chances);
            }
        }
    }
}
