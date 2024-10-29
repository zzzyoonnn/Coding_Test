package programmers.level1;

import java.util.Arrays;

public class 기사단원의무기 {
  public static int solution(int number, int limit, int power) {
    int answer = 0;

    int count;
    int[] arr = new int[number + 1];
    for (int i = 1; i <= number; i++) {
      count = 0;

      for (int j = 1; j <= (int) Math.sqrt(i); j++) {
        if (j == Math.sqrt(i)) count++;
        else if (i % j == 0) count += 2;
      }

      arr[i] = count;
    }

    System.out.println(Arrays.toString(arr));

    for (int i = 1; i <= number; i++) {
      if (arr[i] > limit) answer += power;
      else answer += arr[i];
    }

    return answer;
  }

  public static void main(String[] args) {
//    int number = 5;
//    int limit = 3;
//    int power = 2;

    int number = 10;
    int limit = 3;
    int power = 2;

    System.out.println(solution(number, limit, power));
  }
}
