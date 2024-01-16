package programmers.level0;
// 배열 만들기 1
import java.util.Arrays;
import java.util.Scanner;

public class Page3_20 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();

    int[] answer = new int[n / k];
    for (int i = 0; i < n / k; i++) {
      answer[i] = k * (i + 1);
    }

    System.out.println(Arrays.toString(answer));
  }
}
