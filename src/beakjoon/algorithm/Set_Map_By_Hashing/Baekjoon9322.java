package beakjoon.algorithm.Set_Map_By_Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baekjoon9322 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());        // 테스트케이스 갯수

    for (int tc = 0; tc < t; tc++) {
      int n = Integer.parseInt(br.readLine());      // 한 문장 단어 수
      String first = br.readLine();                 // 제 1 공개 키
      String second = br.readLine();                // 제 2 공개 키
      String secret = br.readLine();                // 암호 키

      HashMap<String, Integer> map = new HashMap<>();       // 키 정보를 담을 HashMap

      StringTokenizer st = new StringTokenizer(second);
      for (int i = 0; i < n; i++) {
        map.put(st.nextToken(), i);                 // 제 2 공개 키의 위치를 Map에 저장
      }

      String[] arr = secret.split(" ");             // 암호 키를 공백을 기준으로 잘라서 배열에 삽입

      StringBuilder sb = new StringBuilder();       // 암호문을 해독한 평문
      st = new StringTokenizer(first);
      for (int i = 0; i < n; i++) {
        sb.append(arr[map.get(st.nextToken())]).append(' ');        // 제 2 공개 키에서 제 1 공개키로 이동한 것 처럼 암호문도 이동하기
      }

      System.out.println(sb);
    }
  }
}
