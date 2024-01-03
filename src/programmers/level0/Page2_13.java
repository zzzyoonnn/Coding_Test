package programmers.level0;
// 이어 붙인 수

public class Page2_13 {
  public static void main(String[] args) {
    int[] num_list = {3, 4, 5, 2, 1};
    int answer = 0;

    String odd = "";    // 홀수
    String even = "";   // 짝수

    for (int i = 0; i < num_list.length; i++) {
      if (num_list[i] % 2 == 0) {
        even += Integer.toString(num_list[i]);
      } else {
        odd += Integer.toString(num_list[i]);
      }
    }

    answer = Integer.parseInt(even) + Integer.parseInt(odd);
    System.out.println(answer);
  }
}
