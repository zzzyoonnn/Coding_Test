package beakjoon.algorithm.Set_Map_By_Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon29723 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());       // 브실이가 수강한 과목 수
    int m = Integer.parseInt(st.nextToken());       // 브실대학에서 요구하는 과목 수
    int k = Integer.parseInt(st.nextToken());       // 브실대학에서 공개한 과목 수

    HashMap<String, Integer> subject = new HashMap<>();     // Key : 과목 이름, Value : 과목 점수

    // 브실이가 수강한 과목 이름과 정수 점수
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      String name = st.nextToken();
      int score = Integer.parseInt(st.nextToken());

      subject.put(name, score);
    }


    int temp = 0;       // 브실대학에서 공개한 과목의 점수

    // 브실대학에서 공개한 과목 이름
    for (int i = 0; i < k; i++) {
      String name = br.readLine();
      temp += subject.get(name);

      subject.remove(name);         // 최대 점수와 최소 점수 구할 때 반영 안하기 위해 제거
    }


    int max = temp;     // 브실이가 얻을 수 있는 최대 점수
    int min = temp;     // 브실이가 얻을 수 있는 최소 점수


    // Map → List
    // ArrayList의 생성자의 파라미터로 map의 value값을 가지는 Collection객체를 넘겨주어서 Map을 List로 변환
    Collection<Integer> values = subject.values();
    List<Integer> list = new ArrayList<>(values);

    Collections.sort(list);

    for (int i = 0; i < m - k; i++) {
      min += list.get(i);
      max += list.get(list.size() - i - 1);
    }

    System.out.println(min);
    System.out.println(max);
  }
}
