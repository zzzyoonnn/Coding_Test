package beakjoon.algorithm.mathematics;
/*
문제
- N!에서 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수를 구하는 프로그램을 작성하시오.
입력
- 첫째 줄에 N이 주어진다. (0 ≤ N ≤ 500)
출력
- 첫째 줄에 구한 0의 개수를 출력한다.
 */
import java.util.Scanner;

public class Baekjoon1676 {
  public static void main(String[] agrs) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int count = 0;
    while (n >= 5) {
      count += n / 5;
      n /= 5;
    }
    System.out.println(count);
  }
}
