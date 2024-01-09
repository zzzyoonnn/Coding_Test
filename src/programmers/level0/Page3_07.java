package programmers.level0;
// 9로 나눈 나머지
import java.util.Scanner;

public class Page3_07 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String number = sc.next();

    int n = 0;
    for (int i = 0; i < number.length(); i++) n += number.charAt(i) - '0';
    System.out.println(n % 9);
  }
}
