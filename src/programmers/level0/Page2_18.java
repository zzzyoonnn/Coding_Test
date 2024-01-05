package programmers.level0;
// 수열과 구간 쿼리 2
import java.util.Arrays;

public class Page2_18 {
  public static void main(String[] args) {
    int[] arr = {0, 1, 2, 4, 3};
    int[][] queries = {{0, 4, 2}, {0, 3, 2}, {0, 2, 2}};
    int[] answer = new int[queries.length];

    for (int i = 0; i < queries.length; i++) {
      int n = queries[i][2];
      int min = Integer.MAX_VALUE;
      boolean check = false;
      for (int j = queries[i][0]; j <= queries[i][1]; j++) {
        if (arr[j] > n) {
          min = Math.min(arr[j], min);
          check = true;
        }
      }
      if (check) answer[i] = min;
      else answer[i] = -1;
    }
    System.out.println(Arrays.toString(answer));
  }
}
