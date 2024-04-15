package beakjoon.algorithm.Set_Map_By_Hashing;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baekjoon14670 {
  public static void main(String[] agrs) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());        // 약 종류의 개수
    StringTokenizer st;

    HashMap<Integer, Integer> medicine = new HashMap<>();
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int effect = Integer.parseInt(st.nextToken());    // 약의 효능
      int name = Integer.parseInt(st.nextToken());      // 약의 이름

      medicine.put(effect, name);
    }

    StringBuilder sb;

    int r = Integer.parseInt(br.readLine());        // 영정이가 겪는 증상의 개수
    for (int i = 0; i < r; i++) {
      st = new StringTokenizer(br.readLine());
      sb = new StringBuilder();
      int num = Integer.parseInt(st.nextToken());       // 증상의 개수
      for (int j = 0; j < num; j++) {
        int symptom = Integer.parseInt(st.nextToken());
        if (!medicine.containsKey(symptom)) {           // map에 저장되어 있지 않은 약이라면,
          sb.setLength(0);                              // StringBuilder 초기화
          sb.append("YOU DIED");                        // "YOU DIED"를 StringBuilder에 추가
          break;
        }
        sb.append(medicine.get(symptom)).append(' ');
      }
      System.out.println(sb);
    }
  }
}
