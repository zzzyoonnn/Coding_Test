package beakjoon.algorithm.implementation;
/*
문제
- 일우는 친구들과 펭귄 얼음깨기 게임을 하고 있다. 
  계속 떨어지는 펭귄이 불쌍했던 일우는 INU 송년 코드페스티벌 참가자들을 펭귄추락대책위원회로 초대했다. 
  이 펭귄 얼음깨기는 리메이크 된 버전으로, N개의 얼음이 1부터 N까지 번호가 매겨져 있다. 
  게임은 얼음 1부터 N까지 순서대로 일렬로 나열된 공간에서 진행된다. 
  게임 시작 시, 펭귄 한 마리가 임의의 얼음 K위에 위치한다. 
  참가자는 몇 개의 얼음을 깨뜨려서 펭귄을 떨어뜨리는 것이 목적이다. 
  단, 펭귄이 밟고 있는 얼음은 깨뜨릴 수 없다. 
  각 얼음은 서로 다른 강도를 가지고 있어서 얼음 i(1 ≤ i ≤ N)를 깨뜨리는 데에 Ai만큼의 힘이 필요하다. 
  양옆으로 인접해 있는 얼음들을 하나의 그룹으로 봤을 때, 
  그룹의 끝이 얼음1 또는 N을 포함하지 않는다면 이 얼음 그룹은 아래로 추락하게 된다. 
  아래 예시를 보자.
  얼음4와 얼음1을 각각 2와 7의 힘을 가해 깨뜨릴 수 있다. 
  이때, 펭귄이 위치한 얼음2와 얼음3으로 구성된 그룹은 얼음1 또는 얼음5를 포함하지 않으므로 아래로 추락하게 된다. 
  위 예시에서 펭귄을 떨어뜨릴 수 있는 최소 힘은 2+7=9가 된다.
  펭귄추락대책위원회인 우리는 게임의 참가자가 펭귄을 떨어뜨릴 수 있는 최소 힘을 구해서 이를 보완하려고 한다. 
  펭귄을 떨어뜨릴 수 있는 최소 힘은 얼마일까?
입력
- 첫째 줄에 얼음의 개수를 의미하는 N(3 ≤ N ≤ 200,000)이 주어진다.
  그다음 줄에는 i번째 얼음을 깨뜨리는 데에 드는 힘을 의미하는 정수 Ai(1 ≤ Ai ≤ 1,000,000,000)가 순서대로 주어진다.
  예외적으로 펭귄이 위치한 곳은 -1로 표시되며, 펭귄이 얼음1 또는 N에 위치하는 경우는 존재하지 않는다.
출력
- 참가자가 펭귄을 떨어뜨릴 수 있는 최소 힘을 나타내는 정수를 출력하시오.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon18228 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int left, right;
    int left_min = Integer.MAX_VALUE;
    int right_min = Integer.MAX_VALUE;

    for (int i = 0; i < n; i++) {
      left = arr[i];
      if (left == -1) break;

      if (left_min > left) left_min = left;
    }

    for (int i = n - 1; i >= 0; i--) {
      right = arr[i];
      if (right == -1) break;

      if (right_min > right) right_min = right;
    }

    System.out.println(left_min + right_min);
  }
}
