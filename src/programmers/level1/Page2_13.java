package programmers.level1;
// 예산
import java.util.Arrays;
import java.util.Scanner;

public class Page2_13 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int answer = 0;
    int[] d = {1, 3, 2, 5, 4};
    int budget = 9;

    Arrays.sort(d);

    for (int i = 0; i < d.length; i++) {
      budget -= d[i];
      if (budget < 0) break;
      answer++;
    }
    System.out.println(answer);
  }
}
