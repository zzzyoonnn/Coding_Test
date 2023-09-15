package beakjoon.Type.Implementation;
/*
문제
- N개의 칸에 1 부터 N 까지의 수들이 왼쪽부터 순서대로 저장되어 있다. 
  또, 각 칸은 왼쪽부터 1 부터 N까지 순서대로 번호가 붙어 있다. 
  즉, 처음에는 각 칸의 번호와 각 칸에 저장된 수가 같다.

  다음 작업을 수가 정확히 하나가 남을 때 까지 반복한다.
    (A) 홀수번 칸의 수들을 모두 지운다 
    (B) 남은 수들을 왼쪽으로 모은다.

  제일 첫 작업의 (A) 단계가 끝나면 칸들의 상태는 다음과 같을 것이다.
  이제 수가 하나 남았으므로 작업은 더 이상 진행되지 않는다.
  N을 입력으로 받아 위와 같이 작업을 진행했을 때 마지막으로 남는 수를 계산하는 프로그램을 작성하라.
입력
- 첫 번째 줄에 정수 N이 주어진다.
출력
- 마지막으로 남는 수를 한 줄에 출력한다.
ex 1)
입력      출력
- 1       - 1
ex 2)
입력      출력
- 2      - 2
ex 3)
입력      출력
- 5      - 4
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Baekjoon21756 {
  public static void main(String[] agrs) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    ArrayList<Integer> arr = new ArrayList<>();

    for (int i = 1; i < n; i++) arr.add(i);

    while (arr.size() >= 2) {
      for (int i = 0; i < arr.size(); i++) arr.remove(i);
      // arr = [1, 2, 3, 4], i == 0
      // arr = [2, 3, 4], i == 1
      // arr = [2, 4] 이런 식으로 동작
    }
    System.out.println(arr.get(0));
  }
}
