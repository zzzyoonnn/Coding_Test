package beakjoon.algorithm.Set_Map_By_Hashing;
/*
문제
- 오늘은 즐거운 축제날이다.
  백남이는 축제에서 무엇을 할까 돌아다니던 중 도전 숫자왕이라는 행사를 발견했고 100만원이라는 상금에 홀려 바로 참가하였다.
  도전 숫자왕은 N개의 숫자 카드를 조합하여 다양한 수를 만드는 게임이다.
  이번 라운드에서는 카드의 적힌 수의 합으로 만들 수 없는 수의 개수를 외치면 이긴다.
  백남이가 1등을 하여 축제를 즐길 수 있도록 도와주자.
입력
- 첫 번째 줄에는 카드의 개수 N(1 <= N <= 20)이 주어진다.
  두 번째 줄에는 N개의 수가 주어진다.
  입력으로 주어지는 수는 100,000,000 이하의 자연수이다.
출력
- 모든 카드에 적힌 수의 합을 M이라고 할 때, 1 이상 M 이하의 자연수 중 만들 수 없는 수의 개수를 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Baekjoon23057 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());    // 카드의 개수

    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] arr = new int[n];
    int m = 0;
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      m += arr[i];
    }
    HashSet<Integer> set = new HashSet<>();     // 모든 카드에 적힌 수의 합

    for (int i = 1; i <= arr.length; i++) {
      combinations(arr, i, 0, 0, set);      // 주어진 배열에서 가능한 모든 부분집합의 합을 계산
      // arr : 입력된 정수 배열
      // i : 현재 조합의 길이(length)
      // 첫 번째 0 : 조합 생성 시작 인덱스(start)
      // 두 번째 0 : 현재까지의 합(currentSum)
      // set : 합을 저장하는 HashSet
    }

    System.out.println(m - set.size());
  }

  private static void combinations(int[] arr, int length, int start, int currentSum, Set<Integer> set) {
    if (length == 0) {      // 하나의 조합 완성
      set.add(currentSum);
      return;
    }

    // 현재 조합의 길이가 0이 아니면 배열에서 가능한 모든 조합을 생성
    // 시작 인덱스부터 배열의 끝까지 반복
    for (int i = start; i <= arr.length - length; i++) {
      // 시작 인덱스를 하나 증가시켜서 다음 원소를 고려
      combinations(arr, length - 1, i + 1, currentSum + arr[i], set);
    }
  }
}
