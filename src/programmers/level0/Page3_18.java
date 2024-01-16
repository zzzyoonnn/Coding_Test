package programmers.level0;
// qr code
import java.util.Scanner;

public class Page3_18 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String code = sc.next();
    int q = sc.nextInt();
    int r = sc.nextInt();

    String answer = "";

    for (int i = 0; i < code.length(); i++) {
      if (i % q == r) answer += code.charAt(i);
    }
    System.out.println(answer);
  }
}
