package programmers.level1;

public class 푸드파이트대회 {
  public static String solution(int[] food) {
    String answer = "";

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i < food.length; i++) {
      for (int j = 0; j < food[i] / 2; j++) {
        sb.append(String.valueOf(i));
      }
    }
    answer += sb.toString();
    answer += 0;
    answer += sb.reverse().toString();

    return answer;
  }

  public static void main(String[] args) {
//    int[] food = {1, 3, 4, 6};
    int[] food = {1, 7, 1, 2};

    System.out.println(solution(food));
  }
}
