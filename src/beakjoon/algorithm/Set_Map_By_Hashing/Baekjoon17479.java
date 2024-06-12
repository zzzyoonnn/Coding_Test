package beakjoon.algorithm.Set_Map_By_Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Baekjoon17479 {
  static int a, b, c;
  static BufferedReader br;
  static StringTokenizer st;
  static HashMap<String, Integer> normal;
  static HashMap<String, Integer> special;
  static HashSet<String> service;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine());

    a = Integer.parseInt(st.nextToken());       // 일반 메뉴 개수
    b = Integer.parseInt(st.nextToken());       // 특별 메뉴 개수
    c = Integer.parseInt(st.nextToken());       // 서비스 메뉴 개수

    normal = new HashMap<>();   // 일반 메뉴
    special = new HashMap<>();  // 특별 메뉴
    service = new HashSet<>();  // 서비스 메뉴


    // 메뉴 가격 정보 저장
    normalMenu();
    specialMenu();
    serviceMenu();

    long normalPrice = 0;
    long specialPrice = 0;
    long serviceCount = 0;       // 서비스 메뉴 주문 개수(<= 1)
    int n = Integer.parseInt(br.readLine());    // 손님이 주문하는 음식의 수
    for (int i = 0; i < n; i++) {
      String menu = br.readLine();

      if (normal.containsKey(menu)) {
        normalPrice += normal.get(menu);
      } else if (special.containsKey(menu)) {
        specialPrice += special.get(menu);
      } else if (service.contains(menu)) {
        serviceCount++;
      }
    }

    boolean able = true;        // 주문 할 수 있는지 확인용

    // 특별 메뉴 주문 조건
    if (specialPrice > 0 && normalPrice < 20000) able = false; 

    // 서비스 메뉴 주문 조건
    if (serviceCount > 0) {
      if ((normalPrice + specialPrice) < 50000 || serviceCount > 1) able = false;
    }

    if (able) System.out.println("Okay");
    else System.out.println("No");

  }

  private static void normalMenu() throws IOException {
    for (int i = 0; i < a; i++) {
      st = new StringTokenizer(br.readLine());

      String menu = st.nextToken();
      int price = Integer.parseInt(st.nextToken());

      normal.put(menu, price);
    }
  }

  private static void specialMenu() throws IOException {
    for (int i = 0; i < b; i++) {
      st = new StringTokenizer(br.readLine());

      String menu = st.nextToken();
      int price = Integer.parseInt(st.nextToken());

      special.put(menu, price);
    }
  }

  private static void serviceMenu() throws IOException {
    for (int i = 0; i < c; i++) {
      st = new StringTokenizer(br.readLine());

      String menu = st.nextToken();

      service.add(menu);
    }
  }
}
