package programmers.level0;
// 더 크게 합치기
import java.util.Scanner;

public class Page2_02 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();

    int answer1 = Integer.parseInt(Integer.toString(a) + Integer.toString(b));
    int answer2 = Integer.parseInt(Integer.toString(b) + Integer.toString(a));

    if (answer1 > answer2) System.out.println(answer1);
    else System.out.println(answer2);
  }
}
