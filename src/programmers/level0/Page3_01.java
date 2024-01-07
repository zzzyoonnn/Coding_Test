package programmers.level0;
// 카운트 업
import java.util.Arrays;
import java.util.Scanner;

public class Page3_01 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int start_num = sc.nextInt();
    int end_num = sc.nextInt();
    int[] answer = new int[end_num - start_num + 1];

    for (int i = 0; i <= end_num - start_num; i++) {
      answer[i] = i + start_num;
    }
    System.out.println(Arrays.toString(answer));
  }
}
