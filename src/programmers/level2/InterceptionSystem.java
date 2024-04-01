package programmers.level2;
// 요격 시스템

import java.util.Arrays;

public class InterceptionSystem {
  public static void main(String[] agrs) {
    int[][] targets = {{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}};
    int answer = 0;

    Arrays.sort(targets, (x, y) -> x[0] - y[0]);

    int preStart = targets[0][0];
    int preEnd = targets[0][1];

    for (int[] target : targets) {
      int curStart = target[0];
      int curEnd = target[1];

      if (curStart >= preStart && curStart < preEnd) {
        preStart = Math.max(preStart, curStart);
        preEnd = Math.min(curEnd, curEnd);
        System.out.println(preStart + " " + preEnd);
      } else {
        answer++;
        preStart = curStart;
        preEnd = curEnd;
        System.out.println("else" + preStart + " " + preEnd);
      }
    }

    System.out.println(answer);
  }
}
