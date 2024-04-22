package beakjoon.individual;
/*
문제
- 모든 자리가 1로만 이루어져있는 두 자연수 A와 B가 주어진다.
  이때, A와 B의 최대 공약수를 구하는 프로그램을 작성하시오.
  예를 들어, A가 111이고,
  B가 1111인 경우에 A와 B의 최대공약수는 1이고,
  A가 111이고, B가 111111인 경우에는 최대공약수가 111이다.
입력
- 첫째 줄에 두 자연수 A와 B를 이루는 1의 개수가 주어진다. 입력되는 수는 263보다 작은 자연수이다.
출력
- 첫째 줄에 A와 B의 최대공약수를 출력한다. 정답은 천만 자리를 넘지 않는다.
ex 1)
입력		출력
- 3 4		- 1
ex 1)
입력		출력
- 3 6		- 111
ex 1)
입력										출력
- 500000000000000000 500000000000000002		- 11
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baekjoon1850 {
  // 방문처리에 사용 할 배열선언
  static boolean[] vistied = new boolean[9];
  
  // 그림예시 그래프의 연결상태를 2차원 배열로 표현
  // 인덱스가 각각의 노드번호가 될 수 있게 0번인덱스는 아무것도 없는 상태라고 생각하시면됩니다.
  static int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};
  
  public static void main(String[] args) {
      dfs(1);
  }
  
  static void dfs(int nodeIndex) {
      // 방문 처리
      vistied[nodeIndex] = true;
      
      // 방문 노드 출력
      System.out.print(nodeIndex + " -> ");
      
      // 방문한 노드에 인접한 노드 찾기
      for (int node : graph[nodeIndex]) {
          // 인접한 노드가 방문한 적이 없다면 DFS 수행
          if(!vistied[node]) {
              dfs(node);
          }
      }
  }
}
