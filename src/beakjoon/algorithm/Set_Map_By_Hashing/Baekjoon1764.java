package beakjoon.algorithm.Set_Map_By_Hashing;
/*
문제
- 김진영이 듣도 못한 사람의 명단과, 보도 못한 사람의 명단이 주어질 때, 듣도 보도 못한 사람의 명단을 구하는 프로그램을 작성하시오.
입력
- 첫째 줄에 듣도 못한 사람의 수 N, 보도 못한 사람의 수 M이 주어진다. 
  이어서 둘째 줄부터 N개의 줄에 걸쳐 듣도 못한 사람의 이름과, N+2째 줄부터 보도 못한 사람의 이름이 순서대로 주어진다. 
  이름은 띄어쓰기 없이 알파벳 소문자로만 이루어지며, 그 길이는 20 이하이다. 
  N, M은 500,000 이하의 자연수이다.
  듣도 못한 사람의 명단에는 중복되는 이름이 없으며, 보도 못한 사람의 명단도 마찬가지이다.
출력
- 듣보잡의 수와 그 명단을 사전순으로 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Baekjoon1764 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());   // 듣지 못한 사람의 수
    int m = Integer.parseInt(st.nextToken());   // 보지 못한 사람의 수

    HashSet<String> hash = new HashSet<>();
    TreeSet<String> tree = new TreeSet<>();

    for (int i = 0; i < n; i++) {
      String name = br.readLine();
      hash.add(name);
    }

    for (int i = 0; i < m; i++) {
      String name = br.readLine();
      if (hash.contains(name)) tree.add(name);
    }

    System.out.println(tree.size());

    Iterator it = tree.iterator();
    while (it.hasNext()) {
      System.out.println(it.next());
    }
  }
}
