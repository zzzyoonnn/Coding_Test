package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Baekjoon30087 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    HashMap<String, String> map = new HashMap<>();
    map.put("Algorithm", "204");
    map.put("DataAnalysis", "207");
    map.put("ArtificialIntelligence", "302");
    map.put("CyberSecurity", "B101");
    map.put("Network", "303");
    map.put("Startup", "501");
    map.put("TestStrategy", "105");

    int n = Integer.parseInt(br.readLine());    // 세미나 수
    for (int i = 0; i < n; i++) {
      String seminar = br.readLine();
      System.out.println(map.get(seminar));
    }
  }
}
