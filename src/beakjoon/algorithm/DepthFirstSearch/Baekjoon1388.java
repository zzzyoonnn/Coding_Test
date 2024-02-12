package beakjoon.algorithm.DepthFirstSearch;
/*
문제
- 형택이는 건축가이다. 
  지금 막 형택이는 형택이의 남자 친구 기훈이의 집을 막 완성시켰다. 
  형택이는 기훈이 방의 바닥 장식을 디자인했고, 이제 몇 개의 나무 판자가 필요한지 궁금해졌다. 
  나무 판자는 크기 1의 너비를 가졌고, 양수의 길이를 가지고 있다. 
  기훈이 방은 직사각형 모양이고, 방 안에는 벽과 평행한 모양의 정사각형으로 나누어져 있다.
  이제 ‘-’와 ‘|’로 이루어진 바닥 장식 모양이 주어진다. 
  만약 두 개의 ‘-’가 인접해 있고, 같은 행에 있다면, 두 개는 같은 나무 판자이고, 
  두 개의 ‘|’가 인접해 있고, 같은 열에 있다면, 두 개는 같은 나무 판자이다.
  기훈이의 방 바닥을 장식하는데 필요한 나무 판자의 개수를 출력하는 프로그램을 작성하시오.
입력
- 첫째 줄에 방 바닥의 세로 크기N과 가로 크기 M이 주어진다. 
  둘째 줄부터 N개의 줄에 M개의 문자가 주어진다. 
  이것은 바닥 장식 모양이고, '-‘와 ’|‘로만 이루어져 있다. 
  N과 M은 50 이하인 자연수이다.
출력
- 첫째 줄에 문제의 정답을 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1388 {
  static int n, m;
  static char[][] arr;
  static boolean[][] visited;

  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    arr = new char[n][m];
    visited = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      for (int j = 0; j < m; j++) {
        arr[i][j] = s.charAt(j);
      }
    }

    int count = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (visited[i][j]) continue;
        if (arr[i][j] == '-') dfs(i, j, true);
        else dfs(i, j, false);
        count++;
      }
    }

    System.out.println(count);
  }

  private static void dfs(int i, int j, boolean row) {
    visited[i][j] = true;

    if (row) {
      j++;  // 다음 가로 좌표로 이동
      if (j < m && arr[i][j] == '-') dfs(i, j, true);   // 다음 좌표가 바닥판의 범위 내에 있고 '-'로 연결되어 있는 경우 재귀적으로 호출
    } else {
      i++;  // 다음 세로 좌표로 이동
      if (i < n && arr[i][j] != '-') dfs(i, j, false);  // 다음 좌표가 바닥판의 범위 내에 있고 '-'가 아닌 경우 재귀적으로 호출
    }
  }
}
