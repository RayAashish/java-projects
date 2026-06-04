import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class TicTacToe{
    static List<Integer> storeX = new ArrayList<>();
    static List<Integer> storeO = new ArrayList<>();

    private static void wins(int[][] board){
        int[][] possibleSolutions = {
            {board[0][0], board[0][1], board[0][2]},
            {board[1][0], board[1][1], board[1][2]},
            {board[2][0], board[2][1], board[2][2]},
            {board[0][0], board[1][0], board[2][0]},
            {board[0][1], board[1][1], board[2][1]},
            {board[0][2], board[1][2], board[2][2]},
            {board[0][0], board[1][1], board[2][2]},
            {board[2][0], board[2][1], board[0][2]}
        };
    }

    private static void showCurrentBoard(char[][] board){
        char ch = '1';
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (board[i][j] == 'X' || board[i][j] == 'O'){
                    ch++;
                    continue;
                }
                board[i][j] = ch;
                ch++;
            }
        }
        for (char[] b : board){
            for (char place : b){
                System.out.print(place + "  ");
            }
            System.out.println();
        }
    }

    private static void placeXO(char[][] board, char ch, int n){
        
        switch (n) {
            case 1:
                board[0][0] = ch;
                break;
            case 2:
                board[0][1] = ch;
                break;
            case 3:
                board[0][2] = ch;
                break;
            case 4:
                board[1][0] = ch;
                break;
            case 5:
                board[1][1] = ch;
                break;
            case 6:
                board[1][2] = ch;
                break;
            case 7:
                board[2][0] = ch;
                break;
            case 8:
                board[2][1] = ch;
                break;
            case 9:
                board[2][2] = ch;
                break;
            default:
                break;
        }
    }

    private static void changePlayer(char[] currentPlayer){
        if (currentPlayer[0] == 'X')
            currentPlayer[0] = 'O';
        else if (currentPlayer[0] == 'O')
            currentPlayer[0] = 'X';
    }

    private static void storePlayer(char[] currentPlayer, int n){
        if (currentPlayer[0] == 'X')
            storeX.add(n);
        else
            storeO.add(n);
        System.out.println("O Moves : " + storeO);
        System.out.println("X Moves : " + storeX);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[3][3];
        Set<Integer> validMoves = new HashSet<>();
        for (int i = 1; i <= 9; i++){
            validMoves.add(i);
        }
        int moves = 0;
        char[] currentPlayer = {'X'};
        while(true){
            if (moves == 9){
                showCurrentBoard(board);
                System.out.println("GAME DRAW!");
                break;
            } else {
                showCurrentBoard(board);
                System.out.print("Enter move : ");
                int n = sc.nextInt();
                if (!validMoves.contains(n)){
                    System.out.println("Invalid move");
                    continue;
                }
                else {
                    validMoves.remove(n);
                    placeXO(board, currentPlayer[0], n);
                    changePlayer(currentPlayer);
                    storePlayer(currentPlayer, n);
                }
                moves++;
            }
        }
        
    }
}