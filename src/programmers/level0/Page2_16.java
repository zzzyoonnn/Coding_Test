package programmers.level0;
// 수 조작하기 2

public class Page2_16 {
  public static void main(String[] args) {
    int[] numLog = {0, 1, 0, 10, 0, 1, 0, 10, 0, -1, -2, -1};
    String answer = "";

    for (int i = 1; i < numLog.length; i++) {
      int n = numLog[i] - numLog[i - 1];
      if (n == 1) answer +='w';
      else if (n == -1) answer +='s';
      else if (n == 10) answer +='d';
      else if (n == -10) answer += 'a';
    }
    System.out.println(answer);
  }
}
