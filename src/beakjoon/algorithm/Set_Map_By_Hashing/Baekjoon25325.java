package beakjoon.algorithm.Set_Map_By_Hashing;
/*
문제
- 학생 이름이 공백으로 구분된 문자열 A가 주어진다. 
  문자열 A에는 중복된 학생 이름이 존재하지 않는다. 
  학생 이름은 알파벳 소문자로 이루어져 있다. 
  각 학생이 좋아하는 학생의 학생 이름 목록이 공백으로 구분된 문자열로 주어진다. 
  각 학생이 좋아하는 학생은 1명 이상 주어지고, 
  내가 나를 좋아하는 예는 없다. 
  나를 좋아하는 학생이 많을수록 나의 인기도가 높다. 
  인기도가 높은 학생부터 낮은 학생 순으로 학생 이름과 해당 학생을 좋아하는 학생 수를 출력하자. 
  인기도가 같은 경우 학생 이름 기준으로 오름차순으로 출력하자.
입력
- 첫 번째 줄에 학생 수 n이 주어진다.
  두 번째 줄에 n명의 학생 이름이 공백으로 구분된 문자열 A가 주어진다.
  다음 줄부터 n개의 줄에 걸쳐 한 줄에 한 학생의 정보가 주어진다. 
  학생 정보는 문자열 A에 나온 학생 순서대로 주어진다. 
  한 명의 학생 정보는 해당 학생이 좋아하는 학생 이름이 공백으로 구분된 문자열로 주어진다.
출력
- 첫 번째 줄부터 n번째 줄까지 학생 이름과 해당 학생을 좋아하는 학생 수를 공백으로 구분하여 한 줄에 출력한다. 
  인기도가 높은 학생부터 낮은 학생 순으로 출력하고, 인기도가 같은 경우 학생 이름 기준으로 오름차순으로 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Baekjoon25325 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    TreeMap<String, Integer> map = new TreeMap<>();

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      String name = st.nextToken();
      map.put(name, 0);
    }

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      while (st.hasMoreTokens()) {
        String name = st.nextToken();

        map.replace(name, map.get(name) + 1);
      }
    }

    List<String> keySet = new ArrayList<>(map.keySet());    // 맵의 키셋을 리스트로 변환

    keySet.sort((o1, o2) -> {       // 정렬을 위한 비교자(Comparator)를 사용하여 키셋을 정렬
      if (map.get(o1) - map.get(o2) == 0) {     // 등장 횟수가 같으면 이름의 사전순으로 정렬
        return o1.compareTo(o2);
      } else {
        return map.get(o2) - map.get(o1);       // 등장 횟수가 다르면 등장 횟수 내림차순으로 정렬
      }
    });

    for (String key : keySet) {
      System.out.println(key + " " + map.get(key));
    }
  }
}
