package beakjoon.algorithm.Set_Map_By_Hashing;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon25329 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    HashMap<String, Integer> map = new HashMap<>();        // Key : 학생 이름, Value : 통화 시간

    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int time = timeS(st.nextToken());
      String name = st.nextToken();

      // 통화 요금 누적
      if (!map.containsKey(name)) map.put(name, time);
      else map.replace(name, map.get(name) + time);
    }


    for (String s : map.keySet()) {     // 통화 요금 계산
      int charge = 10;
      int total = map.get(s) - 100;
      if (total > 0) {
        charge += (total / 50) * 3;
        if (total % 50 > 0) charge += 3;
      }

      map.replace(s, charge);       // Key : 학생 이름, Value : 통화요금 으로 변경
    }

    List<String> keySet = new ArrayList<>(map.keySet());    // 맵의 키셋을 리스트로 변환

    keySet.sort((o1, o2) -> {                   // 정렬을 위한 비교자(Comparator)를 사용하여 키셋을 정렬
      if (map.get(o1) - map.get(o2) == 0) {     // 통화 요금이 같으면 이름의 사전순으로 정렬
        return o1.compareTo(o2);
      } else {
        return map.get(o2) - map.get(o1);       // 통화 요금이 다르면 등장 횟수 내림차순으로 정렬
      }
    });

    for (String key : keySet) {
      System.out.println(key + " " + map.get(key));
    }
  }

  public static int timeS(String time) {
    int hour = Integer.parseInt(time.split(":")[0]) * 60;
    int minute = Integer.parseInt(time.split(":")[1]);

    return hour + minute;
  }
}