package programmers.level0;
// 두 수의 연산값 비교하기
import java.util.Scanner;

public class Page2_03 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();

    int answer1 = Integer.parseInt(Integer.toString(a) + Integer.toString(b));
    int answer2 = 2 * a * b;

    if (answer1 >= answer2) System.out.println(answer1);
    else System.out.println(answer2);
  }
}
