package beakjoon.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon2628 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int width = Integer.parseInt(st.nextToken());       // 가로
    int height = Integer.parseInt(st.nextToken());      // 세로

    int lines = Integer.parseInt(br.readLine());        // 점선의 개수

    ArrayList<Integer> list1 = new ArrayList<>();       // 가로 정보를 담을 list
    ArrayList<Integer> list2 = new ArrayList<>();       // 세로 정보를 담을 list
    list1.add(0);
    list2.add(0);
    for (int i = 0; i < lines; i++) {
      st = new StringTokenizer(br.readLine());
      int type = Integer.parseInt(st.nextToken());      // 0 : 가로, 1 : 세로
      int line = Integer.parseInt(st.nextToken());      // 점선 번호

      if (type == 0) list1.add(line);
      else if (type == 1) list2.add(line);
    }

    list1.add(height);
    list2.add(width);

    int maxWidth = -1;
    int maxHeight = -1;

    Collections.sort(list1);
    Collections.sort(list2);

    for (int i = 1; i < list1.size(); i++) {
      maxWidth = Math.max(maxWidth, list1.get(i) - list1.get(i - 1));
    }

    for (int i = 1; i < list2.size(); i++) {
      maxHeight = Math.max(maxHeight, list2.get(i) - list2.get(i - 1));
    }

    System.out.println(maxWidth * maxHeight);
  }
}
