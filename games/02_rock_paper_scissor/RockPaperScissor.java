import java.util.Scanner;

public class RockPaperScissor {

    private static void showSlection(int n){
        switch (n) {
            case 1:
                System.out.println("Rock");
                break;
            case 2:
                System.out.println("Paper");
                break;
            case 3:
                System.out.println("Scissor");
                break;
            default:
                break;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0, player = 0, computer = 0;
        while (true) {
            if (count == 5){
                if (player == computer)
                    System.out.println("Math Draw");
                boolean winner = player > computer ? true : false;
                if (winner)
                    System.out.println("Player won majority in 5 games\nTotal wins : " + player);
                else
                    System.out.println("Computer won majority in 5 games\nTotal wins : " + computer);
                break;
            }
            System.out.println("Select : \n1.Rock\n2.Paper\n3.Scissor\nEnter no. : ");
            int n = sc.nextInt();
            if (n > 3 || n < 1){
                System.out.println("Select valid options");
                continue;
            }
            System.out.print("Player selected : ");
            showSlection(n);
            int computerVal = (int) Math.ceil(Math.random() * 3);
            System.out.print("Computer selected : ");
            showSlection(computerVal);
            if (n == computerVal){
                count++;
                System.out.println("MATCH DRAW!");
                continue;
            }
            if (n == 1 && (computerVal == 3)){
                player++;
                count++;
                System.out.println("Player won this round");
                continue;
            } else if (n == 1 && (computerVal == 2)){
                computer++;
                count++;
                System.out.println("Computer won this round");
                continue;
            } else if (n == 2 && (computerVal == 1)){
                player++;
                count++;
                System.out.println("Player won this round");
                continue;
            } else if (n == 2 && (computerVal == 3)){
                computer++;
                count++;
                System.out.println("Computer won this round");
                continue;
            } else if (n == 3 && (computerVal == 1)){
                computer++;
                count++;
                System.out.println("Computer won this round");
                continue;
            } else {
                player++;
                count++;
                System.out.println("Player won this round");
                continue;
            }
        }
        sc.close();
    }
}
