import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of password : ");
        int size = sc.nextInt();
        List<Character> chars = new ArrayList<>();
        for (int i = 32; i <= 126; i++){
            chars.add((char) i);
        }
        System.out.println(chars.size());
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < size; i++){
            int idx = (int) (Math.floor(( Math.random()) * 96));
            password.append(chars.get(idx));
        }
        System.out.println(password);
    }
}
