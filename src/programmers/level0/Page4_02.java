package programmers.level0;
// 카운트 다운
import java.util.Arrays;
import java.util.Scanner;

public class Page4_02 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int start_num = sc.nextInt();
    int end_num = sc.nextInt();

    int[] answer = new int[start_num - end_num + 1];
    for (int i = 0; i < answer.length; i++) {
      answer[i] = start_num - i;
    }

    System.out.println(Arrays.toString(answer));
  }
}
