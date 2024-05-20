package beakjoon.algorithm.Set_Map_By_Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baekjoon3077 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());        // 해전의 개수

    HashMap<String, Integer> map = new HashMap<>();      // Key : 해전 이름, Value : 해전 순서

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      String war = st.nextToken();
      map.put(war, i);
    }


    // 현우의 정답
    int count = 0;
    String[] arr = br.readLine().split(" ");

    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        if (map.get(arr[i]) < map.get(arr[j])) count++;
      }
    }

    System.out.println(count + "/" + (n * (n - 1) / 2));
  }
}
