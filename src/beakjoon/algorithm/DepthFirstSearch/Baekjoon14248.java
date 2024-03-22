package beakjoon.algorithm.DepthFirstSearch;
/*
문제
- 영우는 개구리다 개굴개굴개굴
  영우는 지금 n개의 돌이 일렬로 놓여있는 돌다리에 있다. 
  그리고 돌다리의 돌에는 숫자가 하나씩 적혀있다. 
  영우는 이 숫자가 적혀있는 만큼 왼쪽이나 오른쪽으로 점프할 수 있는데, 이때 돌다리 밖으로 나갈 수는 없다.
  영우는 이 돌다리에서 자기가 방문 가능한 돌들의 개수를 알고 싶어한다. 
  방문 가능하다는 것은 현재위치에서 다른 돌을 적절히 밟아 해당하는 위치로 이동이 가능하다는 뜻이다.
  현재 위치가 주어졌을 때, 영우가 방문 가능한 돌들의 개수를 출력하시오.
입력
- 첫 번째 줄에는 돌다리의 돌 개수 n이 주어진다.(1≤n≤100,000) 
  돌의 번호는 왼쪽부터 1번에서 n번이다. 
  다음 줄에는 그 위치에서 점프할 수 있는 거리 Ai가 주어진다.(1≤Ai≤100,000)
  다음 줄에는 출발점 s가 주어진다.(1≤s≤n)
출력
- 영우가 방문 가능한 돌들의 개수를 출력하시오.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon14248 {
  static int n, s, count;
  static int[] stone;
  static boolean[] visited;
  static int[] dx = {1, -1};

  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    stone = new int[n];             // 돌다리
    visited = new boolean[n];       // 방문 여부 확인용

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      stone[i] = Integer.parseInt(st.nextToken());
    }

    s = Integer.parseInt(br.readLine()) - 1;    // 시작 돌. 배열을 사용하기에 1부터가 아닌 0부터

    dfs(s);
    System.out.println(count);
  }

  private static void dfs(int i) {
    visited[i] = true;
    count++;

    for (int k = 0; k < 2; k++) {
      int index = i + (stone[i] * dx[k]);
      if (index >= 0 && index < n) {
        if (!visited[index]) {
          dfs(index);
        }
      }
    }
  }
}
