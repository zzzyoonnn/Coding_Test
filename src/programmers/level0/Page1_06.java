package programmers.level0;
// [PCCE 기출문제] 5번 / 산책
import java.util.Arrays;

public class Page1_06 {
  public static void main(String[] args) {
    int[] numbers = {3, 4};
    int[] our_score = {85, 93};
    int[] score_list = {85, 92, 38, 93, 48, 85, 92, 56};

    int num_student = numbers.length;
    String[] answer = new String[num_student];

    for (int i = 0; i < num_student; i++) {
      if (our_score[i] == score_list[numbers[i] - 1]) {
        answer[i] = "Same";
      } else {
        answer[i] = "Different";
      }
    }
    System.out.println(Arrays.toString(answer));
  }
}
